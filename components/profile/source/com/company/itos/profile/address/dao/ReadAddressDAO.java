package com.company.itos.profile.address.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.audittrail.dao.ReadAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDtls;
import com.company.itos.core.audittrail.pojo.AuditTrailkey;
import com.company.itos.core.codetable.dao.ReadCodeTableItemDAO;
import com.company.itos.core.codetable.pojo.CodeTableItemKey;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.address.pojo.AddressDetail;
import com.company.itos.profile.address.pojo.AddressLinkDetail;

public class ReadAddressDAO {

	public String readPrimaryAddress(AddressLinkDetail addressLinkDetail) {
		String returnMassegeStr = "";

		try {

			Connection connection = DBConnection.getDBConnection();

			String addressLinkSQLStr = "SELECT * FROM AddressLink WHERE relatedID = \'" + addressLinkDetail.getRelatedID()
					+ "\' AND RECORDSTATUS='Active' AND typeCode = 'Primary'";

			PreparedStatement preparedStatementAddressLinkSQLStr = connection.prepareStatement(addressLinkSQLStr);
			ResultSet resultSetaddressLink = preparedStatementAddressLinkSQLStr.executeQuery();

			while (resultSetaddressLink.next()) {
				addressLinkDetail.setAddressLinkID(resultSetaddressLink.getLong("addressLinkID"));
				addressLinkDetail.setRelatedID(resultSetaddressLink.getLong("relatedID"));
				addressLinkDetail.setAddressID(resultSetaddressLink.getLong("addressID"));
				addressLinkDetail.setTypeCode(resultSetaddressLink.getString("typeCode"));
				addressLinkDetail.setPrimaryInd(resultSetaddressLink.getString("primaryInd"));
				addressLinkDetail.setStartDate(resultSetaddressLink.getDate("startDate"));
				addressLinkDetail.setEndDate(resultSetaddressLink.getDate("endDate"));
				addressLinkDetail.setVersionNo(resultSetaddressLink.getInt("versionNo"));
				addressLinkDetail.setRecordStatus(resultSetaddressLink.getString("recordStatus"));
			}

			String addressSQLStr = "SELECT * FROM Address WHERE addressID = \'" + addressLinkDetail.getAddressID() + "\'";

			PreparedStatement preparedStatementaddressSQLStr = connection.prepareStatement(addressSQLStr);
			ResultSet resultSetaddress = preparedStatementaddressSQLStr.executeQuery();

			while (resultSetaddress.next()) {
				AddressDetail addressDetail = new AddressDetail();

				addressDetail.setAddressId(resultSetaddress.getLong("addressID"));
				addressDetail.setStreetOne(resultSetaddress.getString("streetOne"));
				addressDetail.setStreetTwo(resultSetaddress.getString("streetTwo"));
				addressDetail.setAptUnit(resultSetaddress.getString("aptUnit"));
				addressDetail.setCity(resultSetaddress.getString("city"));
				addressDetail.setCounty(resultSetaddress.getString("county"));
				addressDetail.setState(resultSetaddress.getString("state"));
				addressDetail.setCountry(resultSetaddress.getString("country"));
				addressDetail.setZipCode(resultSetaddress.getInt("zipCode"));
				addressDetail.setVersionNo(resultSetaddress.getInt("versionNo"));

				CodeTableItemKey codeTableItemKey = new CodeTableItemKey();
				codeTableItemKey.setCode(addressDetail.getState());

				codeTableItemKey.setTableName("State");
				ReadCodeTableItemDAO readCodeTableItemDAO = new ReadCodeTableItemDAO();
				readCodeTableItemDAO.readCodeTableItemDescription(codeTableItemKey);

				addressDetail.setState(codeTableItemKey.getDescription());
				
				//Retriving audit info from AuditTrail Table
				AuditTrailkey auditTrailkey = new AuditTrailkey();
				auditTrailkey.setRelatedID(addressLinkDetail.getAddressLinkID());
				auditTrailkey.setTableName("Address");
				
				ReadAuditTrailDAO readAuditTrailDAO = new ReadAuditTrailDAO();
				AuditTrailDtls auditTrailDtls = readAuditTrailDAO.readAuditTrailBaseOnCondition(auditTrailkey);
				
				
				addressLinkDetail.setAuditTrailDtls(auditTrailDtls);
				
				addressLinkDetail.setAddressDetail(addressDetail);
			}

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;

	}

	public String readAddress(AddressLinkDetail addressLinkDetail) {
		String returnMassegeStr = "";

		try {

			Connection connection = DBConnection.getDBConnection();

			String addressLinkSQLStr = "SELECT * FROM AddressLink WHERE addressLinkID = \'" + addressLinkDetail.getAddressLinkID()
					+ "\' AND RECORDSTATUS='Active'";

			PreparedStatement preparedStatementAddressLinkSQLStr = connection.prepareStatement(addressLinkSQLStr);
			ResultSet resultSetaddressLink = preparedStatementAddressLinkSQLStr.executeQuery();

			while (resultSetaddressLink.next()) {
				addressLinkDetail.setAddressLinkID(resultSetaddressLink.getLong("addressLinkID"));
				addressLinkDetail.setRelatedID(resultSetaddressLink.getLong("relatedID"));
				addressLinkDetail.setAddressID(resultSetaddressLink.getLong("addressID"));
				addressLinkDetail.setTypeCode(resultSetaddressLink.getString("typeCode"));
				addressLinkDetail.setPrimaryInd(resultSetaddressLink.getString("primaryInd"));
				addressLinkDetail.setStartDate(resultSetaddressLink.getDate("startDate"));
				addressLinkDetail.setEndDate(resultSetaddressLink.getDate("endDate"));
				addressLinkDetail.setVersionNo(resultSetaddressLink.getInt("versionNo"));
				addressLinkDetail.setRecordStatus(resultSetaddressLink.getString("recordStatus"));
			}

			String addressSQLStr = "SELECT * FROM Address WHERE addressID = \'" + addressLinkDetail.getAddressID() + "\'";

			PreparedStatement preparedStatementaddressSQLStr = connection.prepareStatement(addressSQLStr);
			ResultSet resultSetaddress = preparedStatementaddressSQLStr.executeQuery();

			while (resultSetaddress.next()) {
				AddressDetail addressDetail = new AddressDetail();

				addressDetail.setAddressId(resultSetaddress.getLong("addressID"));
				addressDetail.setStreetOne(resultSetaddress.getString("streetOne"));
				addressDetail.setStreetTwo(resultSetaddress.getString("streetTwo"));
				addressDetail.setAptUnit(resultSetaddress.getString("aptUnit"));
				addressDetail.setCity(resultSetaddress.getString("city"));
				addressDetail.setCounty(resultSetaddress.getString("county"));
				addressDetail.setState(resultSetaddress.getString("state"));
				addressDetail.setCountry(resultSetaddress.getString("country"));
				addressDetail.setZipCode(resultSetaddress.getInt("zipCode"));
				addressDetail.setVersionNo(resultSetaddress.getInt("versionNo"));

				addressLinkDetail.setAddressDetail(addressDetail);
			}

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;

	}

}
