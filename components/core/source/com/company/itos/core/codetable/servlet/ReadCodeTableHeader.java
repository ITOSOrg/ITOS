package com.company.itos.core.codetable.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.codetable.dao.ReadCodeTableHeaderDAO;
import com.company.itos.core.codetable.pojo.CodeTableHeaderDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class ReadCodeTableHeader
 */
public class ReadCodeTableHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadCodeTableHeader() {
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
		CodeTableHeaderDetail codeTableHeaderDetail = new CodeTableHeaderDetail();
		
		String tableName = request.getParameter("tableName");
		codeTableHeaderDetail.setTableName(tableName);
		
		ReadCodeTableHeaderDAO readCodeTableHeaderDAO = new ReadCodeTableHeaderDAO();
		String returnMassegeStr =  readCodeTableHeaderDAO.ReadCodeTableHeader(codeTableHeaderDetail);
		
		if (action != null && action.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/components/core/jsp/codetable/UpdateCodeTableHeader.jsp";
			pageForwardStr += "?tableName=" +codeTableHeaderDetail.getTableName();
			
		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/components/core/jsp/codetable/ReadCodeTableHeader.jsp";
		}

		request.setAttribute("codeTableHeaderDetail", codeTableHeaderDetail);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
