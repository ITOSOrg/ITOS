package com.company.itos.core.audittrail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.properties.pojo.PropertiesDetail;
import com.company.itos.core.util.dataaccess.DBConnection;

public class LitAuditTrailDAO {
	
	public List<AuditTrailDetails> litAuditTrail(AuditTrailDetails auditTrailDetailkey){
		List<AuditTrailDetails> auditTrailDetailList = new ArrayList<AuditTrailDetails>();
		
		Connection connection = null;

		try {
			connection = DBConnection.getDBConnection();

			String auditTrailSQLStr = "SELECT * FROM AuditTrail";
			
			PreparedStatement preparedStatement = connection.prepareStatement(auditTrailSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
				auditTrailDetails.setAuditTrailID(resultSet.getLong("auditTrailID"));
				auditTrailDetails.setTableName(resultSet.getString("tableName"));
				auditTrailDetails.setUserName(resultSet.getString("userName"));
				auditTrailDetails.setOperationType(resultSet.getString("operationType"));
				auditTrailDetails.setRelatedID(resultSet.getLong("relatedID"));
				auditTrailDetails.setTimeEntered(resultSet.getTimestamp("timeEntered"));
				auditTrailDetailList.add(auditTrailDetails);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return auditTrailDetailList;
	}

}
