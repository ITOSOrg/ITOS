package com.company.itos.core.role.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;

public class UpdateRoleDAO {

	public String UpdateRole(RoleDetail roleDeatail) {

		Connection connection = null;
		String returnMassegeStr = "";
		DBConnection dbConnection = new DBConnection();

		int roleVersionNoFromUpdate = roleDeatail.getVersionNo();

		int roleVersionNoFromDatabase = returnVersionNumberFromRole(roleDeatail);

		if (roleVersionNoFromUpdate == roleVersionNoFromDatabase) {

			roleVersionNoFromDatabase++;

			try {
				connection = dbConnection.getDBConnection();

				String roleSQLStr = "UPDATE	Role SET roleType = ?, workspace = ?, createdBy = ?, lastModifiedBy = ? WHERE roleID = '"
						+ roleDeatail.getRoleID() + "'";

				PreparedStatement preparedStatementRole = connection.prepareStatement(roleSQLStr);

				preparedStatementRole.setString(1, roleDeatail.getRoleType());
				preparedStatementRole.setString(2, roleDeatail.getWorkspace());
				preparedStatementRole.setString(3, roleDeatail.getCreatedBy());
				preparedStatementRole.setString(4, roleDeatail.getLastModifiedBy());
				preparedStatementRole.execute();

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {

				e.printStackTrace();
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
			}
		}

		return returnMassegeStr;
	}

	public int returnVersionNumberFromRole(RoleDetail roleDeatail) {

		int versionNo = 0;
		try {
			DBConnection dbConnection = new DBConnection();

			Connection connection = dbConnection.getDBConnection();

			String roleSQLStr = "SELECT	versionNo	FROM	Role	WHERE	 roleID = '" + roleDeatail.getRoleID() + "'";

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
