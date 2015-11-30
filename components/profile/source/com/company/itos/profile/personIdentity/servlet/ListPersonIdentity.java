package com.company.itos.profile.personIdentity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.profile.personIdentity.dao.ListPersonIdentityDAO;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

/**
 * Servlet implementation class ListPersonIdentity
 */
public class ListPersonIdentity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPersonIdentity() {
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
		
		Integer personID = (new Integer(request.getParameter("personID")));
		personIdentityDetail.setPersonID(personID);
		
		ListPersonIdentityDAO listPersonIdentityDAO = new ListPersonIdentityDAO();
		List<PersonIdentityDetail> personIdentityDetailList = listPersonIdentityDAO.personIdentityList(personIdentityDetail);
		
		request.setAttribute("personIdentityDetailList", personIdentityDetailList);

		request.setAttribute("personID", personID);

		if (personIdentityDetailList != null) {

			pageForwardStr = "/components/profile/jsp/personIdentity/ListPersonIdentity.jsp";

		} else {

			pageForwardStr = "/PersonHome";
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
