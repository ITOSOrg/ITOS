package com.company.itos.profile.email.pojo;

import java.sql.Date;

public class EmailAddressDetail {

	private String emailAddress;
	
	private int emailAddressID;
	
	private int versionNo;
	

	

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

	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

}
