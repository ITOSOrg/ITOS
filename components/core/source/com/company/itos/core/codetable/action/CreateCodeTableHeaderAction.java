package com.company.itos.core.codetable.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.codetable.dao.CreateCodeTableHeaderDAO;
import com.company.itos.core.codetable.dao.ListCodeTableHeaderDAO;
import com.company.itos.core.codetable.pojo.CodeTableHeaderDetail;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class CreateCodeTableHeaderAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	
	private Map<String,Object> session;
	private CodeTableHeaderDetail codeTableHeaderDetail;
	
	public void setSession(Map<String, Object> session) {
		
		this.session = session;
		
	}
	
	/**
	 * @return the codeTableHeaderDetail
	 */
	public CodeTableHeaderDetail getCodeTableHeaderDetail() {
		return codeTableHeaderDetail;
	}

	/**
	 * @param codeTableHeaderDetail the codeTableHeaderDetail to set
	 */
	public void setCodeTableHeaderDetail(CodeTableHeaderDetail codeTableHeaderDetail) {
		this.codeTableHeaderDetail = codeTableHeaderDetail;
	}

	public String execute() throws Exception {
		
		//CodeTableHeaderDetail codeTableHeaderDetail = new CodeTableHeaderDetail();
		
		CreateCodeTableHeaderDAO createCodeTableHeaderDAO = new CreateCodeTableHeaderDAO();
		String returnMassegeStr = createCodeTableHeaderDAO.CreateCodeTableHeader(codeTableHeaderDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			return SUCCESS;

		} else {
			
			return ERROR;
		
		}

	}
}
