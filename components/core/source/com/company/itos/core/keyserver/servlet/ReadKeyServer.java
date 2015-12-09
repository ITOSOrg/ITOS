package com.company.itos.core.keyserver.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.keyserver.dao.ReadKeyServerDAO;
import com.company.itos.core.keyserver.pojo.KeyServerDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class ReadKeyServer
 */
public class ReadKeyServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadKeyServer() {
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
		KeyServerDetail keyServerDetail = new KeyServerDetail();
		
		String keysetCode = request.getParameter("keysetCode");
		keyServerDetail.setKeysetCode(keysetCode);
		
		ReadKeyServerDAO readKeyServerDAO = new ReadKeyServerDAO();
		String returnMassegeStr = readKeyServerDAO.ReadKeyServer(keyServerDetail);
		
		//request.setAttribute("keysetCode", keysetCode);
		request.setAttribute("keyServerDetail", keyServerDetail);
		
		if (action != null && action.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/components/core/jsp/keyServer/UpdateKeyServer.jsp";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/components/core/jsp/keyServer/ReadKeyServer.jsp";
		}


		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
