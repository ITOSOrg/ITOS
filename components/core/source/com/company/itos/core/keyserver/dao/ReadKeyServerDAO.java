package com.company.itos.core.keyserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.keyserver.pojo.KeyServerDetail;
import com.company.itos.core.util.CRUDConstants;

public class ReadKeyServerDAO {
	
	public String ReadKeyServer(KeyServerDetail keyServerDetail){
		
		String returnMassegeStr = "";
		try {

			Connection connection = DBConnection.getDBConnection();
			
			String KeyServerSQLStr = "SELECT * FROM KeyServer WHERE keysetCode = \'" + keyServerDetail.getKeysetCode()
					+ "\' AND RECORDSTATUS='Active'";
			
			PreparedStatement preparedStatement =  connection.prepareStatement(KeyServerSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				keyServerDetail.setKeysetCode(resultSet.getString("keysetCode"));
				keyServerDetail.setNextUniqueIdBlock(resultSet.getLong("nextUniqueIdBlock"));
				keyServerDetail.setHumanReadable(resultSet.getString("humanReadable"));
				keyServerDetail.setAnnotation(resultSet.getString("annotation"));
				keyServerDetail.setStrategy(resultSet.getString("strategy"));
				keyServerDetail.setRecordStatus(resultSet.getString("recordStatus"));
				keyServerDetail.setCreatedBy(resultSet.getString("createdBy"));
				keyServerDetail.setLastModifiedBy(resultSet.getString("lastModifiedBy"));
				keyServerDetail.setCreatedOn(resultSet.getTimestamp("createdOn"));
				keyServerDetail.setLastModifiedOn(resultSet.getTimestamp("lastModifiedOn"));
				keyServerDetail.setVersionNo(resultSet.getInt("versionNo"));
			}
			
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;
		}

}
