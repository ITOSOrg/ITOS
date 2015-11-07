package com.company.itos.profile.email.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.EmailAddressDetail;

public class ReadEmailAddressDAO {
	
	
	public EmailAddressDetail readEmailAddress(EmailAddressDetail emailAddressDetail) {
		
		String returnMassegeStr = "";
		ResultSet resultSet = null;
		
		
		String emailAddressLinkSQLStr = "SELECT * FROM EmailAddressLink WHERE emailAddressLinkID = \'" + emailAddressDetail.getEmailAddressLinkID() + "\' AND RECORDSTATUS='Active'";
		
		
		try {
			
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getDBConnection();


			Statement statementemailAddressLink = connection.createStatement();
			resultSet = statementemailAddressLink.executeQuery(emailAddressLinkSQLStr);

			if (resultSet.next()) {
				
				emailAddressDetail.setEmailAddressID(resultSet.getInt("emailAddressID"));
				emailAddressDetail.setTypeCode(resultSet.getString("typeCode"));
				emailAddressDetail.setPrimaryInd(resultSet.getString("primaryInd"));
				emailAddressDetail.setStartDate(resultSet.getDate("startDate"));
				emailAddressDetail.setEndDate(resultSet.getDate("endDate"));
				emailAddressDetail.setEmailAddressLinkID(resultSet.getInt("emailAddressLinkID"));
				emailAddressDetail.setRelatedID(resultSet.getInt("relatedID"));
				emailAddressDetail.setVersionNo(resultSet.getInt("versionNo"));
			}
			
			String emailAddressSQLStr = "SELECT * FROM EmailAddress WHERE emailAddressID = \'" + emailAddressDetail.getEmailAddressID() + "\' AND RECORDSTATUS='Active'";
			
			Statement statementEmailAddress = connection.createStatement();
			ResultSet	resultSet1 = statementEmailAddress.executeQuery(emailAddressSQLStr);


			if (resultSet1.next()) {
				
				emailAddressDetail.setEmailAddress(resultSet1.getString("emailAddress"));
			}

			
			//returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			//returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return emailAddressDetail;
	}

}
