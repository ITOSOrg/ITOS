package com.company.itos.profile.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.type.UniqueID;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.JavaUtildates;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

public class CreatePhoneNumberDAO {

	public String createPhoneNumber(PhoneNumberLinkDetail phoneNumberLinkDetail) {
		String returnMassegeStr = "";

		Connection connection = null;

		// UpdatePhoneNumberDAO updatePhoneNumberDAO = new
		// UpdatePhoneNumberDAO();
		// SupdatePhoneNumberDAO.returnVersionNumber(phoneNumberDetail);

		try {

			PhoneNumberDetail phoneNumberDetail = phoneNumberLinkDetail.getPhoneNumberDetail();

			connection = DBConnection.getDBConnection();

			/*
			 * PreparedStatement preparedStatement =
			 * connection.prepareStatement(
			 * "SELECT PhoneNumberSEQ.nextval FROM DUAL");
			 * 
			 * ResultSet resultSetPNSeq = preparedStatement.executeQuery();
			 * 
			 * 
			 * if (resultSetPNSeq.next()) {
			 * phoneNumberDetail.setPhoneNumberID((resultSetPNSeq.getInt(1))); }
			 */
			String PhoneNumberSQLStr = "INSERT INTO PhoneNumber (phoneNumberID, countryCode, areaCode, phoneNumber, extension, recordStatus, versionNo)"
					+ "VALUES(?, ?, ?, ?, ?, 'Active', 1)";

			PreparedStatement preparedStatementPhoneNumber = connection.prepareStatement(PhoneNumberSQLStr);
			
			long phoneNumberID = UniqueID.nextUniqueID();

			preparedStatementPhoneNumber.setLong(1, phoneNumberID);
			preparedStatementPhoneNumber.setInt(2, phoneNumberDetail.getCountryCode());
			preparedStatementPhoneNumber.setInt(3, phoneNumberDetail.getAreaCode());
			preparedStatementPhoneNumber.setLong(4, phoneNumberDetail.getPhoneNumber());
			preparedStatementPhoneNumber.setInt(5, phoneNumberDetail.getExtension());
			preparedStatementPhoneNumber.execute();

			/*
			 * PreparedStatement preparedStatement2 =
			 * connection.prepareStatement
			 * ("SELECT PhoneNumberLinkSEQ.nextval FROM DUAL"); ResultSet
			 * resultSetPNLSeq = preparedStatement2.executeQuery();
			 * 
			 * if (resultSetPNLSeq.next()) {
			 * phoneNumberLinkDetail.setPhoneNumberLinkID
			 * ((resultSetPNLSeq.getInt(1))); }
			 */

			String PhoneNumberLinkSQLStr = "INSERT INTO PhoneNumberLink(phoneNumberLinkID, relatedID, phoneNumberID, typeCode, primaryInd, startDate, endDate, recordStatus, versionNo )"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, 'Active', 1)";

			PreparedStatement preparedStatementPhoneNumberLink = connection.prepareStatement(PhoneNumberLinkSQLStr);
			
			Long phoneNumberLinkID = UniqueID.nextUniqueID();

			preparedStatementPhoneNumberLink.setLong(1, phoneNumberLinkID);
			preparedStatementPhoneNumberLink.setLong(2, phoneNumberLinkDetail.getRelatedID());
			preparedStatementPhoneNumberLink.setLong(3, phoneNumberID);
			preparedStatementPhoneNumberLink.setString(4, phoneNumberLinkDetail.getTypeCode());
			preparedStatementPhoneNumberLink.setString(5, phoneNumberLinkDetail.getPrimaryInd());
			preparedStatementPhoneNumberLink.setDate(6, JavaUtildates.convertUtilToSql(phoneNumberLinkDetail.getStartDate()));
			preparedStatementPhoneNumberLink.setDate(7, JavaUtildates.convertUtilToSql(phoneNumberLinkDetail.getEndDate()));
			preparedStatementPhoneNumberLink.execute();
			
			phoneNumberLinkDetail.setPhoneNumberLinkID(phoneNumberLinkID);
			
			//inserting data into AuditTrail Table for PhoneNumber Table
			AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
			
			auditTrailDetails.setTableName("PhoneNumber");
			auditTrailDetails.setOperationType("Create");
			auditTrailDetails.setUserName("Rahul");
			auditTrailDetails.setRelatedID(phoneNumberLinkID);
			auditTrailDetails.setTransactionType("Online");
			
			CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
			createAuditTrailDAO.createAuditTrail(auditTrailDetails);

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;

	}

}
