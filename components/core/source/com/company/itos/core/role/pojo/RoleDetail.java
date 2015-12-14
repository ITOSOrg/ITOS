package com.company.itos.core.role.pojo;

import java.sql.Timestamp;

import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;

public class RoleDetail {
		
	private int roleID;
	
	private String roleType;
	
	private String workspace;
	
	private String recordStatus;
	
	private int versionNo;
	
	private String createdBy;

	private String lastModifiedBy;

	private Timestamp createdOn;

	private Timestamp lastModifiedOn;
	
	private UserRoleLinkDetail userRoleLinkDetail = null;
	
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


	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getWorkspace() {
		return workspace;
	}

	public void setWorkspace(String workspace) {
		this.workspace = workspace;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(Timestamp lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	public UserRoleLinkDetail getUserRoleLinkDetail() {
		return userRoleLinkDetail;
	}

	public void setUserRoleLinkDetail(UserRoleLinkDetail userRoleLinkDetail) {
		this.userRoleLinkDetail = userRoleLinkDetail;
	}
	
}
