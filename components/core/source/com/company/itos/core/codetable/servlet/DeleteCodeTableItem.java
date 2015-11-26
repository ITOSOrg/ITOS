package com.company.itos.core.codetable.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.codetable.dao.DeleteCodeTableItemDAO;
import com.company.itos.core.codetable.pojo.CodeTableItemDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class DeleteCodeTableItem
 */
public class DeleteCodeTableItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCodeTableItem() {
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
		CodeTableItemDetail codeTableItemDetail = new CodeTableItemDetail();
		
		String code = request.getParameter("code");
		 codeTableItemDetail.setCode(code);
		
		 String tableName = request.getParameter("tableName");
		 codeTableItemDetail.setTableName(tableName);
		 
		 DeleteCodeTableItemDAO deleteCodeTableItemDAO = new DeleteCodeTableItemDAO();
		 String returnMassegeStr = deleteCodeTableItemDAO.deleteCodeTableItem(codeTableItemDetail);
		 
		 if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
				pageForwardStr = "/ReadCodeTableHeader";
				pageForwardStr += "?tableName=" + codeTableItemDetail.getTableName();
			} else {
				pageForwardStr = "/ListCodeTableItem";
			}
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
			requestDispatcher.forward(request, response);
	}

}
