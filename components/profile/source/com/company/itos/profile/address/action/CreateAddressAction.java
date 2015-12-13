package com.company.itos.profile.address.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.address.dao.CreateAddressDAO;
import com.company.itos.profile.address.pojo.AddressLinkDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

public class CreateAddressAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	private AddressLinkDetail addressLinkDetail;
	
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
		
		CreateAddressDAO createAddressDAO = new CreateAddressDAO();
		 String returnMassegeStr = createAddressDAO.createAddress(addressLinkDetail);
		 
		 session.put("addressLinkDetail", addressLinkDetail);
		 
		 if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
				

				pageForwardStr = SUCCESS;

			} else {
				
				pageForwardStr = ERROR;

			}
			return pageForwardStr;
	}

}
