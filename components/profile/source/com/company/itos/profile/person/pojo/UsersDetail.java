package com.company.itos.profile.person.pojo;

import java.util.ArrayList;
import java.util.List;

public class UsersDetail {

	private String userName;

	private String password;

	private String errorMessage;

	private int versionNo;

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
