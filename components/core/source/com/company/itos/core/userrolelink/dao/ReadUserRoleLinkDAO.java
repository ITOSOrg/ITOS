package com.company.itos.core.userrolelink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;

public class ReadUserRoleLinkDAO {

	public String readUserRoleLink(UserRoleLinkDetail userRoleLinkDetail) {

		String returnMassegeStr = "";
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getDBConnection();

			String userRoleLinkrSQLstr = "SELECT * FROM UserRoleLink WHERE userRoleLinkID = '" + userRoleLinkDetail.getUserRoleLinkID()
					+ "'";

			PreparedStatement preparedStatementUserRoleLinkr = connection.prepareStatement(userRoleLinkrSQLstr);
			ResultSet resultSetUserRoleLink = preparedStatementUserRoleLinkr.executeQuery();

			while (resultSetUserRoleLink.next()) {

				userRoleLinkDetail.setUserRoleLinkID(resultSetUserRoleLink.getInt("userRoleLinkID"));
				userRoleLinkDetail.setRoleID(resultSetUserRoleLink.getInt("roleID"));
				userRoleLinkDetail.setUsername(resultSetUserRoleLink.getString("username"));
				userRoleLinkDetail.setStartDate(resultSetUserRoleLink.getTimestamp("startDate"));
				userRoleLinkDetail.setEndDate(resultSetUserRoleLink.getDate("endDate"));
				userRoleLinkDetail.setRecordStatus(resultSetUserRoleLink.getString("recordStatus"));
				userRoleLinkDetail.setVersionNo(resultSetUserRoleLink.getInt("versionNo"));

			}

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;
	}

}
