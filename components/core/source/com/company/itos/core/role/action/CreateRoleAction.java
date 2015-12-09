package com.company.itos.core.role.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.role.dao.CreateRoleDAO;
import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class CreateRoleAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	
	private Map<String,Object> session;
	private RoleDetail roleDeatail;

	/**
	 * @return the roleDeatail
	 */
	public RoleDetail getRoleDeatail() {
		return roleDeatail;
	}

	/**
	 * @param roleDeatail the roleDeatail to set
	 */
	public void setRoleDeatail(RoleDetail roleDeatail) {
		this.roleDeatail = roleDeatail;
	}

	public void setSession(Map<String, Object> session) {
		
		this.session = session;
		
	}
	
	public String execute() throws Exception {
		
		String pageForwardStr = "";
		

		CreateRoleDAO createRoleDAO = new CreateRoleDAO();
		String returnMassegeStr = createRoleDAO.CreateRole(roleDeatail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}

		return pageForwardStr;
}

}
