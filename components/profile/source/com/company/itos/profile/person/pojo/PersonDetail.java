package com.company.itos.profile.person.pojo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.profile.address.pojo.AddressLinkDetail;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

public class PersonDetail {

	private long personID;

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
	
	private Timestamp registrationDate;
	
	//private EmailAddressDetail emailAddressDetail = null;
	
	//private  PhoneNumberDetail phoneNumberDetail = null;
	
	private EmailAddressLinkDetail emailAddressLinkDetail = null;
	
	private PhoneNumberLinkDetail phoneNumberLinkDetail = null;
	
	//private String emailAddress;
	
	private AddressLinkDetail addressLinkDetail = null;
	
	private PersonIdentityDetail personIdentityDetail = null;
	
	private RoleDetail roleDetail = null;
	
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
	
	

	/*public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}*/

	

	public int getRefrenceNumber() {

		return refrenceNumber;
	}

	/**
	 * @return the personID
	 */
	public long getPersonID() {
		return personID;
	}

	/**
	 * @param personID the personID to set
	 */
	public void setPersonID(long personID) {
		this.personID = personID;
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

	public Timestamp getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public EmailAddressLinkDetail getEmailAddressLinkDetail() {
		return emailAddressLinkDetail;
	}

	public void setEmailAddressLinkDetail(EmailAddressLinkDetail emailAddressLinkDetail) {
		this.emailAddressLinkDetail = emailAddressLinkDetail;
	}

	public PhoneNumberLinkDetail getPhoneNumberLinkDetail() {
		return phoneNumberLinkDetail;
	}

	public void setPhoneNumberLinkDetail(PhoneNumberLinkDetail phoneNumberLinkDetail) {
		this.phoneNumberLinkDetail = phoneNumberLinkDetail;
	}

	public AddressLinkDetail getAddressLinkDetail() {
		return addressLinkDetail;
	}

	public void setAddressLinkDetail(AddressLinkDetail addressLinkDetail) {
		this.addressLinkDetail = addressLinkDetail;
	}

	public PersonIdentityDetail getPersonIdentityDetail() {
		return personIdentityDetail;
	}

	public void setPersonIdentityDetail(PersonIdentityDetail personIdentityDetail) {
		this.personIdentityDetail = personIdentityDetail;
	}

	public RoleDetail getRoleDetail() {
		return roleDetail;
	}

	public void setRoleDetail(RoleDetail roleDetail) {
		this.roleDetail = roleDetail;
	}

}
