package com.company.itos.core.role.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.role.dao.DeleteRoleDAO;
import com.company.itos.core.role.pojo.RoleDetail;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteRoleAction extends ActionSupport implements SessionAware {
	
	private Map<String,Object> session;
	private RoleDetail roleDetail;
	HttpServletRequest request;
	
	public void setSession(Map<String, Object> sessionInput) {
		
		this.session = sessionInput;
		
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

	/**
	 * @return the request
	 */
	public HttpServletRequest getServletRequest() {
		return request;
	}


	/**
	 * @param request the request to set
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
		public String execute() throws Exception {
		
			//RoleDetail roleDetail = new RoleDetail();
			
			//int roleID = new Integer((String) getServletRequest().getParameter("roleID")).intValue();
			
			//roleDetail.setRoleID(roleID);
			
		DeleteRoleDAO deleteRoleDAO = new DeleteRoleDAO();
		String returnMassegeStr = deleteRoleDAO.deleteRole(roleDetail);
		
		return SUCCESS;
		
		}

}
