package com.company.itos.core.role.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.role.dao.UpdateRoleDAO;
import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class UpdateRole
 */
public class UpdateRole extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateRole() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pageForwardStr = "";
		RoleDetail roleDeatail = new RoleDetail();

		int roleID = (new Integer(request.getParameter("roleID")));
		roleDeatail.setRoleID(roleID);

		int versionNo = (new Integer(request.getParameter("versionNo")));
		roleDeatail.setVersionNo(versionNo);

		String roleType = request.getParameter("roleType");
		String workspace = request.getParameter("workspace");

		roleDeatail.setRoleType(roleType);
		roleDeatail.setWorkspace(workspace);

		UpdateRoleDAO updateRoleDAO = new UpdateRoleDAO();
		String returnMassegeStr = updateRoleDAO.UpdateRole(roleDeatail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/ListRole";
		} else {

			pageForwardStr = "";
		}
		// pageForwardStr += "?relatedID=" +
		// phoneNumberLinkDetail.getRelatedID();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
