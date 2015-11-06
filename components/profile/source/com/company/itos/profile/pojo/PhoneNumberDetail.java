package com.company.itos.profile.pojo;

import java.sql.Date;

public class PhoneNumberDetail {
	private int phoneNumberID;
	
	private int countryCode;
	
	private int areaCode;
	
	private Long phoneNumber;
	
	private int extension;
	
	private int phoneNumberLinkID;
	
	private int relatedID;
	
	private String typeCode;
	
	private int primaryInd;
	
	private Date startDate;
	
	private Date endDate;
	
	private String comments;
	
	private int versionNo;

	public int getPhoneNumberID() {
		return phoneNumberID;
	}

	public void setPhoneNumberID(int phoneNumberID) {
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

	public int getPhoneNumberLinkID() {
		return phoneNumberLinkID;
	}

	public void setPhoneNumberLinkID(int phoneNumberLinkID) {
		this.phoneNumberLinkID = phoneNumberLinkID;
	}

	public int getRelatedID() {
		return relatedID;
	}

	public void setRelatedID(int relatedID) {
		this.relatedID = relatedID;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public int getPrimaryInd() {
		return primaryInd;
	}

	public void setPrimaryInd(int primaryInd) {
		this.primaryInd = primaryInd;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}
	
	
	

}
