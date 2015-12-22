package com.company.itos.core.role.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;

public class ReadRoleDAO {

	public String readRole(RoleDetail roleDetail) {

		String returnMassegeStr = "";

		String RoleSQLStr = "SELECT * FROM Role WHERE roleID = '" + roleDetail.getRoleID() + "' ";
		try {
			Connection connection = DBConnection.getDBConnection();

			PreparedStatement preparedStatementRole = connection.prepareStatement(RoleSQLStr);
			ResultSet resultSetRole = preparedStatementRole.executeQuery();

			while (resultSetRole.next()) {
				roleDetail.setRoleID(resultSetRole.getLong("roleID"));
				roleDetail.setRoleType(resultSetRole.getString("roleType"));
				roleDetail.setWorkspace(resultSetRole.getString("workspace"));
				roleDetail.setRecordStatus(resultSetRole.getString("recordStatus"));
				roleDetail.setCreatedBy(resultSetRole.getString("createdBy"));
				roleDetail.setLastModifiedBy(resultSetRole.getString("lastModifiedBy"));
				roleDetail.setCreatedOn(resultSetRole.getTimestamp("createdOn"));
				roleDetail.setLastModifiedOn(resultSetRole.getTimestamp("lastModifiedOn"));
				roleDetail.setVersionNo(resultSetRole.getInt("versionNo"));
			}

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;

	}

}
