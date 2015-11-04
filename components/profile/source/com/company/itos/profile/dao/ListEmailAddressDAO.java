package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.EmailAddressDetail;
import com.company.itos.profile.pojo.PersonDetail;

/**
 * 
 * @author vaish
 *
 */
public class ListEmailAddressDAO {

	/**
	 * 
	 * @param emailAddressDetail
	 * @return
	 */
	public List<EmailAddressDetail> listAllEmailAddress(EmailAddressDetail emailAddressDetail) {

		List<EmailAddressDetail> emailAddressDetailList = new ArrayList<EmailAddressDetail>();

		EmailAddressDetail emailAddressDetailFromDB = null;

		DBConnection dbConnection = new DBConnection();
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatementEmailAddressLink = null;
		PreparedStatement preparedStatementEmailAddress = null;

		try {
			connection = dbConnection.getDBConnection();

			String emailAddressLinkSQLStr = "SELECT * FROM EmailAddressLink	WHERE	RECORDSTATUS='Active' AND relatedID = ?";

			preparedStatementEmailAddressLink = connection.prepareStatement(emailAddressLinkSQLStr);

			preparedStatementEmailAddressLink.setInt(1, emailAddressDetail.getRelatedID());

			resultSet = preparedStatementEmailAddressLink.executeQuery();

			String emailAddressSQLStr = "SELECT * FROM EmailAddress WHERE emailAddressID = ? AND RECORDSTATUS='Active'";

			preparedStatementEmailAddress = connection.prepareStatement(emailAddressSQLStr);

			while (resultSet.next()) {

				emailAddressDetailFromDB = new EmailAddressDetail();

				emailAddressDetailFromDB.setEmailAddressLinkID(resultSet.getInt("emailAddressLinkID"));
				emailAddressDetailFromDB.setRelatedID(resultSet.getInt("relatedID"));
				emailAddressDetailFromDB.setEmailAddressID(resultSet.getInt("emailAddressID"));
				emailAddressDetailFromDB.setTypeCode(resultSet.getString("typeCode"));
				emailAddressDetailFromDB.setPrimaryInd(resultSet.getString("primaryInd"));
				emailAddressDetailFromDB.setStartDate(resultSet.getDate("startDate"));
				emailAddressDetailFromDB.setEndDate(resultSet.getDate("endDate"));

				preparedStatementEmailAddress.setInt(1, emailAddressDetailFromDB.getEmailAddressID());

				ResultSet resultSetEA = preparedStatementEmailAddress.executeQuery();

				while (resultSetEA.next()) {

					emailAddressDetailFromDB.setEmailAddress(resultSetEA.getString("emailAddress"));

				}

				// Add object in list
				emailAddressDetailList.add(emailAddressDetailFromDB);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return emailAddressDetailList;
	}
}
