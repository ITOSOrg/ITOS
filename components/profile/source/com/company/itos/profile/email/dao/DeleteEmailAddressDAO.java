package com.company.itos.profile.email.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;

public class DeleteEmailAddressDAO {
	public String deleteEmailAddress(EmailAddressLinkDetail emailAddressLinkDetail) {
		Connection connection = null;
		String returnMassegeStr = "";
		try {

			EmailAddressDetail emailAddressDetail = emailAddressLinkDetail.getEmailAddressDetail();


			String EmailAddressLinkSQLStr = "UPDATE EmailAddressLink SET	RECORDSTATUS='cancel'	WHERE emailAddressLinkID= "
					+ emailAddressLinkDetail.getEmailAddressLinkID();

			connection = DBConnection.getDBConnection();

			String emailAddressSQLStr = "UPDATE	EmailAddress	SET	RECORDSTATUS='cancel'	WHERE emailAddressID = "
					+ emailAddressLinkDetail.getEmailAddressID();
			
			PreparedStatement PreparedStatementEmailAddress = connection.prepareStatement(emailAddressSQLStr);
			PreparedStatementEmailAddress.executeUpdate();

			PreparedStatement preparedStatementEmailAddressLink = connection.prepareStatement(EmailAddressLinkSQLStr);
			preparedStatementEmailAddressLink.executeUpdate();
			
			//inserting data into AuditTrail Table for Email Table
			AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
			
			auditTrailDetails.setTableName("Email");
			auditTrailDetails.setOperationType("Delete");
			auditTrailDetails.setUserName("Rahul");
			auditTrailDetails.setRelatedID(emailAddressLinkDetail.getRelatedID());
			auditTrailDetails.setTransactionType("Online");
			
			CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
			createAuditTrailDAO.createAuditTrail(auditTrailDetails);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

	}

}
