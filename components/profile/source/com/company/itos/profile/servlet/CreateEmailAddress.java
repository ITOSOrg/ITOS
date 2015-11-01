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
import com.company.itos.profile.dao.CreateEmailAddressDAO;
import com.company.itos.profile.pojo.EmailAddressDetail;

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
		String relatedID = request.getParameter("relatedID");
		String typeCode = request.getParameter("typeCode");
		String primaryInd = request.getParameter("primaryInd");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		EmailAddressDetail emailAddressDetail = new EmailAddressDetail();
		if (emailAddress.equals(emailPattern)) {

		}
		emailAddressDetail.setEmailAddress(emailAddress);
		emailAddressDetail.setRelatedID(new Integer(relatedID));
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

		CreateEmailAddressDAO createEmailAddressDAO = new CreateEmailAddressDAO();
		String returnMassegeStr = createEmailAddressDAO.createEmailAddress(emailAddressDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = "/ReadEmailAddress";

		} else {
			// pageForwardStr = "/CreateEmailAddress.jsp";
			pageForwardStr = "/components/profile/jsp/email/CreateEmailAddress.jsp";
		}

		pageForwardStr += "?emailAddressLinkID=" + emailAddressDetail.getEmailAddressLinkID();

		// request.setAttribute("emailAddressID", emailAddressID);
		// request.setAttribute("emailAddressLinkID", emailAddressLinkID);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}
}
