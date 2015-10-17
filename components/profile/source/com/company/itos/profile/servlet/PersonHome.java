package com.company.itos.profile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.profile.pojo.PersonDetail;
import com.company.itos.profile.pojo.UsersDetail;

import com.company.itos.profile.dao.PersonHomeDAO;

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

		System.out.println(request.getParameter("userName"));
		String userName = request.getParameter("userName");
		String action = request.getParameter("act");
		PrintWriter printwriter = response.getWriter();

		UsersDetail usersDetail = new UsersDetail();
		usersDetail.setUserName(userName);

		PersonHomeDAO personHomeDAO = new PersonHomeDAO();

		PersonDetail personDetail = personHomeDAO
				.readStudentDetail(usersDetail);
		/**
		 * 
		 */
		personDetail.setUserName(userName);

		request.setAttribute("personDetail", personDetail);
		RequestDispatcher rd1 = null;
		if (action != null && action.equals("update")) {
			rd1 = request.getRequestDispatcher("/UpdatedRegistrationForm.jsp");
		} else {

			rd1 = request.getRequestDispatcher("/PersonHome.jsp");
		}

		rd1.forward(request, response);
	}
}
