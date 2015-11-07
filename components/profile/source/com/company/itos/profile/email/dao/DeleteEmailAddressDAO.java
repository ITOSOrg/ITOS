package com.company.itos.profile.email.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.EmailAddressDetail;

public class DeleteEmailAddressDAO {
	public String deleteEmailAddress(EmailAddressDetail emailAddressDetail)
	{
		Connection connection = null;
		String returnMassegeStr = "";
		try{
		String emailAddressSQLStr = "UPDATE	EmailAddress	SET	RECORDSTATUS='cancel'	WHERE emailAddressID = "
		+ emailAddressDetail.getEmailAddressID();
		
		String EmailAddressLinkSQLStr = "UPDATE EmailAddressLink SET	RECORDSTATUS='cancel'	WHERE emailAddressLinkID= "
				+ emailAddressDetail.getEmailAddressLinkID();
		DBConnection dbConnection = new DBConnection();
		connection = dbConnection.getDBConnection();
		
		Statement statementEmailAddress = connection.createStatement();
		statementEmailAddress.executeUpdate(emailAddressSQLStr);
		
		Statement statementEmailAddressLink = connection.createStatement();
		statementEmailAddressLink.executeUpdate(EmailAddressLinkSQLStr);
		
		}catch (SQLException e) {

			e.printStackTrace();
		}

		return returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		
	}

}
