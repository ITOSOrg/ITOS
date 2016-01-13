package com.company.itos.profile.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.JavaUtildates;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

public class UpdatePhoneNumberDAO {

	public String updatephoneNumber(PhoneNumberLinkDetail phoneNumberLinkDetail) {

		Connection connection = null;
		ResultSet resultSet = null;
		String returnMassegeStr = "";

		PhoneNumberDetail phoneNumberDetail = phoneNumberLinkDetail.getPhoneNumberDetail();

		// returnVersionNumber( phoneNumberDetail);

		int phoneNumberLinkVersionNoFromUpdate = phoneNumberLinkDetail.getVersionNo();

		int phoneNumberLinkVersionNoFromDatabase = returnPhoneNumberLinkVersionNumber(phoneNumberLinkDetail);

		int phoneNumberVersionNoFromUpdate = phoneNumberDetail.getVersionNo();

		int phoneNumberVersionNoFromDatabase = returnPhoneNumberVersionNumber(phoneNumberDetail);

		if (phoneNumberLinkVersionNoFromUpdate == phoneNumberLinkVersionNoFromDatabase) {
			if (phoneNumberVersionNoFromUpdate == phoneNumberVersionNoFromDatabase) {

				phoneNumberLinkVersionNoFromDatabase++;

				phoneNumberVersionNoFromDatabase++;

				try {
					connection = DBConnection.getDBConnection();

					String phoneNumberSQLStr = "UPDATE	PhoneNumber	SET countryCode = ?, areaCode = ?, phoneNumber = ?, extension = ? WHERE phoneNumberID = '"
							+ phoneNumberLinkDetail.getPhoneNumberID() + "'";

					PreparedStatement preparedStatementPhoneNumber = connection.prepareStatement(phoneNumberSQLStr);
					preparedStatementPhoneNumber.setInt(1, phoneNumberDetail.getCountryCode());
					preparedStatementPhoneNumber.setInt(2, phoneNumberDetail.getAreaCode());
					preparedStatementPhoneNumber.setLong(3, phoneNumberDetail.getPhoneNumber());
					preparedStatementPhoneNumber.setInt(4, phoneNumberDetail.getExtension());

					preparedStatementPhoneNumber.executeUpdate();

					String phoneNumberLinkSQLStr = "UPDATE	PhoneNumberLink	SET typeCode = ?, primaryInd = ?, startDate = ?, endDate = ? WHERE phoneNumberLinkID = '"
							+ phoneNumberLinkDetail.getPhoneNumberLinkID() + "' ";

					PreparedStatement preparedStatementPhoneNumberLink = connection.prepareStatement(phoneNumberLinkSQLStr);
					preparedStatementPhoneNumberLink.setString(1, phoneNumberLinkDetail.getTypeCode());
					preparedStatementPhoneNumberLink.setString(2, phoneNumberLinkDetail.getPrimaryInd());
					preparedStatementPhoneNumberLink.setDate(3, JavaUtildates.convertUtilToSql(phoneNumberLinkDetail.getStartDate()));
					preparedStatementPhoneNumberLink.setDate(4, JavaUtildates.convertUtilToSql(phoneNumberLinkDetail.getEndDate()));

					preparedStatementPhoneNumberLink.executeUpdate();
					
					//inserting data into AuditTrail Table for PhoneNumber Table
					AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
					
					auditTrailDetails.setTableName("PhoneNumber");
					auditTrailDetails.setOperationType("Update");
					auditTrailDetails.setUserName("Rahul");
					auditTrailDetails.setRelatedID(phoneNumberLinkDetail.getPhoneNumberLinkID());
					auditTrailDetails.setTransactionType("Online");
					
					CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
					createAuditTrailDAO.createAuditTrail(auditTrailDetails);


					returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

				} catch (SQLException e) {

					e.printStackTrace();
					returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
				}
			}
		}
		return returnMassegeStr;
	}

	public int returnPhoneNumberLinkVersionNumber(PhoneNumberLinkDetail phoneNumberLinkDetail) {

		int versionNo = 0;
		try {

			Connection connection = DBConnection.getDBConnection();

			String phoneNumberLinkSQLStr = "SELECT	versionNo, relatedID,phoneNumberID	FROM	PhoneNumberLink	WHERE	 phoneNumberLinkID = '"
					+ phoneNumberLinkDetail.getPhoneNumberLinkID() + "'";

			PreparedStatement preparedStatementReturnPhoneNumberLinkVersionNumber = connection.prepareStatement(phoneNumberLinkSQLStr);

			ResultSet resultSet = preparedStatementReturnPhoneNumberLinkVersionNumber.executeQuery();
			if (resultSet.next()) {

				versionNo = resultSet.getInt("versionNo");
				phoneNumberLinkDetail.setRelatedID(resultSet.getLong("relatedID"));
				phoneNumberLinkDetail.setPhoneNumberID(resultSet.getLong("phoneNumberID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return versionNo;
	}

	public int returnPhoneNumberVersionNumber(PhoneNumberDetail phoneNumberDetail) {

		int versionNo = 0;
		try {

			Connection connection = DBConnection.getDBConnection();

			String phoneNumberLinkSQLStr = "SELECT	versionNo, relatedID	FROM	PhoneNumberLink	WHERE	 phoneNumberID = '"
					+ phoneNumberDetail.getPhoneNumberID() + "'";

			PreparedStatement preparedStatementReturnPhoneNumberVersionNumber = connection.prepareStatement(phoneNumberLinkSQLStr);

			ResultSet resultSet = preparedStatementReturnPhoneNumberVersionNumber.executeQuery();
			if (resultSet.next()) {

				versionNo = resultSet.getInt("versionNo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return versionNo;
	}
	


}
