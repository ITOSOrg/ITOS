package com.company.itos.core.properties.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.properties.pojo.PropertiesDetail;
import com.company.itos.core.util.DBConnection;

public class ListPropertiesDAO {
	
	public List<PropertiesDetail> ListProperties(PropertiesDetail propertiesDetailkey){
		
		List<PropertiesDetail> propertiesList = new ArrayList<PropertiesDetail>();
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;

		try {
			connection = dbConnection.getDBConnection();
			
			String propertiesSQLStr = "SELECT * FROM Properties";
			
			PreparedStatement preparedStatement = connection.prepareStatement(propertiesSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				PropertiesDetail propertiesDetail = new PropertiesDetail();
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
				
				propertiesList.add(propertiesDetail);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return propertiesList;
	}

}
