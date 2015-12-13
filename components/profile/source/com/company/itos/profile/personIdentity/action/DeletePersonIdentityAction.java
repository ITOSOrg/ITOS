package com.company.itos.profile.personIdentity.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.personIdentity.dao.DeletePersonIdentityDAO;
import com.company.itos.profile.personIdentity.dao.UpdatePersonIdentityDAO;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePersonIdentityAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	private PersonIdentityDetail personIdentityDetail;
	
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
	
	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		DeletePersonIdentityDAO deletePersonIdentityDAO = new DeletePersonIdentityDAO();
		String returnMassegeStr = deletePersonIdentityDAO.DeletePersonIdentity(personIdentityDetail);
		
		 if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
				

				pageForwardStr = SUCCESS;

			} else {
				
				pageForwardStr = ERROR;

			}
			return pageForwardStr;

}


}
