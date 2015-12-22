package com.company.itos.core.keyserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.keyserver.pojo.KeyServerDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

public class UpdateKeyServerDAO {
		public String UpdateKeyServer(KeyServerDetail keyServerDetail){
			
			Connection connection = null;
			String returnMassegeStr = "";
			
			int KeyServerVersionNoFromUpdate = keyServerDetail.getVersionNo();
			
			int KeyServerVersionNoFromDatabase = returnVersionNumberFromKeyServer(keyServerDetail);
			
			if(KeyServerVersionNoFromUpdate == KeyServerVersionNoFromDatabase){
				
				KeyServerVersionNoFromDatabase++;
			try {
				connection = DBConnection.getDBConnection();
				
				String KeyServerSQLStr = "UPDATE	KeyServer	SET keysetCode = ?, nextUniqueIdBlock = ?, humanReadable = ?, annotation = ?, strategy = ?, recordStatus = ?, createdBy = ?, lastModifiedBy = ?" + " WHERE keysetCode = '" + keyServerDetail.getKeysetCode() + "'";
				
				PreparedStatement preparedStatement = connection.prepareStatement(KeyServerSQLStr);
				
				preparedStatement.setString(1, keyServerDetail.getKeysetCode());
				preparedStatement.setLong(2, keyServerDetail.getNextUniqueIdBlock());
				preparedStatement.setString(3, keyServerDetail.getHumanReadable());
				preparedStatement.setString(4, keyServerDetail.getAnnotation());
				preparedStatement.setString(5, keyServerDetail.getStrategy());
				preparedStatement.setString(6, keyServerDetail.getRecordStatus());
				preparedStatement.setString(7, keyServerDetail.getCreatedBy());
				preparedStatement.setString(8, keyServerDetail.getLastModifiedBy());
				
				preparedStatement.executeUpdate();
				
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
				
			} catch (SQLException e) {

				e.printStackTrace();
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
			
			}
			}
			return returnMassegeStr;
			
		}
		
		public int returnVersionNumberFromKeyServer(KeyServerDetail keyServerDetail){
			
			int versionNo = 0;
			try {

				Connection connection = DBConnection.getDBConnection();
				
				String keyServerSQLStr = "SELECT	versionNo	FROM	KeyServer	WHERE	 keysetCode = '"
						+ keyServerDetail.getKeysetCode() + "'";
				
				PreparedStatement preparedStatement = connection.prepareStatement(keyServerSQLStr);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()){
					versionNo = resultSet.getInt("versionNo");
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			return versionNo;
		}

}
