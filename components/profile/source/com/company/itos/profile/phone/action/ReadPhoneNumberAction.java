package com.company.itos.profile.phone.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.phone.dao.ListPhoneNumberDAO;
import com.company.itos.profile.phone.dao.ReadPhoneNumberDAO;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

public class ReadPhoneNumberAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	private PhoneNumberLinkDetail phoneNumberLinkDetail;
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

		ReadPhoneNumberDAO readPhoneNumberDAO = new ReadPhoneNumberDAO();
		String returnMassegeStr = readPhoneNumberDAO.readPhoneNumber(phoneNumberLinkDetail);
		
		setPhoneNumberLinkDetail(phoneNumberLinkDetail);

		if (act != null && act.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = "SENTTOUPDATE";

		} else {
			pageForwardStr = SUCCESS;
		}

		return pageForwardStr;

	}

}
