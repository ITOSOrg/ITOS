package com.company.itos.profile.phone.pojo;

import java.sql.Date;

public class PhoneNumberLinkDetail {

	private long phoneNumberLinkID;

	private long relatedID = 0;

	private String typeCode;

	private String primaryInd;

	private Date startDate;

	private Date endDate;

	private String comments;

	private int versionNo;

	private long phoneNumberID;

	private PhoneNumberDetail phoneNumberDetail = null;
	
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

	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

	/**
	 * @return the phoneNumberLinkID
	 */
	public long getPhoneNumberLinkID() {
		return phoneNumberLinkID;
	}

	/**
	 * @param phoneNumberLinkID the phoneNumberLinkID to set
	 */
	public void setPhoneNumberLinkID(long phoneNumberLinkID) {
		this.phoneNumberLinkID = phoneNumberLinkID;
	}

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

	public PhoneNumberDetail getPhoneNumberDetail() {
		return phoneNumberDetail;
	}

	public void setPhoneNumberDetail(PhoneNumberDetail phoneNumberDetail) {
		this.phoneNumberDetail = phoneNumberDetail;
	}

}
