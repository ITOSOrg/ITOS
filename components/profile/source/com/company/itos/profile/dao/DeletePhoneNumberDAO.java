package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.PhoneNumberDetail;

public class DeletePhoneNumberDAO {
	public String deletePhoneNumber(PhoneNumberDetail phoneNumberDetail){
		
		Statement statement;
		Connection connection = null;
		String returnMassegeStr = "";
		try{
			
		String phoneNumberSQLStr = "UPDATE	PhoneNumber	SET	RECORDSTATUS='cancel'	WHERE phoneNumberID = "
		+ phoneNumberDetail.getPhoneNumberID();
		
		String phoneNumberLinkSQLStr = "UPDATE PhoneNumberLink SET	RECORDSTATUS='cancel'	WHERE phoneNumberLinkID= "
				+ phoneNumberDetail.getPhoneNumberLinkID();
		
		DBConnection dbConnection = new DBConnection();
		connection = dbConnection.getDBConnection();
		
		statement = connection.createStatement();
		statement.executeUpdate(phoneNumberSQLStr);
		
		Statement statement1 = connection.createStatement();
		statement1.executeUpdate(phoneNumberLinkSQLStr);
		}catch (SQLException e) {

			e.printStackTrace();
			
		}

		return returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;		
	}

}
