package com.company.itos.profile.pojo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDetail {

	private int personID;

	private int refrenceNumber;

	private int versionNo;
	
	private String title;

	private String firstName;

	private String middleName;

	private String lastName;

	private String userName;
	
	private String gender;

	private String recordStatus;

	private Date dateOfBirth;

	private UsersDetail usersDetail = null;

	List<String> errorMessageList = new ArrayList<String>();

	private String createdBy;

	private String modifiedBy;

	private Timestamp createdOn;

	private Timestamp modifiedOn;

	public int getPersonID() {

		return personID;
	}

	public void setPersonID(int personID) {

		this.personID = personID;
	}

	public int getRefrenceNumber() {

		return refrenceNumber;
	}

	public void setRefrenceNumber(int refrenceNumber) {

		this.refrenceNumber = refrenceNumber;
	}

	public String getFirstName() {

		return firstName;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public String getMiddleName() {

		return middleName;
	}

	public void setMiddleName(String middleName) {

		this.middleName = middleName;
	}

	public String getLastName() {

		return lastName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	public String getUserName() {

		return userName;
	}

	public void setUserName(String userName) {

		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {

		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {

		this.dateOfBirth = dateOfBirth;
	}

	public UsersDetail getUsersDetail() {

		return usersDetail;
	}

	public void setUsersDetail(UsersDetail usersDetail) {

		this.usersDetail = usersDetail;
	}

	public List<String> getErrorMessageList() {

		return errorMessageList;
	}

	public void setErrorMessageList(List<String> errorMessageList) {

		this.errorMessageList = errorMessageList;
	}

	public String getCreatedBy() {

		return createdBy;
	}

	public void setCreatedBy(String createdBy) {

		this.createdBy = createdBy;
	}

	public String getModifiedBy() {

		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {

		this.modifiedBy = modifiedBy;
	}

	public Timestamp getCreatedOn() {

		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {

		this.createdOn = createdOn;
	}

	public Timestamp getModifiedOn() {

		return modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {

		this.modifiedOn = modifiedOn;
	}

	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

}
