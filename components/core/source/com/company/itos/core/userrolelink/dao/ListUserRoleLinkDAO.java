package com.company.itos.core.userrolelink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.DBConnection;

public class ListUserRoleLinkDAO {

	public List<UserRoleLinkDetail> listUserRoleLink(UserRoleLinkDetail userRoleLinkDetailkey) {

		List<UserRoleLinkDetail> userRoleLinklist = new ArrayList<UserRoleLinkDetail>();

		DBConnection dbConnection = new DBConnection();
		Connection connection = null;

		try {

			connection = dbConnection.getDBConnection();

			String userRoleLinkSQLStr = "SELECT * FROM UserRoleLink";

			PreparedStatement preparedStatementuserRoleLink = connection.prepareStatement(userRoleLinkSQLStr);
			ResultSet resultSetuserRoleLink = preparedStatementuserRoleLink.executeQuery();

			while (resultSetuserRoleLink.next()) {

				UserRoleLinkDetail userRoleLinkDetail = new UserRoleLinkDetail();

				userRoleLinkDetail.setUserRoleLinkID(resultSetuserRoleLink.getInt("userRoleLinkID"));
				userRoleLinkDetail.setRoleID(resultSetuserRoleLink.getInt("roleID"));
				userRoleLinkDetail.setUsername(resultSetuserRoleLink.getString("username"));
				userRoleLinkDetail.setStartDate(resultSetuserRoleLink.getDate("startDate"));
				userRoleLinkDetail.setEndDate(resultSetuserRoleLink.getDate("endDate"));
				userRoleLinkDetail.setRecordStatus(resultSetuserRoleLink.getString("recordStatus"));
				userRoleLinkDetail.setVersionNo(resultSetuserRoleLink.getInt("versionNo"));

				userRoleLinklist.add(userRoleLinkDetail);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return userRoleLinklist;
	}

}
