package com.company.itos.profile.address.servlet;

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
import com.company.itos.profile.address.dao.UpdateAddressDAO;
import com.company.itos.profile.address.pojo.AddressDetail;
import com.company.itos.profile.address.pojo.AddressLinkDetail;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;

/**
 * Servlet implementation class UpdateAddress
 */
public class UpdateAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAddress() {
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

		AddressLinkDetail addressLinkDetail = new AddressLinkDetail();
		AddressDetail addressDetail = new AddressDetail();

		int addressLinkID = (new Integer(request.getParameter("addressLinkID")));
		addressLinkDetail.setAddressLinkID(addressLinkID);

		//int addressID = (new Integer(request.getParameter("addressID")));
		//addressDetail.setAddressId(addressID);

		// int emailAddressID = (new
		// Integer(request.getParameter("emailAddressID")));
		// emailAddressDetail.setEmailAddressID(emailAddressID);
		int versionNo = (new Integer(request.getParameter("versionNo")));
		addressLinkDetail.setVersionNo(versionNo);
		addressDetail.setVersionNo(versionNo);
		
		String streetOne = request.getParameter("streetOne");
		String streetTwo = request.getParameter("streetTwo");
		String aptUnit = request.getParameter("aptUnit");
		String city = request.getParameter("city");
		String county = request.getParameter("county");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		int zipCode =(new Integer (request.getParameter("zipCode")));
		
		addressDetail.setStreetOne(streetOne);
		addressDetail.setStreetTwo(streetTwo);
		addressDetail.setAptUnit(aptUnit);
		addressDetail.setCity(city);
		addressDetail.setCounty(county);
		addressDetail.setState(state);
		addressDetail.setCountry(country);
		addressDetail.setZipCode(zipCode);
		
		
		String typeCode = request.getParameter("typeCode");
		//int primaryInd =(new Integer (request.getParameter("primaryInd")));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		addressLinkDetail.setTypeCode(typeCode);
		//addressLinkDetail.setPrimaryInd(primaryInd);
		
		java.util.Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			addressLinkDetail.setStartDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			addressLinkDetail.setEndDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		addressLinkDetail.setAddressDetail(addressDetail);
		
		UpdateAddressDAO updateAddressDAO = new UpdateAddressDAO();
		String returnMassegeStr = updateAddressDAO.updateAddress(addressLinkDetail);
		
		request.setAttribute("addressLinkID", addressLinkID);
		request.setAttribute("addressLinkDetail", addressLinkDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/ListAddress";

		} else {
			pageForwardStr = "/";
		}
		pageForwardStr += "?relatedID=" + addressLinkDetail.getRelatedID();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);

	}

}
