package com.company.itos.core.keyserver.pojo;

import java.sql.Timestamp;

public class KeyServerDetail {
		
	private String keysetCode;
	
	private long nextUniqueIdBlock;
	
	private String humanReadable;
	
	private String annotation;
	
	private String strategy;
	
	private String recordStatus;
	
	private String createdBy;

	private String lastModifiedBy;

	private Timestamp createdOn;

	private Timestamp lastModifiedOn;
	
	private int versionNo;

	public String getKeysetCode() {
		return keysetCode;
	}

	public void setKeysetCode(String keysetCode) {
		this.keysetCode = keysetCode;
	}

	public long getNextUniqueIdBlock() {
		return nextUniqueIdBlock;
	}

	public void setNextUniqueIdBlock(long nextUniqueIdBlock) {
		this.nextUniqueIdBlock = nextUniqueIdBlock;
	}

	public String getHumanReadable() {
		return humanReadable;
	}

	public void setHumanReadable(String humanReadable) {
		this.humanReadable = humanReadable;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(Timestamp lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}
}
