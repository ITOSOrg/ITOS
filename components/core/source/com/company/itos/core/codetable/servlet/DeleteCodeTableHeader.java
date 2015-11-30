package com.company.itos.core.codetable.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.codetable.dao.DeleteCodeTableHeaderDAO;
import com.company.itos.core.codetable.pojo.CodeTableHeaderDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class DeleteCodeTableHeader
 */
public class DeleteCodeTableHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCodeTableHeader() {
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
		CodeTableHeaderDetail codeTableHeaderDetail = new CodeTableHeaderDetail();
		
		String defaultCode = request.getParameter("defaultCode");
		codeTableHeaderDetail.setDefaultCode(defaultCode);
		
		DeleteCodeTableHeaderDAO deleteCodeTableHeaderDAO = new DeleteCodeTableHeaderDAO();
		String returnMassegeStr =  deleteCodeTableHeaderDAO.deleteCodeTableHeader(codeTableHeaderDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/ListCodeTableHeader";
		} else {
			pageForwardStr = "/ListCodeTableHeader";
		}
		//pageForwardStr += "?defaultCode=" + codeTableHeaderDetail.getDefaultCode();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
