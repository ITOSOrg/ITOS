package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.EmailAddressDetail;

public class DeleteEmailAddressDAO {
	public String deleteEmailAddress(EmailAddressDetail emailAddressDetail)
	{
		Statement statement;
		Connection connection = null;
		String returnMassegeStr = "";
		try{
		String sql = "UPDATE	EmailAddress	SET	RECORDSTATUS='cancel'	WHERE emailAddressID = "
		+ emailAddressDetail.getEmailAddressID();
		String sql1 = "UPDATE EmailAddressLink SET	RECORDSTATUS='cancel'	WHERE emailAddressLinkID= "
				+ emailAddressDetail.getEmailAddressLinkID();
		DBConnection dbConnection = new DBConnection();
		connection = dbConnection.getDBConnection();
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		
		Statement statement1 = connection.createStatement();
		statement1.executeUpdate(sql1);
		}catch (SQLException e) {

			e.printStackTrace();
		}

		return returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		
	}

}
