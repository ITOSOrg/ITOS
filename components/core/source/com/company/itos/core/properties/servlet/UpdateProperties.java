package com.company.itos.core.properties.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.properties.dao.UpdatePropertiesDAO;
import com.company.itos.core.properties.pojo.PropertiesDetail;
import com.company.itos.core.util.CRUDConstants;

/**
 * Servlet implementation class UpdateProperties
 */
public class UpdateProperties extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProperties() {
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
		
		int propertyID = (new Integer (request.getParameter("propertyID")));
		propertiesDetail.setPropertyID(propertyID);
		
		int versionNo = (new Integer (request.getParameter("versionNo")));
		propertiesDetail.setVersionNo(versionNo);
		
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		String type = request.getParameter("Type");
		String defaultValue = request.getParameter("defaultValue");
		String dynamic = request.getParameter("dynamic");
		String createdBy = request.getParameter("createdBy");
		String lastModifiedBy = request.getParameter("lastModifiedBy");
		
		propertiesDetail.setCategory(category);
		propertiesDetail.setName(name);
		propertiesDetail.setValue(value);
		propertiesDetail.setType(type);
		propertiesDetail.setDefaultValue(defaultValue);
		propertiesDetail.setDynamic(dynamic);
		propertiesDetail.setCreatedBy(createdBy);
		propertiesDetail.setLastModifiedBy(lastModifiedBy);
		
		UpdatePropertiesDAO updatePropertiesDAO = new UpdatePropertiesDAO();
		String returnMassegeStr =  updatePropertiesDAO.updateProperties(propertiesDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/ListProperties";
		} else {
			pageForwardStr = "/ListProperties";
		}
		//pageForwardStr += "?propertyID=" + propertiesDetail.getPropertyID();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
