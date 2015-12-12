package com.company.itos.profile.person.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.person.dao.PersonHomeDAO;
import com.company.itos.profile.person.pojo.PersonDetail;
import com.opensymphony.xwork2.ActionSupport;

public class PersonHomeAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	private PersonDetail personDetail;
	
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
	
	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		//int personID = new Integer((String) getServletRequest().getParameter("personID")).intValue();
		//personDetail.setPersonID(personID);
		
		PersonHomeDAO personHomeDAO = new PersonHomeDAO();
		String returnMassegeStr =	personHomeDAO.readPersonDetail(personDetail);
		
	
		session.put("personDetail", personDetail);
		//session.put("personID", personID);
		if (returnMassegeStr==CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {
			
			pageForwardStr = ERROR;

		}
		return pageForwardStr;
	}

}
