package com.company.itos.profile.email.dao;

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
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;
import com.company.itos.profile.person.pojo.PersonDetail;

public class UpdateEmailAddressDAO {

	public String updateEmailAddress(EmailAddressLinkDetail emailAddressLinkDetail) {
		Connection connection = null;
		ResultSet resultSet = null;
		String returnMassegeStr = "";
		// returnVersionNumber(emailAddressDetail);

		EmailAddressDetail emailAddressDetail = emailAddressLinkDetail.getEmailAddressDetail();

		int emailAddressLinkVersionNoFromUpdate = emailAddressLinkDetail.getVersionNo();

		int EmailAddressLinkVersionNoFromDatabase = returnVersionNumberFromEmailAddressLink(emailAddressLinkDetail);

		int emailAddressVersionNoFromUpdate = emailAddressDetail.getVersionNo();

		int EmailAddressVersionNoFromDatabase = returnVersionNumberFromEmailAddress(emailAddressLinkDetail);

		if (emailAddressLinkVersionNoFromUpdate == EmailAddressLinkVersionNoFromDatabase) {

			if (emailAddressVersionNoFromUpdate == EmailAddressVersionNoFromDatabase) {

				EmailAddressLinkVersionNoFromDatabase++;

				EmailAddressVersionNoFromDatabase++;

				try {

					connection = DBConnection.getDBConnection();

					String updateEmailAddressSqlStr = "UPDATE	EmailAddress	SET emailAddress = '" + emailAddressDetail.getEmailAddress()
							+ "'" + " WHERE emailAddressID = '" + emailAddressLinkDetail.getEmailAddressID() + "'";

					PreparedStatement preparedStatement = connection.prepareStatement(updateEmailAddressSqlStr);
					preparedStatement.executeUpdate();

					String updateEmailAddressLinkSqlStr = "UPDATE EmailAddressLink SET typeCode = '" + emailAddressLinkDetail.getTypeCode()
							+ "', primaryInd = '" + emailAddressLinkDetail.getPrimaryInd() + "', startDate = ?, endDate = ?"
							+ " WHERE emailAddressLinkID = '" + emailAddressLinkDetail.getEmailAddressLinkID() + "'";

					PreparedStatement preparedStatement1 = connection.prepareStatement(updateEmailAddressLinkSqlStr);
					preparedStatement1.setDate(1, JavaUtildates.convertUtilToSql(emailAddressLinkDetail.getStartDate()));
					preparedStatement1.setDate(2, JavaUtildates.convertUtilToSql(emailAddressLinkDetail.getEndDate()));
					preparedStatement1.executeUpdate();
					
					//inserting data into AuditTrail Table for Email Table
					AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
					
					auditTrailDetails.setTableName("Email");
					auditTrailDetails.setOperationType("Update");
					auditTrailDetails.setUserName("Rahul");
					auditTrailDetails.setRelatedID(emailAddressLinkDetail.getEmailAddressLinkID());
					auditTrailDetails.setTransactionType("Online");
					
					CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
					createAuditTrailDAO.createAuditTrail(auditTrailDetails);

					returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

				} catch (SQLException e) {

					e.printStackTrace();
					returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
				}
			}
		}
		return returnMassegeStr;
	}

	public int returnVersionNumberFromEmailAddressLink(EmailAddressLinkDetail emailAddressLinkDetail) {

		int versionNo = 0;
		try {

			Connection connection = DBConnection.getDBConnection();

			String emailAddressSQLStr = "SELECT	versionNo, relatedID, emailAddressID	FROM	EmailAddressLink	WHERE	 emailAddressLinkID = '"
					+ emailAddressLinkDetail.getEmailAddressLinkID() + "'";
			PreparedStatement PreparedStatementReturnVersionNumberFromEmailAddressLink = connection.prepareStatement(emailAddressSQLStr);

			ResultSet resultSet = PreparedStatementReturnVersionNumberFromEmailAddressLink.executeQuery();
			if (resultSet.next()) {

				versionNo = resultSet.getInt("versionNo");
				emailAddressLinkDetail.setRelatedID(resultSet.getLong("relatedID"));
				emailAddressLinkDetail.setEmailAddressID(resultSet.getLong("emailAddressID"));
				// emailAddressDetail.setVersionNo(resultSet.getInt("versionNo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return versionNo;
	}

	public int returnVersionNumberFromEmailAddress(EmailAddressLinkDetail emailAddressLinkDetail) {

		int versionNo = 0;
		try {

			Connection connection = DBConnection.getDBConnection();

			String emailAddressSQLStr = "SELECT	versionNo	FROM	EmailAddress	WHERE	 emailAddressID = '"
					+ emailAddressLinkDetail.getEmailAddressID() + "'";
			PreparedStatement preparedStatementReturnVersionNumberFromEmailAddress = connection.prepareStatement(emailAddressSQLStr);

			ResultSet resultSet = preparedStatementReturnVersionNumberFromEmailAddress.executeQuery();
			if (resultSet.next()) {

				versionNo = resultSet.getInt("versionNo");
				// emailAddressDetail.setVersionNo(resultSet.getInt("versionNo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return versionNo;
	}
	
	
}
