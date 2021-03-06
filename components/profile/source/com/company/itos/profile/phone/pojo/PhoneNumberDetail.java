package com.company.itos.profile.phone.pojo;


public class PhoneNumberDetail {
	
	private long phoneNumberID;
	
	private int countryCode;
	
	private int areaCode;
	
	private Long phoneNumber;
	
	private int extension;
	
	private String recordStatus;
	
	private int versionNo;

	/**
	 * @return the phoneNumberID
	 */
	public long getPhoneNumberID() {
		return phoneNumberID;
	}

	/**
	 * @param phoneNumberID the phoneNumberID to set
	 */
	public void setPhoneNumberID(long phoneNumberID) {
		this.phoneNumberID = phoneNumberID;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}


	public int getExtension() {
		return extension;
	}

	public void setExtension(int extension) {
		this.extension = extension;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
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
