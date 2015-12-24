package com.company.itos.profile.address.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.type.UniqueID;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.address.pojo.AddressDetail;
import com.company.itos.profile.address.pojo.AddressLinkDetail;

public class CreateAddressDAO {

	public String createAddress(AddressLinkDetail addressLinkDetail) {

		String returnMassegeStr = "";

		Connection connection = null;

		AddressDetail addressDetail = addressLinkDetail.getAddressDetail();

		try {
			connection = DBConnection.getDBConnection();

			/*
			 * PreparedStatement preparedStatementAddress =
			 * connection.prepareStatement
			 * ("SELECT AddressSEQ.nextval FROM DUAL"); PreparedStatement
			 * preparedStatementAddressLink =
			 * connection.prepareStatement("SELECT AddressLinkSEQ.nextval FROM DUAL"
			 * );
			 * 
			 * ResultSet resultSetAddress =
			 * preparedStatementAddress.executeQuery(); ResultSet
			 * resultSetAddressLink =
			 * preparedStatementAddressLink.executeQuery();
			 * 
			 * while (resultSetAddress.next()) {
			 * addressDetail.setAddressId(resultSetAddress.getInt(1)); } while
			 * (resultSetAddressLink.next()) {
			 * addressLinkDetail.setAddressLinkID
			 * (resultSetAddressLink.getInt(1)); }
			 */

			String addressSQLStr = "INSERT INTO Address (addressId, streetOne, streetTwo, aptUnit, city, county, state, country, zipCode, versionNo)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, 1)";

			PreparedStatement preparedStatementaddressSQLStr = connection.prepareStatement(addressSQLStr);
			
			long addressId = UniqueID.nextUniqueID();
			
			preparedStatementaddressSQLStr.setLong(1, addressId);
			preparedStatementaddressSQLStr.setString(2, addressDetail.getStreetOne());
			preparedStatementaddressSQLStr.setString(3, addressDetail.getStreetTwo());
			preparedStatementaddressSQLStr.setString(4, addressDetail.getAptUnit());
			preparedStatementaddressSQLStr.setString(5, addressDetail.getCity());
			preparedStatementaddressSQLStr.setString(6, addressDetail.getCounty());
			preparedStatementaddressSQLStr.setString(7, addressDetail.getState());
			preparedStatementaddressSQLStr.setString(8, addressDetail.getCountry());
			preparedStatementaddressSQLStr.setInt(9, addressDetail.getZipCode());
			preparedStatementaddressSQLStr.execute();

			String addressLinkSQLStr = "INSERT INTO AddressLink (addressLinkID, relatedID, addressID, typeCode, primaryInd, startDate, endDate, recordStatus, versionNo)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, 'Active', 1)";

			PreparedStatement preparedStatementaddressLinkSQLStr = connection.prepareStatement(addressLinkSQLStr);
			preparedStatementaddressLinkSQLStr.setLong(1, addressLinkDetail.getAddressLinkID());
			preparedStatementaddressLinkSQLStr.setLong(2, addressLinkDetail.getRelatedID());
			preparedStatementaddressLinkSQLStr.setLong(3, addressId);
			preparedStatementaddressLinkSQLStr.setString(4, addressLinkDetail.getTypeCode());
			preparedStatementaddressLinkSQLStr.setString(5, addressLinkDetail.getPrimaryInd());
			preparedStatementaddressLinkSQLStr.setDate(6, addressLinkDetail.getStartDate());
			preparedStatementaddressLinkSQLStr.setDate(7, addressLinkDetail.getEndDate());
			preparedStatementaddressLinkSQLStr.execute();

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;

	}

}
