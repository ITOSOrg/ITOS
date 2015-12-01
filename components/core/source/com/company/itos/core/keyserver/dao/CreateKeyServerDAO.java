package com.company.itos.core.keyserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.company.itos.core.keyserver.pojo.KeyServerDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.core.util.JavaUtildates;

public class CreateKeyServerDAO {
	
	public String CreateKeyServer(KeyServerDetail keyServerDetail){
		
		String returnMassegeStr = "";

		DBConnection dbConnection = new DBConnection();

		Connection connection = null;
		try {
			
			connection = dbConnection.getDBConnection();
			
			String KeyServerSQLStr = "Insert into KeyServer (keysetCode, nextUniqueIdBlock, humanReadable, annotation, strategy, recordStatus, createdBy, createdOn, lastModifiedBy, lastModifiedOn, versionNo )" + "VALUES(?, ?, ?, ?, ?, 'Active', 'Rahul', ?, 'Rahul', ?, 1)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(KeyServerSQLStr);
			
			preparedStatement.setString(1, keyServerDetail.getKeysetCode());
			preparedStatement.setLong(2, keyServerDetail.getNextUniqueIdBlock());
			preparedStatement.setString(3, keyServerDetail.getHumanReadable());
			preparedStatement.setString(4, keyServerDetail.getAnnotation());
			preparedStatement.setString(5, keyServerDetail.getStrategy());
			
			String crrentDateTime = JavaUtildates.getCurrentDateTime();

			Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
			preparedStatement.setTimestamp(6, timestamp);
			preparedStatement.setTimestamp(7, timestamp);
			
			preparedStatement.executeQuery();
			
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;
		
	}

}
