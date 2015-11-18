package com.company.itos.profile.address.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.address.dao.ReadAddressDAO;
import com.company.itos.profile.address.pojo.AddressLinkDetail;
import com.company.itos.profile.email.dao.ReadEmailAddressDAO;

/**
 * Servlet implementation class ReadAddress
 */
//@WebServlet("/ReadAddress")
public class ReadAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadAddress() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageForwardStr = "";
		String action = request.getParameter("act");
		AddressLinkDetail addressLinkDetail = new AddressLinkDetail();
		
		try {

			Integer addressLinkID = (new Integer(request.getParameter("addressLinkID")));
			addressLinkDetail.setAddressLinkID(addressLinkID);

		} catch (NumberFormatException e) {

			System.out.println(e.getMessage());
		}

		ReadAddressDAO readAddressDAO = new ReadAddressDAO();

		String returnMassegeStr = readAddressDAO.readPrimaryAddress(addressLinkDetail);

		if (action != null && action.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "";
		}

		request.setAttribute("addressLinkDetail", addressLinkDetail);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}