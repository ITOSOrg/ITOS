package com.company.itos.core.codetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.codetable.pojo.CodeTableHeaderDetail;
import com.company.itos.core.codetable.pojo.CodeTableItemDetail;
import com.company.itos.core.util.DBConnection;

public class ListCodeTableHeaderDAO {
		
	public List<CodeTableHeaderDetail> listAllCodeTableHeader(CodeTableHeaderDetail codeTableHeaderDetailkey){
		
		List<CodeTableHeaderDetail> codeTableHeaderList = new ArrayList<CodeTableHeaderDetail>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;

		try {
			connection = dbConnection.getDBConnection();
			
			String codeTableItemSQLStr = "SELECT * FROM CodeTableHeader WHERE recordStatus='Active'";
			
			PreparedStatement preparedStatement = connection.prepareStatement(codeTableItemSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				CodeTableHeaderDetail codeTableHeaderDetail = new CodeTableHeaderDetail();
				
				codeTableHeaderDetail.setTableName(resultSet.getString("tableName"));
				codeTableHeaderDetail.setDefaultCode(resultSet.getString("defaultCode"));
				codeTableHeaderDetail.setCreatedBy(resultSet.getString("createdBy"));
				codeTableHeaderDetail.setLastModifiedBy(resultSet.getString("lastModifiedBy"));
				codeTableHeaderDetail.setCreatedOn(resultSet.getTimestamp("createdOn"));
				codeTableHeaderDetail.setLastModifiedOn(resultSet.getTimestamp("lastModifiedOn"));
				codeTableHeaderDetail.setVersionNo(resultSet.getInt("versionNo"));
				codeTableHeaderDetail.setRecordStatus(resultSet.getString("recordStatus"));
				
				codeTableHeaderList.add(codeTableHeaderDetail);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return codeTableHeaderList;
			
	}
}
