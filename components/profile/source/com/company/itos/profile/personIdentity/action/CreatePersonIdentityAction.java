package com.company.itos.profile.personIdentity.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.address.pojo.AddressLinkDetail;
import com.company.itos.profile.personIdentity.dao.CreatePersonIdentityDAO;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;
import com.opensymphony.xwork2.ActionSupport;

public class CreatePersonIdentityAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	private PersonIdentityDetail personIdentityDetail;

	public void setSession(Map<String, Object> sessionInput) {
		this.session = sessionInput;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getServletRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @return the personIdentityDetail
	 */
	public PersonIdentityDetail getPersonIdentityDetail() {
		return personIdentityDetail;
	}

	/**
	 * @param personIdentityDetail
	 *            the personIdentityDetail to set
	 */
	public void setPersonIdentityDetail(PersonIdentityDetail personIdentityDetail) {
		this.personIdentityDetail = personIdentityDetail;
	}

	public String execute() throws Exception {

		String pageForwardStr = "";

		CreatePersonIdentityDAO createPersonIdentityDAO = new CreatePersonIdentityDAO();
		String returnMassegeStr = createPersonIdentityDAO.CreatePersonIdentity(personIdentityDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}
		return pageForwardStr;

	}
}
