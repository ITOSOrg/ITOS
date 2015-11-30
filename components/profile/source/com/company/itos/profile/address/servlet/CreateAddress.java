package com.company.itos.profile.address.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.address.dao.CreateAddressDAO;
import com.company.itos.profile.address.pojo.AddressDetail;
import com.company.itos.profile.address.pojo.AddressLinkDetail;

/**
 * Servlet implementation class CreateAddress
 */
//@WebServlet("/CreateAddress")
public class CreateAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAddress() {
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
		
		AddressDetail addressDetail = new AddressDetail();
		
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
		
		AddressLinkDetail addressLinkDetail = new AddressLinkDetail();
		
		String typeCode = request.getParameter("typeCode");
		String primaryInd = request.getParameter("primaryIndA");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		Integer relatedID = (new Integer(request.getParameter("relatedID")));
		
		addressLinkDetail.setTypeCode(typeCode);
		addressLinkDetail.setPrimaryInd(primaryInd);
		addressLinkDetail.setRelatedID(relatedID);
		
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
		
		CreateAddressDAO createAddressDAO = new CreateAddressDAO();
		 String returnMassegeStr = createAddressDAO.createAddress(addressLinkDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = "/ListAddress";

		} else {
			
			pageForwardStr = "";
			
		}

		//pageForwardStr += "?emailAddressLinkID=" ;

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
		
	}

}
