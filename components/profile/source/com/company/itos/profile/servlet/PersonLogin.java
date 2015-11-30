package com.company.itos.profile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.dao.PersonLoginDAO;
import com.company.itos.profile.pojo.PersonDetail;
import com.company.itos.profile.pojo.UsersDetail;

/**
 * Servlet implementation class PersonLogin
 */
public class PersonLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonLogin() {
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

		PersonDetail personDetail = new PersonDetail();
		response.setContentType("text/html");
		String pageForwardStr = null;

		boolean errorInd = validateLoginDetails(request, personDetail);

		if (errorInd) {

			request.setAttribute("usersDetail", personDetail.getUsersDetail());

			pageForwardStr = "/LoginForm.jsp";

		} else {

			PersonLoginDAO personLoginDAO = new PersonLoginDAO();

			/**
			 * calling login method of StudentDAO class & assigning return value
			 * of method login to retrunStr
			 */
			String returnMassegeStr = personLoginDAO.login(personDetail);

			if (returnMassegeStr.equals(CRUDConstants.RETURN_MESSAGE_SUCCESS)) {

				pageForwardStr = "/PersonHome";
				pageForwardStr += "?personID=" + personDetail.getPersonID();

			} else {

				pageForwardStr = "/LoginForm.jsp";
				request.setAttribute("usersDetail",
						personDetail.getUsersDetail());

			}
		}

		RequestDispatcher requestDispatcher = getServletContext()
				.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);

	}

	private boolean validateLoginDetails(HttpServletRequest request,
			PersonDetail personDetail) {

		UsersDetail usersDetail = new UsersDetail();
		List<String> errorMessageList = new ArrayList<String>();
		String userName = request.getParameter("userName");
		
		if (userName == null || userName.equals("")) {
			
			errorMessageList.add("Please	enter	username.");
		
		} else {
			
			usersDetail.setUserName(userName);

		}
		
		String password = request.getParameter("password");
		
		if (password == null || password.equals("")) {
			
			errorMessageList.add("Please	enter	password.");
		
		} else {
			
			usersDetail.setPassword(password);

		}

		usersDetail.setErrorMessageList(errorMessageList);
		personDetail.setUsersDetail(usersDetail);

		return !errorMessageList.isEmpty();
	}

}
