package com.company.itos.profile.person.pojo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.profile.address.pojo.AddressLinkDetail;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

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
	
	private Timestamp registrationDate;
	
	//private EmailAddressDetail emailAddressDetail = null;
	
	//private  PhoneNumberDetail phoneNumberDetail = null;
	
	private EmailAddressLinkDetail emailAddressLinkDetail = null;
	
	private PhoneNumberLinkDetail phoneNumberLinkDetail = null;
	
	//private String emailAddress;
	
	private String streetOne;
	
	private String streetTwo;
	
	private String aptUnit;
	
	private String city;
	
	private String county;
	
	private String state;
	
	private String country;
	
	private int zipCode;
	
	private AddressLinkDetail addressLinkDetail = null;
	
	private PersonIdentityDetail personIdentityDetail = null;
	
	

	/*public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}*/

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

	public Timestamp getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getStreetOne() {
		return streetOne;
	}

	public void setStreetOne(String streetOne) {
		this.streetOne = streetOne;
	}

	public String getStreetTwo() {
		return streetTwo;
	}

	public void setStreetTwo(String streetTwo) {
		this.streetTwo = streetTwo;
	}

	public String getAptUnit() {
		return aptUnit;
	}

	public void setAptUnit(String aptUnit) {
		this.aptUnit = aptUnit;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
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

}
