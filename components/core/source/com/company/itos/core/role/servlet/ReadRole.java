package com.company.itos.core.role.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.role.dao.ReadRoleDAO;
import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class ReadRole
 */
public class ReadRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadRole() {
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
		RoleDetail roleDetail = new RoleDetail();
		
		UserRoleLinkDetail userRoleLinkDetail = new UserRoleLinkDetail();
		
		int roleID = (new Integer(request.getParameter("roleID")));
		roleDetail.setRoleID(roleID);
		
		ReadRoleDAO readRoleDAO = new ReadRoleDAO();
		String returnMassegeStr = readRoleDAO.readRole(roleDetail);
		
		request.setAttribute("roleDetail", roleDetail);

		if (action != null && action.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/components/core/jsp/role/UpdateRole.jsp";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/components/core/jsp/role/ReadRole.jsp";
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
