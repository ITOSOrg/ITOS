package com.company.itos.core.codetable.pojo;

import com.company.itos.core.util.resources.StringUtil;


public class CodeTableItemKey {
	
 	private String tableName;
 	
 	private String code;
 	
 	private String description;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = StringUtil.rtrim(tableName);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
 	
 	
}