package com.company.itos.core.userrolelink.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.userrolelink.dao.CreateUserRoleLinkDAO;
import com.company.itos.core.userrolelink.dao.ReadUserRoleLinkDAO;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class ReadUserRoleLinkAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private UserRoleLinkDetail userRoleLinkDetail;
	private Map<String,Object> session;

	

	/**
	 * @return the userRoleLinkDetail
	 */
	public UserRoleLinkDetail getUserRoleLinkDetail() {
		return userRoleLinkDetail;
	}

	/**
	 * @param userRoleLinkDetail the userRoleLinkDetail to set
	 */
	public void setUserRoleLinkDetail(UserRoleLinkDetail userRoleLinkDetail) {
		this.userRoleLinkDetail = userRoleLinkDetail;
	}

	public void setSession(Map<String, Object> session) {
		
		this.session = session;
		
	}
	
	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		ReadUserRoleLinkDAO readUserRoleLinkDAO = new ReadUserRoleLinkDAO();
		String returnMassegeStr =  readUserRoleLinkDAO.readUserRoleLink(userRoleLinkDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}

		return pageForwardStr;
}
}
