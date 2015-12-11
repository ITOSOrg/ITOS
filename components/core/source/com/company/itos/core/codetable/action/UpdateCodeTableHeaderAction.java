package com.company.itos.core.codetable.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.codetable.dao.UpdateCodeTableHeaderDAO;
import com.company.itos.core.codetable.pojo.CodeTableHeaderDetail;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateCodeTableHeaderAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	private CodeTableHeaderDetail codeTableHeaderDetail;
	HttpServletRequest request;

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
	 * @param codeTableHeaderDetail
	 *            the codeTableHeaderDetail to set
	 */
	public void setCodeTableHeaderDetail(CodeTableHeaderDetail codeTableHeaderDetail) {
		this.codeTableHeaderDetail = codeTableHeaderDetail;
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

		UpdateCodeTableHeaderDAO updateCodeTableHeaderDAO = new UpdateCodeTableHeaderDAO();
		String returnMassegeStr = updateCodeTableHeaderDAO.updateCodeTableHeader(codeTableHeaderDetail);

		// session.put("codeTableHeaderDetail", codeTableHeaderDetail);
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			return SUCCESS;

		} else {

			return ERROR;

		}
	}
}
