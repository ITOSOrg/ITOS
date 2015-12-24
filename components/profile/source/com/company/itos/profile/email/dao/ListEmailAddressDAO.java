package com.company.itos.profile.email.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;

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
	public List<EmailAddressLinkDetail> listAllEmailAddress(EmailAddressLinkDetail emailAddressLinkDetailkey) {

		List<EmailAddressLinkDetail> emailAddressLinkDetailList = new ArrayList<EmailAddressLinkDetail>();

		EmailAddressDetail emailAddressDetailFromDB = null;
		EmailAddressLinkDetail emailAddressLinkDetail = null;
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatementEmailAddressLink = null;
		PreparedStatement preparedStatementEmailAddress = null;

		try {

			connection = DBConnection.getDBConnection();

			String emailAddressLinkSQLStr = "SELECT * FROM EmailAddressLink	WHERE	RECORDSTATUS='Active' AND relatedID = ?";

			preparedStatementEmailAddressLink = connection.prepareStatement(emailAddressLinkSQLStr);

			preparedStatementEmailAddressLink.setLong(1, emailAddressLinkDetailkey.getRelatedID());

			resultSet = preparedStatementEmailAddressLink.executeQuery();

			String emailAddressSQLStr = "SELECT * FROM EmailAddress WHERE emailAddressID = ? AND RECORDSTATUS='Active'";

			preparedStatementEmailAddress = connection.prepareStatement(emailAddressSQLStr);

			while (resultSet.next()) {

				emailAddressDetailFromDB = new EmailAddressDetail();
				emailAddressLinkDetail = new EmailAddressLinkDetail();

				emailAddressLinkDetail.setEmailAddressLinkID(resultSet.getLong("emailAddressLinkID"));
				emailAddressLinkDetail.setRelatedID(resultSet.getLong("relatedID"));
				emailAddressLinkDetail.setEmailAddressID(resultSet.getLong("emailAddressID"));
				emailAddressLinkDetail.setTypeCode(resultSet.getString("typeCode"));
				emailAddressLinkDetail.setPrimaryInd(resultSet.getString("primaryInd"));
				emailAddressLinkDetail.setStartDate(resultSet.getDate("startDate"));
				emailAddressLinkDetail.setEndDate(resultSet.getDate("endDate"));

				preparedStatementEmailAddress.setLong(1, emailAddressLinkDetail.getEmailAddressID());

				ResultSet resultSetEA = preparedStatementEmailAddress.executeQuery();

				while (resultSetEA.next()) {

					emailAddressDetailFromDB.setEmailAddressID(resultSetEA.getLong("emailAddressID"));
					emailAddressDetailFromDB.setEmailAddress(resultSetEA.getString("emailAddress"));

				}

				emailAddressLinkDetail.setEmailAddressDetail(emailAddressDetailFromDB);
				// Add object in list
				emailAddressLinkDetailList.add(emailAddressLinkDetail);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return emailAddressLinkDetailList;
	}
}
