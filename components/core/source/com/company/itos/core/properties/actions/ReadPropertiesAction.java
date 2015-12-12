/**
 * 
 */
package com.company.itos.core.properties.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.properties.dao.ReadPropertiesDAO;
import com.company.itos.core.properties.pojo.PropertiesDetail;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ReadPropertiesAction extends ActionSupport implements SessionAware, ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	private Map<String, Object> session;
	HttpServletRequest request;
	PropertiesDetail propertiesDetail;
	String act = "";

	/**
	 * @return the act
	 */
	public String getAct() {
		return act;
	}

	/**
	 * @param act
	 *            the act to set
	 */
	public void setAct(String act) {
		this.act = act;
	}

	/**
	 * @return the propertiesDetail
	 */
	public PropertiesDetail getPropertiesDetail() {
		return propertiesDetail;
	}

	/**
	 * @param propertiesDetail
	 *            the propertiesDetail to set
	 */
	public void setPropertiesDetail(PropertiesDetail propertiesDetail) {
		this.propertiesDetail = propertiesDetail;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getServletRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setSession(Map<String, Object> sessionInput) {

		this.session = sessionInput;

	}

	public String execute() throws Exception {

		// PropertiesDetail propertiesDetail = new PropertiesDetail();

		String pageForwardStr = "";
		// String action = (String) getServletRequest().getParameter("act");

		// int propertyID = new Integer((String)
		// getServletRequest().getParameter("propertyID")).intValue();

		// propertiesDetail.setPropertyID(propertyID);

		ReadPropertiesDAO readPropertiesDAO = new ReadPropertiesDAO();
		String returnMassegeStr = readPropertiesDAO.ReadProperties(propertiesDetail);

		setPropertiesDetail(propertiesDetail);

		//session.put("propertiesDetail", propertiesDetail);

		if (act != null && act.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "SENTTOUPDATE";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = SUCCESS;
		}

		return pageForwardStr;
	}

}
