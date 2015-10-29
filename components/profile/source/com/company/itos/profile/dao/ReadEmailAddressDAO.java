package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.EmailAddressDetail;

public class ReadEmailAddressDAO {
	
	
	public String readEmailAddress(EmailAddressDetail emailAddressDetail) {
		
		String returnMassegeStr = "";
		Statement statement = null;
		ResultSet resultSet = null;
		
		
		String query1 = "SELECT * FROM EmailAddressLink where emailAddressLinkID = \'" + emailAddressDetail.getEmailAddressLinkID() + "\' and RECORDSTATUS='Active'";
		
		
		try {
			
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getDBConnection();


			Statement statement1 = connection.createStatement();
			resultSet = statement1.executeQuery(query1);

			if (resultSet.next()) {
				
				emailAddressDetail.setEmailAddressID(resultSet.getInt("emailAddressID"));
				emailAddressDetail.setTypeCode(resultSet.getString("typeCode"));
				emailAddressDetail.setPrimaryInd(resultSet.getString("primaryInd"));
				emailAddressDetail.setStartDate(resultSet.getDate("startDate"));
				emailAddressDetail.setEndDate(resultSet.getDate("endDate"));
				emailAddressDetail.setEmailAddressLinkID(resultSet.getInt("emailAddressLinkID"));
			}
			
			String query = "SELECT * FROM EmailAddress where emailAddressID = \'" + emailAddressDetail.getEmailAddressID() + "\' and RECORDSTATUS='Active'";
			
			statement = connection.createStatement();
			ResultSet	resultSet1 = statement.executeQuery(query);


			if (resultSet1.next()) {
				
				emailAddressDetail.setEmailAddress(resultSet1.getString("emailAddress"));
			}

			
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;
	}

}
