package com.company.itos.profile.codeTableItem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.profile.codeTableItem.dao.ListCodeTableItemDAO;
import com.company.itos.profile.codeTableItem.pojo.CodeTableItemDetail;

/**
 * Servlet implementation class ListCodeTableItem
 */
public class ListCodeTableItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCodeTableItem() {
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
		
		//String code = request.getParameter("code");
		//codeTableItemDetail.setCode(code);
		
		ListCodeTableItemDAO listCodeTableItemDAO = new ListCodeTableItemDAO();
		List<CodeTableItemDetail> codeTableItemDetailList = listCodeTableItemDAO.listCodeTableItem(codeTableItemDetail);
		
		request.setAttribute("codeTableItemDetailList", codeTableItemDetailList);

		if (codeTableItemDetailList != null) {

			pageForwardStr = "/components/profile/jsp/codeTableItem/ListCodeTableItem.jsp";

		} else {

			pageForwardStr = "/PersonHome";
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
