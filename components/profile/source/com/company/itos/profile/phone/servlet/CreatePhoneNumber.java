package com.company.itos.profile.phone.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.phone.dao.CreatePhoneNumberDAO;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

/**
 * Servlet implementation class CreatePhoneNumber
 */
// @WebServlet("/CreatePhoneNumber")
public class CreatePhoneNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreatePhoneNumber() {
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

		Integer countryCode = (new Integer(request.getParameter("countryCode")));
		Integer areaCode = (new Integer(request.getParameter("areaCode")));
		Long phoneNumber = (new Long(request.getParameter("phoneNumber")));
		Integer relatedID = (new Integer(request.getParameter("relatedID")));
		Integer extension = (new Integer(request.getParameter("extension")));
		String primaryInd = request.getParameter("primaryIndP");
		String typeCode = request.getParameter("typeCode");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		phoneNumberDetail.setCountryCode(countryCode);
		phoneNumberDetail.setAreaCode(areaCode);
		phoneNumberDetail.setPhoneNumber(phoneNumber);
		phoneNumberLinkDetail.setRelatedID(relatedID);
		;
		phoneNumberDetail.setExtension(extension);
		phoneNumberLinkDetail.setPrimaryInd(primaryInd);
		phoneNumberLinkDetail.setTypeCode(typeCode);

		java.util.Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			phoneNumberLinkDetail.setStartDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			phoneNumberLinkDetail.setEndDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		phoneNumberLinkDetail.setPhoneNumberDetail(phoneNumberDetail);
		CreatePhoneNumberDAO createPhoneNumberDAO = new CreatePhoneNumberDAO();
		String returnMassegeStr = createPhoneNumberDAO.createPhoneNumber(phoneNumberLinkDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = "/ListPhoneNumber";

		} else {
			pageForwardStr = "/components/profile/jsp/phone/CreatePhoneNumber.jsp";
		}

		pageForwardStr += "?phoneNumberLinkID=" + phoneNumberLinkDetail.getPhoneNumberLinkID();
		pageForwardStr += "?relatedID=" + phoneNumberLinkDetail.getRelatedID();

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
