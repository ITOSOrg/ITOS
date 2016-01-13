package com.company.itos.profile.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.audittrail.dao.ReadAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDtls;
import com.company.itos.core.audittrail.pojo.AuditTrailkey;
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
			preparedStatementPhoneNumberLink.setLong(1, phoneNumberLinkDetailkey.getRelatedID());

			resultSet = preparedStatementPhoneNumberLink.executeQuery();

			String phoneNumberSQLStr = "SELECT * FROM PhoneNumber WHERE phoneNumberID = ? AND RECORDSTATUS='Active'";

			preparedStatementPhoneNumber = connection.prepareStatement(phoneNumberSQLStr);

			while (resultSet.next()) {
				// phoneNumberDetailFromDB = new PhoneNumberDetail();

				phoneNumberLinkDetail = new PhoneNumberLinkDetail();
				phoneNumberDetail = new PhoneNumberDetail();

				phoneNumberLinkDetail.setPhoneNumberLinkID(resultSet.getLong("phoneNumberLinkID"));
				phoneNumberDetail.setPhoneNumberID(resultSet.getLong("phoneNumberID"));
				phoneNumberLinkDetail.setPhoneNumberID(resultSet.getLong("phoneNumberID"));
				phoneNumberLinkDetail.setRelatedID(resultSet.getLong("relatedID"));
				phoneNumberLinkDetail.setTypeCode(resultSet.getString("typeCode"));
				phoneNumberLinkDetail.setPrimaryInd(resultSet.getString("primaryInd"));
				phoneNumberLinkDetail.setStartDate(resultSet.getDate("startDate"));
				phoneNumberLinkDetail.setEndDate(resultSet.getDate("endDate"));

				preparedStatementPhoneNumber.setLong(1, phoneNumberDetail.getPhoneNumberID());

				ResultSet resultSet1 = preparedStatementPhoneNumber.executeQuery();

				while (resultSet1.next()) {

					phoneNumberDetail.setCountryCode(resultSet1.getInt("countryCode"));
					phoneNumberDetail.setAreaCode(resultSet1.getInt("areaCode"));
					phoneNumberDetail.setPhoneNumber(resultSet1.getLong("phoneNumber"));
					phoneNumberDetail.setExtension(resultSet1.getInt("extension"));

				}
				phoneNumberLinkDetail.setPhoneNumberDetail(phoneNumberDetail);
				
				//Retriving audit info from AuditTrail Table
				AuditTrailkey auditTrailkey = new AuditTrailkey();
				auditTrailkey.setRelatedID(phoneNumberLinkDetail.getPhoneNumberLinkID());
				auditTrailkey.setTableName("PhoneNumber");
				
				ReadAuditTrailDAO readAuditTrailDAO = new ReadAuditTrailDAO();
				AuditTrailDtls auditTrailDtls = readAuditTrailDAO.readAuditTrailBaseOnCondition(auditTrailkey);
				
				
				phoneNumberLinkDetail.setAuditTrailDtls(auditTrailDtls);
				
				PhoneNumberLinkDetailList.add(phoneNumberLinkDetail);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return PhoneNumberLinkDetailList;

	}

}
