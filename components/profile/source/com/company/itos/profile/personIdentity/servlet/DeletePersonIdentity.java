package com.company.itos.profile.personIdentity.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.personIdentity.dao.DeletePersonIdentityDAO;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

/**
 * Servlet implementation class DeletePersonIdentity
 */
public class DeletePersonIdentity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePersonIdentity() {
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
		int personID = (new Integer(request.getParameter("personID")));
		personIdentityDetail.setPersonID(personID);
		
		DeletePersonIdentityDAO deletePersonIdentityDAO = new DeletePersonIdentityDAO();
		String returnMassegeStr = deletePersonIdentityDAO.DeletePersonIdentity(personIdentityDetail);
		
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
