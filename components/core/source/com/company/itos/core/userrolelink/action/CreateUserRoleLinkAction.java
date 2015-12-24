package com.company.itos.core.userrolelink.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.role.dao.CreateRoleDAO;
import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.userrolelink.dao.CreateUserRoleLinkDAO;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserRoleLinkAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private UserRoleLinkDetail userRoleLinkDetail;
	private Map<String, Object> session;

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

	public String execute() throws Exception {

		String pageForwardStr = "";

		CreateUserRoleLinkDAO createUserRoleLinkDAO = new CreateUserRoleLinkDAO();
		String returnMassegeStr = createUserRoleLinkDAO.CreateUserRoleLink(userRoleLinkDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}

		return pageForwardStr;
	}
}
