package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.PersonDetail;
import com.company.itos.profile.pojo.UsersDetail;

public class PersonHomeDAO {
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	/**
	 * method for reading student data from database
	 */
	public PersonDetail readStudentDetail(UsersDetail usersDetail) {

		PersonDetail personDetail = new PersonDetail();

		/**
		 * query to extract person details of matched username
		 */
		String query = "SELECT * FROM PERSON WHERE  USERNAME=\'"
				+ usersDetail.getUserName() + "\' ";
		Statement statement;
		try {
			DBConnection dbConnection = new DBConnection();

			Connection connection = dbConnection.getDBConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(query);
			/**
			 * if resultSet contains values then set it to the respected
			 * attribute
			 */

			if (resultSet.next()) {

				personDetail.setPersonID(resultSet.getInt("personID"));
				personDetail.setRefrenceNumber(resultSet
						.getInt("refrenceNumber"));
				personDetail.setFirstName(resultSet.getString("firstName"));
				personDetail.setMiddleName(resultSet.getString("middleName"));
				personDetail.setLastName(resultSet.getString("lastName"));
				personDetail.setRecordStatus(resultSet.getString("recordStatus"));
				personDetail.setVersionNo(resultSet.getInt("versionNo"));
				personDetail.setCreatedBy(resultSet.getString("createdBy"));
				personDetail.setModifiedBy(resultSet.getString("modifiedBy"));
				personDetail.setDateOfBirth(resultSet.getDate("dateOfBirth"));
				personDetail.setCreatedOn(resultSet.getTimestamp("createdOn"));
				personDetail.setModifiedOn(resultSet.getTimestamp("modifiedOn"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/**
		 * personDetail contains all attribute values
		 */
		return personDetail;
	}

}
