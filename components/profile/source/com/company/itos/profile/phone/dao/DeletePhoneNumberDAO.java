package com.company.itos.profile.phone.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

public class DeletePhoneNumberDAO {
	
	
	public String deletePhoneNumber(PhoneNumberLinkDetail phoneNumberLinkDetail) {

		Connection connection = null;
		String returnMassegeStr = "";
		try {
			PhoneNumberDetail phoneNumberDetail = phoneNumberLinkDetail.getPhoneNumberDetail();

			String phoneNumberSQLStr = "UPDATE	PhoneNumber	SET	RECORDSTATUS='cancel'	WHERE phoneNumberID = "
					+ phoneNumberDetail.getPhoneNumberID();

			String phoneNumberLinkSQLStr = "UPDATE PhoneNumberLink SET	RECORDSTATUS='cancel'	WHERE phoneNumberLinkID= "
					+ phoneNumberLinkDetail.getPhoneNumberLinkID();

			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getDBConnection();

			Statement statementPhoneNumber = connection.createStatement();
			statementPhoneNumber.executeUpdate(phoneNumberSQLStr);

			Statement statementPhoneNumberLink = connection.createStatement();
			statementPhoneNumberLink.executeUpdate(phoneNumberLinkSQLStr);
		} catch (SQLException e) {

			e.printStackTrace();

		}

		return returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
	}

}
