package com.company.itos.profile.codetableheader.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.codetableheader.dao.CreateCodeTableHeaderDAO;
import com.company.itos.profile.codetableheader.pojo.CodeTableHeaderDetail;

/**
 * Servlet implementation class CreateCodeTableHeader
 */
public class CreateCodeTableHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCodeTableHeader() {
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
		
		String tableName = request.getParameter("tableName");
		String defaultCode = request.getParameter("defaultCode");
		
		codeTableHeaderDetail.setTableName(tableName);
		codeTableHeaderDetail.setDefaultCode(defaultCode);
		
		CreateCodeTableHeaderDAO createCodeTableHeaderDAO = new CreateCodeTableHeaderDAO();
		String returnMassegeStr = createCodeTableHeaderDAO.CreateCodeTableHeader(codeTableHeaderDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = "/ListCodeTableHeader";
			//pageForwardStr += "?defaultCode=" + codeTableHeaderDetail.getDefaultCode();

		} else {
			pageForwardStr = "/components/profile/jsp/";
		}


		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
