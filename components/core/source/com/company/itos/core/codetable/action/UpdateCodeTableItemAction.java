package com.company.itos.core.codetable.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.codetable.dao.UpdateCodeTableItemDAO;
import com.company.itos.core.codetable.pojo.CodeTableHeaderDetail;
import com.company.itos.core.codetable.pojo.CodeTableItemDetail;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateCodeTableItemAction extends ActionSupport implements SessionAware {
	
	private Map<String,Object> session;
	private CodeTableItemDetail codeTableItemDetail;
	HttpServletRequest request;
	
	public void setSession(Map<String, Object> session) {
		
		this.session = session;
		
	}

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
		
		UpdateCodeTableItemDAO updateCodeTableItemDAO = new UpdateCodeTableItemDAO();
		String returnMassegeStr = updateCodeTableItemDAO.UpdateCodeTableItem(codeTableItemDetail);
		
		setCodeTableItemDetail(codeTableItemDetail);
		//setCodeTableItemDetail(codeTableItemDetail);
		
		//session.put("codeTableItemDetail", codeTableItemDetail);
		if(returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS){
			
			return SUCCESS;
			
		}else{
			
			return ERROR;
			
		}
	}

}
