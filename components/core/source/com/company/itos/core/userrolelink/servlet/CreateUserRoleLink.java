package com.company.itos.core.userrolelink.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.userrolelink.dao.CreateUserRoleLinkDAO;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class CreateUserRoleLink
 */
public class CreateUserRoleLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserRoleLink() {
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
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
userRoleLinkDetail.setUsername(username);
		
		java.util.Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			userRoleLinkDetail.setStartDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			userRoleLinkDetail.setEndDate(sqlDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		CreateUserRoleLinkDAO createUserRoleLinkDAO = new CreateUserRoleLinkDAO();
		String returnMassegeStr = createUserRoleLinkDAO.CreateUserRoleLink(userRoleLinkDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = "/";

		} else {
			pageForwardStr = "/compone";
		}

		//pageForwardStr += "?phoneNumberLinkID=" + phoneNumberLinkDetail.getPhoneNumberLinkID();
		//pageForwardStr += "?relatedID=" + phoneNumberLinkDetail.getRelatedID();

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
		
	}

}
