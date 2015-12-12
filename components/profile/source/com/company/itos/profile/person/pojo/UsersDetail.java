package com.company.itos.profile.person.pojo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class UsersDetail {

	private String userName;

	private String password;

	private String errorMessage;

	private int versionNo;
	
	private int relatedID;
	
	private int accountEnabled;
	
	private Date creationDate;
	
	private Date passwordExpiryDate;
	
	private Date userWorkspace;
	
	private String recordStatus;
	

	/**
	 * @return the accountEnabled
	 */
	public int getAccountEnabled() {
		return accountEnabled;
	}

	/**
	 * @param accountEnabled the accountEnabled to set
	 */
	public void setAccountEnabled(int accountEnabled) {
		this.accountEnabled = accountEnabled;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the passwordExpiryDate
	 */
	public Date getPasswordExpiryDate() {
		return passwordExpiryDate;
	}

	/**
	 * @param passwordExpiryDate the passwordExpiryDate to set
	 */
	public void setPasswordExpiryDate(Date passwordExpiryDate) {
		this.passwordExpiryDate = passwordExpiryDate;
	}

	/**
	 * @return the userWorkspace
	 */
	public Date getUserWorkspace() {
		return userWorkspace;
	}

	/**
	 * @param userWorkspace the userWorkspace to set
	 */
	public void setUserWorkspace(Date userWorkspace) {
		this.userWorkspace = userWorkspace;
	}

	/**
	 * @return the recordStatus
	 */
	public String getRecordStatus() {
		return recordStatus;
	}

	/**
	 * @param recordStatus the recordStatus to set
	 */
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	/**
	 * @return the relatedID
	 */
	public int getRelatedID() {
		return relatedID;
	}

	/**
	 * @param relatedID the relatedID to set
	 */
	public void setRelatedID(int relatedID) {
		this.relatedID = relatedID;
	}

	List<String> errorMessageList = new ArrayList<String>();

	private int loginFailureCount;

	/**
	 * 
	 * @return password
	 */
	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getUserName() {

		return userName;
	}

	public void setUserName(String userName) {

		this.userName = userName;
	}

	public String getErrorMessage() {

		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {

		this.errorMessage = errorMessage;
	}

	public int getVersionNo() {

		return versionNo;
	}

	public void setVersionNo(int versionNo) {

		this.versionNo = versionNo;
	}

	public List<String> getErrorMessageList() {

		return errorMessageList;
	}

	public void setErrorMessageList(List<String> errorMessageList) {

		this.errorMessageList = errorMessageList;
	}

	public int getLoginFailureCount() {

		return loginFailureCount;
	}

	public void setLoginFailureCount(int loginFailureCount) {

		this.loginFailureCount = loginFailureCount;
	}

}
