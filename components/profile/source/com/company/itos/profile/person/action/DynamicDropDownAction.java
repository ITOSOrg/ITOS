package com.company.itos.profile.person.action;

import java.util.HashMap;
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
	HashMap<String, String> genderMap;
	HashMap<String, String> stateMap;
	
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
	 * @param codeTableItemDetailkey
	 *            the codeTableItemDetailkey to set
	 */
	public void setCodeTableItemDetailkey(CodeTableItemDetail codeTableItemDetailkey) {
		this.codeTableItemDetailkey = codeTableItemDetailkey;
	}

	/**
	 * @return the genderMap
	 */
	public HashMap<String, String> getGenderMap() {
		return genderMap;
	}

	/**
	 * @param genderMap the genderMap to set
	 */
	public void setGenderMap(HashMap<String, String> genderMap) {
		this.genderMap = genderMap;
	}

	/**
	 * @return the stateMap
	 */
	public HashMap<String, String> getStateMap() {
		return stateMap;
	}

	/**
	 * @param stateMap the stateMap to set
	 */
	public void setStateMap(HashMap<String, String> stateMap) {
		this.stateMap = stateMap;
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
		genderMap = readCodeTableItemDAO.litGender();
		stateMap = readCodeTableItemDAO.litState();

		return pageForwardStr = SUCCESS;
	}
}
