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
 * PersonUpdateDAO class create logic for updating student
 */
public class PersonUpdateDAO {
	PreparedStatement preparedStatement = null;
	Connection connection = null;
	ResultSet resultSet = null;

	public String updatePerson(PersonDetail personDetail) {
		String returnMassegeStr = "";

		int versionNoFromUpdate = personDetail.getVersionNo();

		int versionNoFromDatabase = returnVersionNumber(personDetail);

		if (versionNoFromUpdate == versionNoFromDatabase) {

			versionNoFromDatabase++;

			DBConnection dbConnection = new DBConnection();

			try {
				connection = dbConnection.getDBConnection();
				String query = "UPDATE	PERSON	SET title='"
						+ personDetail.getTitle() + "',	firstName='"
						+ personDetail.getFirstName() + "', middleName='"
						+ personDetail.getMiddleName() + "', lastName='"
						+ personDetail.getLastName() + "', gender='"
						+ personDetail.getGender() + "', dateOfBirth = ? , versionNo ='"
						+ versionNoFromDatabase + "' " + "	where	userName='"
						+ personDetail.getUserName() + "'";

				preparedStatement = connection.prepareStatement(query);

				preparedStatement.setDate(1, personDetail.getDateOfBirth());
				preparedStatement.executeUpdate();

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else {
			personDetail
					.getErrorMessageList()
					.add("This Record has been already modified by another user, Please check");
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;

	}

	public int returnVersionNumber(PersonDetail personDetail) {

		int versionNumber = 0;
		try {
			DBConnection dbConnection = new DBConnection();

			Connection connection = dbConnection.getDBConnection();

			String query1 = "SELECT	versionNo	FROM	PERSON	WHERE	 USERNAME='"
					+ personDetail.getUserName() + "'";
			Statement statement = connection.createStatement();

			resultSet = statement.executeQuery(query1);
			if (resultSet.next()) {

				versionNumber = resultSet.getInt("versionNo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return versionNumber;
	}

	public void versionNumberIncreament(PersonDetail personDetail) {

		try {
			DBConnection dbConnection = new DBConnection();

			Connection connection = dbConnection.getDBConnection();
			// PersonDetail personDetail = new PersonDetail();
			String query = "UPDATE	PERSON	SET	versionNo	=	versionNo+1	WHERE	USERNAME='"
					+ personDetail.getUserName() + "'";
			Statement statement = connection.createStatement();
			statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
