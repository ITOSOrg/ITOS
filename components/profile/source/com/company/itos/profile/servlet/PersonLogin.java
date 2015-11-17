package com.company.itos.profile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.dao.PersonLoginDAO;
import com.company.itos.profile.pojo.PersonDetail;
import com.company.itos.profile.pojo.UsersDetail;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class PersonLogin
 */
public class PersonLogin extends HttpServlet {

	PersonDetail personDetail = new PersonDetail();
	private static final long serialVersionUID = 1L;

	UsersDetail usersDetail = new UsersDetail();

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter printwriter = response.getWriter();
		String pageForwardStr = null;

		boolean errorInd = validateLoginDetails(request, usersDetail);
		if (errorInd) {

			pageForwardStr = "/LoginForm.jsp";

			// RequestDispatcher rd1 =
			// request.getRequestDispatcher("/LoginForm.jsp");
			// rd1.forward(request, response);

		} else {

			PersonLoginDAO personLoginDAO = new PersonLoginDAO();

			/**
			 * calling login method of StudentDAO class & assigning return value
			 * of method login to retrunStr
			 */
			String returnMassegeStr = personLoginDAO.login(personDetail);

			if (returnMassegeStr.equals(CRUDConstants.RETURN_MESSAGE_SUCCESS)) {

				pageForwardStr = "/PersonHome";

			} else {

				pageForwardStr = "/LoginForm.jsp";

			}
			pageForwardStr += "?personID=" + personDetail.getPersonID();
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(pageForwardStr);
			requestDispatcher.forward(request, response);
		}

	}

	private boolean validateLoginDetails(HttpServletRequest request, UsersDetail usersDetail)

	{

		List<String> errorMessageList = new ArrayList<String>();
		String userName = request.getParameter("userName");
		if (userName == null || userName.equals("")) {
			errorMessageList.add("Please	enter	username.");
		} else {
			try {
				usersDetail.setUserName(userName);

			} catch (Exception E) {

			}
		}
		String password = request.getParameter("password");
		if (password == null || password.equals("")) {
			errorMessageList.add("Please	enter	password.");
		} else {
			try {
				usersDetail.setPassword(password);

			} catch (Exception E) {

			}
		}

		personDetail.setUsersDetail(usersDetail);
		usersDetail.setErrorMessageList(errorMessageList);
		request.setAttribute("usersDetail", usersDetail);
		return !errorMessageList.isEmpty();
	}

}
