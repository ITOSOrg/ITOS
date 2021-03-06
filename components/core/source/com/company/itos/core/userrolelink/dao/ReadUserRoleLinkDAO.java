package com.company.itos.core.userrolelink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;

public class ReadUserRoleLinkDAO {

	public String readUserRoleLink(UserRoleLinkDetail userRoleLinkDetail) {

		String returnMassegeStr = "";
		try {
			Connection connection = DBConnection.getDBConnection();

			String userRoleLinkrSQLstr = "SELECT * FROM UserRoleLink WHERE userRoleLinkID = '" + userRoleLinkDetail.getUserRoleLinkID()
					+ "'";

			PreparedStatement preparedStatementUserRoleLinkr = connection.prepareStatement(userRoleLinkrSQLstr);
			ResultSet resultSetUserRoleLink = preparedStatementUserRoleLinkr.executeQuery();

			while (resultSetUserRoleLink.next()) {

				userRoleLinkDetail.setUserRoleLinkID(resultSetUserRoleLink.getLong("userRoleLinkID"));
				userRoleLinkDetail.setRoleID(resultSetUserRoleLink.getLong("roleID"));
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
