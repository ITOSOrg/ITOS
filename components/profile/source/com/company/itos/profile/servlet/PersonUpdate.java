package com.company.itos.profile.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.PersonDetail;
import com.company.itos.profile.dao.PersonUpdateDAO;

/**
 * Servlet implementation class PersonUpdate
 */
public class PersonUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonUpdate() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		boolean errorInd = false;
		String pageForwardStr = "";

		PersonDetail personDetail = new PersonDetail();

		errorInd = personValidate(request, personDetail);

		if (!errorInd) {

			int personID = (new Integer( request.getParameter("personID")));
			personDetail.setPersonID(personID);

			PersonUpdateDAO personUpdateDAO = new PersonUpdateDAO();
			String returnMassegeStr = personUpdateDAO
					.updatePerson(personDetail);
			if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

				//pageForwardStr = "/PersonHome";
				pageForwardStr = "/PersonList";
			} else {

				pageForwardStr = "/PersonHome?act=update";
			}

			/*
			 * int versionNumber = personUpdateDAO
			 * .returnVersionNumber(personDetail);
			 * 
			 * if (versionNumber != 0 && versionNumber ==
			 * personDetail.getVersionNo()) {
			 * 
			 * personUpdateDAO.updatePerson(personDetail);
			 * personUpdateDAO.versionNumberIncreament(personDetail);
			 * request.setAttribute("personDetail", personDetail);
			 * 
			 * if (personDetail != null) { pageForwardStr = "/PersonHome"; }
			 * else { errorInd = true; }
			 * 
			 * }
			 */

		}

		if (errorInd) {
			pageForwardStr = "/UpdatedRegistrationForm.jsp";
		}

		RequestDispatcher rd1 = request.getRequestDispatcher(pageForwardStr);
		rd1.forward(request, response);
	}

	private boolean personValidate(HttpServletRequest request,
			PersonDetail personDetail) {

		List<String> errorMessageList = new ArrayList<String>();

		String dateOfBirth = request.getParameter("dateOfBirth");
		String title = request.getParameter("title");
		String gender = request.getParameter("gender");
		
		personDetail.setTitle(title);
		personDetail.setGender(gender);

		/**
		 * JavaUtildates javaUtildates = new JavaUtildates(); java.sql.Date sqlDate = javaUtildates.stringToDateConversion(dateOfBirth);
		 * personDetail.setDateOfBirth(sqlDate);
		 */

		try {

			java.util.Date date = new SimpleDateFormat("MM-dd-yyyy").parse(dateOfBirth);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			personDetail.setDateOfBirth(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String pattern = "^[a-zA-Z]*$";

		String firstName = request.getParameter("firstName");
		if (firstName == null || !firstName.matches(pattern)) {
			errorMessageList
					.add("FirstName	must	contain	A-Z	or	a-z	characters	only.");
			personDetail.setFirstName(firstName);
		} else {
			personDetail.setFirstName(firstName);
		}

		String middleName = request.getParameter("middleName");
		if (middleName == null || !middleName.matches(pattern)) {
			errorMessageList
					.add("MiddleName	must	contain	A-Z	or	a-z	characters	only.");
			personDetail.setMiddleName(middleName);
		} else {
			personDetail.setMiddleName(middleName);
		}

		String lastName = request.getParameter("lastName");
		if (lastName == null || !lastName.matches(pattern)) {
			errorMessageList
					.add("MiddleName	must	contain	A-Z	or	a-z	characters	only.");
			personDetail.setLastName(lastName);
		} else {
			personDetail.setLastName(lastName);
		}
		
		personDetail.setVersionNo(Integer.parseInt(request.getParameter("versionNo")));

		personDetail.setErrorMessageList(errorMessageList);
		request.setAttribute("personDetail", personDetail);

		return !errorMessageList.isEmpty();

	}

}
