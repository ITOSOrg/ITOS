package com.company.itos.profile.personIdentity.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.profile.personIdentity.dao.ListPersonIdentityDAO;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;
import com.opensymphony.xwork2.ActionSupport;

public class ListPersonIdentityAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	private PersonIdentityDetail personIdentityDetail;
	private List<PersonIdentityDetail> personIdentityDetailList;
	
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
	 * @return the personIdentityDetail
	 */
	public PersonIdentityDetail getPersonIdentityDetail() {
		return personIdentityDetail;
	}

	/**
	 * @param personIdentityDetail the personIdentityDetail to set
	 */
	public void setPersonIdentityDetail(PersonIdentityDetail personIdentityDetail) {
		this.personIdentityDetail = personIdentityDetail;
	}
	
/**
	 * @return the personIdentityDetailList
	 */
	public List<PersonIdentityDetail> getPersonIdentityDetailList() {
		return personIdentityDetailList;
	}

	/**
	 * @param personIdentityDetailList the personIdentityDetailList to set
	 */
	public void setPersonIdentityDetailList(List<PersonIdentityDetail> personIdentityDetailList) {
		this.personIdentityDetailList = personIdentityDetailList;
	}

public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		ListPersonIdentityDAO listPersonIdentityDAO = new ListPersonIdentityDAO();
		List<PersonIdentityDetail> personIdentityDetailList = listPersonIdentityDAO.personIdentityList(personIdentityDetail);
		
		setPersonIdentityDetailList(personIdentityDetailList);
		
		if (personIdentityDetailList != null) {
			pageForwardStr = SUCCESS;

		} else {
			
			pageForwardStr = ERROR;

		}
		return pageForwardStr;
}
}
