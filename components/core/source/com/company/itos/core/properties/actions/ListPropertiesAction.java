/**
 * 
 */
package com.company.itos.core.properties.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.properties.dao.ListPropertiesDAO;
import com.company.itos.core.properties.pojo.PropertiesDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ListPropertiesAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;

	private List<PropertiesDetail> propertiesList;

	/**
	 * @return the propertiesList
	 */
	public List<PropertiesDetail> getPropertiesList() {
		return propertiesList;
	}

	/**
	 * @param propertiesList
	 *            the propertiesList to set
	 */
	public void setPropertiesList(List<PropertiesDetail> propertiesList) {
		this.propertiesList = propertiesList;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * 
	 */
	public String execute() throws Exception {

		PropertiesDetail propertiesDetail = new PropertiesDetail();

		ListPropertiesDAO listPropertiesDAO = new ListPropertiesDAO();

		List<PropertiesDetail> propertiesList = listPropertiesDAO.ListProperties(propertiesDetail);

		setPropertiesList(propertiesList);

		// session.put("propertiesList", propertiesList);

		return SUCCESS;
	}

}
