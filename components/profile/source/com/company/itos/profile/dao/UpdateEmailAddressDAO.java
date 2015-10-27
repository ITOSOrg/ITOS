package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.EmailAddressDetail;

public class UpdateEmailAddressDAO {
	Connection connection = null;
	ResultSet resultSet = null;
				public String updateEmailAddress(EmailAddressDetail emailAddressDetail)
				{
					String returnMassegeStr = "";
					DBConnection dbConnection = new DBConnection();

					try {
						connection = dbConnection.getDBConnection();
						String updateEmailAddressSqlStr = "UPDATE	EmailAddress	SET emailAddress = '"+emailAddressDetail.getEmailAddress()+"'" + "where emailAddressID = '"+emailAddressDetail.getEmailAddressID() +"'";
						String updateEmailAddressLinkSqlStr = "UPDATE EmailAddressLink SET typeCode = '"+emailAddressDetail.getTypeCode()+"',primaryInd = '"+emailAddressDetail.getPrimaryInd()+"', ?, ?" + "where emailAddressLinkID = '"+emailAddressDetail.getEmailAddressLinkID()+"'";
						PreparedStatement	preparedStatement = connection.prepareStatement(updateEmailAddressSqlStr);
						preparedStatement.executeUpdate();

						PreparedStatement preparedStatement1 = connection.prepareStatement(updateEmailAddressLinkSqlStr);
						preparedStatement1.setDate(1, emailAddressDetail.getStartDate());
						preparedStatement1.setDate(2, emailAddressDetail.getEndDate());
						preparedStatement1.executeUpdate();
						
						returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

					}catch (SQLException e) {

					e.printStackTrace();
				}
					return returnMassegeStr;
}
}
