package com.company.itos.core.keyserver.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.keyserver.dao.ListKeyServerDAO;
import com.company.itos.core.keyserver.pojo.KeyServerDetail;

/**
 * Servlet implementation class ListKeyServer
 */
public class ListKeyServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListKeyServer() {
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
		KeyServerDetail keyServerDetail = new KeyServerDetail();
		
		ListKeyServerDAO listKeyServerDAO = new ListKeyServerDAO();
		List<KeyServerDetail> KeyServerList = listKeyServerDAO.listKeyServer(keyServerDetail);
		
		request.setAttribute("KeyServerList", KeyServerList);

		if (KeyServerList != null) {

			pageForwardStr = "/components/core/jsp/keyServer/ListKeyServer.jsp";

		} else {

			pageForwardStr = "/";
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
