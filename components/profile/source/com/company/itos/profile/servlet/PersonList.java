package com.company.itos.profile.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.profile.pojo.PersonDetail;

import com.company.itos.profile.dao.PersonListDAO;

/**
 * Servlet implementation class PersonList
 */
public class PersonList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonList() {
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

		PersonListDAO personListDAO = new PersonListDAO();

		String pageForwardStr = null;

		List<PersonDetail> personDetailList = personListDAO.listAllStudent();
		request.setAttribute("personDetailList", personDetailList);

		if (personDetailList != null) {

			pageForwardStr = "/AdministratorHome.jsp";

			/*
			 * RequestDispatcher rd = request
			 * .getRequestDispatcher("/AdministratorHome.jsp");
			 * rd.forward(request, response);
			 */
		} else {
			pageForwardStr = "/Login.jsp";
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);

	}

}
