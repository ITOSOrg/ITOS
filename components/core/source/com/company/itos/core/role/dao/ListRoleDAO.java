package com.company.itos.core.role.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.DBConnection;

public class ListRoleDAO {

	public List<RoleDetail> ListRole(RoleDetail roleDeatailkey) {

		List<RoleDetail> roleDetailList = new ArrayList<RoleDetail>();

		DBConnection dbConnection = new DBConnection();
		Connection connection = null;

		try {

			connection = dbConnection.getDBConnection();

			String roleSQLStr = "SELECT * FROM Role";

			PreparedStatement preparedStatementRole = connection.prepareStatement(roleSQLStr);
			ResultSet resultSet = preparedStatementRole.executeQuery();

			while (resultSet.next()) {
				RoleDetail roleDetail = new RoleDetail();
				roleDetail.setRoleType(resultSet.getString("roleType"));
				roleDetail.setWorkspace(resultSet.getString("workspace"));
				roleDetail.setRecordStatus(resultSet.getString("recordStatus"));
				roleDetail.setCreatedBy(resultSet.getString("createdBy"));
				roleDetail.setLastModifiedBy(resultSet.getString("lastModifiedBy"));
				roleDetail.setRoleID(resultSet.getInt("roleID"));
				roleDetail.setVersionNo(resultSet.getInt("versionNo"));
				roleDetail.setCreatedOn(resultSet.getTimestamp("createdOn"));
				roleDetail.setLastModifiedOn(resultSet.getTimestamp("lastModifiedOn"));
				roleDetailList.add(roleDetail);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return roleDetailList;
	}
}
