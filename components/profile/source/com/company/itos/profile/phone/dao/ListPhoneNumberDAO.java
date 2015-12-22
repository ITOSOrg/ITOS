package com.company.itos.profile.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

public class ListPhoneNumberDAO {

	public List<PhoneNumberLinkDetail> listAllPhoneNumber(PhoneNumberLinkDetail phoneNumberLinkDetailkey) {
		List<PhoneNumberLinkDetail> PhoneNumberLinkDetailList = new ArrayList<PhoneNumberLinkDetail>();

		Connection connection = null;

		PhoneNumberLinkDetail phoneNumberLinkDetail = null;
		PhoneNumberDetail phoneNumberDetail = null;

		Statement statement = null;
		ResultSet resultSet = null;

		PhoneNumberDetail phoneNumberDetailFromDB = null;

		PreparedStatement preparedStatementPhoneNumberLink = null;
		PreparedStatement preparedStatementPhoneNumber = null;

		try {
			connection = DBConnection.getDBConnection();

			String phoneNumberLinkSQLStr = "SELECT * FROM PhoneNumberLink WHERE	RECORDSTATUS='Active' AND relatedID = ?";

			preparedStatementPhoneNumberLink = connection.prepareStatement(phoneNumberLinkSQLStr);
			preparedStatementPhoneNumberLink.setInt(1, phoneNumberLinkDetailkey.getRelatedID());

			resultSet = preparedStatementPhoneNumberLink.executeQuery();

			String phoneNumberSQLStr = "SELECT * FROM PhoneNumber WHERE phoneNumberID = ? AND RECORDSTATUS='Active'";

			preparedStatementPhoneNumber = connection.prepareStatement(phoneNumberSQLStr);

			while (resultSet.next()) {
				// phoneNumberDetailFromDB = new PhoneNumberDetail();

				phoneNumberLinkDetail = new PhoneNumberLinkDetail();
				phoneNumberDetail = new PhoneNumberDetail();

				phoneNumberLinkDetail.setPhoneNumberLinkID(resultSet.getInt("phoneNumberLinkID"));
				phoneNumberDetail.setPhoneNumberID(resultSet.getInt("phoneNumberID"));
				phoneNumberLinkDetail.setPhoneNumberID(resultSet.getInt("phoneNumberID"));
				phoneNumberLinkDetail.setRelatedID(resultSet.getInt("relatedID"));
				phoneNumberLinkDetail.setTypeCode(resultSet.getString("typeCode"));
				phoneNumberLinkDetail.setPrimaryInd(resultSet.getString("primaryInd"));
				phoneNumberLinkDetail.setStartDate(resultSet.getDate("startDate"));
				phoneNumberLinkDetail.setEndDate(resultSet.getDate("endDate"));

				preparedStatementPhoneNumber.setInt(1, phoneNumberDetail.getPhoneNumberID());

				ResultSet resultSet1 = preparedStatementPhoneNumber.executeQuery();

				while (resultSet1.next()) {

					phoneNumberDetail.setCountryCode(resultSet1.getInt("countryCode"));
					phoneNumberDetail.setAreaCode(resultSet1.getInt("areaCode"));
					phoneNumberDetail.setPhoneNumber(resultSet1.getLong("phoneNumber"));
					phoneNumberDetail.setExtension(resultSet1.getInt("extension"));

				}
				phoneNumberLinkDetail.setPhoneNumberDetail(phoneNumberDetail);
				PhoneNumberLinkDetailList.add(phoneNumberLinkDetail);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return PhoneNumberLinkDetailList;

	}

}
