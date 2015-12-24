package com.company.itos.profile.person.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.profile.person.pojo.UsersDetail;
import com.opensymphony.xwork2.ActionSupport;

public class PersonLogOutAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	private Map<String, Object> session;

	public void setSession(Map<String, Object> sessionInput) {

		this.session = sessionInput;

	}

	public String execute() throws Exception {

		return SUCCESS;

	}

}
