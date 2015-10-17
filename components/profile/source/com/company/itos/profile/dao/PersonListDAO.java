package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.PersonDetail;

/**
 * PersonListDAO class create logic for displaying person list
 */
public class PersonListDAO {
	Statement statement;
	ResultSet resultSet;

	public List<PersonDetail> listAllStudent() {
		List<PersonDetail> personDetailList = new ArrayList<PersonDetail>();
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		try {
			connection = dbConnection.getDBConnection();

			String query = "SELECT * FROM PERSON	WHERE	RECORDSTATUS='active'";

			statement = connection.createStatement();

			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				PersonDetail personDetail = new PersonDetail();
				personDetail.setPersonID(resultSet.getInt("PERSONID"));
				personDetail.setRefrenceNumber(resultSet
						.getInt("REFRENCENUMBER"));
				personDetail.setFirstName(resultSet.getString("FIRSTNAME"));
				personDetail.setMiddleName(resultSet.getString("MIDDLENAME"));
				personDetail.setLastName(resultSet.getString("LASTNAME"));
				personDetail.setUserName(resultSet.getString("USERNAME"));
				personDetail
						.setVersionNo(resultSet.getInt("versionNo"));
				personDetail.setCreatedBy(resultSet.getString("createdBy"));
				personDetail.setCreatedOn(resultSet.getTimestamp("createdOn"));
				personDetail.setModifiedBy(resultSet.getString("modifiedBy"));
				personDetail.setModifiedOn(resultSet.getTimestamp("modifiedOn"));
				
				personDetailList.add(personDetail);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return personDetailList;

	}

	
}