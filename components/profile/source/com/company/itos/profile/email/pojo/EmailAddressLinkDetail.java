package com.company.itos.profile.email.pojo;

import java.sql.Date;

public class EmailAddressLinkDetail {

	private String typeCode;
	private String primaryInd;
	private Date startDate;
	private Date endDate;
	private String comments;
	private int emailAddressLinkID;
	private int relatedID;
	private int emailAddressID;
	private int versionNo;
	private EmailAddressDetail emailAddressDetail = null;
	
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getPrimaryInd() {
		return primaryInd;
	}
	public void setPrimaryInd(String primaryInd) {
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
	public int getEmailAddressLinkID() {
		return emailAddressLinkID;
	}
	public void setEmailAddressLinkID(int emailAddressLinkID) {
		this.emailAddressLinkID = emailAddressLinkID;
	}
	public int getRelatedID() {
		return relatedID;
	}
	public void setRelatedID(int relatedID) {
		this.relatedID = relatedID;
	}
	public int getEmailAddressID() {
		return emailAddressID;
	}
	public void setEmailAddressID(int emailAddressID) {
		this.emailAddressID = emailAddressID;
	}
	public int getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}
	public EmailAddressDetail getEmailAddressDetail() {
		return emailAddressDetail;
	}
	public void setEmailAddressDetail(EmailAddressDetail emailAddressDetail) {
		this.emailAddressDetail = emailAddressDetail;
	}
}
