package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.EmailAddressDetail;
import com.company.itos.profile.pojo.PersonDetail;
import com.company.itos.profile.pojo.PhoneNumberDetail;
import com.company.itos.profile.pojo.UsersDetail;

public class PersonHomeDAO {

	
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Statement statement = null;
	DBConnection dbConnection = new DBConnection();

	/**
	 * method for reading student data from database
	 */
	public PersonDetail readPersonDetail(UsersDetail usersDetail) {

		PersonDetail personDetail = new PersonDetail();

		/**
		 * query to extract person details of matched username
		 */
		String personSQLStr = "SELECT * FROM PERSON WHERE  USERNAME=\'" + usersDetail.getUserName() + "\' ";

		try {

			Connection connection = dbConnection.getDBConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(personSQLStr);
			/**
			 * if resultSet contains values then set it to the respected
			 * attribute
			 */

			if (resultSet.next()) {

				personDetail.setPersonID(resultSet.getInt("personID"));
				personDetail.setRefrenceNumber(resultSet.getInt("refrenceNumber"));
				personDetail.setTitle(resultSet.getString("title"));
				personDetail.setFirstName(resultSet.getString("firstName"));
				personDetail.setMiddleName(resultSet.getString("middleName"));
				personDetail.setLastName(resultSet.getString("lastName"));
				personDetail.setDateOfBirth(resultSet.getDate("dateOfBirth"));
				personDetail.setGender(resultSet.getString("gender"));
				personDetail.setRecordStatus(resultSet.getString("recordStatus"));
				personDetail.setCreatedBy(resultSet.getString("createdBy"));
				personDetail.setCreatedOn(resultSet.getTimestamp("createdOn"));
				personDetail.setModifiedBy(resultSet.getString("modifiedBy"));
				personDetail.setModifiedOn(resultSet.getTimestamp("modifiedOn"));
				personDetail.setRegistrationDate(resultSet.getTimestamp("registrationDate"));
				personDetail.setVersionNo(resultSet.getInt("versionNo"));
			}
			
			//Read emailAddress information
			EmailAddressDetail emailAddressDetail = new EmailAddressDetail();

			String EmailAddressLinkSQLStr = "SELECT EmailAddressLinkID FROM EmailAddressLink WHERE relatedID='"+personDetail.getPersonID()+"' AND primaryInd = '1'";
			

			statement = connection.createStatement();

			resultSet = statement.executeQuery(EmailAddressLinkSQLStr);
			if(resultSet.next())
			{
				emailAddressDetail.setEmailAddressLinkID(resultSet.getInt("emailAddressLinkID"));
			}
			
			ReadEmailAddressDAO readEmailAddressDAO = new ReadEmailAddressDAO();
			readEmailAddressDAO.readEmailAddress(emailAddressDetail);
			personDetail.setEmailAddressDetail(emailAddressDetail);
			
			//Read phoneNumber information
			
			PhoneNumberDetail phoneNumberDetail = new PhoneNumberDetail();
			
			String PhoneNumberLinkSQLStr = "SELECT phoneNumberLinkID FROM PhoneNumberLink WHERE relatedID='"+personDetail.getPersonID()+"' AND primaryInd = '1'";
			
			statement = connection.createStatement();

			resultSet = statement.executeQuery(PhoneNumberLinkSQLStr);
			if(resultSet.next())
			{
				phoneNumberDetail.setPhoneNumberLinkID(resultSet.getInt("phoneNumberLinkID"));
			}
			
			ReadPhoneNumberDAO readPhoneNumberDAO = new ReadPhoneNumberDAO();
			readPhoneNumberDAO.ReadPhoneNumber(phoneNumberDetail);
			personDetail.setPhoneNumberDetail(phoneNumberDetail);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/**
		 * personDetail contains all attribute values
		 */
		return personDetail;
	}

	/*
	 * public EmailAddressDetail getEmailAddressLinkID(EmailAddressDetail
	 * emailAddressDetail) {
	 * 
	 * Connection connection; try { connection = dbConnection.getDBConnection();
	 * statement = connection.createStatement();
	 * 
	 * String EmailAddressLinkSQLStr =
	 * "SELECT emailAddressLinkID FROM EmailAddressLink where relatedID = \'"
	 * +emailAddressDetail.getRelatedID()+"\'"; ResultSet resultSet =
	 * statement.executeQuery("EmailAddressLinkSQLStr"); if(resultSet.next()) {
	 * 
	 * emailAddressDetail.setEmailAddressLinkID(resultSet.getInt(
	 * "emailAddressLinkID")); }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * return emailAddressDetail;
	 * 
	 * }
	 */

}
