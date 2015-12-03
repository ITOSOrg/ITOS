package com.company.itos.core.userrolelink.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.userrolelink.dao.ReadUserRoleLinkDAO;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class ReadUserRoleLink
 */
public class ReadUserRoleLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadUserRoleLink() {
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
		
		UserRoleLinkDetail userRoleLinkDetail = new UserRoleLinkDetail();
		
		int userRoleLinkID = (new Integer(request.getParameter("userRoleLinkID")));
		userRoleLinkDetail.setUserRoleLinkID(userRoleLinkID);
		
		ReadUserRoleLinkDAO readUserRoleLinkDAO = new ReadUserRoleLinkDAO();
		String returnMassegeStr =  readUserRoleLinkDAO.readUserRoleLink(userRoleLinkDetail);
		
		request.setAttribute("userRoleLinkDetail", userRoleLinkDetail);

		if (action != null && action.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/components/core/jsp/userrolelink/UpdateUserRoleLink.jsp";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/components/core/jsp/userrolelink/ReadUserRoleLink.jsp";
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
