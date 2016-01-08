package com.company.itos.core.role.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;

public class UpdateRoleDAO {

	public String UpdateRole(RoleDetail roleDetail) {

		Connection connection = null;
		String returnMassegeStr = "";

		int roleVersionNoFromUpdate = roleDetail.getVersionNo();

		int roleVersionNoFromDatabase = returnVersionNumberFromRole(roleDetail);

		if (roleVersionNoFromUpdate == roleVersionNoFromDatabase) {

			roleVersionNoFromDatabase++;

			try {
				connection = DBConnection.getDBConnection();

				String roleSQLStr = "UPDATE	Role SET roleType = ?, workspace = ?, createdBy = ?, lastModifiedBy = ? WHERE roleID = '"
						+ roleDetail.getRoleID() + "'";

				PreparedStatement preparedStatementRole = connection.prepareStatement(roleSQLStr);

				preparedStatementRole.setString(1, roleDetail.getRoleType());
				preparedStatementRole.setString(2, roleDetail.getWorkspace());
				preparedStatementRole.setString(3, roleDetail.getCreatedBy());
				preparedStatementRole.setString(4, roleDetail.getLastModifiedBy());
				preparedStatementRole.execute();
				
				//inserting data into AuditTrail Table for Role Table
				AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
				
				auditTrailDetails.setTableName("Role");
				auditTrailDetails.setOperationType("Update");
				auditTrailDetails.setUserName("Rahul");
				auditTrailDetails.setRelatedID(roleDetail.getRoleID());
				auditTrailDetails.setTransactionType("Online");
				
				CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {

				e.printStackTrace();
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
			}
		}

		return returnMassegeStr;
	}

	public int returnVersionNumberFromRole(RoleDetail roleDetail) {

		int versionNo = 0;
		try {

			Connection connection = DBConnection.getDBConnection();

			String roleSQLStr = "SELECT	versionNo	FROM	Role	WHERE	 roleID = '" + roleDetail.getRoleID() + "'";

			PreparedStatement preparedStatementReturnVersionNumberFromRole = connection.prepareStatement(roleSQLStr);

			ResultSet resultSet = preparedStatementReturnVersionNumberFromRole.executeQuery();
			if (resultSet.next()) {

				versionNo = resultSet.getInt("versionNo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return versionNo;
	}

}
