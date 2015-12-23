package com.company.itos.profile.address.pojo;

import java.sql.Date;

public class AddressLinkDetail {
	
	private long addressLinkID;
	
	private long relatedID;
	
	private long addressID;
	
	private String typeCode;
	
	private String primaryInd;
	
	private Date startDate;
	
	private Date endDate;
	
	private String recordStatus;
	
	private String comments;
	
	private int versionNo;
	
	private AddressDetail addressDetail = null;
	
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

	/**
	 * @return the addressLinkID
	 */
	public long getAddressLinkID() {
		return addressLinkID;
	}

	/**
	 * @param addressLinkID the addressLinkID to set
	 */
	public void setAddressLinkID(long addressLinkID) {
		this.addressLinkID = addressLinkID;
	}

	/**
	 * @return the addressID
	 */
	public long getAddressID() {
		return addressID;
	}

	/**
	 * @param addressID the addressID to set
	 */
	public void setAddressID(long addressID) {
		this.addressID = addressID;
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

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
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

	public AddressDetail getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(AddressDetail addressDetail) {
		this.addressDetail = addressDetail;
	}

}
