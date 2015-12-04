package com.company.itos.profile.person.dao;

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

import com.company.itos.core.role.dao.CreateRoleDAO;
import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.userrolelink.dao.CreateUserRoleLinkDAO;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.core.util.JavaUtildates;
import com.company.itos.profile.address.dao.CreateAddressDAO;
import com.company.itos.profile.address.pojo.AddressLinkDetail;
import com.company.itos.profile.email.dao.CreateEmailAddressDAO;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;
import com.company.itos.profile.person.pojo.PersonDetail;
import com.company.itos.profile.person.pojo.PersonSearchCriteria;
import com.company.itos.profile.person.pojo.PersonSearchDetails;
import com.company.itos.profile.person.pojo.UsersDetail;
import com.company.itos.profile.personIdentity.dao.CreatePersonIdentityDAO;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;
import com.company.itos.profile.phone.dao.CreatePhoneNumberDAO;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

/**
 * PersonRegistrationDAO class create logic for person registration
 */
public class PersonRegistrationDAO {

	ResultSet resultSet;

	public String registerPerson(PersonDetail personDetail) {

		PreparedStatement preparedStatement = null;
		String returnMassegeStr = "";
		boolean personExistInd = personExist(personDetail);
		boolean userNameExistInd = checkingUserName(personDetail);

		if (!personExistInd && !userNameExistInd) {

			UsersDetail usersDetail = personDetail.getUsersDetail();
			EmailAddressLinkDetail emailAddressLinkDetail = personDetail.getEmailAddressLinkDetail();
			PhoneNumberLinkDetail phoneNumberLinkDetail = personDetail.getPhoneNumberLinkDetail();
			AddressLinkDetail addressLinkDetail = personDetail.getAddressLinkDetail();
			PersonIdentityDetail personIdentityDetail = personDetail.getPersonIdentityDetail();

			String usersSQLStr = "INSERT	INTO	USERS(userName, password, recordStatus, relatedID)	VALUES('" + usersDetail.getUserName()
					+ "','" + usersDetail.getPassword() + "','active', ?)";

			DBConnection dbConnection = new DBConnection();

			Connection connection = null;

			Statement statement = null;
			try {
				connection = dbConnection.getDBConnection();
				statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT PersonSEQ.nextval FROM DUAL");

				if (resultSet.next()) {
					emailAddressLinkDetail.setRelatedID(resultSet.getInt(1));
					phoneNumberLinkDetail.setRelatedID(resultSet.getInt(1));
					personDetail.setPersonID(resultSet.getInt(1));
					addressLinkDetail.setRelatedID(resultSet.getInt(1));
					personIdentityDetail.setPersonID(resultSet.getInt(1));
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
					+ personDetail.getGender()
					+ "' ,'"
					+ usersDetail.getUserName() + "',?, 'active','Rahul',?,'Rahul',?,?," + " 1 )";

			// String sql1 =
			// "INSERT INTO EmailAddress(emailAddressID, emailAddress, recordStatus, versionNo)"
			// +
			// "VALUES(EmailAddressSEQ.nextval, '"+personDetail.getEmailAddress()+"','active',1)";

			// String sql2 =
			// "INSERT INTO Address(addressId, streetOne, streetTwo, aptUnit, city, county, state, country, zipCode, versionNo)"
			// +
			// "VALUES(AddressSEQ.naxtval, '"+personDetail.getStreetOne()+"', '"+personDetail.getStreetTwo()+"', '"+personDetail.getAptUnit()+"', '"+personDetail.getCity()+"', '"+personDetail.getCounty()+"', '"+personDetail.getState()+"', '"+personDetail.getCountry()+"', '"+personDetail.getZipCode()+"', 1)";

			try {
				// connection = dbConnection.getDBConnection();

				preparedStatement = connection.prepareStatement(usersSQLStr);
				preparedStatement.setInt(1, personDetail.getPersonID());

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
				createEmailAddressDAO.createEmailAddress(emailAddressLinkDetail);

				CreatePhoneNumberDAO createPhoneNumberDAO = new CreatePhoneNumberDAO();
				createPhoneNumberDAO.createPhoneNumber(phoneNumberLinkDetail);

				CreateAddressDAO createAddressDAO = new CreateAddressDAO();
				createAddressDAO.createAddress(addressLinkDetail);
				
				CreatePersonIdentityDAO createPersonIdentityDAO = new CreatePersonIdentityDAO();
				createPersonIdentityDAO.CreatePersonIdentity(personIdentityDetail);

				//For Role table
				
				RoleDetail roleDetail = personDetail.getRoleDetail();
				
				
				//For UserRoleLink
				UserRoleLinkDetail userRoleLinkDetail = new UserRoleLinkDetail();
				userRoleLinkDetail.setUsername(usersDetail.getUserName());
				userRoleLinkDetail.setRoleID(roleDetail.getRoleID());
				CreateUserRoleLinkDAO createUserRoleLinkDAO = new CreateUserRoleLinkDAO();
				createUserRoleLinkDAO.createUserRoleLinkUsingRegistrationform(userRoleLinkDetail);
				
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
			String usersSQLStr = "select userName from USERS where userName='" + personDetail.getUsersDetail().getUserName() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(usersSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();
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
