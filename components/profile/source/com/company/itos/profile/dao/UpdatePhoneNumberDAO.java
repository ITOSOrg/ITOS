package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.PhoneNumberDetail;

public class UpdatePhoneNumberDAO {
	
	public String updatephoneNumber(PhoneNumberDetail phoneNumberDetail){
		
		Connection connection = null;
		ResultSet resultSet = null;
		String returnMassegeStr = "";
		DBConnection dbConnection = new DBConnection();

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

}
