package com.company.itos.profile.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.phone.pojo.PhoneNumberDetail;
import com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail;

public class DeletePhoneNumberDAO {

	public String deletePhoneNumber(PhoneNumberLinkDetail phoneNumberLinkDetail) {

		Connection connection = null;
		String returnMassegeStr = "";
		try {
			PhoneNumberDetail phoneNumberDetail = phoneNumberLinkDetail.getPhoneNumberDetail();

			String phoneNumberSQLStr = "UPDATE	PhoneNumber	SET	RECORDSTATUS='cancel'	WHERE phoneNumberID = "
					+ phoneNumberLinkDetail.getPhoneNumberID();

			String phoneNumberLinkSQLStr = "UPDATE PhoneNumberLink SET	RECORDSTATUS='cancel'	WHERE phoneNumberLinkID= "
					+ phoneNumberLinkDetail.getPhoneNumberLinkID();

			connection = DBConnection.getDBConnection();

			PreparedStatement preparedStatementPhoneNumber = connection.prepareStatement(phoneNumberSQLStr);
			preparedStatementPhoneNumber.executeUpdate();

			PreparedStatement preparedStatementPhoneNumberLink = connection.prepareStatement(phoneNumberLinkSQLStr);
			preparedStatementPhoneNumberLink.executeUpdate();
			
			//inserting data into AuditTrail Table for PhoneNumber Table
			AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
			
			auditTrailDetails.setTableName("PhoneNumber");
			auditTrailDetails.setOperationType("Update");
			auditTrailDetails.setUserName("Rahul");
			auditTrailDetails.setRelatedID(phoneNumberLinkDetail.getRelatedID());
			auditTrailDetails.setTransactionType("Online");
			
			CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
			createAuditTrailDAO.createAuditTrail(auditTrailDetails);
		} catch (SQLException e) {

			e.printStackTrace();

		}

		return returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
	}

}
