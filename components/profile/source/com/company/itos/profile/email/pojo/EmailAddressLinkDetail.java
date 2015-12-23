package com.company.itos.profile.email.pojo;

import java.sql.Date;

public class EmailAddressLinkDetail {

	private String typeCode;
	
	private String primaryInd;
	
	private Date startDate;
	
	private Date endDate;
	
	private String comments;
	
	private long emailAddressLinkID;
	
	private long relatedID;
	
	private long emailAddressID;
	
	private int versionNo;
	
	private EmailAddressDetail emailAddressDetail = null;
	
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
	 * @return the emailAddressLinkID
	 */
	public long getEmailAddressLinkID() {
		return emailAddressLinkID;
	}

	/**
	 * @param emailAddressLinkID the emailAddressLinkID to set
	 */
	public void setEmailAddressLinkID(long emailAddressLinkID) {
		this.emailAddressLinkID = emailAddressLinkID;
	}

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
