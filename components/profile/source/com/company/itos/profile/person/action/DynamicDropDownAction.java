package com.company.itos.profile.person.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.codetable.dao.ReadCodeTableItemDAO;
import com.company.itos.core.codetable.pojo.CodeTableItemDetail;
import com.company.itos.profile.person.pojo.PersonDetail;
import com.opensymphony.xwork2.ActionSupport;

public class DynamicDropDownAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	private CodeTableItemDetail codeTableItemDetailkey;

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
	 * @return the codeTableItemDetailkey
	 */
	public CodeTableItemDetail getCodeTableItemDetailkey() {
		return codeTableItemDetailkey;
	}

	/**
	 * @param codeTableItemDetailkey the codeTableItemDetailkey to set
	 */
	public void setCodeTableItemDetailkey(CodeTableItemDetail codeTableItemDetailkey) {
		this.codeTableItemDetailkey = codeTableItemDetailkey;
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
		
		ReadCodeTableItemDAO readCodeTableItemDAO = new ReadCodeTableItemDAO();
		List<CodeTableItemDetail> codeTableItemList = readCodeTableItemDAO.litCodeTableItem(codeTableItemDetailkey);
		
		return pageForwardStr = SUCCESS;
	}
}
