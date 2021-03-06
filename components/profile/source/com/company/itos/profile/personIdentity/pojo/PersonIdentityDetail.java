package com.company.itos.profile.personIdentity.pojo;

import java.util.Date;

import com.company.itos.core.audittrail.pojo.AuditTrailDtls;


public class PersonIdentityDetail {
	
	private long personIdentityID;
	
	private long personID;
	
	private String alternateID;
	
	private String primaryInd;
	
	private String typeCode;
	
	private Date startDate;
	
	private Date endDate;
	
	private String recordStatus;
	
	private int versionNo;
	
	private AuditTrailDtls auditTrailDtls = null;
	
	private String updateAction = "update";
	
	/**
	 * @return the updateAction
	 */
	public String getUpdateAction() {
		return updateAction;
	}

	/**
	 * @param updateAction the updateAction to set
	 */
	public void setUpdateAction(String updateAction) {
		this.updateAction = "update";
	}

	/**
	 * @return the personIdentityID
	 */
	public long getPersonIdentityID() {
		return personIdentityID;
	}

	/**
	 * @param personIdentityID the personIdentityID to set
	 */
	public void setPersonIdentityID(long personIdentityID) {
		this.personIdentityID = personIdentityID;
	}

	/**
	 * @return the personID
	 */
	public long getPersonID() {
		return personID;
	}

	/**
	 * @param personID the personID to set
	 */
	public void setPersonID(long personID) {
		this.personID = personID;
	}

	

	/**
	 * @return the alternateID
	 */
	public String getAlternateID() {
		return alternateID;
	}

	/**
	 * @param alternateID the alternateID to set
	 */
	public void setAlternateID(String alternateID) {
		this.alternateID = alternateID;
	}

	public String getPrimaryInd() {
		return primaryInd;
	}

	public void setPrimaryInd(String primaryInd) {
		this.primaryInd = primaryInd;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

	/**
	 * @return the auditTrailDtls
	 */
	public AuditTrailDtls getAuditTrailDtls() {
		return auditTrailDtls;
	}

	/**
	 * @param auditTrailDtls the auditTrailDtls to set
	 */
	public void setAuditTrailDtls(AuditTrailDtls auditTrailDtls) {
		this.auditTrailDtls = auditTrailDtls;
	}
	

}
