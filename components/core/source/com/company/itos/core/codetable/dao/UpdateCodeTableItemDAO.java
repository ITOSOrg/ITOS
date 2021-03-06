package com.company.itos.core.codetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.codetable.pojo.CodeTableItemDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

public class UpdateCodeTableItemDAO {

	public String UpdateCodeTableItem(CodeTableItemDetail codeTableItemDetail) {

		Connection connection = null;
		String returnMassegeStr = "";

		int codeTableItemVersionNoFromUpdate = codeTableItemDetail.getVersionNo();

		int codeTableItemVersionNoFromDatabase = returnVersionNumberFromCodeTableItem(codeTableItemDetail);

		if (codeTableItemVersionNoFromUpdate == codeTableItemVersionNoFromDatabase) {

			codeTableItemVersionNoFromDatabase++;

			try {
				connection = DBConnection.getDBConnection();

				String codeTableItemSQLStr = "UPDATE	CodeTableItem	SET tableName = ?, code = ?, description = ?, annotation = ?, isEnabled = ?, recordStatus = ?"
						+ " WHERE code = '" + codeTableItemDetail.getCode() + "'";

				PreparedStatement preparedStatement = connection.prepareStatement(codeTableItemSQLStr);

				preparedStatement.setString(1, codeTableItemDetail.getTableName());
				preparedStatement.setString(2, codeTableItemDetail.getCode());
				preparedStatement.setString(3, codeTableItemDetail.getDescription());
				preparedStatement.setString(4, codeTableItemDetail.getAnnotation());
				preparedStatement.setString(5, codeTableItemDetail.getIsEnabled());
				preparedStatement.setString(6, codeTableItemDetail.getRecordStatus());

				preparedStatement.executeUpdate();
				
				//inserting data into AuditTrail Table for CodeTableItem Table
				AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
				
				auditTrailDetails.setTableName("CodeTableItem");
				auditTrailDetails.setOperationType("Update");
				auditTrailDetails.setUserName("Rahul");
				auditTrailDetails.setRelatedID(codeTableItemDetail.getCode());
				auditTrailDetails.setTransactionType("Online");
				
				CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {

				e.printStackTrace();
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
			}
		}

		return returnMassegeStr;

	}

	public int returnVersionNumberFromCodeTableItem(CodeTableItemDetail codeTableItemDetail) {

		int versionNo = 0;
		try {

			Connection connection = DBConnection.getDBConnection();

			String codeTableItemSQLStr = "SELECT	versionNo	FROM	CodeTableItem	WHERE	 code = '" + codeTableItemDetail.getCode() + "'";

			PreparedStatement preparedStatement = connection.prepareStatement(codeTableItemSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				versionNo = resultSet.getInt("versionNo");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return versionNo;
	}

}
