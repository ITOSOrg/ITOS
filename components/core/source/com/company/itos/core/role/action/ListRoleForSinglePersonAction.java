package com.company.itos.core.role.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.role.dao.ListRoleForSinglePersonDAO;
import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

public class ListRoleForSinglePersonAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	private UserRoleLinkDetail userRoleLinkDetail;
	private List<RoleDetail> singlePersonRolelist;

	public void setSession(Map<String, Object> session) {

		this.session = session;

	}

	/**
	 * @return the userRoleLinkDetail
	 */
	public UserRoleLinkDetail getUserRoleLinkDetail() {
		return userRoleLinkDetail;
	}

	/**
	 * @param userRoleLinkDetail
	 *            the userRoleLinkDetail to set
	 */
	public void setUserRoleLinkDetail(UserRoleLinkDetail userRoleLinkDetail) {
		this.userRoleLinkDetail = userRoleLinkDetail;
	}

	/**
	 * @return the singlePersonRolelist
	 */
	public List<RoleDetail> getSinglePersonRolelist() {
		return singlePersonRolelist;
	}

	/**
	 * @param singlePersonRolelist
	 *            the singlePersonRolelist to set
	 */
	public void setSinglePersonRolelist(List<RoleDetail> singlePersonRolelist) {
		this.singlePersonRolelist = singlePersonRolelist;
	}

	public String execute() throws Exception {

		ListRoleForSinglePersonDAO listRoleForSinglePersonDAO = new ListRoleForSinglePersonDAO();
		List<RoleDetail> singlePersonRolelist = listRoleForSinglePersonDAO.listRoleForSinglePerson(userRoleLinkDetail);
		setSinglePersonRolelist(singlePersonRolelist);

		if (singlePersonRolelist != null) {

			return SUCCESS;

		} else {

			return ERROR;
		}

	}

}
