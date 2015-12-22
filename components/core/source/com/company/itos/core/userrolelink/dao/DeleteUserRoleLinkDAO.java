package com.company.itos.core.userrolelink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

	}
}
