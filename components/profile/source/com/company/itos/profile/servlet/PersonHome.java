package com.company.itos.profile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.profile.pojo.EmailAddressDetail;
import com.company.itos.profile.pojo.PersonDetail;
import com.company.itos.profile.pojo.UsersDetail;
import com.company.itos.profile.dao.PersonHomeDAO;
import com.company.itos.profile.email.dao.ReadEmailAddressDAO;

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
		
		EmailAddressDetail emailAddressDetail = new EmailAddressDetail();
		

		System.out.println(request.getParameter("userName"));
		String userName = request.getParameter("userName");
		String action = request.getParameter("act");
		PrintWriter printwriter = response.getWriter();

		UsersDetail usersDetail = new UsersDetail();
		usersDetail.setUserName(userName);

		PersonHomeDAO personHomeDAO = new PersonHomeDAO();

		PersonDetail personDetail = personHomeDAO
				.readPersonDetail(usersDetail);
		/**
		 * 
		 */
		personDetail.setUserName(userName);

		request.setAttribute("personDetail", personDetail);
		
		/*personHomeDAO.getEmailAddressLinkID(emailAddressDetail);
		request.setAttribute("emailAddressDetail", emailAddressDetail);*/
		
		RequestDispatcher requestDispatcher = null;
		
		if (action != null && action.equals("update")) {
			requestDispatcher = request.getRequestDispatcher("/UpdatedRegistrationForm.jsp");
		} else {

			requestDispatcher = request.getRequestDispatcher("/PersonHome.jsp");
		}
		
		requestDispatcher.forward(request, response);
		
	}
}
