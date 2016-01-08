package com.company.itos.profile.personIdentity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.JavaUtildates;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

public class UpdatePersonIdentityDAO {

	public String UpdatePersonIdentity(PersonIdentityDetail personIdentityDetail) {

		Connection connection = null;
		String returnMassegeStr = "";

		int personIdentityVersionNoFromUpdate = personIdentityDetail.getVersionNo();

		int personIdentityVersionNoFromDatabase = returnVersionNumberFromPersonIdentity(personIdentityDetail);

		if (personIdentityVersionNoFromUpdate == personIdentityVersionNoFromDatabase) {

			personIdentityVersionNoFromDatabase++;

			try {
				connection = DBConnection.getDBConnection();
				String personIdentitySQLStr = "UPDATE	PersonIdentity	SET alternateID = ?, primaryInd = ?, typeCode = ?, startDate = ?, endDate = ?"
						+ " WHERE personIdentityID = '" + personIdentityDetail.getPersonIdentityID() + "'";

				PreparedStatement preparedStatementpersonIdentity = connection.prepareStatement(personIdentitySQLStr);

				preparedStatementpersonIdentity.setString(1, personIdentityDetail.getAlternateID());
				preparedStatementpersonIdentity.setString(2, personIdentityDetail.getPrimaryInd());
				preparedStatementpersonIdentity.setString(3, personIdentityDetail.getTypeCode());
				preparedStatementpersonIdentity.setDate(4, JavaUtildates.convertUtilToSql(personIdentityDetail.getStartDate()));
				preparedStatementpersonIdentity.setDate(5, JavaUtildates.convertUtilToSql(personIdentityDetail.getEndDate()));

				preparedStatementpersonIdentity.executeUpdate();
				
				//inserting data into AuditTrail Table for PersonIdentity Table
				AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
				
				auditTrailDetails.setTableName("PersonIdentity");
				auditTrailDetails.setOperationType("Update");
				String username = returnUserName(personIdentityDetail);
				auditTrailDetails.setUserName(username);
				auditTrailDetails.setRelatedID(personIdentityDetail.getPersonID());
				auditTrailDetails.setTransactionType("Online");
				
				CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {

				e.printStackTrace();
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
			}
		}
		return returnMassegeStr;
	}

	public int returnVersionNumberFromPersonIdentity(PersonIdentityDetail personIdentityDetail) {

		int versionNo = 0;
		try {

			Connection connection = DBConnection.getDBConnection();

			String emailAddressSQLStr = "SELECT	versionNo, personID	FROM	PersonIdentity	WHERE	 personIdentityID = '"
					+ personIdentityDetail.getPersonIdentityID() + "'";

			PreparedStatement preparedStatement = connection.prepareStatement(emailAddressSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				versionNo = resultSet.getInt("versionNo");
				personIdentityDetail.setPersonID(resultSet.getLong("personID"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return versionNo;
	}
	
public String returnUserName(PersonIdentityDetail personIdentityDetail) throws SQLException{
		
		String username = null;
		Connection connection = DBConnection.getDBConnection();
		
		String usersSQLStr = "SELECT userName FROM Users WHERE relatedID=\'" + personIdentityDetail.getPersonID() + "\'";
		PreparedStatement preparedStatementusers = connection.prepareStatement(usersSQLStr);

		ResultSet resultSetUsers = preparedStatementusers.executeQuery();

		while (resultSetUsers.next()) {
			 username = resultSetUsers.getString("userName");
		}
		
		return username;
		
	}

}
