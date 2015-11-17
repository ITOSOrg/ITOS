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

public class ReadPhoneNumberDAO {

	public String readPhoneNumber(PhoneNumberLinkDetail phoneNumberLinkDetail) {
		String returnMassegeStr = "";

		String PhoneNumberLinkSQLStr = "SELECT * FROM PhoneNumberLink WHERE phoneNumberLinkID = \'"
				+ phoneNumberLinkDetail.getPhoneNumberLinkID() + "\' AND RECORDSTATUS='Active'";
		try {
			// PhoneNumberDetail phoneNumberDetail =
			// phoneNumberLinkDetail.getPhoneNumberDetail();
			PhoneNumberDetail phoneNumberDetail = null;
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getDBConnection();

			PreparedStatement preparedStatementPhoneNumberLink = connection.prepareStatement(PhoneNumberLinkSQLStr);
			ResultSet resultSetPhoneNumberLink = preparedStatementPhoneNumberLink.executeQuery();

			while (resultSetPhoneNumberLink.next()) {
				phoneNumberLinkDetail.setRelatedID(resultSetPhoneNumberLink.getInt("relatedID"));
				phoneNumberLinkDetail.setPhoneNumberID(resultSetPhoneNumberLink.getInt("phoneNumberID"));
				phoneNumberLinkDetail.setTypeCode(resultSetPhoneNumberLink.getString("typeCode"));
				phoneNumberLinkDetail.setPrimaryInd(resultSetPhoneNumberLink.getInt("primaryInd"));
				phoneNumberLinkDetail.setStartDate(resultSetPhoneNumberLink.getDate("startDate"));
				phoneNumberLinkDetail.setEndDate(resultSetPhoneNumberLink.getDate("endDate"));
				phoneNumberLinkDetail.setPhoneNumberLinkID(resultSetPhoneNumberLink.getInt("phoneNumberLinkID"));
				phoneNumberLinkDetail.setVersionNo(resultSetPhoneNumberLink.getInt("versionNo"));
			}

			String PhoneNumberSQLstr = "SELECT * FROM PhoneNumber WHERE phoneNumberID = \'" + phoneNumberLinkDetail.getPhoneNumberID()
					+ "\' AND RECORDSTATUS='Active'";

			PreparedStatement preparedStatementPhoneNumber = connection.prepareStatement(PhoneNumberSQLstr);
			ResultSet resultSetPhoneNumber = preparedStatementPhoneNumber.executeQuery();
			while (resultSetPhoneNumber.next()) {

				phoneNumberDetail = new PhoneNumberDetail();

				phoneNumberDetail.setPhoneNumberID(resultSetPhoneNumber.getInt("phoneNumberID"));
				phoneNumberDetail.setCountryCode(resultSetPhoneNumber.getInt("countryCode"));
				phoneNumberDetail.setAreaCode(resultSetPhoneNumber.getInt("areaCode"));
				phoneNumberDetail.setPhoneNumber(resultSetPhoneNumber.getLong("phoneNumber"));
				phoneNumberDetail.setExtension(resultSetPhoneNumber.getInt("extension"));

				phoneNumberLinkDetail.setPhoneNumberDetail(phoneNumberDetail);
			}
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;

	}

	public String readPrimaryPhoneNumber(PhoneNumberLinkDetail phoneNumberLinkDetail) {
		String returnMassegeStr = "";

		String PhoneNumberLinkSQLStr = "SELECT * FROM PhoneNumberLink WHERE relatedID = \'" + phoneNumberLinkDetail.getRelatedID()
				+ "\' AND RECORDSTATUS='Active' AND typeCode = 'primary'";
		try {
			// PhoneNumberDetail phoneNumberDetail =
			// phoneNumberLinkDetail.getPhoneNumberDetail();
			PhoneNumberDetail phoneNumberDetail = null;
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getDBConnection();

			Statement statementPhoneNumberLink = connection.createStatement();
			ResultSet resultSetPhoneNumberLink = statementPhoneNumberLink.executeQuery(PhoneNumberLinkSQLStr);

			while (resultSetPhoneNumberLink.next()) {
				phoneNumberLinkDetail.setRelatedID(resultSetPhoneNumberLink.getInt("relatedID"));
				phoneNumberLinkDetail.setPhoneNumberID(resultSetPhoneNumberLink.getInt("phoneNumberID"));
				phoneNumberLinkDetail.setTypeCode(resultSetPhoneNumberLink.getString("typeCode"));
				phoneNumberLinkDetail.setPrimaryInd(resultSetPhoneNumberLink.getInt("primaryInd"));
				phoneNumberLinkDetail.setStartDate(resultSetPhoneNumberLink.getDate("startDate"));
				phoneNumberLinkDetail.setEndDate(resultSetPhoneNumberLink.getDate("endDate"));
				phoneNumberLinkDetail.setPhoneNumberLinkID(resultSetPhoneNumberLink.getInt("phoneNumberLinkID"));
				phoneNumberLinkDetail.setVersionNo(resultSetPhoneNumberLink.getInt("versionNo"));
			}

			String PhoneNumberSQLstr = "SELECT * FROM PhoneNumber WHERE phoneNumberID = \'" + phoneNumberLinkDetail.getPhoneNumberID()
					+ "\' AND RECORDSTATUS='Active'";

			Statement statementPhoneNumber = connection.createStatement();
			ResultSet resultSetPhoneNumber = statementPhoneNumber.executeQuery(PhoneNumberSQLstr);
			while (resultSetPhoneNumber.next()) {

				phoneNumberDetail = new PhoneNumberDetail();

				phoneNumberDetail.setPhoneNumberID(resultSetPhoneNumber.getInt("phoneNumberID"));
				phoneNumberDetail.setCountryCode(resultSetPhoneNumber.getInt("countryCode"));
				phoneNumberDetail.setAreaCode(resultSetPhoneNumber.getInt("areaCode"));
				phoneNumberDetail.setPhoneNumber(resultSetPhoneNumber.getLong("phoneNumber"));
				phoneNumberDetail.setExtension(resultSetPhoneNumber.getInt("extension"));

				phoneNumberLinkDetail.setPhoneNumberDetail(phoneNumberDetail);
			}
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;

	}

}
