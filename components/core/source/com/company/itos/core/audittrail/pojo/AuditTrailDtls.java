package com.company.itos.core.audittrail.pojo;

import java.sql.Timestamp;

public class AuditTrailDtls {
	
	private long auditTrailID;
	
	private long relatedID;
	
	private String createdBy;
	
	private Timestamp createdOn;
	
	private String lastModifieddBy;
	
	private Timestamp lastModifiedOn;

	/**
	 * @return the auditTrailID
	 */
	public long getAuditTrailID() {
		return auditTrailID;
	}

	/**
	 * @param auditTrailID the auditTrailID to set
	 */
	public void setAuditTrailID(long auditTrailID) {
		this.auditTrailID = auditTrailID;
	}

	/**
	 * @return the relatedID
	 */
	public long getRelatedID() {
		return relatedID;
	}

	/**
	 * @param relatedID the relatedID to set
	 */
	public void setRelatedID(long relatedID) {
		this.relatedID = relatedID;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdOn
	 */
	public Timestamp getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the lastModifieddBy
	 */
	public String getLastModifieddBy() {
		return lastModifieddBy;
	}

	/**
	 * @param lastModifieddBy the lastModifieddBy to set
	 */
	public void setLastModifieddBy(String lastModifieddBy) {
		this.lastModifieddBy = lastModifieddBy;
	}

	/**
	 * @return the lastModifiedOn
	 */
	public Timestamp getLastModifiedOn() {
		return lastModifiedOn;
	}

	/**
	 * @param lastModifiedOn the lastModifiedOn to set
	 */
	public void setLastModifiedOn(Timestamp lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

}
