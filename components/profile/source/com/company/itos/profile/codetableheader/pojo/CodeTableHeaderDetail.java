package com.company.itos.profile.codetableheader.pojo;

import java.sql.Timestamp;
import java.util.List;

import com.company.itos.profile.codeTableItem.pojo.CodeTableItemDetail;

public class CodeTableHeaderDetail {
			
			private	String tableName;
			
			private String defaultCode;
			
			private String parentCodeTable;
			
			private String comments;
			
			private String recordStatus;
			
			private int versionNo;
		 	
		 	private String createdBy;

			private String lastModifiedBy;

			private Timestamp createdOn;

			private Timestamp lastModifiedOn;
			
			List<CodeTableItemDetail> codeTableItemDetailList = null;

			public List<CodeTableItemDetail> getCodeTableItemDetailList() {
				return codeTableItemDetailList;
			}

			public void setCodeTableItemDetailList(List<CodeTableItemDetail> codeTableItemDetailList) {
				this.codeTableItemDetailList = codeTableItemDetailList;
			}

			public String getTableName() {
				return tableName;
			}

			public void setTableName(String tableName) {
				this.tableName = tableName;
			}

			public String getDefaultCode() {
				return defaultCode;
			}

			public void setDefaultCode(String defaultCode) {
				this.defaultCode = defaultCode;
			}

			public String getParentCodeTable() {
				return parentCodeTable;
			}

			public void setParentCodeTable(String parentCodeTable) {
				this.parentCodeTable = parentCodeTable;
			}

			public String getComments() {
				return comments;
			}

			public void setComments(String comments) {
				this.comments = comments;
			}

			public String getRecordStatus() {
				return recordStatus;
			}

			public void setRecordStatus(String recordStatus) {
				this.recordStatus = recordStatus;
			}

			public int getVersionNo() {
				return versionNo;
			}

			public void setVersionNo(int versionNo) {
				this.versionNo = versionNo;
			}

			public String getCreatedBy() {
				return createdBy;
			}

			public void setCreatedBy(String createdBy) {
				this.createdBy = createdBy;
			}

			public String getLastModifiedBy() {
				return lastModifiedBy;
			}

			public void setLastModifiedBy(String lastModifiedBy) {
				this.lastModifiedBy = lastModifiedBy;
			}

			public Timestamp getCreatedOn() {
				return createdOn;
			}

			public void setCreatedOn(Timestamp createdOn) {
				this.createdOn = createdOn;
			}

			public Timestamp getLastModifiedOn() {
				return lastModifiedOn;
			}

			public void setLastModifiedOn(Timestamp lastModifiedOn) {
				this.lastModifiedOn = lastModifiedOn;
			}
}
