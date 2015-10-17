package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.PersonDetail;

/**
 * PersonDeleteDAO class create logic for deleting student
 */
public class PersonDeleteDAO {

	Statement statement;
	Connection connection = null;
	ResultSet resultSet = null;

	public String deleteStudent(PersonDetail personDetail) {
		/**
		 * creating object of DBConnection class
		 */
		DBConnection dbConnection = new DBConnection();
		String returnMassegeStr = "";

		try {
			/**
			 * get connected with database by calling getDBConnection() method
			 * of DBConnection class
			 */
			connection = dbConnection.getDBConnection();
			String query = "UPDATE	PERSON	SET	STATUS='cancel'	WHERE	REFRENCENUMBER="
					+ personDetail.getRefrenceNumber();
			/**
			 * sending sql statement to the database
			 */
			statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
	}

}
