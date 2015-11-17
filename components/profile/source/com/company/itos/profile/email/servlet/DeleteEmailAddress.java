package com.company.itos.profile.email.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.email.dao.DeleteEmailAddressDAO;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;

/**
 * Servlet implementation class DeleteEmailAddress
 */
public class DeleteEmailAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteEmailAddress() {
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

		EmailAddressDetail emailAddressDetail = new EmailAddressDetail();
		EmailAddressLinkDetail emailAddressLinkDetail = new EmailAddressLinkDetail();

		int emailAddressID = (new Integer(request.getParameter("emailAddressID")));
		int relatedID = (new Integer(request.getParameter("relatedID")));
		int emailAddressLinkID = (new Integer(request.getParameter("emailAddressLinkID")));

		emailAddressDetail.setEmailAddressID(emailAddressID);
		emailAddressLinkDetail.setRelatedID(relatedID);
		emailAddressLinkDetail.setEmailAddressLinkID(emailAddressLinkID);

		emailAddressLinkDetail.setEmailAddressDetail(emailAddressDetail);

		DeleteEmailAddressDAO deleteEmailAddressDAO = new DeleteEmailAddressDAO();
		String returnMassegeStr = deleteEmailAddressDAO.deleteEmailAddress(emailAddressLinkDetail);

		// TODO Pass relatedID to listphonenumber servlet

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/ListEmailAddress";
		} else {
			pageForwardStr = "/ListEmailAddress";
		}
		pageForwardStr += "?relatedID=" + emailAddressLinkDetail.getRelatedID();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
