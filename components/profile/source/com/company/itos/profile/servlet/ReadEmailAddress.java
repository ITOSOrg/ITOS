package com.company.itos.profile.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.dao.ReadEmailAddressDAO;
import com.company.itos.profile.pojo.EmailAddressDetail;

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
		
		try {
			
			Integer emailAddressLinkID = (new Integer(request.getParameter("emailAddressLinkID")));
			emailAddressDetail.setEmailAddressLinkID(emailAddressLinkID);
			
		} catch (NumberFormatException e) {
			
			System.out.println(e.getMessage());
		}

		ReadEmailAddressDAO readEmailAddressDAO = new ReadEmailAddressDAO();

		// String returnMassegeStr =
		// readEmailAddressDAO.readEmailAddress(emailAddressDetail);

		readEmailAddressDAO.readEmailAddress(emailAddressDetail);

		if (action != null && action.equals("update")) {
			pageForwardStr = "/UpdateEmailAddress.jsp";

		} else {
			pageForwardStr = "/ReadEmailAddress.jsp";
		}

		/*
		 * if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
		 * 
		 * pageForwardStr = "/ReadEmailAddress.jsp";
		 * 
		 * } else { pageForwardStr = "/UpdateEmailAddress.jsp"; }
		 */

		request.setAttribute("emailAddressDetail", emailAddressDetail);

		// pageForwardStr += "?emailAddressLinkID=" +
		// emailAddressDetail.getEmailAddressLinkID();

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);

	}

}
