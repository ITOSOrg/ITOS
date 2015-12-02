package com.company.itos.core.keyserver.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.keyserver.dao.UpdateKeyServerDAO;
import com.company.itos.core.keyserver.pojo.KeyServerDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class UpdateKeyServer
 */
public class UpdateKeyServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateKeyServer() {
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
		keyServerDetail.setKeysetCode(keysetCode);
		
		int versionNo = (new Integer(request.getParameter("versionNo")));
		keyServerDetail.setVersionNo(versionNo);
		
		int nextUniqueIdBlock = ( new Integer (request.getParameter("nextUniqueIdBlock")));
		String humanReadable = request.getParameter("humanReadable");
		String annotation = request.getParameter("annotation");
		String strategy = request.getParameter("strategy");
		String recordStatus = request.getParameter("recordStatus");
		String createdBy = request.getParameter("createdBy");
		String lastModifiedBy = request.getParameter("lastModifiedBy");
		
		keyServerDetail.setNextUniqueIdBlock(nextUniqueIdBlock);
		keyServerDetail.setHumanReadable(humanReadable);
		keyServerDetail.setAnnotation(annotation);
		keyServerDetail.setStrategy(strategy);
		keyServerDetail.setRecordStatus(recordStatus);
		keyServerDetail.setCreatedBy(createdBy);
		keyServerDetail.setLastModifiedBy(lastModifiedBy);
		
		UpdateKeyServerDAO updateKeyServerDAO = new UpdateKeyServerDAO();
		String returnMassegeStr = updateKeyServerDAO.UpdateKeyServer(keyServerDetail);
		
		

		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/ListKeyServer";
		} else {
			pageForwardStr = "/ListKeyServer";
		}
		pageForwardStr += "?keysetCode=" + keyServerDetail.getKeysetCode();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
