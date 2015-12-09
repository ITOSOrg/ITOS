package com.company.itos.core.userrolelink.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.userrolelink.dao.UpdateUserRoleLinkDAO;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class UpdateUserRoleLink
 */
public class UpdateUserRoleLink extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserRoleLink() {
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

		int userRoleLinkID = (new Integer(request.getParameter("userRoleLinkID")));
		userRoleLinkDetail.setUserRoleLinkID(userRoleLinkID);

		int versionNo = (new Integer(request.getParameter("versionNo")));
		userRoleLinkDetail.setVersionNo(versionNo);

		String username = request.getParameter("username");
		String endDate = request.getParameter("endDate");

		userRoleLinkDetail.setUsername(username);

		java.util.Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			userRoleLinkDetail.setEndDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		UpdateUserRoleLinkDAO updateUserRoleLinkDAO = new UpdateUserRoleLinkDAO();
		String returnMassegeStr = updateUserRoleLinkDAO.updateUserRoleLink(userRoleLinkDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/ListUserRoleLink";
		} else {

			pageForwardStr = "";
		}
		// pageForwardStr += "?relatedID=" +
		// phoneNumberLinkDetail.getRelatedID();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);

	}

}
