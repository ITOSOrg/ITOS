package com.company.itos.profile.pojo;

import java.sql.Date;

public class EmailAddressDetail {

	private String emailAddress;
	private String typeCode;
	private String primaryInd;
	private Date startDate;
	private Date endDate;
	private String comments;
	private int emailAddressID;
	private int emailAddressLinkID;

	public int getEmailAddressLinkID() {
		return emailAddressLinkID;
	}

	public void setEmailAddressLinkID(int emailAddressLinkID) {
		this.emailAddressLinkID = emailAddressLinkID;
	}

	public int getEmailAddressID() {
		return emailAddressID;
	}

	public void setEmailAddressID(int emailAddressID) {
		this.emailAddressID = emailAddressID;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

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

}
