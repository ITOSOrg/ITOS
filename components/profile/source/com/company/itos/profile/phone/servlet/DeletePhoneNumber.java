package com.company.itos.profile.phone.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.phone.dao.DeletePhoneNumberDAO;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

/**
 * Servlet implementation class DeletePhoneNumber
 */
// @WebServlet("/DeletePhoneNumber")
public class DeletePhoneNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletePhoneNumber() {
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

		Integer phoneNumberLinkID = (new Integer(request.getParameter("phoneNumberLinkID")));
		Integer phoneNumberID = (new Integer(request.getParameter("phoneNumberID")));
		phoneNumberDetail.setPhoneNumberID(phoneNumberID);
		phoneNumberLinkDetail.setPhoneNumberLinkID(phoneNumberLinkID);
		Integer relatedID = (new Integer(request.getParameter("relatedID")));
		phoneNumberLinkDetail.setRelatedID(relatedID);

		phoneNumberLinkDetail.setPhoneNumberDetail(phoneNumberDetail);

		DeletePhoneNumberDAO deletePhoneNumberDAO = new DeletePhoneNumberDAO();
		String returnMassegeStr = deletePhoneNumberDAO.deletePhoneNumber(phoneNumberLinkDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/ListPhoneNumber";
			pageForwardStr += "?relatedID" + phoneNumberLinkDetail.getRelatedID();
		} else {
			pageForwardStr = "/ListPhoneNumber";
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
