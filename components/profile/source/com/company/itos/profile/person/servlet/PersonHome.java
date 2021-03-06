package com.company.itos.profile.person.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.person.dao.PersonHomeDAO;
import com.company.itos.profile.person.pojo.PersonDetail;
import com.company.itos.profile.person.pojo.UsersDetail;

/**
 * Servlet implementation class PersonHome
 */
public class PersonHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonHome() {
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

		EmailAddressDetail emailAddressDetail = new EmailAddressDetail();
		String pageForwardStr = "";

		UsersDetail usersDetail = new UsersDetail();

		PersonDetail personDetail = new PersonDetail();

		System.out.println(request.getParameter("userName"));
		// String userName = request.getParameter("userName");

		int personID = (new Integer(request.getParameter("personID")));
		personDetail.setPersonID(personID);

		String action = request.getParameter("act");
		PrintWriter printwriter = response.getWriter();

		// usersDetail.setUserName(userName);

		PersonHomeDAO personHomeDAO = new PersonHomeDAO();

		// PersonDetail personDetail =
		// personHomeDAO.readPersonDetail(personDetail);
		personHomeDAO.readPersonDetail(personDetail);
		// personDetail.setUserName(userName);

		request.setAttribute("personDetail", personDetail);
		request.setAttribute("personID", personID);

		/*
		 * personHomeDAO.getEmailAddressLinkID(emailAddressDetail);
		 * request.setAttribute("emailAddressDetail", emailAddressDetail);
		 */

		if (action != null && action.equals("update")) {

			pageForwardStr = "/components/profile/jsp/person/UpdatePerson.jsp";
			pageForwardStr += "?personID" + personDetail.getPersonID();
		} else {
			pageForwardStr = "/components/profile/jsp/person/PersonHome.jsp";
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);

	}
}
