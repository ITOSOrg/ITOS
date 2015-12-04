package com.company.itos.core.role.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.role.dao.ListRoleForSinglePersonDAO;
import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;

/**
 * Servlet implementation class ListRoleForSinglePerson
 */
public class ListRoleForSinglePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListRoleForSinglePerson() {
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
		
		String username = request.getParameter("username");
		userRoleLinkDetail.setUsername(username);
		
		ListRoleForSinglePersonDAO listRoleForSinglePersonDAO = new ListRoleForSinglePersonDAO();
		List<RoleDetail> SinglePersonRolelist = listRoleForSinglePersonDAO.listRoleForSinglePerson(userRoleLinkDetail);
		
		request.setAttribute("SinglePersonRolelist", SinglePersonRolelist);

		if (SinglePersonRolelist != null) {

			pageForwardStr = "/components/core/jsp/role/SinglePersonRolelist.jsp";

		} else {

			pageForwardStr = "";

		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
