package com.company.itos.core.role.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.role.dao.DeleteRoleDAO;
import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class DeleteRole
 */
public class DeleteRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRole() {
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

		RoleDetail roleDetail = new RoleDetail();
		
		
		long roleID = (new Long (request.getParameter("roleID")));
		roleDetail.setRoleID(roleID);
		
		DeleteRoleDAO deleteRoleDAO = new DeleteRoleDAO();
		String returnMassegeStr = deleteRoleDAO.deleteRole(roleDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/ListRole";

		} else  {
			pageForwardStr = "/ListRole";
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
