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

public class UpdateEmailAddressDAO {

	public String updateEmailAddress(EmailAddressDetail emailAddressDetail) {
		Connection connection = null;
		ResultSet resultSet = null;
		String returnMassegeStr = "";
		DBConnection dbConnection = new DBConnection();
		returnVersionNumber(emailAddressDetail);
		
		/*int versionNoFromUpdate = emailAddressDetail.getVersionNo();

		int versionNoFromDatabase = returnVersionNumber(emailAddressDetail);

		if (versionNoFromUpdate == versionNoFromDatabase) {

			versionNoFromDatabase++;*/

		try {
			connection = dbConnection.getDBConnection();
			
			String updateEmailAddressSqlStr = "UPDATE	EmailAddress	SET emailAddress = '" + emailAddressDetail.getEmailAddress() + "'"
					+ " WHERE emailAddressID = '" + emailAddressDetail.getEmailAddressID() + "'";
			
			PreparedStatement preparedStatement = connection.prepareStatement(updateEmailAddressSqlStr);
			preparedStatement.executeUpdate();
			
			
			String updateEmailAddressLinkSqlStr = "UPDATE EmailAddressLink SET typeCode = '" + emailAddressDetail.getTypeCode()
					+ "', primaryInd = '" + emailAddressDetail.getPrimaryInd() + "', startDate = ?, endDate = ?" + " WHERE emailAddressLinkID = '"
					+ emailAddressDetail.getEmailAddressLinkID() + "'";

			PreparedStatement preparedStatement1 = connection.prepareStatement(updateEmailAddressLinkSqlStr);
			preparedStatement1.setDate(1, emailAddressDetail.getStartDate());
			preparedStatement1.setDate(2, emailAddressDetail.getEndDate());
			preparedStatement1.executeUpdate();

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

		} catch (SQLException e) {

			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		//}
		return returnMassegeStr;
	}
	
	public int returnVersionNumber(EmailAddressDetail emailAddressDetail) {

		int versionNo = 0;
		try {
			DBConnection dbConnection = new DBConnection();

			Connection connection = dbConnection.getDBConnection();

			String emailAddressSQLStr = "SELECT	versionNo, relatedID	FROM	EmailAddressLink	WHERE	 emailAddressLinkID = '"
					+ emailAddressDetail.getEmailAddressLinkID() + "'";
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(emailAddressSQLStr);
			if (resultSet.next()) {

				versionNo = resultSet.getInt("versionNo");
				emailAddressDetail.setRelatedID(resultSet.getInt("relatedID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  versionNo;
	}
}
