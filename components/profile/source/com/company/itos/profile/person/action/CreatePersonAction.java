package com.company.itos.profile.person.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.person.dao.PersonHomeDAO;
import com.company.itos.profile.person.dao.PersonRegistrationDAO;
import com.company.itos.profile.person.pojo.PersonDetail;
import com.company.itos.profile.person.pojo.UsersDetail;
import com.opensymphony.xwork2.ActionSupport;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreatePersonAction extends ActionSupport implements SessionAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	HttpServletRequest request;
	private PersonDetail personDetail;

	public void setSession(Map<String, Object> sessionInput) {
		this.session = sessionInput;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getServletRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @return the personDetail
	 */
	public PersonDetail getPersonDetail() {
		return personDetail;
	}

	/**
	 * @param personDetail
	 *            the personDetail to set
	 */
	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}


	public String createPerson() throws Exception {

		String pageForwardStr = "";
		

		PersonRegistrationDAO personRegistrationDAO = new PersonRegistrationDAO();
		String returnMassegeStr = personRegistrationDAO.registerPerson(personDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}
		return pageForwardStr;
	}

	/*
	 * public String updatePerson() throws Exception {
	 * 
	 * 
	 * return null;
	 * 
	 * } public String deletePerson() throws Exception {
	 * 
	 * 
	 * return null;
	 * 
	 * }
	 */
	

	

	/*public void validate() {
		System.out.println("inside validate method");
		String letters = "/^[A-Za-z]+$/";
		// Validation for First Name

		if (personDetail.getFirstName() == null || personDetail.getFirstName().trim().equals("")) {
			addFieldError("personDetail.firstName", "The FirstName is required");
		} else if (!personDetail.getFirstName().matches(letters)) {

			addFieldError("personDetail.firstName", "FirstName must contain ablphabet");
		}

		// Validation for Middle Name

		if (personDetail.getMiddleName() == null || personDetail.getMiddleName().trim().equals("")) {
			addFieldError("personDetail.middleName", "The MiddleName is required");
		} else if (!personDetail.getMiddleName().matches(letters)) {

			addFieldError("personDetail.middleName", "MiddleName must contain ablphabet");
		}

		// Validation for Last Name

		if (personDetail.getLastName() == null || personDetail.getLastName().trim().equals("")) {
			addFieldError("personDetail.lastName", "The LastName is required");
		} else if (!personDetail.getLastName().matches(letters)) {

			addFieldError("personDetail.lastName", "LastName must contain ablphabet");
		}

		// Validation for User Name and Password

		if (personDetail.getUsersDetail().getUserName().length() == 0) {
			addFieldError("personDetail.usersDetail.userName", "UserName.required");
		} else if (!personDetail.getUsersDetail().getUserName().equals("")) {
			addFieldError("userName", "Invalid User");
		}
		if (personDetail.getUsersDetail().getPassword().length() == 0) {
			addFieldError("personDetail.usersDetail.password", getText("password.required"));
		} else if (personDetail.getUsersDetail().getPassword().length() < 6) {
			addFieldError("personDetail.usersDetail.password", "Password must be minimum of 6 characters");
		}

		// Validation for Email Address

		if (personDetail.getEmailAddressLinkDetail().getEmailAddressDetail().getEmailAddress().equals("")) {
			addFieldError("personDetail.emailAddressLinkDetail.emailAddressDetail.emailAddress", "The Email can't be empty");
		} else {
			String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			CharSequence inputStr = personDetail.getEmailAddressLinkDetail().getEmailAddressDetail().getEmailAddress();
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(inputStr);
			if (!matcher.matches())
				addFieldError("personDetail.emailAddressLinkDetail.emailAddressDetail.emailAddress", "Invalid email address");
		}

		// Validation for DateOfBirth

		// Validation for Street one

		if (personDetail.getAddressLinkDetail().getAddressDetail().getStreetOne() == null
				|| personDetail.getAddressLinkDetail().getAddressDetail().getStreetOne().trim().equals("")) {
			addFieldError("personDetail.addressLinkDetail.addressDetail.streetOne", "Please Enter Street one");
		}

		// Validation for Street Two

		if (personDetail.getAddressLinkDetail().getAddressDetail().getStreetTwo() == null
				|| personDetail.getAddressLinkDetail().getAddressDetail().getStreetTwo().trim().equals("")) {
			addFieldError("personDetail.addressLinkDetail.addressDetail.streetTwo", "Please Enter Street Two");
		}

		// Validation for Phone Number
		
		if(!personDetail.getPhoneNumberLinkDetail().getPhoneNumberDetail().getCountryCode().isNumeric()){
			
			addFieldError
			 ("personDetail.phoneNumberLinkDetail.phoneNumberDetail.countryCode", "Phone number is required");
			
		}
		
		// Validation for Phone Number

		 if (!personDetail.getPhoneNumberLinkDetail().getPhoneNumberDetail().
		 getPhoneNumber().equals("")) &&
		 !personDetail.getPhoneNumberLinkDetail
		 ().getPhoneNumberDetail().getPhoneNumber().isNumeric() {
		 addFieldError
		 ("personDetail.phoneNumberLinkDetail.phoneNumberDetail.phoneNumber",
		 "Phone number is required"); }
		 
		 if (!personDetail.getPhoneNumberLinkDetail().getPhoneNumberDetail().
		 getPhoneNumber().equals("") &&
		 personDetail.getPhoneNumberLinkDetail()
		 .getPhoneNumberDetail().getPhoneNumber().length()!=10) {
		 addFieldError("mobile", "Phone number should have ten digits"); }
		

	}*/
}
