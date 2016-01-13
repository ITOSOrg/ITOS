package com.company.itos.profile.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.JavaUtildates;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;
import com.company.itos.profile.person.pojo.PersonDetail;

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

			try {
				connection = DBConnection.getDBConnection();
				String personSQLStr = "UPDATE	PERSON	SET title='" + personDetail.getTitle() + "',	firstName='"
						+ personDetail.getFirstName() + "', middleName='" + personDetail.getMiddleName() + "', lastName='"
						+ personDetail.getLastName() + "', gender='" + personDetail.getGender() + "', dateOfBirth = ? , versionNo ='"
						+ versionNoFromDatabase + "' " + "	where	personID='" + personDetail.getPersonID() + "'";

				preparedStatement = connection.prepareStatement(personSQLStr);

				preparedStatement.setDate(1, JavaUtildates.convertUtilToSql(personDetail.getDateOfBirth()));
				preparedStatement.executeUpdate();
				
				//inserting data into AuditTrail Table for Person Table
				AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
				
				auditTrailDetails.setTableName("Person");
				auditTrailDetails.setOperationType("Update");
				auditTrailDetails.setUserName("Rahul");
				auditTrailDetails.setRelatedID(personDetail.getPersonID());
				auditTrailDetails.setTransactionType("Online");
				
				CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else {
			personDetail.getErrorMessageList().add("This Record has been already modified by another user, Please check");
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;

	}

	public int returnVersionNumber(PersonDetail personDetail) {

		int versionNumber = 0;
		try {
			Connection connection = DBConnection.getDBConnection();

			String personSQLStr = "SELECT	versionNo	FROM	PERSON	WHERE	 personID='" + personDetail.getPersonID() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(personSQLStr);

			resultSet = preparedStatement.executeQuery();
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

			Connection connection = DBConnection.getDBConnection();
			// PersonDetail personDetail = new PersonDetail();
			String PersonSQLStr = "UPDATE	PERSON	SET	versionNo	=	versionNo+1	WHERE	personID='" + personDetail.getPersonID() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(PersonSQLStr);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	


}
