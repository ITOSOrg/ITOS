package com.company.itos.core.keyserver.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.keyserver.dao.ListKeyServerDAO;
import com.company.itos.core.keyserver.pojo.KeyServerDetail;
import com.opensymphony.xwork2.ActionSupport;

public class ListKeyServerAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	
	public void setSession(Map<String, Object> session) {
		
		 this.session = session;

	}
	
	public String execute() throws Exception {
		
		KeyServerDetail keyServerDetail = new KeyServerDetail();
		
		ListKeyServerDAO listKeyServerDAO = new ListKeyServerDAO();
		List<KeyServerDetail> keyServerList = listKeyServerDAO.listKeyServer(keyServerDetail);
		
		session.put("keyServerList", keyServerList);
		
		return SUCCESS;
	}
}
