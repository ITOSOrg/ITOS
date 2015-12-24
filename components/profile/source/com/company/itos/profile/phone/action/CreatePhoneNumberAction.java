package com.company.itos.profile.phone.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.personIdentity.dao.CreatePersonIdentityDAO;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;
import com.company.itos.profile.phone.dao.CreatePhoneNumberDAO;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

public class CreatePhoneNumberAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	private PhoneNumberLinkDetail phoneNumberLinkDetail;

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
	 * @return the phoneNumberLinkDetail
	 */
	public PhoneNumberLinkDetail getPhoneNumberLinkDetail() {
		return phoneNumberLinkDetail;
	}

	/**
	 * @param phoneNumberLinkDetail
	 *            the phoneNumberLinkDetail to set
	 */
	public void setPhoneNumberLinkDetail(PhoneNumberLinkDetail phoneNumberLinkDetail) {
		this.phoneNumberLinkDetail = phoneNumberLinkDetail;
	}

	public String execute() throws Exception {

		String pageForwardStr = "";

		CreatePhoneNumberDAO createPhoneNumberDAO = new CreatePhoneNumberDAO();
		String returnMassegeStr = createPhoneNumberDAO.createPhoneNumber(phoneNumberLinkDetail);
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}
		return pageForwardStr;

	}

}
