package com.company.itos.profile.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

public class CreatePhoneNumberDAO {

	public String createPhoneNumber(PhoneNumberLinkDetail phoneNumberLinkDetail) {
		String returnMassegeStr = "";

		DBConnection dbConnection = new DBConnection();

		Connection connection = null;

		// UpdatePhoneNumberDAO updatePhoneNumberDAO = new
		// UpdatePhoneNumberDAO();
		// SupdatePhoneNumberDAO.returnVersionNumber(phoneNumberDetail);

		try {

			PhoneNumberDetail phoneNumberDetail = phoneNumberLinkDetail.getPhoneNumberDetail();

			connection = dbConnection.getDBConnection();

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT PhoneNumberSEQ.nextval FROM DUAL");
			PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT PhoneNumberLinkSEQ.nextval FROM DUAL");

			ResultSet resultSetPNSeq = preparedStatement.executeQuery();

			ResultSet resultSetPNLSeq = preparedStatement2.executeQuery();

			if (resultSetPNSeq.next()) {
				phoneNumberDetail.setPhoneNumberID((resultSetPNSeq.getInt(1)));
			}

			if (resultSetPNLSeq.next()) {
				phoneNumberLinkDetail.setPhoneNumberLinkID((resultSetPNLSeq.getInt(1)));
			}

			String PhoneNumberSQLStr = "INSERT INTO PhoneNumber (phoneNumberID, countryCode, areaCode, phoneNumber, extension, recordStatus, versionNo)"
					+ "VALUES(?, ?, ?, ?, ?, 'Active', 1)";

			PreparedStatement preparedStatementPhoneNumber = connection.prepareStatement(PhoneNumberSQLStr);

			preparedStatementPhoneNumber.setInt(1, phoneNumberDetail.getPhoneNumberID());
			preparedStatementPhoneNumber.setInt(2, phoneNumberDetail.getCountryCode());
			preparedStatementPhoneNumber.setInt(3, phoneNumberDetail.getAreaCode());
			preparedStatementPhoneNumber.setLong(4, phoneNumberDetail.getPhoneNumber());
			preparedStatementPhoneNumber.setInt(5, phoneNumberDetail.getExtension());
			preparedStatementPhoneNumber.execute();

			String PhoneNumberLinkSQLStr = "INSERT INTO PhoneNumberLink(phoneNumberLinkID, relatedID, phoneNumberID, typeCode, primaryInd, startDate, endDate, recordStatus, versionNo )"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, 'Active', 1)";

			PreparedStatement preparedStatementPhoneNumberLink = connection.prepareStatement(PhoneNumberLinkSQLStr);

			preparedStatementPhoneNumberLink.setInt(1, phoneNumberLinkDetail.getPhoneNumberLinkID());
			preparedStatementPhoneNumberLink.setInt(2, phoneNumberLinkDetail.getRelatedID());
			preparedStatementPhoneNumberLink.setInt(3, phoneNumberDetail.getPhoneNumberID());
			preparedStatementPhoneNumberLink.setString(4, phoneNumberLinkDetail.getTypeCode());
			preparedStatementPhoneNumberLink.setInt(5, phoneNumberLinkDetail.getPrimaryInd());
			preparedStatementPhoneNumberLink.setDate(6, phoneNumberLinkDetail.getStartDate());
			preparedStatementPhoneNumberLink.setDate(7, phoneNumberLinkDetail.getEndDate());
			preparedStatementPhoneNumberLink.execute();

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;

	}

}
