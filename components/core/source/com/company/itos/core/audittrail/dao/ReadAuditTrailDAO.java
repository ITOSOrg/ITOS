package com.company.itos.core.audittrail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.audittrail.pojo.AuditTrailDtls;
import com.company.itos.core.audittrail.pojo.AuditTrailkey;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.dataaccess.DBConnection;

public class ReadAuditTrailDAO {
	
	public String readAuditTrail(AuditTrailDetails auditTrailDetails){
		
		String returnMassegeStr = "";

		Connection connection = null;
		try {

			connection = DBConnection.getDBConnection();
			
			String auditTrailSQLStr = "SELECT * FROM AuditTrail WHERE auditTrailID = \'" + auditTrailDetails.getAuditTrailID()
					+ "\'";
			
			PreparedStatement preparedStatement = connection.prepareStatement(auditTrailSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				auditTrailDetails.setTableName(resultSet.getString("tableName"));
				auditTrailDetails.setRelatedID(resultSet.getLong("relatedID"));
				auditTrailDetails.setAuditTrailID(resultSet.getLong("auditTrailID"));
				auditTrailDetails.setOperationType(resultSet.getString("operationType"));
				auditTrailDetails.setUserName(resultSet.getString("userName"));
				auditTrailDetails.setTimeEntered(resultSet.getTimestamp("timeEntered"));
				
			}
			
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;	
		}catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;
	}
	
public AuditTrailDtls readAuditTrailBaseOnCondition(AuditTrailkey auditTrailkey){
		
		String returnMassegeStr = "";
		AuditTrailDtls auditTrailDtls = new AuditTrailDtls();

		Connection connection = null;
		try {

			connection = DBConnection.getDBConnection();
			
			String auditTrailSQLStr = "SELECT userName, timeEntered FROM AuditTrail WHERE relatedID = \'" + auditTrailkey.getRelatedID()
					+ "\'  AND tableName = \'" + auditTrailkey.getTableName()
					+ "\'AND operationType = 'Create'";
			
			PreparedStatement preparedStatement = connection.prepareStatement(auditTrailSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				auditTrailDtls.setCreatedBy(resultSet.getString("userName"));
				auditTrailDtls.setCreatedOn(resultSet.getTimestamp("timeEntered"));
				
			}
			String auditTrailSQLStr1 = "SELECT userName, MAX(timeEntered) timeEntered FROM AuditTrail WHERE relatedID = \'" + auditTrailkey.getRelatedID()
					+ "\'  AND tableName = \'" + auditTrailkey.getTableName()
					+ "\' AND operationType = 'Update' GROUP  BY userName";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(auditTrailSQLStr1);
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			
			while (resultSet1.next()) {
				
				auditTrailDtls.setLastModifieddBy(resultSet1.getString("userName"));
				auditTrailDtls.setLastModifiedOn(resultSet1.getTimestamp("timeEntered"));
				
			}
			
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;	
		}catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return auditTrailDtls;
	}


}
