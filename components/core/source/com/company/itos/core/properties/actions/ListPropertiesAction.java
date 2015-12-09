/**
 * 
 */
package com.company.itos.core.properties.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.properties.dao.ListPropertiesDAO;
import com.company.itos.core.properties.pojo.PropertiesDetail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ListPropertiesAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;

    public void setSession(Map<String,Object> session){ 
        this.session = session;
    }
    
	/**
	 * 
	 */
	public String execute() throws Exception {

		PropertiesDetail propertiesDetail = new PropertiesDetail();
		
		ListPropertiesDAO listPropertiesDAO = new ListPropertiesDAO();
		
		List<PropertiesDetail> propertiesList =  listPropertiesDAO.ListProperties(propertiesDetail);
		
		
		session.put("propertiesList", propertiesList);


		return SUCCESS;
	}

}
