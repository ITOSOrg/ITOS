package com.company.itos.core.codetable.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.codetable.dao.CreateCodeTableItemDAO;
import com.company.itos.core.codetable.pojo.CodeTableItemDetail;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class CreateCodeTableItemAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	private CodeTableItemDetail codeTableItemDetail;
	
	/**
	 * @return the codeTableItemDetail
	 */
	public CodeTableItemDetail getCodeTableItemDetail() {
		return codeTableItemDetail;
	}

	/**
	 * @param codeTableItemDetail the codeTableItemDetail to set
	 */
	public void setCodeTableItemDetail(CodeTableItemDetail codeTableItemDetail) {
		this.codeTableItemDetail = codeTableItemDetail;
	}

	private Map<String,Object> session;

	public void setSession(Map<String, Object> session) {
		
		this.session = session;

	}
	
	public String execute() throws Exception {
		
	
	CreateCodeTableItemDAO createCodeTableItemDAO = new CreateCodeTableItemDAO();
	String returnMassegeStr = createCodeTableItemDAO.createCreateCodeTableItem(codeTableItemDetail);
	
	if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

		return SUCCESS;

	} else {
		
		return ERROR;
	
	}

}
	

}
