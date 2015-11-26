package com.company.itos.core.codetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.company.itos.core.codetable.pojo.CodeTableHeaderDetail;
import com.company.itos.core.codetable.pojo.CodeTableItemDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;

public class ReadCodeTableHeaderDAO {
	
	public String ReadCodeTableHeader(CodeTableHeaderDetail codeTableHeaderDetail){
		
		String returnMassegeStr = "";
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;

		try {
			connection = dbConnection.getDBConnection();
			
			String codeTableItemSQLStr = "SELECT * FROM CodeTableHeader WHERE tableName = \'"+codeTableHeaderDetail.getTableName()+"\' AND recordStatus='Active'";
			
			PreparedStatement preparedStatement = connection.prepareStatement(codeTableItemSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				
				codeTableHeaderDetail.setTableName(resultSet.getString("tableName"));
				codeTableHeaderDetail.setDefaultCode(resultSet.getString("defaultCode"));
				codeTableHeaderDetail.setCreatedBy(resultSet.getString("createdBy"));
				codeTableHeaderDetail.setLastModifiedBy(resultSet.getString("lastModifiedBy"));
				codeTableHeaderDetail.setCreatedOn(resultSet.getTimestamp("createdOn"));
				codeTableHeaderDetail.setLastModifiedOn(resultSet.getTimestamp("lastModifiedOn"));
				codeTableHeaderDetail.setVersionNo(resultSet.getInt("versionNo"));
				codeTableHeaderDetail.setRecordStatus(resultSet.getString("recordStatus"));
				
			}
			CodeTableItemDetail codeTableItemDetail = new CodeTableItemDetail();
			codeTableItemDetail.setTableName(codeTableHeaderDetail.getTableName());
			
			ListCodeTableItemDAO listCodeTableItemDAO = new ListCodeTableItemDAO();
			List<CodeTableItemDetail> codeTableItemDetailList =	listCodeTableItemDAO.listCodeTableItem(codeTableItemDetail);
			
			codeTableHeaderDetail.setCodeTableItemDetailList(codeTableItemDetailList);
			
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
			
		} catch (SQLException e) {

		e.printStackTrace();
		returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
	}
			return returnMassegeStr;
	}

}
