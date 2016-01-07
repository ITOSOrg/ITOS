package com.company.itos.core.audittrail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.properties.pojo.PropertiesDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.dataaccess.DBConnection;

public class UpdateAuditTrailDAO {
	
	public String updateAuditTrail(AuditTrailDetails auditTrailDetails){
		
		Connection connection = null;
		String returnMassegeStr = "";
		
		//int auditTrailVersionNoFromUpdate = auditTrailDetails.getVersionNo();

		//int auditTrailVersionNoFromDatabase = returnVersionNumberFromauditTrail(auditTrailDetails);

		//if (auditTrailVersionNoFromUpdate == auditTrailVersionNoFromDatabase) {

			//auditTrailVersionNoFromDatabase++;

			try {
				connection = DBConnection.getDBConnection();
				
				String auditTrailSQLStr = "UPDATE	AuditTrail	SET tableName = ?, operationType = ?, userName = ?, relatedID = ?"
						+ " WHERE auditTrailID = '" + auditTrailDetails.getAuditTrailID() + "'";

				PreparedStatement preparedStatement = connection.prepareStatement(auditTrailSQLStr);

				preparedStatement.setString(1, auditTrailDetails.getTableName());
				preparedStatement.setString(2, auditTrailDetails.getOperationType());
				preparedStatement.setString(3, auditTrailDetails.getUserName());
				preparedStatement.setLong(4, auditTrailDetails.getRelatedID());
				
				preparedStatement.executeUpdate();
				
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {

				e.printStackTrace();
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
			}
			return returnMassegeStr;
		}

		
	
	public int returnVersionNumberFromauditTrail(AuditTrailDetails auditTrailDetails) {

		int versionNo = 0;
		try {
			DBConnection dbConnection = new DBConnection();

			Connection connection = dbConnection.getDBConnection();

			String PropertiesSQLStr = "SELECT	versionNo	FROM	AuditTrail	WHERE	 auditTrailID = '" + auditTrailDetails.getAuditTrailID() + "'";

			PreparedStatement preparedStatement = connection.prepareStatement(PropertiesSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				versionNo = resultSet.getInt("versionNo");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return versionNo;
	}

}
