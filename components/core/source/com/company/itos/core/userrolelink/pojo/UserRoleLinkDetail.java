package com.company.itos.core.userrolelink.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class UserRoleLinkDetail {
	
	private String username;
	
	private Timestamp startDate;
	
	private Date endDate;
	
	private int userRoleLinkID;
	
	private int roleID;
	
	private String comments;
	
	private String recordStatus;
	
	private int versionNo;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getUserRoleLinkID() {
		return userRoleLinkID;
	}

	public void setUserRoleLinkID(int userRoleLinkID) {
		this.userRoleLinkID = userRoleLinkID;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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
