package com.company.itos.core.properties.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.properties.dao.CreatePropertiesDAO;
import com.company.itos.core.properties.pojo.PropertiesDetail;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class CreatePropertiesAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PropertiesDetail propertiesDetail;

	private Map<String, Object> session;

	public void setSession(Map<String, Object> session) {
		this.session = session;
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
	 * 
	 */
	public String execute() throws Exception {

		String pageForwardStr = "";

		CreatePropertiesDAO createPropertiesDAO = new CreatePropertiesDAO();
		String returnMassegeStr = createPropertiesDAO.createProperties(propertiesDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}

		return pageForwardStr;
	}
}
