package com.company.itos.profile.codeTableItem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.codeTableItem.dao.UpdateCodeTableItemDAO;
import com.company.itos.profile.codeTableItem.pojo.CodeTableItemDetail;

/**
 * Servlet implementation class UpdateCodeTableItem
 */
public class UpdateCodeTableItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCodeTableItem() {
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
		CodeTableItemDetail	 codeTableItemDetail = new CodeTableItemDetail();
		String code = request.getParameter("code");
		codeTableItemDetail.setCode(code);
		
		String tableName = request.getParameter("tableName");
		String description = request.getParameter("description");
		String annotation = request.getParameter("annotation");
		String isEnabled = request.getParameter("isEnabled");
		String recordStatus = request.getParameter("recordStatus");
		int versionNo = (new Integer(request.getParameter("versionNo")));
		
		codeTableItemDetail.setTableName(tableName);
		codeTableItemDetail.setDescription(description);
		codeTableItemDetail.setAnnotation(annotation);
		codeTableItemDetail.setIsEnabled(isEnabled);
		codeTableItemDetail.setRecordStatus(recordStatus);
		codeTableItemDetail.setVersionNo(versionNo);
		
		UpdateCodeTableItemDAO updateCodeTableItemDAO = new UpdateCodeTableItemDAO();
		String returnMassegeStr = updateCodeTableItemDAO.UpdateCodeTableItem(codeTableItemDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/ReadCodeTableHeader";
			pageForwardStr += "?tableName=" + codeTableItemDetail.getTableName();
		} else {
			pageForwardStr = "/ListCodeTableItem";
		}
		//pageForwardStr += "?code=" + codeTableItemDetail.getCode();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
