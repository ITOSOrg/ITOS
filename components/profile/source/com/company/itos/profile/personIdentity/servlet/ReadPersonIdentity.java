package com.company.itos.profile.personIdentity.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.personIdentity.dao.ReadPersonIdentityDAO;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

/**
 * Servlet implementation class ReadPersonIdentity
 */
public class ReadPersonIdentity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadPersonIdentity() {
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
		String action = request.getParameter("act");
		PersonIdentityDetail personIdentityDetail = new PersonIdentityDetail();
		
		Integer personIdentityID = (new Integer(request.getParameter("personIdentityID")));
		personIdentityDetail.setPersonIdentityID(personIdentityID);
		
		ReadPersonIdentityDAO readPersonIdentityDAO = new ReadPersonIdentityDAO();
		String returnMassegeStr = readPersonIdentityDAO.readPersonIdentity(personIdentityDetail);
		
		if (action != null && action.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/components/profile/jsp/email/UpdateEmailAddress.jsp";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/components/profile/jsp/personIdentity/ReadPersonIdentity.jsp";
		}

		request.setAttribute("personIdentityDetail", personIdentityDetail);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
