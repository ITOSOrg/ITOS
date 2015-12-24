package com.company.itos.core.codetable.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.codetable.dao.ReadCodeTableHeaderDAO;
import com.company.itos.core.codetable.pojo.CodeTableHeaderDetail;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class ReadCodeTableHeaderAction extends ActionSupport implements SessionAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	private CodeTableHeaderDetail codeTableHeaderDetail;
	HttpServletRequest request;
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

		String pageForwardStr = "";
		// String action = (String) getServletRequest().getParameter("act");

		// CodeTableHeaderDetail codeTableHeaderDetail = new
		// CodeTableHeaderDetail();

		// String tableName = (String)
		// getServletRequest().getParameter("tableName");
		// codeTableHeaderDetail.setTableName(tableName);

		ReadCodeTableHeaderDAO readCodeTableHeaderDAO = new ReadCodeTableHeaderDAO();
		String returnMassegeStr = readCodeTableHeaderDAO.ReadCodeTableHeader(codeTableHeaderDetail);

		setCodeTableHeaderDetail(codeTableHeaderDetail);
		// session.put("codeTableHeaderDetail", codeTableHeaderDetail);

		if (act != null && act.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = "SENTTOUPDATE";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = SUCCESS;
		}

		return pageForwardStr;
	}
}
