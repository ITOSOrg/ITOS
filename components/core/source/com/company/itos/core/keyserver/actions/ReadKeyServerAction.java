package com.company.itos.core.keyserver.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.keyserver.dao.ReadKeyServerDAO;
import com.company.itos.core.keyserver.pojo.KeyServerDetail;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class ReadKeyServerAction extends ActionSupport implements SessionAware, ServletRequestAware {

	HttpServletRequest request;
	private KeyServerDetail keyServerDetail;
	private Map<String, Object> session;
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

	/**
	 * @return the keyServerDetail
	 */
	public KeyServerDetail getKeyServerDetail() {
		return keyServerDetail;
	}

	/**
	 * @param keyServerDetail
	 *            the keyServerDetail to set
	 */
	public void setKeyServerDetail(KeyServerDetail keyServerDetail) {
		this.keyServerDetail = keyServerDetail;
	}

	public void setSession(Map<String, Object> session) {

		this.session = session;

	}

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

	public String execute() throws Exception {

		String pageForwardStr = "";
		// String action = (String) getServletRequest().getParameter("act");
		// KeyServerDetail keyServerDetail = new KeyServerDetail();

		// String keysetCode = (String)
		// getServletRequest().getParameter("keysetCode");
		// keyServerDetail.setKeysetCode(keysetCode);

		ReadKeyServerDAO readKeyServerDAO = new ReadKeyServerDAO();
		String returnMassegeStr = readKeyServerDAO.ReadKeyServer(keyServerDetail);
		setKeyServerDetail(keyServerDetail);

		// request.setAttribute("keysetCode", keysetCode);
		// session.put("keyServerDetail", keyServerDetail);

		if (act != null && act.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = "SENTTOUPDATE";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		}

		return pageForwardStr;
	}

}
