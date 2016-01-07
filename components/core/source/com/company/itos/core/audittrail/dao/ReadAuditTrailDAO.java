package com.company.itos.core.audittrail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
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

}
