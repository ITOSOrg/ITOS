package com.company.itos.core.userrolelink.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.userrolelink.dao.CreateUserRoleLinkDAO;
import com.company.itos.core.userrolelink.dao.ListUserRoleLinkDAO;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class ListUserRoleLinkAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private UserRoleLinkDetail userRoleLinkDetail;
	private Map<String, Object> session;
	private List<UserRoleLinkDetail> userRoleLinklist;

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

	public void setSession(Map<String, Object> session) {

		this.session = session;

	}

	/**
	 * @return the userRoleLinklist
	 */
	public List<UserRoleLinkDetail> getUserRoleLinklist() {
		return userRoleLinklist;
	}

	/**
	 * @param userRoleLinklist
	 *            the userRoleLinklist to set
	 */
	public void setUserRoleLinklist(List<UserRoleLinkDetail> userRoleLinklist) {
		this.userRoleLinklist = userRoleLinklist;
	}

	public String execute() throws Exception {

		String pageForwardStr = "";

		ListUserRoleLinkDAO listUserRoleLinkDAO = new ListUserRoleLinkDAO();
		List<UserRoleLinkDetail> userRoleLinklist = listUserRoleLinkDAO.listUserRoleLink(userRoleLinkDetail);
		setUserRoleLinklist(userRoleLinklist);

		if (userRoleLinklist != null) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}

		return pageForwardStr;
	}

}
