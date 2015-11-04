package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.EmailAddressDetail;
import com.company.itos.profile.pojo.PhoneNumberDetail;

public class UpdatePhoneNumberDAO {
	
	public String updatephoneNumber(PhoneNumberDetail phoneNumberDetail){
		
		Connection connection = null;
		ResultSet resultSet = null;
		String returnMassegeStr = "";
		DBConnection dbConnection = new DBConnection();
		returnVersionNumber( phoneNumberDetail);

		try {
			connection = dbConnection.getDBConnection();
			
			String phoneNumberSQLStr = "UPDATE	PhoneNumber	SET countryCode = ?, areaCode = ?, phoneNumber = ?, extension = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(phoneNumberSQLStr);
			preparedStatement.setInt(1, phoneNumberDetail.getCountryCode());
			preparedStatement.setInt(2, phoneNumberDetail.getAreaCode());
			preparedStatement.setLong(3, phoneNumberDetail.getPhoneNumber());
			preparedStatement.setInt(4, phoneNumberDetail.getExtension());
			
			preparedStatement.executeUpdate();
			
			String phoneNumberLinkSQLStr = "UPDATE	PhoneNumberLink	SET typeCode = ?, primaryInd = ?, startDate = ?, endDate = ?";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(phoneNumberLinkSQLStr);
			preparedStatement1.setString(1, phoneNumberDetail.getTypeCode());
			preparedStatement1.setInt(2, phoneNumberDetail.getPrimaryInd());
			preparedStatement1.setDate(3, phoneNumberDetail.getStartDate());
			preparedStatement1.setDate(4, phoneNumberDetail.getEndDate());
			
			preparedStatement.executeUpdate();
		
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

		} catch (SQLException e) {

			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;
		
	}
	
	
	public int returnVersionNumber(PhoneNumberDetail phoneNumberDetail) {

		int versionNo = 0;
		try {
			DBConnection dbConnection = new DBConnection();

			Connection connection = dbConnection.getDBConnection();

			String phoneNumberLinkSQLStr = "SELECT	versionNo, relatedID	FROM	PhoneNumberLink	WHERE	 phoneNumberLinkID = '"
					+ phoneNumberDetail.getPhoneNumberLinkID() + "'";
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(phoneNumberLinkSQLStr);
			if (resultSet.next()) {

				versionNo = resultSet.getInt("versionNo");
				phoneNumberDetail.setRelatedID(resultSet.getInt("relatedID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  versionNo;
	}

}
