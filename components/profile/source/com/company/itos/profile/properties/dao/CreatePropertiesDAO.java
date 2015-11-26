package com.company.itos.profile.properties.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.core.util.JavaUtildates;
import com.company.itos.profile.properties.pojo.PropertiesDetail;

public class CreatePropertiesDAO {
		
	public String createProperties(PropertiesDetail propertiesDetail){
		
		String returnMassegeStr = "";

		DBConnection dbConnection = new DBConnection();

		Connection connection = null;
		try {
			
			connection = dbConnection.getDBConnection();
			
			String propertiesSQLStr = "INSERT INTO Properties ( propertyID, category, name, value, type, defaultValue, dynamic, createdBy, createdOn, lastModifiedBy, lastModifiedOn, versionNo) "
					+ "VALUES(PropertiesSEQ.nextval, ?, ?, ?, ?, ?, ?, 'Rahul', ?, 'Rahul', ?, 1)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(propertiesSQLStr);
			
			preparedStatement.setString(1, propertiesDetail.getCategory());
			preparedStatement.setString(2, propertiesDetail.getName());
			preparedStatement.setString(3, propertiesDetail.getValue());
			preparedStatement.setString(4, propertiesDetail.getType());
			preparedStatement.setString(5, propertiesDetail.getDefaultValue());
			preparedStatement.setString(6, propertiesDetail.getDynamic());
			
			String crrentDateTime = JavaUtildates.getCurrentDateTime();

			Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
			preparedStatement.setTimestamp(7, timestamp);
			preparedStatement.setTimestamp(8, timestamp);
			
			preparedStatement.executeQuery();
			
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;
		
	}
}
