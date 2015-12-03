package com.company.itos.core.userrolelink.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.userrolelink.dao.ListUserRoleLinkDAO;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;

/**
 * Servlet implementation class ListUserRoleLink
 */
public class ListUserRoleLink extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListUserRoleLink() {
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

		UserRoleLinkDetail userRoleLinkDetail = new UserRoleLinkDetail();

		ListUserRoleLinkDAO listUserRoleLinkDAO = new ListUserRoleLinkDAO();
		List<UserRoleLinkDetail> userRoleLinklist = listUserRoleLinkDAO.listUserRoleLink(userRoleLinkDetail);

		request.setAttribute("userRoleLinklist", userRoleLinklist);

		if (userRoleLinklist != null) {

			pageForwardStr = "/components/core/jsp/userrolelink/ListUserRoleLink.jsp";

		} else {

			pageForwardStr = "";

		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);

	}

}
