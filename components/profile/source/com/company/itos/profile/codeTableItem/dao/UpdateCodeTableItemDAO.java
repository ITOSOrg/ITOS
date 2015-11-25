package com.company.itos.profile.codeTableItem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.codeTable.pojo.CodeTableItemDetail;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

public class UpdateCodeTableItemDAO {
	
	public String UpdateCodeTableItem(CodeTableItemDetail codeTableItemDetail){
		
		Connection connection = null;
		String returnMassegeStr = "";
		DBConnection dbConnection = new DBConnection();
		
		int codeTableItemVersionNoFromUpdate = codeTableItemDetail.getVersionNo();
		
		int codeTableItemVersionNoFromDatabase = returnVersionNumberFromCodeTableItem(codeTableItemDetail);
		
		if(codeTableItemVersionNoFromUpdate == codeTableItemVersionNoFromDatabase){
				
			codeTableItemVersionNoFromDatabase++;
			
			
		try {
			connection = dbConnection.getDBConnection();
			
			String codeTableItemSQLStr = "UPDATE	CodeTableItem	SET tableName = ?, code = ?, description = ?, annotation = ?, isEnabled = ?, recordStatus = ?" + " WHERE code = '" + codeTableItemDetail.getCode() + "'";
			
			PreparedStatement preparedStatement = connection.prepareStatement(codeTableItemSQLStr);
			
			preparedStatement.setString(1, codeTableItemDetail.getTableName());
			preparedStatement.setString(2, codeTableItemDetail.getCode());
			preparedStatement.setString(3, codeTableItemDetail.getDescription());
			preparedStatement.setString(4, codeTableItemDetail.getAnnotation());
			preparedStatement.setString(5, codeTableItemDetail.getIsEnabled());
			preparedStatement.setString(6, codeTableItemDetail.getRecordStatus());
			
			preparedStatement.executeUpdate();
					
         returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
			
		}
		catch (SQLException e) {

			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		}
		
		return returnMassegeStr;
		
	}
	
public int returnVersionNumberFromCodeTableItem(CodeTableItemDetail codeTableItemDetail){
		
		int versionNo = 0;
		try {
			DBConnection dbConnection = new DBConnection();

			Connection connection = dbConnection.getDBConnection();
			
			String codeTableItemSQLStr = "SELECT	versionNo	FROM	CodeTableItem	WHERE	 code = '"
					+ codeTableItemDetail.getCode() + "'";
			
			PreparedStatement preparedStatement = connection.prepareStatement(codeTableItemSQLStr);
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
