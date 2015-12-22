package com.company.itos.core.properties.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.company.itos.core.util.dataaccess.DBConnection;

import com.company.itos.core.properties.pojo.PropertiesDetail;
import com.company.itos.core.util.CRUDConstants;

public class ReadPropertiesDAO {
	
	public String ReadProperties(PropertiesDetail propertiesDetail){
		
		String returnMassegeStr = "";
		try {

			Connection connection = DBConnection.getDBConnection();
			
			String PropertiesSQLStr = "SELECT * FROM Properties WHERE propertyID = \'" + propertiesDetail.getPropertyID()
					+ "\'";
			
			PreparedStatement preparedStatementpersonIdentity =  connection.prepareStatement(PropertiesSQLStr);
			ResultSet resultSet = preparedStatementpersonIdentity.executeQuery();
			
			while(resultSet.next()){
				//PropertiesDetail propertiesDetail = new PropertiesDetail();
				
				propertiesDetail.setPropertyID(resultSet.getLong("propertyID"));
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
