package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.core.util.JavaUtildates;
import com.company.itos.profile.pojo.EmailAddressDetail;
import com.company.itos.profile.pojo.PersonDetail;
import com.company.itos.profile.pojo.PhoneNumberDetail;
import com.company.itos.profile.pojo.UsersDetail;
import com.company.itos.profile.pojo.PersonSearchCriteria;
import com.company.itos.profile.pojo.PersonSearchDetails;

/**
 * PersonRegistrationDAO class create logic for person registration
 */
public class PersonRegistrationDAO {

	PreparedStatement preparedStatement;

	ResultSet resultSet;

	public String registerPerson(PersonDetail personDetail) {

		String returnMassegeStr = "";
		boolean personExistInd = personExist(personDetail);
		boolean userNameExistInd = checkingUserName(personDetail);

		if (!personExistInd && !userNameExistInd) {

			UsersDetail usersDetail = personDetail.getUsersDetail();
			EmailAddressDetail emailAddressDetail = personDetail.getEmailAddressDetail();
			 PhoneNumberDetail phoneNumberDetail = personDetail.getPhoneNumberDetail();

			String usersSQLStr = "INSERT	INTO	USERS(userName,password,recordStatus)	VALUES('" + usersDetail.getUserName() + "','"
					+ usersDetail.getPassword() + "','active')";

			DBConnection dbConnection = new DBConnection();

			Connection connection = null;
			
			Statement statement = null;
			try {
				connection = dbConnection.getDBConnection();
				statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT PersonSEQ.nextval FROM DUAL");
				
				if (resultSet.next()) {
					emailAddressDetail.setRelatedID(resultSet.getInt(1));
					phoneNumberDetail.setRelatedID(resultSet.getInt(1));
					personDetail.setPersonID(resultSet.getInt(1));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			String personSQLStr = "INSERT INTO PERSON(personID,  refrenceNumber, title, firstName, middleName, lastName, gender, userName, dateOfBirth, recordStatus, createdBy, createdOn, modifiedBy, modifiedOn, REGISTRATIONDATE, versionNo) "
					+ "VALUES (?, PersonRefrenceNumberSEQ.nextval, '"
					+ personDetail.getTitle()
					+ "', '"
					+ personDetail.getFirstName()
					+ "','"
					+ personDetail.getMiddleName()
					+ "','"
					+ personDetail.getLastName()
					+ "','"
					+ personDetail.getGender() + "' ,'" + usersDetail.getUserName() + "',?, 'active','Rahul',?,'Rahul',?,?," + " 1 )";

			

			// String sql1 =
			// "INSERT INTO EmailAddress(emailAddressID, emailAddress, recordStatus, versionNo)"
			// +
			// "VALUES(EmailAddressSEQ.nextval, '"+personDetail.getEmailAddress()+"','active',1)";

			// String sql2 =
			// "INSERT INTO Address(addressId, streetOne, streetTwo, aptUnit, city, county, state, country, zipCode, versionNo)"
			// +
			// "VALUES(AddressSEQ.naxtval, '"+personDetail.getStreetOne()+"', '"+personDetail.getStreetTwo()+"', '"+personDetail.getAptUnit()+"', '"+personDetail.getCity()+"', '"+personDetail.getCounty()+"', '"+personDetail.getState()+"', '"+personDetail.getCountry()+"', '"+personDetail.getZipCode()+"', 1)";

			try {
				//connection = dbConnection.getDBConnection();

				preparedStatement = connection.prepareStatement(usersSQLStr);

				preparedStatement.execute();

				PreparedStatement preparedStatement1 = connection.prepareStatement(personSQLStr);

				preparedStatement1.setInt(1, personDetail.getPersonID());
				preparedStatement1.setDate(2, personDetail.getDateOfBirth());

				String crrentDateTime = JavaUtildates.getCurrentDateTime();

				Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
				preparedStatement1.setTimestamp(3, timestamp);
				preparedStatement1.setTimestamp(4, timestamp);
				preparedStatement1.setTimestamp(5, timestamp);

				preparedStatement1.execute();
				
				CreateEmailAddressDAO createEmailAddressDAO = new CreateEmailAddressDAO();
				createEmailAddressDAO.createEmailAddress(emailAddressDetail);
				
				CreatePhoneNumberDAO createPhoneNumberDAO = new CreatePhoneNumberDAO();
				createPhoneNumberDAO.createPhoneNumber(phoneNumberDetail);

				// PreparedStatement preparedStatement2 =
				// connection.prepareStatement(sql1);
				// preparedStatement2.execute();

				/*
				 * PreparedStatement preparedStatement3 = connection
				 * .prepareStatement(sql2); preparedStatement3.execute();
				 */

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
			} catch (SQLException e) {
				personDetail.getErrorMessageList().add("Username already exist");
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
