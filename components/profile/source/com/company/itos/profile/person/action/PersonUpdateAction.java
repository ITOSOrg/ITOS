package com.company.itos.profile.person.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.person.dao.PersonUpdateDAO;
import com.company.itos.profile.person.pojo.PersonDetail;
import com.opensymphony.xwork2.ActionSupport;

public class PersonUpdateAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	private PersonDetail personDetail;
	
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
	 * @return the personDetail
	 */
	public PersonDetail getPersonDetail() {
		return personDetail;
	}

	/**
	 * @param personDetail the personDetail to set
	 */
	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}

	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		int personID = new Integer((String) getServletRequest().getParameter("personID")).intValue();
		personDetail.setPersonID(personID);
		
		PersonUpdateDAO personUpdateDAO = new PersonUpdateDAO();
		String returnMassegeStr = personUpdateDAO.updatePerson(personDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			
			pageForwardStr = SUCCESS;
			
		}else{
			pageForwardStr = ERROR;
		}
		return pageForwardStr;
	}

}
