package com.company.itos.core.userrolelink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.core.util.JavaUtildates;

public class UpdateUserRoleLinkDAO {

	public String updateUserRoleLink(UserRoleLinkDetail userRoleLinkDetail) {

		Connection connection = null;
		String returnMassegeStr = "";
		DBConnection dbConnection = new DBConnection();

		int userRoleLinkVersionNoFromUpdate = userRoleLinkDetail.getVersionNo();

		int userRoleLinkVersionNoFromDatabase = returnVersionNumberFromUserRoleLink(userRoleLinkDetail);

		if (userRoleLinkVersionNoFromUpdate == userRoleLinkVersionNoFromDatabase) {
			userRoleLinkVersionNoFromDatabase++;

			try {
				connection = dbConnection.getDBConnection();

				String userRoleLinkSQLStr = "UPDATE	UserRoleLink SET username = ?, startDate = ?, endDate = ? WHERE userRoleLinkID = '"
						+ userRoleLinkDetail.getUserRoleLinkID() + "'";

				PreparedStatement preparedStatementuserRoleLink = connection.prepareStatement(userRoleLinkSQLStr);

				preparedStatementuserRoleLink.setString(1, userRoleLinkDetail.getUsername());

				String crrentDateTime = JavaUtildates.getCurrentDateTime();

				Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
				preparedStatementuserRoleLink.setTimestamp(2, timestamp);
				
				preparedStatementuserRoleLink.setDate(3, userRoleLinkDetail.getEndDate());
				preparedStatementuserRoleLink.execute();

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {

				e.printStackTrace();
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
			}
		}

		return returnMassegeStr;

	}

	public int returnVersionNumberFromUserRoleLink(UserRoleLinkDetail userRoleLinkDetail) {

		int versionNo = 0;
		try {
			DBConnection dbConnection = new DBConnection();

			Connection connection = dbConnection.getDBConnection();

			String userRoleLinkSQLStr = "SELECT	versionNo 	FROM	UserRoleLink	WHERE	 userRoleLinkID = '"
					+ userRoleLinkDetail.getUserRoleLinkID() + "'";

			PreparedStatement preparedStatementReturnPhoneNumberVersionNumber = connection.prepareStatement(userRoleLinkSQLStr);

			ResultSet resultSet = preparedStatementReturnPhoneNumberVersionNumber.executeQuery();
			if (resultSet.next()) {

				versionNo = resultSet.getInt("versionNo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return versionNo;
	}

}
