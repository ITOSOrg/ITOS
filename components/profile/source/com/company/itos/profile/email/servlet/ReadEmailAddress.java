package com.company.itos.profile.email.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.email.dao.ReadEmailAddressDAO;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;

/**
 * Servlet implementation class EmailAddressHome
 */
public class ReadEmailAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadEmailAddress() {
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

		String pageForwardStr = "";
		String action = request.getParameter("act");

		EmailAddressDetail emailAddressDetail = new EmailAddressDetail();
		EmailAddressLinkDetail emailAddressLinkDetail = new EmailAddressLinkDetail();
		
		try {
			
			Integer emailAddressLinkID = (new Integer(request.getParameter("emailAddressLinkID")));
			emailAddressLinkDetail.setEmailAddressLinkID(emailAddressLinkID);
			
		} catch (NumberFormatException e) {
			
			System.out.println(e.getMessage());
		}

		ReadEmailAddressDAO readEmailAddressDAO = new ReadEmailAddressDAO();


		readEmailAddressDAO.readEmailAddress(emailAddressLinkDetail);

		if (action != null && action.equals("update")) {
			pageForwardStr = "/components/profile/jsp/email/UpdateEmailAddress.jsp";

		} else {
			pageForwardStr = "/components/profile/jsp/email/ReadEmailAddress.jsp";
		}


		request.setAttribute("emailAddressLinkDetail", emailAddressLinkDetail);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);

	}

}
