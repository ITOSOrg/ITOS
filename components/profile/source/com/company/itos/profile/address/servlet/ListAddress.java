package com.company.itos.profile.address.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.profile.address.dao.ListAddressDAO;
import com.company.itos.profile.address.pojo.AddressLinkDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;

/**
 * Servlet implementation class ListAddress
 */
//@WebServlet("/ListAddress")
public class ListAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAddress() {
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

		Integer relatedID = (new Integer(request.getParameter("relatedID")));
		addressLinkDetail.setRelatedID(relatedID);
		
		ListAddressDAO listAddressDAO = new ListAddressDAO();
		List<AddressLinkDetail> addressLinkDetailList =listAddressDAO.ListAllAddress(addressLinkDetail);
		
		request.setAttribute("addressLinkDetailList", addressLinkDetailList);

		request.setAttribute("relatedID", relatedID);

		if (addressLinkDetailList != null) {

			pageForwardStr = "/components/profile/jsp/address/ListAddress.jsp";

		} else {

			pageForwardStr = "/PersonHome";
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);

		
	}

}
