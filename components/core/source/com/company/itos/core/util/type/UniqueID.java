/**
 * 
 */
package com.company.itos.core.util.type;

import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Random;

import com.company.itos.core.util.keyserver.KeyServerInterface;
import com.company.itos.core.util.keyserver.KeyServerBlock;
import com.company.itos.core.util.resources.Configuration;

/**
 * 
 * @author Rahul
 */
public abstract class UniqueID {
	
	private static boolean stUseSimpleKeyServerMock;
	
	private static Hashtable<String, UniqueIDSet> stInstantiatedSets = new Hashtable<String, UniqueIDSet>();
	
	public static synchronized long nextUniqueID(String keySet) {
		// throws AppRuntimeException, DatabaseException, AppException {

		UniqueIDSet set = (UniqueIDSet) stInstantiatedSets.get(keySet);
		
		if (set == null) {
			set = new UniqueIDSet(keySet);
			stInstantiatedSets.put(keySet, set);
		}
		
		long key = set.nextKeyInSet();
		
		/*if (Trace.atLeast(Trace.kTraceUltraVerbose)) {
			LocalisableString localisedMessage = new LocalisableString(
					INFRASTRUCTURE.LOG_ID_UNIQUE_ID_GENERATED);

			localisedMessage.arg(key);
			localisedMessage.arg(keySet);
			Trace.kTopLevelLogger.info(localisedMessage.getMessage());
		}*/

		return key;
	}
	
	/**
	 * 
	 * @return
	 */
	public static long nextUniqueID() { // throws AppRuntimeException, AppException, DatabaseException {
		
		String defaultSetName = null;
		// Configuration.getProperty("curam.keyserver.default.unique.set");
		
		if (defaultSetName == null) {
			defaultSetName = "DEFAULT";
		}
		
		return nextUniqueID(defaultSetName);
	}
	
	public static void clearUniqueIDs() { // throws UnimplementedException {
	
		if (!(stUseSimpleKeyServerMock)) {
			// throw new UnimplementedException();
		}
		stInstantiatedSets = new Hashtable();
	}
	
	private static final class UniqueIDSet {
		
		private static final String kKeyServerImplClass = "com.company.itos.core.util.keyserver.KeyServerImpl";
		
		private static final short kLoBits = 8;
		
		private static final short kTotalBits = 64;
		
		private static final long kMaxLoKey = 255L;
		
		private static final long kLoKeyMask = 255L;
		
		private static final long kMaxTotalKey = 0L;
		
		private static final long kHiKeyMask = -255L;
		
		private static final long kLoBitMask = 1L;
		
		private static KeyServerInterface stHiddenImpl;
		
		private long nextKeyValue;
		
		private final String keySetName;
		
		private boolean humanReadable = true;
		
		private int cachedBlockCount;
		
		private long currentHi;
		
		private long nextLo;
		
		private long loSeed;
		
		// private final Random rand = new Random(DateTime.getCurrentDateTime().asLong());
		private final Random rand = new Random(Calendar.getInstance().getTimeInMillis());
		
		private long counterLo = 256L;
		
		UniqueIDSet(String keySet) {

			this.keySetName = keySet;
			if (UniqueID.isUseSimpleKeyServerMock())
				this.nextKeyValue = 0L;
		}
		
		long nextKeyInSet() { // throws AppException {
		
			if (UniqueID.isUseSimpleKeyServerMock()) {
				this.nextKeyValue += 1L;
				return this.nextKeyValue;
			}
			
			this.nextKeyValue = 0L;
			
			if (this.counterLo > 255L) {
				nextHiKey();
				
				/*if (Trace.atLeast(Trace.kTraceUltraVerbose)) {
					LocalisableString localisedMessage = new LocalisableString(
							INFRASTRUCTURE.LOG_ID_KEY_SET_BLOCK_ALLOC);

					localisedMessage.arg(this.currentHi);
					localisedMessage.arg(this.keySetName);
					Trace.kTopLevelLogger.info(localisedMessage.getMessage());
				}*/

				this.counterLo = 0L;
				
				if (this.humanReadable){
					
					this.loSeed = 1L;
					this.nextLo = 0L;
					
				} else {
					
					this.loSeed = (this.rand.nextInt() & 0xFF | 1L);
					this.nextLo = (this.rand.nextInt() & 0xFF);
					
				}
				
			} else {
				
				this.nextLo = (this.nextLo + this.loSeed & 0xFF);
				
			}
			
			this.counterLo += 1L;
			
			this.nextKeyValue = (this.currentHi << 8);
			
			this.nextKeyValue = (this.nextKeyValue & 0xFFFFFF01 | this.nextLo);
			
			if (!(this.humanReadable)) {
				
				long tmpValue = this.nextKeyValue;
				this.nextKeyValue = 0L;
				
				for (short i = 0; i < 64; i = (short) (i + 1)) {
					
					this.nextKeyValue <<= 1;
					this.nextKeyValue |= tmpValue & 1L;
					
					tmpValue >>= 1;
					
				}
			}
			
			return ((this.nextKeyValue == 0L) ? nextKeyInSet() : this.nextKeyValue);
		}

		/**
		 * 
		 */
		private void nextHiKey() {// throws DatabaseException, AppRuntimeException {
		
			if (this.cachedBlockCount > 0) {
				this.cachedBlockCount -= 1;
				this.currentHi += 1L;
				
				return;
				
			}
			
			KeyServerBlock keyOut = getHidden().nextId(this.keySetName);
			
			this.currentHi = keyOut.getNextUniqueIdBlock();
			
			if (this.currentHi >= keyOut.getNextUniqueIdBlock()) {
				// throw new AppRuntimeException(
				// new AppException(
				// INFRASTRUCTURE.RUN_UNIQUE_ID_KEY_SERVER_OUT_OF_SYNC_ERROR));
			}
			
			this.humanReadable = keyOut.getHumanReadable();
			
			this.cachedBlockCount = (keyOut.getBlockCount() - 1);
		}
		
		/**
		 * 
		 * @return
		 */
		private static KeyServerInterface getHidden() // throws AppRuntimeException
		{

			if (stHiddenImpl != null)
				return stHiddenImpl;
			try {
				Object o = Class.forName(kKeyServerImplClass).newInstance();
				stHiddenImpl = (KeyServerInterface) o;
			} catch (Exception e) {
				// throw new AppRuntimeException(e);
			}
			return stHiddenImpl;
		}
		
	}

	/**
	 * 
	 * @return
	 */
	static boolean isUseSimpleKeyServerMock() {

		return stUseSimpleKeyServerMock;
	}
	
}
