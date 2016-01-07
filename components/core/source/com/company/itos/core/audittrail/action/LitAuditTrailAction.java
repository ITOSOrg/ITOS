package com.company.itos.core.audittrail.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.dao.LitAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class LitAuditTrailAction extends ActionSupport implements SessionAware {

	List<AuditTrailDetails> auditTrailDetailList ;
	
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;

	/**
	 * @return the auditTrailDetailList
	 */
	public List<AuditTrailDetails> getAuditTrailDetailList() {
		return auditTrailDetailList;
	}

	/**
	 * @param auditTrailDetailList the auditTrailDetailList to set
	 */
	public void setAuditTrailDetailList(List<AuditTrailDetails> auditTrailDetailList) {
		this.auditTrailDetailList = auditTrailDetailList;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String execute() throws Exception {

		String pageForwardStr = "";
		AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
		
		LitAuditTrailDAO litAuditTrailDAO = new LitAuditTrailDAO();
		List<AuditTrailDetails> auditTrailDetailList = litAuditTrailDAO.litAuditTrail(auditTrailDetails);
		setAuditTrailDetailList(auditTrailDetailList);
		
		
		return SUCCESS;
	}
		


}
