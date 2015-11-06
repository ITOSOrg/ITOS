package com.company.itos.profile.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.PhoneNumberDetail;

public class ListPhoneNumberDAO {
	
	public List<PhoneNumberDetail> listAllPhoneNumber(PhoneNumberDetail phoneNumberDetail)
	{
		List<PhoneNumberDetail> phoneNumberDetailList = new ArrayList<PhoneNumberDetail>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;
		
		PhoneNumberDetail phoneNumberDetailFromDB = null;
		
		PreparedStatement preparedStatementPhoneNumberLink = null;
		PreparedStatement preparedStatementPhoneNumber = null;
		
		try {
			connection = dbConnection.getDBConnection();
			
			String phoneNumberLinkSQLStr = "SELECT * FROM PhoneNumberLink WHERE	RECORDSTATUS='Active' AND relatedID = ?";
			
			preparedStatementPhoneNumberLink = connection.prepareStatement(phoneNumberLinkSQLStr);
			preparedStatementPhoneNumberLink.setInt(1, phoneNumberDetail.getRelatedID());
			
			resultSet = preparedStatementPhoneNumberLink.executeQuery();

			
			String phoneNumberSQLStr = "SELECT * FROM PhoneNumber WHERE phoneNumberID = ? AND RECORDSTATUS='Active'";

			preparedStatementPhoneNumber = connection.prepareStatement(phoneNumberSQLStr);
			
			while(resultSet.next()){
				phoneNumberDetailFromDB = new PhoneNumberDetail();
				
				phoneNumberDetailFromDB.setPhoneNumberLinkID(resultSet.getInt("phoneNumberLinkID"));
				phoneNumberDetailFromDB.setPhoneNumberID(resultSet.getInt("phoneNumberID"));
				phoneNumberDetailFromDB.setRelatedID(resultSet.getInt("relatedID"));
				phoneNumberDetailFromDB.setTypeCode(resultSet.getString("typeCode"));
				phoneNumberDetailFromDB.setPrimaryInd(resultSet.getInt("primaryInd"));
				phoneNumberDetailFromDB.setStartDate(resultSet.getDate("startDate"));
				phoneNumberDetailFromDB.setEndDate(resultSet.getDate("endDate"));
				
				preparedStatementPhoneNumber.setInt(1, phoneNumberDetailFromDB.getPhoneNumberID());
				
				ResultSet resultSet1 = preparedStatementPhoneNumber.executeQuery();
				
				while(resultSet1.next()){
					
					phoneNumberDetailFromDB.setCountryCode(resultSet1.getInt("countryCode"));
					phoneNumberDetailFromDB.setAreaCode(resultSet1.getInt("areaCode"));
					phoneNumberDetailFromDB.setPhoneNumber(resultSet1.getLong("phoneNumber"));
					phoneNumberDetailFromDB.setExtension(resultSet1.getInt("extension"));
					
				}
				phoneNumberDetailList.add(phoneNumberDetailFromDB);
			}
		
		
		} catch (SQLException e) {

				e.printStackTrace();
			}
		
		
		return phoneNumberDetailList;
		
	}

}
