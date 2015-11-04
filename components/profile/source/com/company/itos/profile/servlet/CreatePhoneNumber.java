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
import com.company.itos.profile.dao.CreatePhoneNumberDAO;
import com.company.itos.profile.pojo.PhoneNumberDetail;

/**
 * Servlet implementation class CreatePhoneNumber
 */
//@WebServlet("/CreatePhoneNumber")
public class CreatePhoneNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePhoneNumber() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageForwardStr = "";
		
		PhoneNumberDetail phoneNumberDetail = new PhoneNumberDetail();
		
		Integer countryCode = (new Integer (request.getParameter("countryCode")));
		Integer areaCode = (new Integer (request.getParameter("areaCode")));
		Long phoneNumber = (new Long (request.getParameter("phoneNumber")));
		Integer relatedID = (new Integer(request.getParameter("relatedID")));
		Integer extension = (new Integer (request.getParameter("extension")));
		Integer primaryInd = (new Integer (request.getParameter("primaryInd")));
		String typeCode = request.getParameter("typeCode");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		phoneNumberDetail.setCountryCode(countryCode);
		phoneNumberDetail.setAreaCode(areaCode);
		phoneNumberDetail.setPhoneNumber(phoneNumber);
		phoneNumberDetail.setRelatedID(relatedID);;
		phoneNumberDetail.setExtension(extension);
		phoneNumberDetail.setPrimaryInd(primaryInd);
		phoneNumberDetail.setTypeCode(typeCode);
		
		java.util.Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			phoneNumberDetail.setStartDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			phoneNumberDetail.setEndDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		CreatePhoneNumberDAO createPhoneNumberDAO = new CreatePhoneNumberDAO();
		String returnMassegeStr = createPhoneNumberDAO.createPhoneNumber(phoneNumberDetail);
		
		if(returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS){
			
			pageForwardStr = "/ListPhoneNumber";
			
		}else {
			pageForwardStr = "/CreatePhoneNumber.jsp";
		}

		pageForwardStr += "?phoneNumberLinkID=" + phoneNumberDetail.getPhoneNumberLinkID();
		pageForwardStr += "?relatedID=" + phoneNumberDetail.getRelatedID();

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
