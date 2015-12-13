package com.company.itos.profile.email.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.email.dao.DeleteEmailAddressDAO;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteEmailAddressAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	private EmailAddressLinkDetail emailAddressLinkDetail;
	
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
	 * @return the emailAddressLinkDetail
	 */
	public EmailAddressLinkDetail getEmailAddressLinkDetail() {
		return emailAddressLinkDetail;
	}

	/**
	 * @param emailAddressLinkDetail the emailAddressLinkDetail to set
	 */
	public void setEmailAddressLinkDetail(EmailAddressLinkDetail emailAddressLinkDetail) {
		this.emailAddressLinkDetail = emailAddressLinkDetail;
	}

	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		DeleteEmailAddressDAO deleteEmailAddressDAO = new DeleteEmailAddressDAO();
		String returnMassegeStr = deleteEmailAddressDAO.deleteEmailAddress(emailAddressLinkDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			

			pageForwardStr = SUCCESS;

		} else {
			
			pageForwardStr = ERROR;

		}
		return pageForwardStr;
	}
		
	}


