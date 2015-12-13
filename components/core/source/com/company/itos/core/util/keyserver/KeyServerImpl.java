/**
 * 
 */
package com.company.itos.core.util.keyserver;

/**
 * 
 * @author Rahul
 */
public class KeyServerImpl implements KeyServerInterface {
	
	/**
	 * 
	 */
	public KeyServerBlock nextId(String keySet) { // throws AppRuntimeException {
	
		int numOfBlocks = 1;
		
		KeyServerBlock keyServerBlock = readAndModifyTable(keySet, numOfBlocks);
		
		return keyServerBlock;
	}
	
	protected KeyServerBlock readAndModifyTable(String keySet, int blocksRequestedIn) { // throws AppException, DatabaseException,
	
		// AppRuntimeException, InformationalException, RecordLockedException {
		
		int blocksRequested = blocksRequestedIn;
		
		long returnedIdBlock = 256;
		
		//Read from DB
		KeyServerBlock keyServerBlock = new KeyServerBlock(returnedIdBlock, false, blocksRequested);
		
		return keyServerBlock;
	}
	
}
