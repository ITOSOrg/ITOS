package com.company.itos.core.audittrail.pojo;

import java.sql.Timestamp;

public class AuditTrailDetails {
		
		private long auditTrailID;
		
		private long relatedID;
		
		private String tableName;
		
		private String operationType;
		
		private String userName;
		
		private Timestamp timeEntered;
		
		private String updateAction = "update";
		
		/**
		 * @return the updateAction
		 */
		public String getUpdateAction() {
			return updateAction;
		}

		/**
		 * @param updateAction the updateAction to set
		 */
		public void setUpdateAction(String updateAction) {
			this.updateAction = "update";
		}

		
		/**
		 * @return the auditTrailID
		 */
		public long getAuditTrailID() {
			return auditTrailID;
		}

		/**
		 * @param auditTrailID the auditTrailID to set
		 */
		public void setAuditTrailID(long auditTrailID) {
			this.auditTrailID = auditTrailID;
		}

		/**
		 * @return the relatedID
		 */
		public long getRelatedID() {
			return relatedID;
		}

		/**
		 * @param relatedID the relatedID to set
		 */
		public void setRelatedID(long relatedID) {
			this.relatedID = relatedID;
		}

		/**
		 * @return the tableName
		 */
		public String getTableName() {
			return tableName;
		}

		/**
		 * @param tableName the tableName to set
		 */
		public void setTableName(String tableName) {
			this.tableName = tableName;
		}

		/**
		 * @return the operationType
		 */
		public String getOperationType() {
			return operationType;
		}

		/**
		 * @param operationType the operationType to set
		 */
		public void setOperationType(String operationType) {
			this.operationType = operationType;
		}

		/**
		 * @return the userName
		 */
		public String getUserName() {
			return userName;
		}

		/**
		 * @param userName the userName to set
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}

		/**
		 * @return the timeEntered
		 */
		public Timestamp getTimeEntered() {
			return timeEntered;
		}

		/**
		 * @param timeEntered the timeEntered to set
		 */
		public void setTimeEntered(Timestamp timeEntered) {
			this.timeEntered = timeEntered;
		}

		
}
