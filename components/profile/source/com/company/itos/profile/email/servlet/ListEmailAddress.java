package com.company.itos.profile.email.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.profile.email.dao.ListEmailAddressDAO;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;
import com.company.itos.profile.pojo.PersonDetail;

/**
 * Servlet implementation class ListEmailAddress
 */
// @WebServlet("/ListEmailAddress")
public class ListEmailAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListEmailAddress() {
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

		EmailAddressLinkDetail emailAddressLinkDetail = new EmailAddressLinkDetail();

		Integer relatedID = (new Integer(request.getParameter("relatedID")));
		emailAddressLinkDetail.setRelatedID(relatedID);

		ListEmailAddressDAO listEmailAddressDAO = new ListEmailAddressDAO();
		List<EmailAddressLinkDetail> emailAddressLinkDetailList = listEmailAddressDAO.listAllEmailAddress(emailAddressLinkDetail);

		request.setAttribute("emailAddressLinkDetailList", emailAddressLinkDetailList);

		request.setAttribute("relatedID", relatedID);

		if (emailAddressLinkDetailList != null) {

			pageForwardStr = "/components/profile/jsp/email/ListEmailAddress.jsp";

		} else {

			pageForwardStr = "/PersonHome";
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
