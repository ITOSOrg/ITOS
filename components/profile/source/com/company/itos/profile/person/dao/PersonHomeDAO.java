package com.company.itos.profile.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.codetable.dao.ReadCodeTableItemDAO;
import com.company.itos.core.codetable.pojo.CodeTableItemKey;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.address.dao.ReadAddressDAO;
import com.company.itos.profile.address.pojo.AddressLinkDetail;
import com.company.itos.profile.email.dao.ReadEmailAddressDAO;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;
import com.company.itos.profile.person.pojo.PersonDetail;
import com.company.itos.profile.person.pojo.UsersDetail;
import com.company.itos.profile.personIdentity.dao.ReadPersonIdentityDAO;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;
import com.company.itos.profile.phone.dao.ReadPhoneNumberDAO;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

public class PersonHomeDAO {

	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Statement statement = null;
	String returnMassegeStr = "";

	/**
	 * method for reading student data from database
	 */
	// public PersonDetail readPersonDetail(UsersDetail usersDetail) {
	public String readPersonDetail(PersonDetail personDetail) {

		// PersonDetail personDetail = new PersonDetail();

		/**
		 * query to extract person details of matched username
		 */
		String personSQLStr = "SELECT * FROM PERSON WHERE  personID=\'" + personDetail.getPersonID() + "\' ";

		try {

			Connection connection = DBConnection.getDBConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(personSQLStr);

			// System.out.println(preparedStatement.);
			resultSet = preparedStatement.executeQuery();
			/**
			 * if resultSet contains values then set it to the respected
			 * attribute
			 */

			if (resultSet.next()) {

				personDetail.setPersonID(resultSet.getLong("personID"));
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

			// For User

			String usersSQLStr = "SELECT * FROM Users WHERE relatedID=\'" + personDetail.getPersonID() + "\'";
			PreparedStatement preparedStatementusers = connection.prepareStatement(usersSQLStr);

			ResultSet resultSetUsers = preparedStatementusers.executeQuery();

			while (resultSetUsers.next()) {
				personDetail.setUserName(resultSetUsers.getString("userName"));
			}

			// For Gender
			CodeTableItemKey codeTableItemKey = new CodeTableItemKey();
			codeTableItemKey.setCode(personDetail.getGender());

			codeTableItemKey.setTableName("Gender");

			ReadCodeTableItemDAO readCodeTableItemDAO = new ReadCodeTableItemDAO();
			readCodeTableItemDAO.readCodeTableItemDescription(codeTableItemKey);

			personDetail.setGender(codeTableItemKey.getDescription());

			// Read emailAddress information
			EmailAddressLinkDetail emailAddressLinkDetail = new EmailAddressLinkDetail();
			emailAddressLinkDetail.setRelatedID(personDetail.getPersonID());

			ReadEmailAddressDAO readEmailAddressDAO = new ReadEmailAddressDAO();
			readEmailAddressDAO.readPrimaryEmailAddress(emailAddressLinkDetail);
			personDetail.setEmailAddressLinkDetail(emailAddressLinkDetail);

			// Read phoneNumber information

			PhoneNumberLinkDetail phoneNumberLinkDetail = new PhoneNumberLinkDetail();
			phoneNumberLinkDetail.setRelatedID(personDetail.getPersonID());

			ReadPhoneNumberDAO readPhoneNumberDAO = new ReadPhoneNumberDAO();
			readPhoneNumberDAO.readPrimaryPhoneNumber(phoneNumberLinkDetail);
			personDetail.setPhoneNumberLinkDetail(phoneNumberLinkDetail);

			// Read Address information
			AddressLinkDetail addressLinkDetail = new AddressLinkDetail();
			addressLinkDetail.setRelatedID(personDetail.getPersonID());

			ReadAddressDAO readAddressDAO = new ReadAddressDAO();
			readAddressDAO.readPrimaryAddress(addressLinkDetail);
			personDetail.setAddressLinkDetail(addressLinkDetail);

			// Read PersonIdentity Information
			PersonIdentityDetail personIdentityDetail = new PersonIdentityDetail();
			personIdentityDetail.setPersonID(personDetail.getPersonID());

			ReadPersonIdentityDAO readPersonIdentityDAO = new ReadPersonIdentityDAO();
			readPersonIdentityDAO.readPrimaryPersonIdentity(personIdentityDetail);
			personDetail.setPersonIdentityDetail(personIdentityDetail);

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

		} catch (SQLException e) {
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
			e.printStackTrace();
		}
		/**
		 * personDetail contains all attribute values
		 */
		return returnMassegeStr;
	}


}
