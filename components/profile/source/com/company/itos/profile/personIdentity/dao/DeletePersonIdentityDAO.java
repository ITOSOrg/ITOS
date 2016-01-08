package com.company.itos.profile.personIdentity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

public class DeletePersonIdentityDAO {

	public String DeletePersonIdentity(PersonIdentityDetail personIdentityDetail) {

		Connection connection = null;
		String returnMassegeStr = "";
		try {

			connection = DBConnection.getDBConnection();

			String PersonIdentitySQLStr = "UPDATE PersonIdentity SET	recordStatus='cancel'	WHERE personIdentityID= "
					+ personIdentityDetail.getPersonIdentityID();
			PreparedStatement preparedStatement = connection.prepareStatement(PersonIdentitySQLStr);
			preparedStatement.executeUpdate();
			
			//inserting data into AuditTrail Table for PersonIdentity Table
			AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
			
			auditTrailDetails.setTableName("PersonIdentity");
			auditTrailDetails.setOperationType("Delete");
			
			UpdatePersonIdentityDAO updatePersonIdentityDAO = new UpdatePersonIdentityDAO();
			String username = updatePersonIdentityDAO.returnUserName(personIdentityDetail);
			
			auditTrailDetails.setUserName(username);
			auditTrailDetails.setRelatedID(personIdentityDetail.getPersonID());
			auditTrailDetails.setTransactionType("Online");
			
			CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
			createAuditTrailDAO.createAuditTrail(auditTrailDetails);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

	}

}
