package com.company.itos.profile.personIdentity.pojo;

import java.sql.Date;

public class PersonIdentityDetail {
	
	private int personIdentityID;
	
	private int personID;
	
	private int alternateID;
	
	private String primaryInd;
	
	private String typeCode;
	
	private Date startDate;
	
	private Date endDate;
	
	private String recordStatus;
	
	private int versionNo;

	public int getPersonIdentityID() {
		return personIdentityID;
	}

	public void setPersonIdentityID(int personIdentityID) {
		this.personIdentityID = personIdentityID;
	}

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public int getAlternateID() {
		return alternateID;
	}

	public void setAlternateID(int alternateID) {
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
	

}
