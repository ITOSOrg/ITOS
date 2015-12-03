package com.company.itos.core.userrolelink.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.userrolelink.dao.DeleteUserRoleLinkDAO;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class DeleteUserRoleLink
 */
public class DeleteUserRoleLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserRoleLink() {
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
		
		UserRoleLinkDetail userRoleLinkDetail = new UserRoleLinkDetail();
		
		int userRoleLinkID = (new Integer(request.getParameter("userRoleLinkID")));
		userRoleLinkDetail.setUserRoleLinkID(userRoleLinkID);
		
		DeleteUserRoleLinkDAO deleteUserRoleLinkDAO = new DeleteUserRoleLinkDAO();
		String returnMassegeStr = deleteUserRoleLinkDAO.deleteUserRoleLink(userRoleLinkDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/ListUserRoleLink";

		} else  {
			pageForwardStr = "/ListUserRoleLink";
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
