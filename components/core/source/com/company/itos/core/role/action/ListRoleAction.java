package com.company.itos.core.role.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.role.dao.ListRoleDAO;
import com.company.itos.core.role.pojo.RoleDetail;
import com.opensymphony.xwork2.ActionSupport;

public class ListRoleAction extends ActionSupport implements SessionAware {
	
	private Map<String,Object> session;
	
	public void setSession(Map<String, Object> session) {
		

		 this.session = session;
		
	}
	
	public String execute() throws Exception {
		
		RoleDetail roleDetail = new RoleDetail();
		
		ListRoleDAO listRoleDAO = new ListRoleDAO();
		List<RoleDetail> roleDetailList = listRoleDAO.ListRole(roleDetail);
		
		session.put("roleDetailList", roleDetailList);
		
		return SUCCESS;
	}

}
