package com.company.itos.core.keyserver.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.itos.core.keyserver.dao.CreateKeyServerDAO;
import com.company.itos.core.keyserver.pojo.KeyServerDetail;
import com.company.itos.core.util.CRUDConstants;
import com.opensymphony.xwork2.ActionSupport;

public class CreateKeyServerAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	
	private Map<String,Object> session;
	private KeyServerDetail keyServerDetail;
	
	/**
	 * @return the keyServerDetail
	 */
	public KeyServerDetail getKeyServerDetail() {
		return keyServerDetail;
	}

	/**
	 * @param keyServerDetail the keyServerDetail to set
	 */
	public void setKeyServerDetail(KeyServerDetail keyServerDetail) {
		this.keyServerDetail = keyServerDetail;
	}

	public void setSession(Map<String, Object> session) {
		
		this.session = session;
		
	}
	
	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		CreateKeyServerDAO createKeyServerDAO = new CreateKeyServerDAO();
		String returnMassegeStr = createKeyServerDAO.CreateKeyServer(keyServerDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;
			//pageForwardStr += "?tableName=" + codeTableItemDetail.getTableName();

		} else {
			pageForwardStr = ERROR;
		}

		return pageForwardStr;
		
	}

}
