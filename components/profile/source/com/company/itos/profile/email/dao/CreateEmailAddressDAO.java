package com.company.itos.profile.email.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.JavaUtildates;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.type.UniqueID;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;

public class CreateEmailAddressDAO {

	public String createEmailAddress(EmailAddressLinkDetail emailAddressLinkDetail) {

		String returnMassegeStr = "";

		Connection connection = null;
		try {

			EmailAddressDetail emailAddressDetail = emailAddressLinkDetail.getEmailAddressDetail();

			connection = DBConnection.getDBConnection();

			String emailAddressSQLStr = "INSERT INTO EmailAddress ( emailAddressID, emailAddress, recordStatus, versionNo) "
					+ "VALUES(?,  ?, 'Active', 1)";

			PreparedStatement preparedStatementEmailAddress = connection.prepareStatement(emailAddressSQLStr);

			long emailAddressID = UniqueID.nextUniqueID();

			preparedStatementEmailAddress.setLong(1, emailAddressID);
			preparedStatementEmailAddress.setString(2, emailAddressDetail.getEmailAddress());

			preparedStatementEmailAddress.execute();

			// EmailaddressLink table code

			String emailAddressLinkSQLStr = "INSERT INTO EmailAddressLink ( emailAddressLinkID, relatedID, emailAddressID, typeCode, primaryInd, startDate, endDate, recordStatus, versionNo) "
					+ "VALUES(?, ? , ?, '"
					+ emailAddressLinkDetail.getTypeCode()
					+ "', '"
					+ emailAddressLinkDetail.getPrimaryInd()
					+ "', ?, ?, 'Active', 1)";

			PreparedStatement preparedStatementEmailAddressLink = connection.prepareStatement(emailAddressLinkSQLStr);
			
			Long emailAddressLinkID = UniqueID.nextUniqueID();

			preparedStatementEmailAddressLink.setLong(1, emailAddressLinkID);
			preparedStatementEmailAddressLink.setLong(2, emailAddressLinkDetail.getRelatedID());
			preparedStatementEmailAddressLink.setLong(3, emailAddressID);
			preparedStatementEmailAddressLink.setDate(4, JavaUtildates.convertUtilToSql(emailAddressLinkDetail.getStartDate()));
			preparedStatementEmailAddressLink.setDate(5, JavaUtildates.convertUtilToSql(emailAddressLinkDetail.getStartDate()));

			preparedStatementEmailAddressLink.execute();
			emailAddressLinkDetail.setEmailAddressLinkID(emailAddressLinkID);
			
			//inserting data into AuditTrail Table for Email Table
			AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
			
			auditTrailDetails.setTableName("Email");
			auditTrailDetails.setOperationType("Create");
			auditTrailDetails.setUserName("Rahul");
			auditTrailDetails.setRelatedID(emailAddressLinkID);
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
