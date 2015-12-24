package com.company.itos.core.role.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.type.UniqueID;
import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.JavaUtildates;

public class CreateRoleDAO {

	public String CreateRole(RoleDetail roleDeatail) {

		String returnMassegeStr = "";

		Connection connection = null;

		try {

			connection = DBConnection.getDBConnection();

			/*
			 * PreparedStatement preparedStatement1 =
			 * connection.prepareStatement("SELECT RoleSEQ.nextval FROM DUAL");
			 * ResultSet resultSet1 = preparedStatement1.executeQuery();
			 * 
			 * while (resultSet1.next()) {
			 * roleDeatail.setRoleID(resultSet1.getInt(1)); }
			 */

			String roleSQLStr = "INSERT INTO Role(roleID, roleType, workspace, recordStatus, createdBy, createdOn, lastModifiedBy, lastModifiedOn, versionNo)"
					+ "VALUES(?, ?, ?, 'Active', 'Rahul', ?, 'Rahul', ?, 1)";

			PreparedStatement preparedStatementRole = connection.prepareStatement(roleSQLStr);

			preparedStatementRole.setLong(1, UniqueID.nextUniqueID());
			preparedStatementRole.setString(2, roleDeatail.getRoleType());
			preparedStatementRole.setString(3, roleDeatail.getWorkspace());

			String crrentDateTime = JavaUtildates.getCurrentDateTime();

			Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
			preparedStatementRole.setTimestamp(4, timestamp);
			preparedStatementRole.setTimestamp(5, timestamp);

			preparedStatementRole.execute();

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;

	}

	public String createRoleUsingRegistrationForm(RoleDetail roleDetail) {

		String returnMassegeStr = "";

		DBConnection dbConnection = new DBConnection();

		Connection connection = null;

		try {

			connection = dbConnection.getDBConnection();

			/*
			 * PreparedStatement preparedStatement =
			 * connection.prepareStatement("SELECT RoleSEQ.nextval FROM DUAL");
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 * 
			 * while (resultSet.next()) {
			 * roleDetail.setRoleID(resultSet.getLong(1)); }
			 */
			String roleSQLStr = "INSERT INTO Role(roleID, roleType, workspace, recordStatus, createdBy, createdOn, lastModifiedBy, lastModifiedOn, versionNo)"
					+ "VALUES(?, ?, 'Emp', 'Active', 'Rahul', ?, 'Rahul', ?, 1)";

			PreparedStatement preparedStatementRole = connection.prepareStatement(roleSQLStr);

			preparedStatementRole.setLong(1, UniqueID.nextUniqueID());
			preparedStatementRole.setString(2, roleDetail.getRoleType());

			String crrentDateTime = JavaUtildates.getCurrentDateTime();

			Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
			preparedStatementRole.setTimestamp(3, timestamp);
			preparedStatementRole.setTimestamp(4, timestamp);

			preparedStatementRole.execute();

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;

	}

}
