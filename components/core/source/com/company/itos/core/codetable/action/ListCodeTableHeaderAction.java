package com.company.itos.core.codetable.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.codetable.dao.ListCodeTableHeaderDAO;
import com.company.itos.core.codetable.pojo.CodeTableHeaderDetail;
import com.opensymphony.xwork2.ActionSupport;

public class ListCodeTableHeaderAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	private List<CodeTableHeaderDetail> codeTableHeaderList;

	public void setSession(Map<String, Object> session) {

		this.session = session;

	}

	/**
	 * @return the codeTableHeaderList
	 */
	public List<CodeTableHeaderDetail> getCodeTableHeaderList() {
		return codeTableHeaderList;
	}

	/**
	 * @param codeTableHeaderList
	 *            the codeTableHeaderList to set
	 */
	public void setCodeTableHeaderList(List<CodeTableHeaderDetail> codeTableHeaderList) {
		this.codeTableHeaderList = codeTableHeaderList;
	}

	public String execute() throws Exception {

		CodeTableHeaderDetail codeTableHeaderDetail = new CodeTableHeaderDetail();

		ListCodeTableHeaderDAO listCodeTableHeaderDAO = new ListCodeTableHeaderDAO();
		List<CodeTableHeaderDetail> codeTableHeaderList = listCodeTableHeaderDAO.listAllCodeTableHeader(codeTableHeaderDetail);
		setCodeTableHeaderList(codeTableHeaderList);

		// session.put("codeTableHeaderList", codeTableHeaderList);

		return SUCCESS;
	}

}
