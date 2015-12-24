package com.company.itos.profile.personIdentity.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.personIdentity.dao.ReadPersonIdentityDAO;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;
import com.opensymphony.xwork2.ActionSupport;

public class ReadPersonIdentityAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	private PersonIdentityDetail personIdentityDetail;
	String act = "";

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

		ReadPersonIdentityDAO readPersonIdentityDAO = new ReadPersonIdentityDAO();
		String returnMassegeStr = readPersonIdentityDAO.readPersonIdentity(personIdentityDetail);

		setPersonIdentityDetail(personIdentityDetail);

		if (act != null && act.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "SENTTOUPDATE";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = SUCCESS;
		}

		return pageForwardStr;
	}
}