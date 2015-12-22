package com.company.itos.core.keyserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.keyserver.pojo.KeyServerDetail;

public class ListKeyServerDAO {
	
	public List<KeyServerDetail> listKeyServer(KeyServerDetail keyServerDetailkey){
			
		List<KeyServerDetail> KeyServerList = new ArrayList<KeyServerDetail>();
		
		Connection connection = null;

		try {
			connection = DBConnection.getDBConnection();
			
			String KeyServerSQLStr = "SELECT * FROM KeyServer WHERE RECORDSTATUS='Active'";
			
			PreparedStatement preparedStatement = connection.prepareStatement(KeyServerSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				KeyServerDetail keyServerDetail = new KeyServerDetail();
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
				
				KeyServerList.add(keyServerDetail);
			}
			
		
	} catch (SQLException e) {

		e.printStackTrace();
	}
	return KeyServerList;
	}

}
