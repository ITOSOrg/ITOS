package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.PersonDetail;
import com.company.itos.profile.pojo.UsersDetail;

import com.company.itos.profile.pojo.PersonSearchCriteria;
import com.company.itos.profile.pojo.PersonSearchDetails;

/**
 * PersonRegistrationDAO class create logic for person registration
 */
public class PersonRegistrationDAO {

	PreparedStatement	preparedStatement;

	ResultSet			resultSet;

	public String registerPerson(PersonDetail personDetail) {

		String returnMassegeStr = "";
		boolean personExistInd = personExist(personDetail);
		boolean userNameExistInd = checkingUserName(personDetail);
		
		if (!personExistInd && !userNameExistInd) {

			UsersDetail usersDetail = personDetail.getUsersDetail();

			String sql = "INSERT	INTO	USERS(userName,password)	VALUES('" + usersDetail.getUserName() + "','" + usersDetail.getPassword()
					+ "')";

			String insertTableSQL = "INSERT INTO PERSON(RefrenceNumber,FirstName,MiddleName,LastName,userName,versionNo,recordStatus,dateOfBirth) VALUES ('"
					+ personDetail.getRefrenceNumber()
					+ "','"
					+ personDetail.getFirstName()
					+ "','"
					+ personDetail.getMiddleName()
					+ "','"
					+ personDetail.getLastName()
					+ "','"
					+ usersDetail.getUserName()
					+ "','"
					+ personDetail.getVersionNo()
					+ "','active'," + " ? )";

			DBConnection dbConnection = new DBConnection();

			Connection connection = null;
			try {
				connection = dbConnection.getDBConnection();

				preparedStatement = connection.prepareStatement(sql);

				preparedStatement.execute();

				PreparedStatement preparedStatement1 = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);

				resultSet = preparedStatement1.getGeneratedKeys();

				preparedStatement1.setDate(1, personDetail.getDateOfBirth());
				
				preparedStatement1.execute();

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
			} catch (SQLException e) {
				List<String> errorMessageList = new ArrayList<String>();
				errorMessageList.add("Username already exist");
				e.printStackTrace();
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
			}
		}

		return returnMassegeStr;
	}

	/**
	 * 
	 * @param personDetail
	 */
	public boolean personExist(PersonDetail personDetail) {

		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		try {

			PersonSearchCriteria personSearchCriteria = new PersonSearchCriteria();

			personSearchCriteria.setFirstName(personDetail.getFirstName() == null ? "" : personDetail.getFirstName());
			personSearchCriteria.setMiddleName(personDetail.getMiddleName() == null ? "" : personDetail.getMiddleName());
			personSearchCriteria.setLastName(personDetail.getLastName() == null ? "" : personDetail.getLastName());

			PersonSearchDetails personSearchDetails = new PersonSearchDetails();
			personSearchDetails.setPersonSearchCriteria(personSearchCriteria);

			//
			SearchPersonDAO searchPersonDAO = new SearchPersonDAO();

			//
			List<PersonDetail> personDetailList = searchPersonDAO.searchPersonInfo(personSearchDetails);

			if (personDetailList.size() > 0) {

				// List<String> errorMessageList = new ArrayList<String>();
				// errorMessageList.add("Person already exist");
				//
				// personDetail.setErrorMessageList(errorMessageList);

				personDetail.getErrorMessageList().add("Person already exist");

				return true;
			}
		} catch (Exception e) {

		}

		return false;

	}

	public boolean checkingUserName(PersonDetail personDetail) {

		DBConnection dbConnection = new DBConnection();

		Connection connection = null;
		try {
			connection = dbConnection.getDBConnection();
			Statement statement = connection.createStatement();
			String sql = "select userName from USERS where userName='" + personDetail.getUsersDetail().getUserName() + "'";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				List<String> errorMessageList = new ArrayList<String>();
				errorMessageList.add("UserName already exist");
				// personDetail.setErrorMessageList(errorMessageList);
				personDetail.getErrorMessageList().add("UserName already exist");
				return true;

			}

		} catch (Exception E) {

		}

		return false;
	}

}
