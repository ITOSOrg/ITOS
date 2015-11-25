package com.company.itos.profile.codetableheader.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.codetableheader.dao.UpdateCodeTableHeaderDAO;
import com.company.itos.profile.codetableheader.pojo.CodeTableHeaderDetail;

/**
 * Servlet implementation class UpdateCodeTableHeader
 */
public class UpdateCodeTableHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCodeTableHeader() {
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
		String tableName = request.getParameter("tableName");
		String recordStatus = request.getParameter("recordStatus");
		String createdBy = request.getParameter("createdBy");
		String lastModifiedBy = request.getParameter("lastModifiedBy");
		int versionNo = (new Integer (request.getParameter("versionNo")));
		
		codeTableHeaderDetail.setDefaultCode(defaultCode);
		codeTableHeaderDetail.setTableName(tableName);
		codeTableHeaderDetail.setRecordStatus(recordStatus);
		codeTableHeaderDetail.setCreatedBy(createdBy);
		codeTableHeaderDetail.setLastModifiedBy(lastModifiedBy);
		codeTableHeaderDetail.setVersionNo(versionNo);
		
		UpdateCodeTableHeaderDAO updateCodeTableHeaderDAO = new UpdateCodeTableHeaderDAO();
		String returnMassegeStr = updateCodeTableHeaderDAO.updateCodeTableHeader(codeTableHeaderDetail);
		
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
