package com.company.itos.core.role.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.role.dao.UpdateRoleDAO;
import com.company.itos.core.role.pojo.RoleDetail;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateRoleAction extends ActionSupport implements SessionAware, ServletRequestAware {
	
	private Map<String, Object> session;
	HttpServletRequest request;
	private RoleDetail roleDetail;
	
	public void setSession(Map<String, Object> sessionInput) {
		
		this.session = sessionInput;

	}
	public HttpServletRequest getServletRequest() {
		return request;
	}

	public void setServletRequest(HttpServletRequest request) {

		this.request = request;

	}
	
	
	
	/**
	 * @return the roleDetail
	 */
	public RoleDetail getRoleDetail() {
		return roleDetail;
	}
	/**
	 * @param roleDetail the roleDetail to set
	 */
	public void setRoleDetail(RoleDetail roleDetail) {
		this.roleDetail = roleDetail;
	}
	public String execute() throws Exception {
		
		UpdateRoleDAO updateRoleDAO = new UpdateRoleDAO();
		String returnMassegeStr = updateRoleDAO.UpdateRole(roleDetail);
		
		//session.put("roleDetail", roleDetail);
		
		return SUCCESS;
	}

}
