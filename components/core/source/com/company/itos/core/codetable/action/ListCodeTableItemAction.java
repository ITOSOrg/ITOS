package com.company.itos.core.codetable.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.codetable.dao.ListCodeTableItemDAO;
import com.company.itos.core.codetable.pojo.CodeTableHeaderDetail;
import com.company.itos.core.codetable.pojo.CodeTableItemDetail;
import com.opensymphony.xwork2.ActionSupport;

public class ListCodeTableItemAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	
	private Map<String,Object> session;
	
	public void setSession(Map<String, Object> session) {
		
		this.session = session;

	}
	
	public String execute() throws Exception {
		
		//CodeTableHeaderDetail codeTableHeaderDetail = new CodeTableHeaderDetail();
		CodeTableItemDetail codeTableItemDetail = new CodeTableItemDetail();
	
	ListCodeTableItemDAO listCodeTableItemDAO = new ListCodeTableItemDAO();
	List<CodeTableItemDetail> codeTableItemDetailList = listCodeTableItemDAO.listCodeTableItem(codeTableItemDetail);
	
	//codeTableHeaderDetail.setCodeTableItemDetailList(codeTableItemDetailList);
	
	session.put("codeTableItemDetailList", codeTableItemDetailList);


	return SUCCESS;
}

}
