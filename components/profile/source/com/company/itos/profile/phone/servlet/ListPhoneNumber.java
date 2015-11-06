package com.company.itos.profile.phone.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.profile.phone.dao.ListPhoneNumberDAO;
import com.company.itos.profile.pojo.EmailAddressDetail;
import com.company.itos.profile.pojo.PhoneNumberDetail;

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

		Integer relatedID = (new Integer(request.getParameter("relatedID")));
		phoneNumberDetail.setRelatedID(relatedID);

		ListPhoneNumberDAO listPhoneNumberDAO = new ListPhoneNumberDAO();
		List<PhoneNumberDetail> phoneNumberDetailList = listPhoneNumberDAO.listAllPhoneNumber(phoneNumberDetail);

		request.setAttribute("phoneNumberDetailList", phoneNumberDetailList);
		request.setAttribute("relatedID", relatedID);

		if (phoneNumberDetailList != null) {

			pageForwardStr = "/components/profile/jsp/phoneNumber/ListPhoneNumber.jsp";

		} else {

			pageForwardStr = "";

		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
