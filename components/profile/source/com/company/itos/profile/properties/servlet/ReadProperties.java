package com.company.itos.profile.properties.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.properties.dao.ReadPropertiesDAO;
import com.company.itos.profile.properties.pojo.PropertiesDetail;

/**
 * Servlet implementation class ReadProperties
 */
public class ReadProperties extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadProperties() {
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
		String action = request.getParameter("act");
		
		PropertiesDetail propertiesDetail = new PropertiesDetail();
		int propertyID = (new Integer (request.getParameter("propertyID")));
		
		propertiesDetail.setPropertyID(propertyID);
		
		ReadPropertiesDAO readPropertiesDAO = new ReadPropertiesDAO();
		String returnMassegeStr = readPropertiesDAO.ReadProperties(propertiesDetail);
		
		if (action != null && action.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/components/profile/jsp/properties/UpdateProperties.jsp";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "/components/profile/jsp/properties/ReadProperties.jsp";
		}

		request.setAttribute("propertiesDetail", propertiesDetail);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageForwardStr);
		requestDispatcher.forward(request, response);
	}

}
