package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.EmailAddressDetail;
import com.company.itos.profile.pojo.PersonDetail;

public class CreateEmailAddressDAO {

	public String createEmailAddress(EmailAddressDetail emailAddressDetail) {

		String returnMassegeStr = "";

		DBConnection dbConnection = new DBConnection();

		Connection connection = null;
		try {

			connection = dbConnection.getDBConnection();

			Statement statement = connection.createStatement();
			Statement statement2 = connection.createStatement();

			ResultSet resultSetEASeq = statement.executeQuery("SELECT EmailAddressSEQ.nextval FROM DUAL");

			ResultSet resultSetEALSeq = statement2.executeQuery("SELECT EmailAddressLinkSEQ.nextval FROM DUAL");

			if (resultSetEASeq.next()) {
				emailAddressDetail.setEmailAddressID(resultSetEASeq.getInt(1));
			}

			if (resultSetEALSeq.next()) {
				emailAddressDetail.setEmailAddressLinkID(resultSetEALSeq.getInt(1));
			}
			

			String emailAddressSQLStr = "INSERT INTO EmailAddress ( emailAddressID, emailAddress, recordStatus, versionNo) "
					+ "VALUES(?,  ?, 'Active', 1)";

			String emailAddressLinkSQLStr = "INSERT INTO EmailAddressLink ( emailAddressLinkID, relatedID, emailAddressID, typeCode, primaryInd, startDate, endDate, recordStatus, versionNo) "
					+ "VALUES(?, ? , ?, '"
					+ emailAddressDetail.getTypeCode()
					+ "', '"
					+ emailAddressDetail.getPrimaryInd()
					+ "', ?, ?, 'Active', 1)";

			PreparedStatement preparedStatement = connection.prepareStatement(emailAddressSQLStr);

			preparedStatement.setInt(1, emailAddressDetail.getEmailAddressID());
			preparedStatement.setString(2, emailAddressDetail.getEmailAddress());

			preparedStatement.execute();

			PreparedStatement preparedStatement1 = connection.prepareStatement(emailAddressLinkSQLStr);

			preparedStatement1.setInt(1, emailAddressDetail.getEmailAddressLinkID());
			preparedStatement1.setInt(2,  emailAddressDetail.getRelatedID());
			preparedStatement1.setInt(3, emailAddressDetail.getEmailAddressID());
			preparedStatement1.setDate(4, emailAddressDetail.getStartDate());
			preparedStatement1.setDate(5, emailAddressDetail.getEndDate());

			preparedStatement1.execute();

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;

	}

}
