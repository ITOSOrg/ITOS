package com.company.itos.profile.personIdentity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.type.UniqueID;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.JavaUtildates;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

public class CreatePersonIdentityDAO {

	public String CreatePersonIdentity(PersonIdentityDetail personIdentityDetail) {

		String returnMassegeStr = "";

		Connection connection = null;
		try {

			connection = DBConnection.getDBConnection();

			String personIdentitySQLStr = "INSERT INTO PersonIdentity ( personIdentityID, personID, alternateID, primaryInd, typeCode, startDate, endDate, recordStatus, versionNo) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, 'Active', 1)";

			PreparedStatement preparedStatementpersonIdentity = connection.prepareStatement(personIdentitySQLStr);
			
			Long personIdentityID = UniqueID.nextUniqueID();

			preparedStatementpersonIdentity.setLong(1, personIdentityID);
			preparedStatementpersonIdentity.setLong(2, personIdentityDetail.getPersonID());
			preparedStatementpersonIdentity.setString(3, personIdentityDetail.getAlternateID());
			preparedStatementpersonIdentity.setString(4, personIdentityDetail.getPrimaryInd());
			preparedStatementpersonIdentity.setString(5, personIdentityDetail.getTypeCode());
			preparedStatementpersonIdentity.setDate(6, JavaUtildates.convertUtilToSql(personIdentityDetail.getStartDate()));
			preparedStatementpersonIdentity.setDate(7, JavaUtildates.convertUtilToSql(personIdentityDetail.getEndDate()));

			preparedStatementpersonIdentity.executeQuery();
			
			personIdentityDetail.setPersonIdentityID(personIdentityID);
			
			//inserting data into AuditTrail Table for PersonIdentity Table
			AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
			
			auditTrailDetails.setTableName("PersonIdentity");
			auditTrailDetails.setOperationType("Create");
			auditTrailDetails.setUserName("Rahul");
			auditTrailDetails.setRelatedID(personIdentityID);
			auditTrailDetails.setTransactionType("Online");
			
			CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
			createAuditTrailDAO.createAuditTrail(auditTrailDetails);


			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;

	}

}
