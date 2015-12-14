package com.company.itos.core.keyserver.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.keyserver.dao.UpdateKeyServerDAO;
import com.company.itos.core.keyserver.pojo.KeyServerDetail;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateKeyServerAction extends ActionSupport implements SessionAware, ServletRequestAware {

	private Map<String,Object> session;
	private KeyServerDetail keyServerDetail;
	HttpServletRequest request;
	
	/**
	 * @return the keyServerDetail
	 */
	public KeyServerDetail getKeyServerDetail() {
		return keyServerDetail;
	}

	/**
	 * @param keyServerDetail the keyServerDetail to set
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
	 * @param request the request to set
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String execute() throws Exception {
		
		//KeyServerDetail keyServerDetail = new KeyServerDetail();
		
		UpdateKeyServerDAO updateKeyServerDAO = new UpdateKeyServerDAO();
		String returnMassegeStr = updateKeyServerDAO.UpdateKeyServer(keyServerDetail);
		
		//session.put("keyServerDetail", keyServerDetail);
		
		return SUCCESS;
		
	}
		

}
