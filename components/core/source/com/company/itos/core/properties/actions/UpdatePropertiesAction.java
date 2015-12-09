package com.company.itos.core.properties.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.properties.dao.UpdatePropertiesDAO;
import com.company.itos.core.properties.pojo.PropertiesDetail;
import com.opensymphony.xwork2.ActionSupport;

public class UpdatePropertiesAction extends ActionSupport implements SessionAware, ServletRequestAware {

	private PropertiesDetail propertiesDetail;

	/**
	 * @return the propertiesDetail
	 */
	public PropertiesDetail getPropertiesDetail() {
		return propertiesDetail;
	}

	/**
	 * @param propertiesDetail the propertiesDetail to set
	 */
	public void setPropertiesDetail(PropertiesDetail propertiesDetail) {
		this.propertiesDetail = propertiesDetail;
	}

	private Map<String, Object> session;
	HttpServletRequest request;

	public HttpServletRequest getServletRequest() {
		return request;
	}

	public void setServletRequest(HttpServletRequest request) {

		this.request = request;

	}

	public void setSession(Map<String, Object> sessionInput) {

		this.session = sessionInput;

	}

	public String execute() throws Exception {

		/*int propertyID = new Integer((String) getServletRequest().getParameter("propertyID")).intValue();
		propertiesDetail.setPropertyID(propertyID);

		int versionNo = new Integer((String) getServletRequest().getParameter("versionNo")).intValue();
		propertiesDetail.setVersionNo(versionNo);*/

		UpdatePropertiesDAO updatePropertiesDAO = new UpdatePropertiesDAO();
		String returnMassegeStr = updatePropertiesDAO.updateProperties(propertiesDetail);
		session.put("propertiesDetail", propertiesDetail);

		return returnMassegeStr;
	}

}
