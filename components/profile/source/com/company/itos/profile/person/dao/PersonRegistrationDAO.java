package com.company.itos.profile.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.role.pojo.RoleDetail;
import com.company.itos.core.userrolelink.dao.CreateUserRoleLinkDAO;
import com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.JavaUtildates;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.type.UniqueID;
import com.company.itos.profile.address.dao.CreateAddressDAO;
import com.company.itos.profile.address.pojo.AddressLinkDetail;
import com.company.itos.profile.email.dao.CreateEmailAddressDAO;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;
import com.company.itos.profile.person.pojo.PersonDetail;
import com.company.itos.profile.person.pojo.PersonSearchCriteria;
import com.company.itos.profile.person.pojo.PersonSearchDetails;
import com.company.itos.profile.person.pojo.UsersDetail;
import com.company.itos.profile.personIdentity.dao.CreatePersonIdentityDAO;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;
import com.company.itos.profile.phone.dao.CreatePhoneNumberDAO;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

/**
 * PersonRegistrationDAO class create logic for person registration
 */
public class PersonRegistrationDAO {

	/**
	 * 
	 * @param personDetail
	 * @return
	 */
	public String registerPerson(PersonDetail personDetail) {

		PreparedStatement preparedStatement = null;
		String returnMassegeStr = "";
		boolean personExistInd = personExist(personDetail);
		boolean userNameExistInd = checkUserNameExist(personDetail);

		if (!personExistInd && !userNameExistInd) {

			UsersDetail usersDetail = personDetail.getUsersDetail();
			EmailAddressLinkDetail emailAddressLinkDetail = personDetail.getEmailAddressLinkDetail();
			PhoneNumberLinkDetail phoneNumberLinkDetail = personDetail.getPhoneNumberLinkDetail();
			AddressLinkDetail addressLinkDetail = personDetail.getAddressLinkDetail();
			PersonIdentityDetail personIdentityDetail = personDetail.getPersonIdentityDetail();

			Connection connection = null;
			try {
				connection = DBConnection.getDBConnection();

				String usersSQLStr = "INSERT	INTO	USERS(userName, password, recordStatus, relatedID)	VALUES('" + usersDetail.getUserName()
						+ "','" + usersDetail.getPassword() + "','active', ?)";
				preparedStatement = connection.prepareStatement(usersSQLStr);
				long relatedID = UniqueID.nextUniqueID();
				preparedStatement.setLong(1, relatedID);

				preparedStatement.execute();

				emailAddressLinkDetail.setRelatedID(relatedID);
				phoneNumberLinkDetail.setRelatedID(relatedID);
				personDetail.setPersonID(relatedID);
				addressLinkDetail.setRelatedID(relatedID);
				personIdentityDetail.setPersonID(relatedID);

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
						+ "' ,'" + usersDetail.getUserName() + "',?, 'Active','Rahul',?,'Rahul',?,?," + " 1 )";

				PreparedStatement preparedStatement1 = connection.prepareStatement(personSQLStr);

				preparedStatement1.setLong(1, personDetail.getPersonID());
				preparedStatement1.setDate(2, JavaUtildates.convertUtilToSql(personDetail.getDateOfBirth()));

				String crrentDateTime = JavaUtildates.getCurrentDateTime();

				Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
				preparedStatement1.setTimestamp(3, timestamp);
				preparedStatement1.setTimestamp(4, timestamp);
				preparedStatement1.setTimestamp(5, timestamp);

				preparedStatement1.execute();
				
				//inserting data into AuditTrail Table for Person Table
				AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
				
				auditTrailDetails.setTableName("Person");
				auditTrailDetails.setOperationType("Create");
				auditTrailDetails.setUserName(usersDetail.getUserName());
				auditTrailDetails.setRelatedID(personDetail.getPersonID());
				auditTrailDetails.setTransactionType("Online");
				
				CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);
				
				//Inserting data into EmailAddress Table
				CreateEmailAddressDAO createEmailAddressDAO = new CreateEmailAddressDAO();
				createEmailAddressDAO.createEmailAddress(emailAddressLinkDetail);
				
				//inserting data into AuditTrail Table for Email Table
				
				auditTrailDetails.setTableName("Email");
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);
				
				//Inserting data into PhoneNumber Table
				CreatePhoneNumberDAO createPhoneNumberDAO = new CreatePhoneNumberDAO();
				createPhoneNumberDAO.createPhoneNumber(phoneNumberLinkDetail);
				
				//inserting data into AuditTrail Table for PhoneNumber Table
				
				auditTrailDetails.setTableName("PhoneNumber");
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);
				
				//Inserting data into Address Table
				CreateAddressDAO createAddressDAO = new CreateAddressDAO();
				createAddressDAO.createAddress(addressLinkDetail);
				
				//inserting data into AuditTrail Table for Address Table
				
				auditTrailDetails.setTableName("Address");
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);
				
				//Inserting data into PersonIdentity Table
				CreatePersonIdentityDAO createPersonIdentityDAO = new CreatePersonIdentityDAO();
				createPersonIdentityDAO.CreatePersonIdentity(personIdentityDetail);
				
				//inserting data into AuditTrail Table for PersonIdentity Table
				
				auditTrailDetails.setTableName("PersonIdentity");
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);
				

				// For Role table

				RoleDetail roleDetail = personDetail.getRoleDetail();

				// For UserRoleLink
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

			} catch (Exception e) {
				personDetail.getErrorMessageList().add("Main exception");
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

		boolean personExistInd = false;

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

				personExistInd = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return personExistInd;

	}

	public boolean checkUserNameExist(PersonDetail personDetail) {

		Connection connection = null;
		try {
			connection = DBConnection.getDBConnection();

			String usersSQLStr = "SELECT userName FROM USERS where userName='" + personDetail.getUsersDetail().getUserName() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(usersSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				personDetail.getErrorMessageList().add("UserName already exist");
				return true;

			}

		} catch (Exception E) {

		}

		return false;
	}

}
