package com.company.itos.profile.phone.pojo;

import java.sql.Date;

public class PhoneNumberLinkDetail {
	
	private int phoneNumberLinkID;
	
	private int relatedID;
	
	private String typeCode;
	
	private int primaryInd;
	
	private Date startDate;
	
	private Date endDate;
	
	private String comments;
	
	private int versionNo;
	
	private int phoneNumberID;
	
	private PhoneNumberDetail phoneNumberDetail = null;

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

	public int getPhoneNumberID() {
		return phoneNumberID;
	}

	public void setPhoneNumberID(int phoneNumberID) {
		this.phoneNumberID = phoneNumberID;
	}

	public PhoneNumberDetail getPhoneNumberDetail() {
		return phoneNumberDetail;
	}

	public void setPhoneNumberDetail(PhoneNumberDetail phoneNumberDetail) {
		this.phoneNumberDetail = phoneNumberDetail;
	}

}