package com.company.itos.profile.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.dao.DeleteEmailAddressDAO;
import com.company.itos.profile.pojo.EmailAddressDetail;

/**
 * Servlet implementation class DeleteEmailAddress
 */
public class DeleteEmailAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmailAddress() {
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
		EmailAddressDetail emailAddressDetail = new EmailAddressDetail();
		int emailAddressID = (new Integer( request.getParameter("emailAddressID")));
		int emailAddressLinkID = (new Integer( request.getParameter("emailAddressLinkID")));
		emailAddressDetail.setEmailAddressID(emailAddressID);
		emailAddressDetail.setEmailAddressLinkID(emailAddressLinkID);
		
		DeleteEmailAddressDAO deleteEmailAddressDAO = new DeleteEmailAddressDAO();
	String returnMassegeStr = deleteEmailAddressDAO.deleteEmailAddress(emailAddressDetail);
	if(returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS)
	{
		pageForwardStr = "";
	}else
	{
		pageForwardStr = "";
	}
	RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
	requestDispatcher.forward(request, response);
	}

}
