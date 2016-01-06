package com.company.itos.core.userrolelink.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class UserRoleLinkDetail {

	private String username;

	private Timestamp startDate;

	private Date endDate;

	private long userRoleLinkID;

	private long roleID;

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

	/**
	 * @return the userRoleLinkID
	 */
	public long getUserRoleLinkID() {
		return userRoleLinkID;
	}

	/**
	 * @param userRoleLinkID
	 *            the userRoleLinkID to set
	 */
	public void setUserRoleLinkID(long userRoleLinkID) {
		this.userRoleLinkID = userRoleLinkID;
	}

	/**
	 * @return the roleID
	 */
	public long getRoleID() {
		return roleID;
	}

	/**
	 * @param roleID
	 *            the roleID to set
	 */
	public void setRoleID(long roleID) {
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
