package com.company.itos.core.userrolelink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;

public class DeleteUserRoleLinkDAO {

	public String deleteUserRoleLink(UserRoleLinkDetail userRoleLinkDetail) {

		String returnMassegeStr = "";

		Connection connection = null;
		try {

			connection = DBConnection.getDBConnection();

			String UserRoleLinkSQLStr = "UPDATE UserRoleLink SET recordStatus='cancel' WHERE userRoleLinkID= '"
					+ userRoleLinkDetail.getUserRoleLinkID() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(UserRoleLinkSQLStr);
			preparedStatement.executeUpdate();
			
			//inserting data into AuditTrail Table for UserRoleLink Table
			AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
			
			auditTrailDetails.setTableName("UserRoleLink");
			auditTrailDetails.setOperationType("Delete");
			auditTrailDetails.setUserName("Rahul");
			auditTrailDetails.setRelatedID(userRoleLinkDetail.getUserRoleLinkID());
			auditTrailDetails.setTransactionType("Online");
			
			CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
			createAuditTrailDAO.createAuditTrail(auditTrailDetails);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

	}
}
