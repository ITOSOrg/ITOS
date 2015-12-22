package com.company.itos.core.role.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.util.CRUDConstants;

public class DeleteRoleDAO {
	
	public String deleteRole(RoleDetail roleDetail){
			
		String returnMassegeStr = "";


		Connection connection = null;
		try {
			
			connection = DBConnection.getDBConnection();
	
			String RoleSQLStr = "UPDATE Role SET recordStatus='cancel' WHERE roleID= '"+ roleDetail.getRoleID()+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(RoleSQLStr);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnMassegeStr  = CRUDConstants.RETURN_MESSAGE_SUCCESS;
	}
		
		}


