package com.company.itos.core.audittrail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.JavaUtildates;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.type.UniqueID;

public class CreateAuditTrailDAO {
	
	public String createAuditTrail(AuditTrailDetails auditTrailDetails)
	{
		String returnMassegeStr = "";

		Connection connection = null;
		try {

			connection = DBConnection.getDBConnection();
			
			String auditTrailSQLStr = "INSERT INTO AuditTrail ( auditTrailID, tableName, operationType, userName, timeEntered, relatedID, transactionType) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(auditTrailSQLStr);

			preparedStatement.setLong(1, UniqueID.nextUniqueID());
			preparedStatement.setString(2, auditTrailDetails.getTableName());
			preparedStatement.setString(3, auditTrailDetails.getOperationType());
			preparedStatement.setString(4, auditTrailDetails.getUserName());
			
			String crrentDateTime = JavaUtildates.getCurrentDateTime();

			Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
			preparedStatement.setTimestamp(5, timestamp);
			preparedStatement.setLong(6,   auditTrailDetails.getRelatedID());
			preparedStatement.setString(7,   auditTrailDetails.getTransactionType());
			preparedStatement.executeQuery();
			
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;	
		}catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;
	}

}
