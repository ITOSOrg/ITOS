package com.company.itos.profile.email.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.audittrail.dao.ReadAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDtls;
import com.company.itos.core.audittrail.pojo.AuditTrailkey;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.email.pojo.EmailAddressDetail;
import com.company.itos.profile.email.pojo.EmailAddressLinkDetail;

public class ReadEmailAddressDAO {

	public String readEmailAddress(EmailAddressLinkDetail emailAddressLinkDetail) {

		String returnMassegeStr = "";
		ResultSet resultSet = null;

		String emailAddressLinkSQLStr = "SELECT * FROM EmailAddressLink WHERE emailAddressLinkID = \'"
				+ emailAddressLinkDetail.getEmailAddressLinkID() + "\' AND RECORDSTATUS='Active'";

		try {

			Connection connection = DBConnection.getDBConnection();

			PreparedStatement preparedStatementemailAddressLink = connection.prepareStatement(emailAddressLinkSQLStr);
			resultSet = preparedStatementemailAddressLink.executeQuery();

			if (resultSet.next()) {

				emailAddressLinkDetail.setEmailAddressID(resultSet.getLong("emailAddressID"));
				emailAddressLinkDetail.setTypeCode(resultSet.getString("typeCode"));
				emailAddressLinkDetail.setPrimaryInd(resultSet.getString("primaryInd"));
				emailAddressLinkDetail.setStartDate(resultSet.getDate("startDate"));
				emailAddressLinkDetail.setEndDate(resultSet.getDate("endDate"));
				emailAddressLinkDetail.setEmailAddressLinkID(resultSet.getLong("emailAddressLinkID"));
				emailAddressLinkDetail.setRelatedID(resultSet.getLong("relatedID"));
				emailAddressLinkDetail.setVersionNo(resultSet.getInt("versionNo"));
			}

			String emailAddressSQLStr = "SELECT * FROM EmailAddress WHERE emailAddressID = \'" + emailAddressLinkDetail.getEmailAddressID()
					+ "\' AND RECORDSTATUS='Active'";

			PreparedStatement preparedStatementEmailAddress = connection.prepareStatement(emailAddressSQLStr);
			ResultSet resultSet1 = preparedStatementEmailAddress.executeQuery();

			if (resultSet1.next()) {

				EmailAddressDetail emailAddressDetail = new EmailAddressDetail();
				emailAddressDetail.setEmailAddress(resultSet1.getString("emailAddress"));
				emailAddressDetail.setRecordStatus(resultSet1.getString("recordStatus"));
				emailAddressDetail.setVersionNo(resultSet1.getInt("versionNo"));
				emailAddressLinkDetail.setEmailAddressDetail(emailAddressDetail);
			}
			

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;
	}

	public String readPrimaryEmailAddress(EmailAddressLinkDetail emailAddressLinkDetail) {

		String returnMassegeStr = "";
		ResultSet resultSet = null;

		String emailAddressLinkSQLStr = "SELECT * FROM EmailAddressLink WHERE relatedID = \'" + emailAddressLinkDetail.getRelatedID()
				+ "\' AND RECORDSTATUS='Active' AND typeCode = 'Primary'";

		try {

			Connection connection = DBConnection.getDBConnection();

			PreparedStatement preparedStatementemailAddressLink = connection.prepareStatement(emailAddressLinkSQLStr);
			resultSet = preparedStatementemailAddressLink.executeQuery();

			while (resultSet.next()) {

				emailAddressLinkDetail.setEmailAddressID(resultSet.getLong("emailAddressID"));
				emailAddressLinkDetail.setTypeCode(resultSet.getString("typeCode"));
				emailAddressLinkDetail.setPrimaryInd(resultSet.getString("primaryInd"));
				emailAddressLinkDetail.setStartDate(resultSet.getDate("startDate"));
				emailAddressLinkDetail.setEndDate(resultSet.getDate("endDate"));
				emailAddressLinkDetail.setEmailAddressLinkID(resultSet.getLong("emailAddressLinkID"));
				emailAddressLinkDetail.setRelatedID(resultSet.getLong("relatedID"));
				emailAddressLinkDetail.setVersionNo(resultSet.getInt("versionNo"));
			}

			String emailAddressSQLStr = "SELECT * FROM EmailAddress WHERE emailAddressID = \'" + emailAddressLinkDetail.getEmailAddressID()
					+ "\' AND RECORDSTATUS='Active'";

			PreparedStatement preparedStatementEmailAddress = connection.prepareStatement(emailAddressSQLStr);
			ResultSet resultSet1 = preparedStatementEmailAddress.executeQuery();

			while (resultSet1.next()) {

				EmailAddressDetail emailAddressDetail = new EmailAddressDetail();
				emailAddressDetail.setEmailAddress(resultSet1.getString("emailAddress"));
				emailAddressLinkDetail.setEmailAddressDetail(emailAddressDetail);
			}
			
			//Retriving audit info from AuditTrail Table
			AuditTrailkey auditTrailkey = new AuditTrailkey();
			auditTrailkey.setRelatedID(emailAddressLinkDetail.getEmailAddressLinkID());
			auditTrailkey.setTableName("Email");
			
			ReadAuditTrailDAO readAuditTrailDAO = new ReadAuditTrailDAO();
			AuditTrailDtls auditTrailDtls = readAuditTrailDAO.readAuditTrailBaseOnCondition(auditTrailkey);
			
			
			emailAddressLinkDetail.setAuditTrailDtls(auditTrailDtls);

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;
	}

}
