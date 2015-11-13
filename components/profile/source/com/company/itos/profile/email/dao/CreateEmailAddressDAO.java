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

			Statement statement = connection.createStatement();
			Statement statement2 = connection.createStatement();

			ResultSet resultSetEASeq = statement.executeQuery("SELECT EmailAddressSEQ.nextval FROM DUAL");

			ResultSet resultSetEALSeq = statement2.executeQuery("SELECT EmailAddressLinkSEQ.nextval FROM DUAL");

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

			PreparedStatement preparedStatement = connection.prepareStatement(emailAddressSQLStr);

			preparedStatement.setInt(1, emailAddressDetail.getEmailAddressID());
			preparedStatement.setString(2, emailAddressDetail.getEmailAddress());

			preparedStatement.execute();

			PreparedStatement preparedStatement1 = connection.prepareStatement(emailAddressLinkSQLStr);

			preparedStatement1.setInt(1, emailAddressLinkDetail.getEmailAddressLinkID());
			preparedStatement1.setInt(2,  emailAddressLinkDetail.getRelatedID());
			preparedStatement1.setInt(3, emailAddressDetail.getEmailAddressID());
			preparedStatement1.setDate(4, emailAddressLinkDetail.getStartDate());
			preparedStatement1.setDate(5, emailAddressLinkDetail.getEndDate());

			preparedStatement1.execute();

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;

	}

}
