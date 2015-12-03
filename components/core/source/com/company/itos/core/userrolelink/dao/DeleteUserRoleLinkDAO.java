package com.company.itos.core.userrolelink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;

public class DeleteUserRoleLinkDAO {

	public String deleteUserRoleLink(UserRoleLinkDetail userRoleLinkDetail) {

		String returnMassegeStr = "";

		Connection connection = null;
		try {

			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getDBConnection();

			String UserRoleLinkSQLStr = "UPDATE UserRoleLink SET recordStatus='cancel' WHERE userRoleLinkID= '"
					+ userRoleLinkDetail.getUserRoleLinkID() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(UserRoleLinkSQLStr);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

	}
}
