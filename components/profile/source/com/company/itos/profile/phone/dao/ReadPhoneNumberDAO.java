package com.company.itos.profile.phone.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.PhoneNumberDetail;

public class ReadPhoneNumberDAO {
	
	public PhoneNumberDetail readPhoneNumber(PhoneNumberDetail phoneNumberDetail)
	{
		String returnMassegeStr = "";
		Statement statement = null;
		ResultSet resultSet = null;
		
		String PhoneNumberLinkSQLStr = "SELECT * FROM PhoneNumberLink where phoneNumberLinkID = \'" + phoneNumberDetail.getPhoneNumberLinkID() + "\' and RECORDSTATUS='Active'";
try {
			
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getDBConnection();
		
			statement	= connection.createStatement();
			resultSet = statement.executeQuery(PhoneNumberLinkSQLStr);

			if (resultSet.next()) {
				phoneNumberDetail.setRelatedID(resultSet.getInt("relatedID"));
				phoneNumberDetail.setPhoneNumberID(resultSet.getInt("phoneNumberID"));
				phoneNumberDetail.setTypeCode(resultSet.getString("typeCode"));
				phoneNumberDetail.setPrimaryInd(resultSet.getInt("primaryInd"));
				phoneNumberDetail.setStartDate(resultSet.getDate("startDate"));
				phoneNumberDetail.setEndDate(resultSet.getDate("endDate"));
				phoneNumberDetail.setPhoneNumberLinkID(resultSet.getInt("phoneNumberLinkID"));
			}
			
			String PhoneNumberSQLstr = "SELECT * FROM PhoneNumber where phoneNumberID = \'" + phoneNumberDetail.getPhoneNumberID() + "\' and RECORDSTATUS='Active'";
			
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
return phoneNumberDetail;

}
}
