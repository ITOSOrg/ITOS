package com.company.itos.core.keyserver.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.keyserver.dao.CreateKeyServerDAO;
import com.company.itos.core.keyserver.pojo.KeyServerDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class CreateKeyServer
 */
public class CreateKeyServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateKeyServer() {
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
		
		String keysetCode = request.getParameter("keysetCode");
		int nextUniqueIdBlock = ( new Integer (request.getParameter("nextUniqueIdBlock")));
		String humanReadable = request.getParameter("humanReadable");
		String annotation = request.getParameter("annotation");
		String strategy = request.getParameter("strategy");
		
		keyServerDetail.setKeysetCode(keysetCode);
		keyServerDetail.setNextUniqueIdBlock(nextUniqueIdBlock);
		keyServerDetail.setHumanReadable(humanReadable);
		keyServerDetail.setAnnotation(annotation);
		keyServerDetail.setStrategy(strategy);
		
		CreateKeyServerDAO createKeyServerDAO = new CreateKeyServerDAO();
		String returnMassegeStr = createKeyServerDAO.CreateKeyServer(keyServerDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = "/ListKeyServer";

		} else {
			
			pageForwardStr = "";
		
		}

		//pageForwardStr += "?personID=" + personIdentityDetail.getPersonID();
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
