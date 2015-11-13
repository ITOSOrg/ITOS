package com.company.itos.profile.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

public class UpdatePhoneNumberDAO {
	
	public String updatephoneNumber(PhoneNumberLinkDetail phoneNumberLinkDetail){
		
		Connection connection = null;
		ResultSet resultSet = null;
		String returnMassegeStr = "";
		DBConnection dbConnection = new DBConnection();
		
		PhoneNumberDetail phoneNumberDetail = phoneNumberLinkDetail.getPhoneNumberDetail();
		
		//returnVersionNumber( phoneNumberDetail);
		
		int phoneNumberLinkVersionNoFromUpdate = phoneNumberLinkDetail.getVersionNo();

		int phoneNumberLinkVersionNoFromDatabase = returnPhoneNumberLinkVersionNumber(phoneNumberLinkDetail);
		
		int phoneNumberVersionNoFromUpdate = phoneNumberDetail.getVersionNo();
		
		int phoneNumberVersionNoFromDatabase = returnPhoneNumberVersionNumber(phoneNumberDetail);

		if (phoneNumberLinkVersionNoFromUpdate == phoneNumberLinkVersionNoFromDatabase) {
			if(phoneNumberVersionNoFromUpdate == phoneNumberVersionNoFromDatabase){

			phoneNumberLinkVersionNoFromDatabase++;
			
			phoneNumberVersionNoFromDatabase++;

		

		try {
			connection = dbConnection.getDBConnection();
			
			String phoneNumberSQLStr = "UPDATE	PhoneNumber	SET countryCode = ?, areaCode = ?, phoneNumber = ?, extension = ?";
			
			PreparedStatement preparedStatementPhoneNumber = connection.prepareStatement(phoneNumberSQLStr);
			preparedStatementPhoneNumber.setInt(1, phoneNumberDetail.getCountryCode());
			preparedStatementPhoneNumber.setInt(2, phoneNumberDetail.getAreaCode());
			preparedStatementPhoneNumber.setLong(3, phoneNumberDetail.getPhoneNumber());
			preparedStatementPhoneNumber.setInt(4, phoneNumberDetail.getExtension());
			
			preparedStatementPhoneNumber.executeUpdate();
			
			String phoneNumberLinkSQLStr = "UPDATE	PhoneNumberLink	SET typeCode = ?, primaryInd = ?, startDate = ?, endDate = ?";
			
			PreparedStatement preparedStatementPhoneNumberLink = connection.prepareStatement(phoneNumberLinkSQLStr);
			preparedStatementPhoneNumberLink.setString(1, phoneNumberLinkDetail.getTypeCode());
			preparedStatementPhoneNumberLink.setInt(2, phoneNumberLinkDetail.getPrimaryInd());
			preparedStatementPhoneNumberLink.setDate(3, phoneNumberLinkDetail.getStartDate());
			preparedStatementPhoneNumberLink.setDate(4, phoneNumberLinkDetail.getEndDate());
			
			preparedStatementPhoneNumberLink.executeUpdate();
		
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

		} catch (SQLException e) {

			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		}
		}
		return returnMassegeStr;
	}
	
	
	public int returnPhoneNumberLinkVersionNumber(PhoneNumberLinkDetail phoneNumberLinkDetail) {

		int versionNo = 0;
		try {
			DBConnection dbConnection = new DBConnection();

			Connection connection = dbConnection.getDBConnection();

			String phoneNumberLinkSQLStr = "SELECT	versionNo, relatedID	FROM	PhoneNumberLink	WHERE	 phoneNumberLinkID = '"
					+ phoneNumberLinkDetail.getPhoneNumberLinkID() + "'";
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(phoneNumberLinkSQLStr);
			if (resultSet.next()) {

				versionNo = resultSet.getInt("versionNo");
				phoneNumberLinkDetail.setRelatedID(resultSet.getInt("relatedID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  versionNo;
	}
	public int returnPhoneNumberVersionNumber(PhoneNumberDetail phoneNumberDetail) {
		
		int versionNo = 0;
		try {
			DBConnection dbConnection = new DBConnection();
			
			Connection connection = dbConnection.getDBConnection();
			
			String phoneNumberLinkSQLStr = "SELECT	versionNo, relatedID	FROM	PhoneNumberLink	WHERE	 phoneNumberID = '"
					+ phoneNumberDetail.getPhoneNumberID() + "'";
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(phoneNumberLinkSQLStr);
			if (resultSet.next()) {
				
				versionNo = resultSet.getInt("versionNo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  versionNo;
	}

}
