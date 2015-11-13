package com.company.itos.profile.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

public class ListPhoneNumberDAO {
	
	public List<PhoneNumberLinkDetail> listAllPhoneNumber(PhoneNumberLinkDetail phoneNumberLinkDetail)
	{
		List<PhoneNumberLinkDetail> PhoneNumberLinkDetailList = new ArrayList<PhoneNumberLinkDetail>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;
		
		PhoneNumberDetail phoneNumberDetailFromDB = null;
		
		PreparedStatement preparedStatementPhoneNumberLink = null;
		PreparedStatement preparedStatementPhoneNumber = null;
		
		try {
			PhoneNumberDetail phoneNumberDetail = phoneNumberLinkDetail.getPhoneNumberDetail();
			connection = dbConnection.getDBConnection();
			
			String phoneNumberLinkSQLStr = "SELECT * FROM PhoneNumberLink WHERE	RECORDSTATUS='Active' AND relatedID = ?";
			
			preparedStatementPhoneNumberLink = connection.prepareStatement(phoneNumberLinkSQLStr);
			preparedStatementPhoneNumberLink.setInt(1, phoneNumberLinkDetail.getRelatedID());
			
			resultSet = preparedStatementPhoneNumberLink.executeQuery();

			
			String phoneNumberSQLStr = "SELECT * FROM PhoneNumber WHERE phoneNumberID = ? AND RECORDSTATUS='Active'";

			preparedStatementPhoneNumber = connection.prepareStatement(phoneNumberSQLStr);
			
			while(resultSet.next()){
				//phoneNumberDetailFromDB = new PhoneNumberDetail();
				PhoneNumberLinkDetail phoneNumberLinkDetailFromDB = new PhoneNumberLinkDetail();
				
				phoneNumberLinkDetailFromDB.setPhoneNumberLinkID(resultSet.getInt("phoneNumberLinkID"));
				phoneNumberDetail.setPhoneNumberID(resultSet.getInt("phoneNumberID"));
				phoneNumberLinkDetailFromDB.setRelatedID(resultSet.getInt("relatedID"));
				phoneNumberLinkDetailFromDB.setTypeCode(resultSet.getString("typeCode"));
				phoneNumberLinkDetailFromDB.setPrimaryInd(resultSet.getInt("primaryInd"));
				phoneNumberLinkDetailFromDB.setStartDate(resultSet.getDate("startDate"));
				phoneNumberLinkDetailFromDB.setEndDate(resultSet.getDate("endDate"));
				
				preparedStatementPhoneNumber.setInt(1, phoneNumberDetail.getPhoneNumberID());
				
				ResultSet resultSet1 = preparedStatementPhoneNumber.executeQuery();
				
				while(resultSet1.next()){
					
					phoneNumberDetail.setCountryCode(resultSet1.getInt("countryCode"));
					phoneNumberDetail.setAreaCode(resultSet1.getInt("areaCode"));
					phoneNumberDetail.setPhoneNumber(resultSet1.getLong("phoneNumber"));
					phoneNumberDetail.setExtension(resultSet1.getInt("extension"));
					
				}
				phoneNumberLinkDetailFromDB.setPhoneNumberDetail(phoneNumberDetail);
				PhoneNumberLinkDetailList.add(phoneNumberLinkDetailFromDB);
			}
		
		
		} catch (SQLException e) {

				e.printStackTrace();
			}
		
		
		return PhoneNumberLinkDetailList;
		
	}

}
