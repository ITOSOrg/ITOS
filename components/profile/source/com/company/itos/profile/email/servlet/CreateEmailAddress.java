package com.company.itos.profile.email.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.email.dao.CreateEmailAddressDAO;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;

/**
 * Servlet implementation class CreateEmailAddress
 */
public class CreateEmailAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateEmailAddress() {
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

		String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		String emailAddress = request.getParameter("emailAddress");
		Integer relatedID = (new Integer(request.getParameter("relatedID")));
		String typeCode = request.getParameter("typeCode");
		String primaryInd = request.getParameter("primaryInd");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		EmailAddressDetail emailAddressDetail = new EmailAddressDetail();
		EmailAddressLinkDetail emailAddressLinkDetail = new EmailAddressLinkDetail();
		if (emailAddress.equals(emailPattern)) {

		}
		emailAddressDetail.setEmailAddress(emailAddress);
		emailAddressLinkDetail.setRelatedID(relatedID);
		emailAddressLinkDetail.setTypeCode(typeCode);
		emailAddressLinkDetail.setPrimaryInd(primaryInd);

		java.util.Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			emailAddressLinkDetail.setStartDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			emailAddressLinkDetail.setEndDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		emailAddressLinkDetail.setEmailAddressDetail(emailAddressDetail);

		CreateEmailAddressDAO createEmailAddressDAO = new CreateEmailAddressDAO();
		String returnMassegeStr = createEmailAddressDAO.createEmailAddress(emailAddressLinkDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = "/ListEmailAddress";

		} else {
			// pageForwardStr = "/CreateEmailAddress.jsp";
			pageForwardStr = "/components/profile/jsp/email/CreateEmailAddress.jsp";
		}

		pageForwardStr += "?emailAddressLinkID=" + emailAddressLinkDetail.getEmailAddressLinkID();

		// request.setAttribute("emailAddressID", emailAddressID);
		// request.setAttribute("emailAddressLinkID", emailAddressLinkID);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}
}
