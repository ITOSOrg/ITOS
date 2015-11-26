package com.company.itos.profile.properties.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.properties.pojo.PropertiesDetail;

public class ReadPropertiesDAO {
	
	public String ReadProperties(PropertiesDetail propertiesDetail){
		
		String returnMassegeStr = "";
		try {

			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getDBConnection();
			
			String PropertiesSQLStr = "SELECT * FROM Properties WHERE propertyID = \'" + propertiesDetail.getPropertyID()
					+ "\'";
			
			PreparedStatement preparedStatementpersonIdentity =  connection.prepareStatement(PropertiesSQLStr);
			ResultSet resultSet = preparedStatementpersonIdentity.executeQuery();
			
			while(resultSet.next()){
				//PropertiesDetail propertiesDetail = new PropertiesDetail();
				
				propertiesDetail.setPropertyID(resultSet.getInt("propertyID"));
				propertiesDetail.setCategory(resultSet.getString("category"));
				propertiesDetail.setName(resultSet.getString("name"));
				propertiesDetail.setValue(resultSet.getString("value"));
				propertiesDetail.setType(resultSet.getString("type"));
				propertiesDetail.setDefaultValue(resultSet.getString("defaultValue"));
				propertiesDetail.setDynamic(resultSet.getString("dynamic"));
				propertiesDetail.setName(resultSet.getString("name"));
				propertiesDetail.setCreatedBy(resultSet.getString("createdBy"));
				propertiesDetail.setCreatedOn(resultSet.getTimestamp("createdOn"));
				propertiesDetail.setLastModifiedBy(resultSet.getString("lastModifiedBy"));
				propertiesDetail.setLastModifiedOn(resultSet.getTimestamp("lastModifiedOn"));
				propertiesDetail.setVersionNo(resultSet.getInt("versionNo"));
				
			}
			
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;
		}

}
