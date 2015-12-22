package com.company.itos.core.userrolelink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.JavaUtildates;

public class CreateUserRoleLinkDAO {

	public String CreateUserRoleLink(UserRoleLinkDetail userRoleLinkDetail) {

		String returnMassegeStr = "";

		Connection connection = null;

		try {

			connection = DBConnection.getDBConnection();

			PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT UsersRoleLinkSEQ.nextval FROM DUAL");
			ResultSet resultSet2 = preparedStatement2.executeQuery();

			while (resultSet2.next()) {
				userRoleLinkDetail.setUserRoleLinkID(resultSet2.getInt(1));
			}

			String userRoleLinkSQLStr = "INSERT INTO UserRoleLink(userRoleLinkID, username, roleID, startDate, endDate, recordStatus, versionNo)"
					+ "VALUES(?, ?, ?, ?, ?, 'Active', 1)";

			PreparedStatement preparedStatementuserRoleLink = connection.prepareStatement(userRoleLinkSQLStr);

			preparedStatementuserRoleLink.setInt(1, userRoleLinkDetail.getUserRoleLinkID());
			preparedStatementuserRoleLink.setString(2, userRoleLinkDetail.getUsername());
			preparedStatementuserRoleLink.setInt(3, userRoleLinkDetail.getRoleID());

			String crrentDateTime = JavaUtildates.getCurrentDateTime();

			Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
			preparedStatementuserRoleLink.setTimestamp(4, timestamp);

			preparedStatementuserRoleLink.setDate(5, userRoleLinkDetail.getEndDate());
			preparedStatementuserRoleLink.execute();

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;
	}
	
	
	
	
	
	

	public String createUserRoleLinkUsingRegistrationform(UserRoleLinkDetail userRoleLinkDetail) {

		String returnMassegeStr = "";

		DBConnection dbConnection = new DBConnection();

		Connection connection = null;

		try {

			connection = dbConnection.getDBConnection();

			PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT UsersRoleLinkSEQ.nextval FROM DUAL");
			ResultSet resultSet2 = preparedStatement2.executeQuery();

			while (resultSet2.next()) {
				userRoleLinkDetail.setUserRoleLinkID(resultSet2.getInt(1));
			}

			String userRoleLinkSQLStr = "INSERT INTO UserRoleLink(userRoleLinkID, username, roleID, startDate, endDate, recordStatus, versionNo)"
					+ "VALUES(?,           ?,          ?,     ?,   '',         'Active', 1)";

			PreparedStatement preparedStatementuserRoleLink = connection.prepareStatement(userRoleLinkSQLStr);

			preparedStatementuserRoleLink.setInt(1, userRoleLinkDetail.getUserRoleLinkID());
			preparedStatementuserRoleLink.setString(2, userRoleLinkDetail.getUsername());
			preparedStatementuserRoleLink.setInt(3, userRoleLinkDetail.getRoleID());

			String crrentDateTime = JavaUtildates.getCurrentDateTime();

			Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
			preparedStatementuserRoleLink.setTimestamp(4, timestamp);

			preparedStatementuserRoleLink.execute();

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;
	}

}
