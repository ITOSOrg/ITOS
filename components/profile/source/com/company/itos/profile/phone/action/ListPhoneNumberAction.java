package com.company.itos.profile.phone.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.phone.dao.CreatePhoneNumberDAO;
import com.company.itos.profile.phone.dao.ListPhoneNumberDAO;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

public class ListPhoneNumberAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	private PhoneNumberLinkDetail phoneNumberLinkDetail;
	private List<PhoneNumberLinkDetail> phoneNumberLinkDetailList;
	
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
	 * @param phoneNumberLinkDetail the phoneNumberLinkDetail to set
	 */
	public void setPhoneNumberLinkDetail(PhoneNumberLinkDetail phoneNumberLinkDetail) {
		this.phoneNumberLinkDetail = phoneNumberLinkDetail;
	}

	/**
	 * @return the phoneNumberLinkDetailList
	 */
	public List<PhoneNumberLinkDetail> getPhoneNumberLinkDetailList() {
		return phoneNumberLinkDetailList;
	}

	/**
	 * @param phoneNumberLinkDetailList the phoneNumberLinkDetailList to set
	 */
	public void setPhoneNumberLinkDetailList(List<PhoneNumberLinkDetail> phoneNumberLinkDetailList) {
		this.phoneNumberLinkDetailList = phoneNumberLinkDetailList;
	}

	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		ListPhoneNumberDAO listPhoneNumberDAO = new ListPhoneNumberDAO();
		List<PhoneNumberLinkDetail> phoneNumberLinkDetailList = listPhoneNumberDAO.listAllPhoneNumber(phoneNumberLinkDetail);
		
		setPhoneNumberLinkDetailList(phoneNumberLinkDetailList);
		
		 if (phoneNumberLinkDetailList != null) {
				

				pageForwardStr = SUCCESS;

			} else {
				
				pageForwardStr = ERROR;

			}
			return pageForwardStr;

}


}
