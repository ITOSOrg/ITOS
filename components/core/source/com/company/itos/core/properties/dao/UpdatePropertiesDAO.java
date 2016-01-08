package com.company.itos.core.properties.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.properties.pojo.PropertiesDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

public class UpdatePropertiesDAO {

	public String updateProperties(PropertiesDetail propertiesDetail) {

		Connection connection = null;
		String returnMassegeStr = "";

		int propertiesVersionNoFromUpdate = propertiesDetail.getVersionNo();

		int propertiesVersionNoFromDatabase = returnVersionNumberFromProperties(propertiesDetail);

		if (propertiesVersionNoFromUpdate == propertiesVersionNoFromDatabase) {

			propertiesVersionNoFromDatabase++;

			try {
				connection = DBConnection.getDBConnection();

				String personIdentitySQLStr = "UPDATE	Properties	SET category = ?, name = ?, value = ?, type = ?, defaultValue = ?, dynamic = ?, createdBy = ?, 	lastModifiedBy = ?"
						+ " WHERE propertyID = '" + propertiesDetail.getPropertyID() + "'";

				PreparedStatement preparedStatement = connection.prepareStatement(personIdentitySQLStr);

				preparedStatement.setString(1, propertiesDetail.getCategory());
				preparedStatement.setString(2, propertiesDetail.getName());
				preparedStatement.setString(3, propertiesDetail.getValue());
				preparedStatement.setString(4, propertiesDetail.getType());
				preparedStatement.setString(5, propertiesDetail.getDefaultValue());
				preparedStatement.setString(6, propertiesDetail.getDynamic());
				preparedStatement.setString(7, propertiesDetail.getCreatedBy());
				preparedStatement.setString(8, propertiesDetail.getLastModifiedBy());
				preparedStatement.executeUpdate();
				
				//inserting data into AuditTrail Table for Properties Table
				AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
				
				auditTrailDetails.setTableName("Properties");
				auditTrailDetails.setOperationType("Update");
				auditTrailDetails.setUserName("Rahul");
				auditTrailDetails.setRelatedID(propertiesDetail.getPropertyID());
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

	public int returnVersionNumberFromProperties(PropertiesDetail propertiesDetail) {

		int versionNo = 0;
		try {
			DBConnection dbConnection = new DBConnection();

			Connection connection = dbConnection.getDBConnection();

			String PropertiesSQLStr = "SELECT	versionNo	FROM	Properties	WHERE	 propertyID = '" + propertiesDetail.getPropertyID() + "'";

			PreparedStatement preparedStatement = connection.prepareStatement(PropertiesSQLStr);
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
