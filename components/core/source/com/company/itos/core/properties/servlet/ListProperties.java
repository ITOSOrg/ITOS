package com.company.itos.core.properties.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.properties.dao.ListPropertiesDAO;
import com.company.itos.core.properties.pojo.PropertiesDetail;

/**
 * Servlet implementation class ListProperties
 */
public class ListProperties extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProperties() {
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
		PropertiesDetail propertiesDetail = new PropertiesDetail();
		
		ListPropertiesDAO listPropertiesDAO = new ListPropertiesDAO();
		
		List<PropertiesDetail> propertiesList =  listPropertiesDAO.ListProperties(propertiesDetail);
		
		request.setAttribute("propertiesList", propertiesList);

		//request.setAttribute("personID", personID);

		if (propertiesList != null) {

			pageForwardStr = "/components/core/jsp/properties/ListProperties.jsp";

		} else {

			pageForwardStr = "/";
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
