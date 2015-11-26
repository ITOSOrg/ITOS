package com.company.itos.core.codetable.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.codetable.dao.ListCodeTableHeaderDAO;
import com.company.itos.core.codetable.pojo.CodeTableHeaderDetail;

/**
 * Servlet implementation class ListCodeTableHeader
 */
public class ListCodeTableHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCodeTableHeader() {
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
		
		ListCodeTableHeaderDAO listCodeTableHeaderDAO = new ListCodeTableHeaderDAO();
		List<CodeTableHeaderDetail> codeTableHeaderList = listCodeTableHeaderDAO.listAllCodeTableHeader(codeTableHeaderDetail);
		
		request.setAttribute("codeTableHeaderList", codeTableHeaderList);

		if (codeTableHeaderList != null) {

			pageForwardStr = "/components/core/jsp/codetable/ListCodeTableHeader.jsp";

		} else {

			pageForwardStr = "/PersonHome";
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
