package com.company.itos.profile.person.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.person.dao.SearchPersonDAO;
import com.company.itos.profile.person.pojo.PersonDetail;
import com.company.itos.profile.person.pojo.PersonSearchDetails;
import com.opensymphony.xwork2.ActionSupport;

public class SearchPersonAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	private PersonSearchDetails personSearchDetails;
	private List<PersonDetail> personDetailList;

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
	 * @return the personSearchDetails
	 */
	public PersonSearchDetails getPersonSearchDetails() {
		return personSearchDetails;
	}

	/**
	 * @param personSearchDetails
	 *            the personSearchDetails to set
	 */
	public void setPersonSearchDetails(PersonSearchDetails personSearchDetails) {
		this.personSearchDetails = personSearchDetails;
	}

	/**
	 * @return the personDetailList
	 */
	public List<PersonDetail> getPersonDetailList() {
		return personDetailList;
	}

	/**
	 * @param personDetailList
	 *            the personDetailList to set
	 */
	public void setPersonDetailList(List<PersonDetail> personDetailList) {
		this.personDetailList = personDetailList;
	}

	public String execute() throws Exception {

		String pageForwardStr = "";

		SearchPersonDAO searchPersonDAO = new SearchPersonDAO();

		List<PersonDetail> personDetailList = searchPersonDAO.searchPersonInfo(personSearchDetails);
		setPersonDetailList(personDetailList);

		if (personDetailList != null) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}
		return pageForwardStr;
	}

}
