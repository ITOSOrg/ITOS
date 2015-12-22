package com.company.itos.core.role.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.keyserver.pojo.KeyServerDetail;
import com.company.itos.core.role.dao.ReadRoleDAO;
import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class ReadPersonRoleAction extends ActionSupport implements SessionAware, ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	
	String act = "";
	private Map<String,Object> session;
	private RoleDetail roleDetail;
	HttpServletRequest request;

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
		
		String pageForwardStr = "";
		//RoleDetail roleDetail = new RoleDetail();
		
		//String action = (String) getServletRequest().getParameter("act");
		//int roleID = new Integer((String) getServletRequest().getParameter("roleID")).intValue();
		
		//roleDetail.setRoleID(roleID);
		
		ReadRoleDAO readRoleDAO = new ReadRoleDAO();
		String returnMassegeStr = readRoleDAO.readRole(roleDetail);
		
		setRoleDetail(roleDetail);
		
		//session.put("roleDetail", roleDetail);
		
		if (act != null && act.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			
			pageForwardStr = "SENTTOUPDATE";
			
		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			
			pageForwardStr = SUCCESS;
			
		}

		return pageForwardStr;
}

}
