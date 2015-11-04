package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.PhoneNumberDetail;

public class CreatePhoneNumberDAO {
	
	public String createPhoneNumber(PhoneNumberDetail phoneNumberDetail)
	{
		String returnMassegeStr = "";

		DBConnection dbConnection = new DBConnection();

		Connection connection = null;
		
		//UpdatePhoneNumberDAO updatePhoneNumberDAO = new UpdatePhoneNumberDAO();
		//SupdatePhoneNumberDAO.returnVersionNumber(phoneNumberDetail);
		
		try {

			connection = dbConnection.getDBConnection();
			
			Statement statement = connection.createStatement();
			Statement statement2 = connection.createStatement();

			ResultSet resultSetPNSeq = statement.executeQuery("SELECT PhoneNumberSEQ.nextval FROM DUAL");
			
			ResultSet resultSetPNLSeq = statement2.executeQuery("SELECT PhoneNumberLinkSEQ.nextval FROM DUAL");
			
			if (resultSetPNSeq.next()) {
				phoneNumberDetail.setPhoneNumberID((resultSetPNSeq.getInt(1)));
			}

			if (resultSetPNLSeq.next()) {
				phoneNumberDetail.setPhoneNumberLinkID((resultSetPNLSeq.getInt(1)));
			}
			
			String PhoneNumberSQLStr = "INSERT INTO PhoneNumber (phoneNumberID, countryCode, areaCode, phoneNumber, extension, recordStatus, versionNo)" 
			                                           + "VALUES(?, ?, ?, ?, ?, 'Active', 1)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(PhoneNumberSQLStr);
			
			preparedStatement.setInt(1, phoneNumberDetail.getPhoneNumberID());
			preparedStatement.setInt(2, phoneNumberDetail.getCountryCode());
			preparedStatement.setInt(3, phoneNumberDetail.getAreaCode());
			preparedStatement.setLong(4, phoneNumberDetail.getPhoneNumber());
			preparedStatement.setInt(5, phoneNumberDetail.getExtension());
			preparedStatement.execute();
			
			String PhoneNumberLinkSQLStr = "INSERT INTO PhoneNumberLink(phoneNumberLinkID, relatedID, phoneNumberID, typeCode, primaryInd, startDate, endDate, recordStatus, versionNo )"
			                                                  + "VALUES(?, ?, ?, ?, ?, ?, ?, 'Active', 1)";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(PhoneNumberLinkSQLStr);
			
			preparedStatement1.setInt(1, phoneNumberDetail.getPhoneNumberLinkID());
			preparedStatement1.setInt(2, phoneNumberDetail.getRelatedID());
			preparedStatement1.setInt(3, phoneNumberDetail.getPhoneNumberID());
			preparedStatement1.setString(4, phoneNumberDetail.getTypeCode());
			preparedStatement1.setInt(5, phoneNumberDetail.getPrimaryInd());
			preparedStatement1.setDate(6, phoneNumberDetail.getStartDate());
			preparedStatement1.setDate(7, phoneNumberDetail.getEndDate());
			preparedStatement1.execute();
			
			
			
			
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;
		
	}

}
