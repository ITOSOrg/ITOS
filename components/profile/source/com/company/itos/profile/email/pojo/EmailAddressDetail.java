package com.company.itos.profile.email.pojo;


public class EmailAddressDetail {

	private String emailAddress;
	
	private long emailAddressID;
	
	private int versionNo;
	
	private String recordStatus;
	
	/**
	 * @return the emailAddressID
	 */
	public long getEmailAddressID() {
		return emailAddressID;
	}

	/**
	 * @param emailAddressID the emailAddressID to set
	 */
	public void setEmailAddressID(long emailAddressID) {
		this.emailAddressID = emailAddressID;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

}
