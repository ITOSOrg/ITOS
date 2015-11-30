package com.company.itos.profile.address.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.address.dao.DeleteAddressDAO;
import com.company.itos.profile.address.pojo.AddressDetail;
import com.company.itos.profile.address.pojo.AddressLinkDetail;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;

/**
 * Servlet implementation class DeleteAddress
 */
public class DeleteAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAddress() {
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
		
		String pageForwardStr = null;
		AddressDetail addressDetail = new AddressDetail();
		AddressLinkDetail addressLinkDetail = new AddressLinkDetail();

		//int addressId = (new Integer(request.getParameter("addressId")));
		int relatedID = (new Integer(request.getParameter("relatedID")));
		int addressLinkID = (new Integer(request.getParameter("addressLinkID")));

		//addressDetail.setAddressId(addressId);
		addressLinkDetail.setRelatedID(relatedID);
		addressLinkDetail.setAddressLinkID(addressLinkID);
		
		DeleteAddressDAO deleteAddressDAO = new DeleteAddressDAO();
		String returnMassegeStr = deleteAddressDAO.deleteAddress(addressLinkDetail);
		
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/ListAddress";
		} else {
			pageForwardStr = "/ListAddress";
		}
		pageForwardStr += "?relatedID=" + addressLinkDetail.getRelatedID();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);

	}

}
