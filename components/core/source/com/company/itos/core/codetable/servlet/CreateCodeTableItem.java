package com.company.itos.core.codetable.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.codetable.dao.CreateCodeTableItemDAO;
import com.company.itos.core.codetable.pojo.CodeTableItemDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class CreateCodeTableItem
 */
public class CreateCodeTableItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCodeTableItem() {
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
		
		String tableName = request.getParameter("tableName");
		codeTableItemDetail.setTableName(tableName);
		
		
		String code = request.getParameter("code");
		String description = request.getParameter("description");
		String annotation = request.getParameter("annotation");
		String isEnabled = request.getParameter("isEnabled");
		
		codeTableItemDetail.setCode(code);
		codeTableItemDetail.setDescription(description);
		codeTableItemDetail.setAnnotation(annotation);
		codeTableItemDetail.setIsEnabled(isEnabled);
		
		CreateCodeTableItemDAO createCodeTableItemDAO = new CreateCodeTableItemDAO();
		String returnMassegeStr = createCodeTableItemDAO.createCreateCodeTableItem(codeTableItemDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = "/ReadCodeTableHeader";
			pageForwardStr += "?tableName=" + codeTableItemDetail.getTableName();

		} else {
			pageForwardStr = "";
		}


		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
