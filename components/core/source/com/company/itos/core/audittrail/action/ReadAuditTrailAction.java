package com.company.itos.core.audittrail.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.dao.ReadAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class ReadAuditTrailAction extends ActionSupport implements SessionAware {

	public AuditTrailDetails auditTrailDetails;
	
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	
	String act = "";

	/**
	 * @return the act
	 */
	public String getAct() {
		return act;
	}

	/**
	 * @param act
	 *            the act to set
	 */
	public void setAct(String act) {
		this.act = act;
	}



/**
 * @return the auditTrailDetails
 */
public AuditTrailDetails getAuditTrailDetails() {
	return auditTrailDetails;
}

/**
 * @param auditTrailDetails the auditTrailDetails to set
 */
public void setAuditTrailDetails(AuditTrailDetails auditTrailDetails) {
	this.auditTrailDetails = auditTrailDetails;
}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String execute() throws Exception {

		String pageForwardStr = "";
		ReadAuditTrailDAO readAuditTrailDAO = new ReadAuditTrailDAO();
		String returnMassegeStr = readAuditTrailDAO.readAuditTrail(auditTrailDetails);
		setAuditTrailDetails(auditTrailDetails);
		
		if (act != null && act.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "SENTTOUPDATE";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = SUCCESS;
		}
		
		return pageForwardStr;
	}

}
