package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.PersonDetail;

/**
 * PersonUpdateDAO class create logic for updating student
 */
public class PersonUpdateDAO {
	PreparedStatement preparedStatement = null;
	Connection connection = null;
	ResultSet resultSet = null;

	public PersonDetail updatePerson(PersonDetail personDetail) {
		DBConnection dbConnection = new DBConnection();

		try {
			connection = dbConnection.getDBConnection();
			String query = "UPDATE	PERSON	SET	refrenceNumber='"
					+ personDetail.getRefrenceNumber() + "',firstName='"
					+ personDetail.getFirstName() + "',middleName='"
					+ personDetail.getMiddleName() + "',lastName='"
					+ personDetail.getLastName() + "'" + "	where	userName='"
					+ personDetail.getUserName() + "'";

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return personDetail;

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
	
	public	void	versionNumberIncreament(PersonDetail personDetail)
	{
		
		try
		{
			DBConnection dbConnection = new DBConnection();

			Connection connection = dbConnection.getDBConnection();
			//PersonDetail personDetail	=	new	PersonDetail();
			String	query	=	"UPDATE	PERSON	SET	versionNo	=	versionNo+1	WHERE	USERNAME='"
					+ personDetail.getUserName() + "'";
			Statement statement = connection.createStatement();
			statement.executeQuery(query);
		}catch (SQLException e) {
			e.printStackTrace();
		}
			
		}
		
	}

