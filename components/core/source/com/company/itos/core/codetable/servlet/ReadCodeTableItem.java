package com.company.itos.core.codetable.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.codetable.dao.ReadCodeTableItemDAO;
import com.company.itos.core.codetable.pojo.CodeTableItemDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class ReadCodeTableItem
 */
public class ReadCodeTableItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadCodeTableItem() {
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
		
		CodeTableItemDetail codeTableItemDetail = new CodeTableItemDetail();
		
		String pageForwardStr = "";
		String action = request.getParameter("act");
		
		String code = request.getParameter("code");
		codeTableItemDetail.setCode(code);
		
		String tableName = request.getParameter("tableName");
		codeTableItemDetail.setTableName(tableName);
		
		ReadCodeTableItemDAO readCodeTableItemDAO = new ReadCodeTableItemDAO();
		String returnMassegeStr = readCodeTableItemDAO.readCodeTableItem(codeTableItemDetail);
		
		if (action != null && action.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/components/core/jsp/codetable/UpdateCodeTableItem.jsp";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/components/core/jsp/codetable/ReadCodeTableItem.jsp";
		}

		request.setAttribute("codeTableItemDetail", codeTableItemDetail);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
