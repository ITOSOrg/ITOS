package com.company.itos.profile.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.pojo.PersonDetail;

import com.company.itos.profile.dao.PersonDeleteDAO;

/**
 * Servlet implementation class PersonDelete
 */
public class PersonDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonDelete() {
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

		Integer personID = new Integer(
				request.getParameter("personID"));

		PersonDetail personDetail = new PersonDetail();
		personDetail.setPersonID(personID);

		PersonDeleteDAO personDeleteDAO = new PersonDeleteDAO();
		/**
		 * assign return value of deletePerson method to returnMassegeStr
		 */
		String returnMassegeStr = personDeleteDAO.deleteStudent(personDetail);

		/**
		 * if data deleted successfully then request will dispatch to the
		 * PersonList servlet
		 */
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/PersonList");
			requestDispatcher.forward(request, response);
		} else {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/AdministratorHome.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
