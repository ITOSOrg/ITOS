package com.company.itos.core.codetable.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.codetable.dao.ReadCodeTableItemDAO;
import com.company.itos.core.codetable.pojo.CodeTableHeaderDetail;
import com.company.itos.core.codetable.pojo.CodeTableItemDetail;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class ReadCodeTableItemAction extends ActionSupport implements SessionAware {
	
	private Map<String,Object> session;
	HttpServletRequest request;
	private CodeTableItemDetail codeTableItemDetail;

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
		
		String pageForwardStr = "";
		String action = (String) getServletRequest().getParameter("act");
		
		CodeTableItemDetail codeTableItemDetail = new CodeTableItemDetail();
		
		String tableName = (String) getServletRequest().getParameter("tableName");
		String code = (String) getServletRequest().getParameter("code");
		
		codeTableItemDetail.setTableName(tableName);
		codeTableItemDetail.setCode(code);
		
		
		ReadCodeTableItemDAO readCodeTableItemDAO = new ReadCodeTableItemDAO();
		String returnMassegeStr = readCodeTableItemDAO.readCodeTableItem(codeTableItemDetail);
		
		setCodeTableItemDetail(codeTableItemDetail);
		session.put("codeTableItemDetail", codeTableItemDetail);
		
		if (action != null && action.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "SENTTOUPDATE";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = SUCCESS;
		}

		return pageForwardStr;
	}

}
