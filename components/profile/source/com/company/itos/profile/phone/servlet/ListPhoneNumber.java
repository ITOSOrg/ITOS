package com.company.itos.profile.phone.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.phone.dao.ListPhoneNumberDAO;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

/**
 * Servlet implementation class ListPhoneNumber
 */
// @WebServlet("/ListPhoneNumber")
public class ListPhoneNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListPhoneNumber() {
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
		PhoneNumberDetail phoneNumberDetail = new PhoneNumberDetail();
		PhoneNumberLinkDetail phoneNumberLinkDetail = new PhoneNumberLinkDetail();

		Integer relatedID = (new Integer(request.getParameter("relatedID")));
		phoneNumberLinkDetail.setRelatedID(relatedID);
		
		phoneNumberLinkDetail.setPhoneNumberDetail(phoneNumberDetail);

		ListPhoneNumberDAO listPhoneNumberDAO = new ListPhoneNumberDAO();
		List<PhoneNumberLinkDetail> phoneNumberLinkDetailList = listPhoneNumberDAO.listAllPhoneNumber(phoneNumberLinkDetail);

		request.setAttribute("PhoneNumberLinkDetailList", phoneNumberLinkDetailList);
		request.setAttribute("relatedID", relatedID);

		if (phoneNumberLinkDetailList != null) {

			pageForwardStr = "/components/profile/jsp/phone/ListPhoneNumber.jsp";

		} else {

			pageForwardStr = "";

		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
