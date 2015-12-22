package com.company.itos.core.codetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.codetable.pojo.CodeTableHeaderDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.JavaUtildates;

public class CreateCodeTableHeaderDAO {
			
	public String CreateCodeTableHeader(CodeTableHeaderDetail codeTableHeaderDetail){
		
		String returnMassegeStr = "";

		Connection connection = null;
		try {
			
			connection = DBConnection.getDBConnection();
			
			String CodeTableHeaderSQLStr = "INSERT INTO CodeTableHeader ( tableName, defaultCode, recordStatus, createdBy, createdOn, lastModifiedBy, lastModifiedOn, versionNo) "
					+ "VALUES(?, ?,  'Active', 'Rahul', ?, 'Rahul', ?, 1)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(CodeTableHeaderSQLStr);
			
			preparedStatement.setString(1, codeTableHeaderDetail.getTableName());
			preparedStatement.setString(2, codeTableHeaderDetail.getDefaultCode());
			
			String crrentDateTime = JavaUtildates.getCurrentDateTime();

			Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
			preparedStatement.setTimestamp(3, timestamp);
			preparedStatement.setTimestamp(4, timestamp);
			
			preparedStatement.executeQuery();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;
	}
}
