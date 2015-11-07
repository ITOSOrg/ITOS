package com.company.itos.profile.phone.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.profile.phone.dao.ReadPhoneNumberDAO;
import com.company.itos.profile.pojo.PhoneNumberDetail;

/**
 * Servlet implementation class ReadPhoneNumber
 */
//@WebServlet("/ReadPhoneNumber")
public class ReadPhoneNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadPhoneNumber() {
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
		
		PhoneNumberDetail phoneNumberDetail = new PhoneNumberDetail();
		
		Integer phoneNumberLinkID = (new Integer(request.getParameter("phoneNumberLinkID")));
		phoneNumberDetail.setPhoneNumberLinkID(phoneNumberLinkID);
		
		ReadPhoneNumberDAO readPhoneNumberDAO = new ReadPhoneNumberDAO();
		readPhoneNumberDAO.readPhoneNumber(phoneNumberDetail);
		request.setAttribute("phoneNumberDetail", phoneNumberDetail);
		
		if (action != null && action.equals("update")) {
			pageForwardStr = "/components/profile/jsp/phone/UpdatePhoneNumber.jsp";

		} else {
			pageForwardStr = "";
		}
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
