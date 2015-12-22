package com.company.itos.core.codetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.codetable.pojo.CodeTableHeaderDetail;
import com.company.itos.core.codetable.pojo.CodeTableItemDetail;
import com.company.itos.core.util.CRUDConstants;

public class UpdateCodeTableHeaderDAO {
			
			public String updateCodeTableHeader(CodeTableHeaderDetail codeTableHeaderDetail){
				
				Connection connection = null;
				String returnMassegeStr = "";
				
				int CodeTableHeaderVersionNoFromUpdate = codeTableHeaderDetail.getVersionNo();
				
				int CodeTableHeaderVersionNoFromDatabase = returnVersionNumberFromCodeTableHeader(codeTableHeaderDetail);
				
				if(CodeTableHeaderVersionNoFromUpdate == CodeTableHeaderVersionNoFromDatabase){
				
					CodeTableHeaderVersionNoFromDatabase++;
					
				try {
					connection = DBConnection.getDBConnection();
					
					String codeTableHeaderSQLStr = "UPDATE	CodeTableHeader	SET tableName = ?, defaultCode = ?, recordStatus = ?, versionNo = ?, createdBy = ?, lastModifiedBy = ? "+ "WHERE tableName = '" + codeTableHeaderDetail.getTableName() + "'";
					
					PreparedStatement preparedStatement = connection.prepareStatement(codeTableHeaderSQLStr);
					
					preparedStatement.setString(1, codeTableHeaderDetail.getTableName());
					preparedStatement.setString(2, codeTableHeaderDetail.getDefaultCode());
					preparedStatement.setString(3, codeTableHeaderDetail.getRecordStatus());
					preparedStatement.setInt(4, codeTableHeaderDetail.getVersionNo());
					preparedStatement.setString(5, codeTableHeaderDetail.getLastModifiedBy());
					preparedStatement.setString(6, codeTableHeaderDetail.getCreatedBy());
					
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
			
			public int returnVersionNumberFromCodeTableHeader(CodeTableHeaderDetail codeTableHeaderDetail){
				
				int versionNo = 0;
				try {

					Connection connection = DBConnection.getDBConnection();
					
					String codeTableHeaderSQLStr = "SELECT	versionNo	FROM	CodeTableHeader	WHERE	 tableName = '"
							+ codeTableHeaderDetail.getTableName() + "'";
					
					PreparedStatement preparedStatement = connection.prepareStatement(codeTableHeaderSQLStr);
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
