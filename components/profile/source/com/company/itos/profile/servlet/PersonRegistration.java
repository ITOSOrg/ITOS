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
import com.company.itos.profile.pojo.PersonDetail;
import com.company.itos.profile.pojo.UsersDetail;

import com.company.itos.profile.dao.PersonRegistrationDAO;

/**
 * Servlet implementation class PersonRegistration
 */
public class PersonRegistration extends HttpServlet {

	private static final long	serialVersionUID	= 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonRegistration() {

		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Inside doPost method");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		PersonDetail personDetail = new PersonDetail();

		// Call Validate Method
		boolean errorInd = validatePersonDetails(request, personDetail);
		String pageForwardStr ="";

		if (errorInd) {

			RequestDispatcher rd1 = request.getRequestDispatcher("/RegistrationForm.jsp");
			rd1.forward(request, response);

		} else {

			PersonRegistrationDAO personRegistrationDAO = new PersonRegistrationDAO();
			String returnMassegeStr = personRegistrationDAO.registerPerson(personDetail);

			if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

				pageForwardStr = "/PersonHome";
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

			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			personDetail.setDateOfBirth(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		

		String userName = request.getParameter("userName");
		

		UsersDetail usersDetail = new UsersDetail();
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
		if (password.length() < 8) {
			errorMessageList.add("Password must contain at 8 charachters");
			usersDetail.setPassword(password);
		} else {
			usersDetail.setPassword(password);
		}

		personDetail.setErrorMessageList(errorMessageList);
		request.setAttribute("personDetail", personDetail);

		return !errorMessageList.isEmpty();

	}
}
