package com.company.itos.core.properties.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.properties.dao.CreatePropertiesDAO;
import com.company.itos.core.properties.pojo.PropertiesDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class CreateProperties
 */
public class CreateProperties extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProperties() {
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
		
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		String type = request.getParameter("Type");
		String defaultValue = request.getParameter("defaultValue");
		String dynamic = request.getParameter("dynamic");
		
		propertiesDetail.setCategory(category);
		propertiesDetail.setName(name);
		propertiesDetail.setValue(defaultValue);
		propertiesDetail.setType(type);
		propertiesDetail.setDefaultValue(defaultValue);
		propertiesDetail.setDynamic(dynamic);
		
		CreatePropertiesDAO createPropertiesDAO = new CreatePropertiesDAO();
		String returnMassegeStr = createPropertiesDAO.createProperties(propertiesDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = "/ListProperties";
			//pageForwardStr += "?tableName=" + codeTableItemDetail.getTableName();

		} else {
			pageForwardStr = "/components/core/jsp/";
		}


		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
