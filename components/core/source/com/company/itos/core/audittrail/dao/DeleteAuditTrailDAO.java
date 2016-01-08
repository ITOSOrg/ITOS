package com.company.itos.core.audittrail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.dataaccess.DBConnection;

public class DeleteAuditTrailDAO {
	
	public String DeleteAudit(AuditTrailDetails auditTrailDetails){
		
		String returnMassegeStr = "";

		Connection connection = null;
		try {

			connection = DBConnection.getDBConnection();
			
			String auditTrailSQLStr = "UPDATE AuditTrail SET recordStatus='cancel' WHERE auditTrailID = \'" + auditTrailDetails.getAuditTrailID()
					+ "\'";
			
			PreparedStatement preparedStatement = connection.prepareStatement(auditTrailSQLStr);
			preparedStatement.executeQuery();
			
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;	
		}catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;
	}

}
