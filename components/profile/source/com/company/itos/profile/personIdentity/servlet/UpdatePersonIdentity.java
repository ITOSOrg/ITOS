package com.company.itos.profile.personIdentity.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.company.itos.core.util.CRUDConstants;

import com.company.itos.profile.personIdentity.dao.UpdatePersonIdentityDAO;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

/**
 * Servlet implementation class UpdatePersonIdentity
 */
public class UpdatePersonIdentity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePersonIdentity() {
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
		PersonIdentityDetail personIdentityDetail = new PersonIdentityDetail();
		
		int personIdentityID = (new Integer(request.getParameter("personIdentityID")));
		personIdentityDetail.setPersonIdentityID(personIdentityID);
		
		//int personID = (new Integer(request.getParameter("personID")));
		//personIdentityDetail.setPersonID(personID);
		
		int versionNo = (new Integer(request.getParameter("versionNo")));
		personIdentityDetail.setVersionNo(versionNo);
		
		 String alternateID = request.getParameter("alternateID");
		 String primaryInd = request.getParameter("primaryInd");
		 String typeCode = request.getParameter("typeCode");
		 String startDate = request.getParameter("startDate");
		 String endDate = request.getParameter("endDate");
		 
		 personIdentityDetail.setAlternateID(alternateID);
		 personIdentityDetail.setPrimaryInd(primaryInd);
		 personIdentityDetail.setTypeCode(typeCode);
		 
		 java.util.Date date;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				personIdentityDetail.setStartDate(sqlDate);

			} catch (ParseException e) {
				e.printStackTrace();
			}

			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				personIdentityDetail.setEndDate(sqlDate);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		
		UpdatePersonIdentityDAO updatePersonIdentityDAO = new UpdatePersonIdentityDAO();
		String returnMassegeStr = updatePersonIdentityDAO.UpdatePersonIdentity(personIdentityDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/ListPersonIdentity";
		} else {
			pageForwardStr = "/ListPersonIdentity";
		}
		pageForwardStr += "?personID=" + personIdentityDetail.getPersonID();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
