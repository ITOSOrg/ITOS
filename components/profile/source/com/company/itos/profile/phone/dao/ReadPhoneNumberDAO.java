package com.company.itos.profile.phone.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

public class ReadPhoneNumberDAO {
	
	public PhoneNumberLinkDetail readPhoneNumber(PhoneNumberLinkDetail phoneNumberLinkDetail)
	{
		String returnMassegeStr = "";
		Statement statement = null;
		ResultSet resultSet = null;
		
		String PhoneNumberLinkSQLStr = "SELECT * FROM PhoneNumberLink WHERE phoneNumberLinkID = \'" + phoneNumberLinkDetail.getPhoneNumberLinkID() + "\' AND RECORDSTATUS='Active'";
try {
	  		PhoneNumberDetail phoneNumberDetail = phoneNumberLinkDetail.getPhoneNumberDetail();
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getDBConnection();
		
			statement	= connection.createStatement();
			resultSet = statement.executeQuery(PhoneNumberLinkSQLStr);

			if (resultSet.next()) {
				phoneNumberLinkDetail.setRelatedID(resultSet.getInt("relatedID"));
				phoneNumberLinkDetail.setPhoneNumberID(resultSet.getInt("phoneNumberID"));
				phoneNumberLinkDetail.setTypeCode(resultSet.getString("typeCode"));
				phoneNumberLinkDetail.setPrimaryInd(resultSet.getInt("primaryInd"));
				phoneNumberLinkDetail.setStartDate(resultSet.getDate("startDate"));
				phoneNumberLinkDetail.setEndDate(resultSet.getDate("endDate"));
				phoneNumberLinkDetail.setPhoneNumberLinkID(resultSet.getInt("phoneNumberLinkID"));
				phoneNumberLinkDetail.setVersionNo(resultSet.getInt("versionNo"));
			}
			
			String PhoneNumberSQLstr = "SELECT * FROM PhoneNumber WHERE phoneNumberID = \'" + phoneNumberLinkDetail.getPhoneNumberID() + "\' AND RECORDSTATUS='Active'";
			
			Statement	statement1	= connection.createStatement();
			ResultSet resultSet1 = statement.executeQuery(PhoneNumberSQLstr);
			if(resultSet1.next())
			{
				phoneNumberDetail.setPhoneNumberID(resultSet1.getInt("phoneNumberID"));	
				phoneNumberDetail.setCountryCode(resultSet1.getInt("countryCode"));
				phoneNumberDetail.setAreaCode(resultSet1.getInt("areaCode"));
				phoneNumberDetail.setPhoneNumber(resultSet1.getLong("phoneNumber"));
				phoneNumberDetail.setExtension(resultSet1.getInt("extension"));
			}

} catch (SQLException e) {
		e.printStackTrace();
		//returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
	}
return phoneNumberLinkDetail;

}
}
