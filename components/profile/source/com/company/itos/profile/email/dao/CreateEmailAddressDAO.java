package com.company.itos.profile.email.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;
import com.company.itos.profile.pojo.PersonDetail;

public class CreateEmailAddressDAO {

	public String createEmailAddress(EmailAddressLinkDetail emailAddressLinkDetail) {

		String returnMassegeStr = "";

		DBConnection dbConnection = new DBConnection();

		Connection connection = null;
		try {

			EmailAddressDetail emailAddressDetail = emailAddressLinkDetail.getEmailAddressDetail();

			connection = dbConnection.getDBConnection();

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT EmailAddressSEQ.nextval FROM DUAL");
			PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT EmailAddressLinkSEQ.nextval FROM DUAL");

			ResultSet resultSetEASeq = preparedStatement.executeQuery();

			ResultSet resultSetEALSeq = preparedStatement2.executeQuery();

			if (resultSetEASeq.next()) {
				emailAddressDetail.setEmailAddressID(resultSetEASeq.getInt(1));
			}

			if (resultSetEALSeq.next()) {
				emailAddressLinkDetail.setEmailAddressLinkID(resultSetEALSeq.getInt(1));
			}

			String emailAddressSQLStr = "INSERT INTO EmailAddress ( emailAddressID, emailAddress, recordStatus, versionNo) "
					+ "VALUES(?,  ?, 'Active', 1)";

			String emailAddressLinkSQLStr = "INSERT INTO EmailAddressLink ( emailAddressLinkID, relatedID, emailAddressID, typeCode, primaryInd, startDate, endDate, recordStatus, versionNo) "
					+ "VALUES(?, ? , ?, '"
					+ emailAddressLinkDetail.getTypeCode()
					+ "', '"
					+ emailAddressLinkDetail.getPrimaryInd()
					+ "', ?, ?, 'Active', 1)";

			PreparedStatement preparedStatementEmailAddress = connection.prepareStatement(emailAddressSQLStr);

			preparedStatementEmailAddress.setInt(1, emailAddressDetail.getEmailAddressID());
			preparedStatementEmailAddress.setString(2, emailAddressDetail.getEmailAddress());

			preparedStatementEmailAddress.execute();

			PreparedStatement preparedStatementEmailAddressLink = connection.prepareStatement(emailAddressLinkSQLStr);

			preparedStatementEmailAddressLink.setInt(1, emailAddressLinkDetail.getEmailAddressLinkID());
			preparedStatementEmailAddressLink.setInt(2, emailAddressLinkDetail.getRelatedID());
			preparedStatementEmailAddressLink.setInt(3, emailAddressDetail.getEmailAddressID());
			preparedStatementEmailAddressLink.setDate(4, emailAddressLinkDetail.getStartDate());
			preparedStatementEmailAddressLink.setDate(5, emailAddressLinkDetail.getEndDate());

			preparedStatementEmailAddressLink.execute();

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;

	}

}
