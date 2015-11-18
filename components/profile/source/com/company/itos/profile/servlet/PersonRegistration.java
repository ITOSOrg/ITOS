package com.company.itos.profile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.JavaUtildates;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;
import com.company.itos.profile.pojo.PersonDetail;
import com.company.itos.profile.pojo.UsersDetail;
import com.company.itos.profile.address.pojo.AddressDetail;
import com.company.itos.profile.address.pojo.AddressLinkDetail;
import com.company.itos.profile.dao.PersonRegistrationDAO;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;

/**
 * Servlet implementation class PersonRegistration
 */
public class PersonRegistration extends HttpServlet {
	UsersDetail usersDetail = new UsersDetail();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonRegistration() {

		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Inside doPost method");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		PersonDetail personDetail = new PersonDetail();

		// Call Validate Method
		boolean errorInd = validatePersonDetails(request, personDetail);
		String pageForwardStr = "";

		if (errorInd) {

			pageForwardStr = "/RegistrationForm.jsp";

			// RequestDispatcher requestDispatcher =
			// request.getRequestDispatcher("/RegistrationForm.jsp");
			// requestDispatcher.forward(request, response);

		} else {

			PersonRegistrationDAO personRegistrationDAO = new PersonRegistrationDAO();
			String returnMassegeStr = personRegistrationDAO.registerPerson(personDetail);

			if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

				pageForwardStr = "/PersonHome";
				pageForwardStr += "?personID=" + personDetail.getPersonID();

			} else {

				pageForwardStr = "/RegistrationForm.jsp";
			}
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

	/**
	 * This method will validate Person details input parameters.
	 * 
	 * @param request
	 * @param personDetail
	 */
	private boolean validatePersonDetails(HttpServletRequest request, PersonDetail personDetail) {

		List<String> errorMessageList = new ArrayList<String>();
		EmailAddressDetail emailAddressDetail = new EmailAddressDetail();
		EmailAddressLinkDetail emailAddressLinkDetail = new EmailAddressLinkDetail();

		String dateOfBirth = request.getParameter("dateOfBirth");
		String title = request.getParameter("title");
		String gender = request.getParameter("gender");

		String emailAddress = request.getParameter("emailAddress");
		String typeCode = request.getParameter("typeCode");
		String primaryInd = request.getParameter("primaryInd");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		/*
		 * String streetOne = request.getParameter("streetOne"); String
		 * streetTwo = request.getParameter("streetTwo"); String aptUnit =
		 * request.getParameter("aptUnit"); String city =
		 * request.getParameter("city"); String county =
		 * request.getParameter("county"); String state =
		 * request.getParameter("state"); String country =
		 * request.getParameter("country"); int zipCode =(new Integer
		 * (request.getParameter("zipCode")));
		 */

		personDetail.setTitle(title);
		personDetail.setGender(gender);

		emailAddressDetail.setEmailAddress(emailAddress);
		emailAddressLinkDetail.setTypeCode(typeCode);
		emailAddressLinkDetail.setPrimaryInd(primaryInd);
		java.util.Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			emailAddressLinkDetail.setStartDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			emailAddressLinkDetail.setEndDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		emailAddressLinkDetail.setEmailAddressDetail(emailAddressDetail);
		personDetail.setEmailAddressLinkDetail(emailAddressLinkDetail);

		/*
		 * personDetail.setStreetOne(streetOne);
		 * personDetail.setStreetTwo(streetTwo);
		 * personDetail.setAptUnit(aptUnit); personDetail.setCity(city);
		 * personDetail.setCounty(county); personDetail.setState(state);
		 * personDetail.setCountry(country); personDetail.setZipCode(zipCode);
		 */

		/**
		 * JavaUtildates javaUtildates = new JavaUtildates(); java.sql.Date
		 * sqlDate = javaUtildates.stringToDateConversion(dateOfBirth);
		 * personDetail.setDateOfBirth(sqlDate);
		 */

		try {

			java.util.Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
			java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
			personDetail.setDateOfBirth(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		String userName = request.getParameter("userName");

		usersDetail.setUserName(userName);

		personDetail.setUsersDetail(usersDetail);

		String firstName = request.getParameter("firstName");
		String pattern = "^[a-zA-Z]*$";
		if (!firstName.matches(pattern) || firstName == null) {

			errorMessageList.add("FirstName	must	contain	A-Z	or	a-z	characters	only.");
			personDetail.setFirstName(firstName);

		} else {
			try {

				personDetail.setFirstName(firstName);
			} catch (Exception E) {
			}

		}

		String middleName = request.getParameter("middleName");
		if (!middleName.matches(pattern) || middleName == null) {

			errorMessageList.add("MiddleName	must	contain	A-Z	or	a-z	characters	only.\n");
			personDetail.setMiddleName(middleName);
		} else {
			try {
				personDetail.setMiddleName(middleName);
			} catch (Exception E) {
			}
		}
		String lastName = request.getParameter("lastName");
		if (!lastName.matches(pattern) || lastName == null) {

			errorMessageList.add("LastName	must	contain	A-Z	or	a-z	characters	only.\n");
			personDetail.setLastName(lastName);
		} else {
			try {
				personDetail.setLastName(lastName);
			} catch (Exception E) {

			}
		}
		String password = request.getParameter("password");
		usersDetail.setPassword(password);
		/*
		 * if (password.length() < 8) {
		 * errorMessageList.add("Password must contain at 8 charachters"); }
		 */

		// Phone Number Parameters
		PhoneNumberDetail phoneNumberDetail = new PhoneNumberDetail();
		PhoneNumberLinkDetail phoneNumberLinkDetail = new PhoneNumberLinkDetail();

		Integer countryCode = (new Integer(request.getParameter("countryCode")));
		Integer areaCode = (new Integer(request.getParameter("areaCode")));
		Long phoneNumber = (new Long(request.getParameter("phoneNumber")));
		Integer extension = (new Integer(request.getParameter("extension")));
		Integer primaryInd1 = (new Integer(request.getParameter("primaryInd")));
		String typeCode1 = request.getParameter("typeCode");
		String startDate1 = request.getParameter("startDate");
		String endDate1 = request.getParameter("endDate");

		phoneNumberDetail.setCountryCode(countryCode);
		phoneNumberDetail.setAreaCode(areaCode);
		phoneNumberDetail.setPhoneNumber(phoneNumber);
		phoneNumberDetail.setExtension(extension);
		phoneNumberLinkDetail.setPrimaryInd(primaryInd1);
		phoneNumberLinkDetail.setTypeCode(typeCode1);

		java.util.Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate1);
			java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
			phoneNumberLinkDetail.setStartDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate1);
			java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
			phoneNumberLinkDetail.setEndDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		phoneNumberLinkDetail.setPhoneNumberDetail(phoneNumberDetail);
		personDetail.setPhoneNumberLinkDetail(phoneNumberLinkDetail);
		
		
		// insert data for Address table
		
		
		AddressDetail addressDetail = new AddressDetail();
		
		String streetOne = request.getParameter("streetOne");
		String streetTwo = request.getParameter("streetTwo");
		String aptUnit = request.getParameter("aptUnit");
		String city = request.getParameter("city");
		String county = request.getParameter("county");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		int zipCode =(new Integer (request.getParameter("zipCode")));
		
		addressDetail.setStreetOne(streetOne);
		addressDetail.setStreetTwo(streetTwo);
		addressDetail.setAptUnit(aptUnit);
		addressDetail.setCity(city);
		addressDetail.setCounty(county);
		addressDetail.setState(state);
		addressDetail.setCountry(country);
		addressDetail.setZipCode(zipCode);
		
		AddressLinkDetail addressLinkDetail = new AddressLinkDetail();
		
		String typeCode2 = request.getParameter("typeCode");
		int primaryInd2 =(new Integer (request.getParameter("primaryInd")));
		String startDate2 = request.getParameter("startDate");
		String endDate2 = request.getParameter("endDate");
		
		addressLinkDetail.setTypeCode(typeCode2);
		addressLinkDetail.setPrimaryInd(primaryInd2);
		
		java.util.Date date2;
		try {
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			java.sql.Date sqlDate = new java.sql.Date(date2.getTime());
			addressLinkDetail.setStartDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			java.sql.Date sqlDate = new java.sql.Date(date2.getTime());
			addressLinkDetail.setEndDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		addressLinkDetail.setAddressDetail(addressDetail);
		personDetail.setAddressLinkDetail(addressLinkDetail);

		personDetail.setErrorMessageList(errorMessageList);
		request.setAttribute("personDetail", personDetail);

		return !errorMessageList.isEmpty();

	}
}
