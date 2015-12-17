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

public class ListRoleForSinglePersonDAO {
	
	public List<RoleDetail> listRoleForSinglePerson(UserRoleLinkDetail userRoleLinkDetail){
		
		List<RoleDetail> singlePersonRolelist = new ArrayList<RoleDetail>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;

		try {

			connection = dbConnection.getDBConnection();
			
			String userRoleLinkSQLStr = "SELECT roleID FROM UserRoleLink WHERE username='"+userRoleLinkDetail.getUsername()+"'";
			
			PreparedStatement preparedStatementuserRoleLink = connection.prepareStatement(userRoleLinkSQLStr);
			ResultSet resultSetuserRoleLink = preparedStatementuserRoleLink.executeQuery();
			
			RoleDetail roleDetailkey = new RoleDetail();
			while(resultSetuserRoleLink.next()){
				roleDetailkey.setRoleID(resultSetuserRoleLink.getInt("roleID"));
			}

			String roleSQLStr = "SELECT * FROM Role WHERE roleID = '"+roleDetailkey.getRoleID()+"'";

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
				
				singlePersonRolelist.add(roleDetail);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return singlePersonRolelist;
	}

}
