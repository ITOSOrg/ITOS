package com.company.itos.profile.address.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.address.dao.ListAddressDAO;
import com.company.itos.profile.address.pojo.AddressLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

public class ListAddressAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	private AddressLinkDetail addressLinkDetail;
	private List<AddressLinkDetail> addressLinkDetailList;

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
	 * @param addressLinkDetail
	 *            the addressLinkDetail to set
	 */
	public void setAddressLinkDetail(AddressLinkDetail addressLinkDetail) {
		this.addressLinkDetail = addressLinkDetail;
	}

	/**
	 * @return the addressLinkDetailList
	 */
	public List<AddressLinkDetail> getAddressLinkDetailList() {
		return addressLinkDetailList;
	}

	/**
	 * @param addressLinkDetailList
	 *            the addressLinkDetailList to set
	 */
	public void setAddressLinkDetailList(List<AddressLinkDetail> addressLinkDetailList) {
		this.addressLinkDetailList = addressLinkDetailList;
	}

	public String execute() throws Exception {

		String pageForwardStr = "";

		ListAddressDAO listAddressDAO = new ListAddressDAO();
		List<AddressLinkDetail> addressLinkDetailList = listAddressDAO.ListAllAddress(addressLinkDetail);

		setAddressLinkDetailList(addressLinkDetailList);

		// session.put("addressLinkDetailList", addressLinkDetailList);

		if (addressLinkDetailList != null) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}
		return pageForwardStr;

	}

}
