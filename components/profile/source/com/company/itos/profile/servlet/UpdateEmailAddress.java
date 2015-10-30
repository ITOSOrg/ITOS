package com.company.itos.profile.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.dao.UpdateEmailAddressDAO;
import com.company.itos.profile.pojo.EmailAddressDetail;

/**
 * Servlet implementation class UpdateEmailAddress
 */
public class UpdateEmailAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEmailAddress() {
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

		int emailAddressLinkID = (new Integer(request.getParameter("emailAddressLinkID")));
		emailAddressDetail.setEmailAddressLinkID(emailAddressLinkID);
		int emailAddressID = (new Integer(request.getParameter("emailAddressID")));
		emailAddressDetail.setEmailAddressID(emailAddressID);

		String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		String emailAddress = request.getParameter("emailAddress");
		String typeCode = request.getParameter("typeCode");
		String primaryInd = request.getParameter("primaryInd");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		if (emailAddress.equals(emailPattern)) {

		}
		emailAddressDetail.setEmailAddress(emailAddress);
		emailAddressDetail.setTypeCode(typeCode);
		emailAddressDetail.setPrimaryInd(primaryInd);

		java.util.Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			emailAddressDetail.setStartDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			emailAddressDetail.setEndDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		UpdateEmailAddressDAO updateEmailAddressDAO = new UpdateEmailAddressDAO();
		String returnMassegeStr = updateEmailAddressDAO.updateEmailAddress(emailAddressDetail);
		request.setAttribute("emailAddressLinkID", emailAddressLinkID);
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/ReadEmailAddress";

		} else {
			pageForwardStr = "/";
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);

	}

}
