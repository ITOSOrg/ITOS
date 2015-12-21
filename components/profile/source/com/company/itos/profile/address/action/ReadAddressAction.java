package com.company.itos.profile.address.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.address.dao.ReadAddressDAO;
import com.company.itos.profile.address.pojo.AddressLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

public class ReadAddressAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	private AddressLinkDetail addressLinkDetail;
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
	 * @return the addressLinkDetail
	 */
	public AddressLinkDetail getAddressLinkDetail() {
		return addressLinkDetail;
	}

	/**
	 * @param addressLinkDetail the addressLinkDetail to set
	 */
	public void setAddressLinkDetail(AddressLinkDetail addressLinkDetail) {
		this.addressLinkDetail = addressLinkDetail;
	}

	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		ReadAddressDAO readAddressDAO = new ReadAddressDAO();

		String returnMassegeStr = readAddressDAO.readAddress(addressLinkDetail);
		
		//session.put("addressLinkDetail", addressLinkDetail);
		
		if (act != null && act.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "SENTTOUPDATE";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = SUCCESS;
		}

		return pageForwardStr;
		
	}

}
