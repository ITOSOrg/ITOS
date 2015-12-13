package com.company.itos.core.util.keyserver;

import java.io.Serializable;

/**
 * 
 * @author Rahul
 */
public class KeyServerBlock implements Serializable {

	private static final long serialVersionUID = 1L;
	private final int blockCount;
	private long nextUniqueIdBlock;
	private final boolean humanReadable;

	/**
	 * 
	 * @param nextUniqueIdBlock
	 * @param humanReadable
	 * @param blockCount
	 */
	public KeyServerBlock(long nextUniqueIdBlock, boolean humanReadable,
			int blockCount) {
		
		this.nextUniqueIdBlock = nextUniqueIdBlock;
		this.humanReadable = humanReadable;
		this.blockCount = blockCount;
		
	}

	public int getBlockCount() {
		return this.blockCount;
	}

	public long getNextUniqueIdBlock() {
		this.nextUniqueIdBlock += 1L;
		return this.nextUniqueIdBlock;
	}

	public boolean getHumanReadable() {
		return this.humanReadable;
	}
}
