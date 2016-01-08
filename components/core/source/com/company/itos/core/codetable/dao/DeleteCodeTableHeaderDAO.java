package com.company.itos.core.codetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.codetable.pojo.CodeTableHeaderDetail;
import com.company.itos.core.util.CRUDConstants;

public class DeleteCodeTableHeaderDAO {

	public String deleteCodeTableHeader(CodeTableHeaderDetail codeTableHeaderDetail) {

		String returnMassegeStr = "";

		Connection connection = null;
		try {
			connection = DBConnection.getDBConnection();

			String codeTableHeaderSQLStr = "UPDATE CodeTableHeader SET recordStatus='cancel' WHERE defaultCode= '"
					+ codeTableHeaderDetail.getDefaultCode() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(codeTableHeaderSQLStr);
			preparedStatement.executeUpdate();
			
			//inserting data into AuditTrail Table for CodeTableHeader Table
			AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
			
			auditTrailDetails.setTableName("CodeTableHeader");
			auditTrailDetails.setOperationType("Delete");
			auditTrailDetails.setUserName("Rahul");
			auditTrailDetails.setRelatedID(codeTableHeaderDetail.getTableName());
			auditTrailDetails.setTransactionType("Online");
			
			CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
			createAuditTrailDAO.createAuditTrail(auditTrailDetails);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
	}

}
