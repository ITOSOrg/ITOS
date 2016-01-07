package com.company.itos.core.audittrail.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.dao.UpdateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAuditTrailAction extends ActionSupport implements SessionAware {

	public AuditTrailDetails auditTrailDetails;
	
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;



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
		CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
		
		UpdateAuditTrailDAO updateAuditTrailDAO = new UpdateAuditTrailDAO();
		String returnMassegeStr = updateAuditTrailDAO.updateAuditTrail(auditTrailDetails);
		
		if(returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS)
		{
			pageForwardStr = SUCCESS;
		}else{
			pageForwardStr = ERROR;
		}
		
		return pageForwardStr;
	}
		


}
