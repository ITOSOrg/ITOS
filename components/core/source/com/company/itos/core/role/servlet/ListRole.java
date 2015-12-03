package com.company.itos.core.role.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.role.dao.ListRoleDAO;
import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;

/**
 * Servlet implementation class ListRole
 */
public class ListRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListRole() {
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
		
		UserRoleLinkDetail userRoleLinkDetail = new UserRoleLinkDetail();
		
		ListRoleDAO listRoleDAO = new ListRoleDAO();
		List<RoleDetail> roleDetailList = listRoleDAO.ListRole(roleDetail);
		
		request.setAttribute("roleDetailList", roleDetailList);

		if (roleDetailList != null) {

			pageForwardStr = "/components/core/jsp/role/ListRole.jsp";

		} else {

			pageForwardStr = "";

		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
