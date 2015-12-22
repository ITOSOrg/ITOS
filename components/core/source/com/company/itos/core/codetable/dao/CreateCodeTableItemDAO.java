package com.company.itos.core.codetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.codetable.pojo.CodeTableItemDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.JavaUtildates;

public class CreateCodeTableItemDAO {
	
	public String createCreateCodeTableItem(CodeTableItemDetail codeTableItemDetail){
		
		String returnMassegeStr = "";


		Connection connection = null;
		try {
			
			connection = DBConnection.getDBConnection();
			
			String CreateCodeTableItemSQLStr = "INSERT INTO CodeTableItem ( tableName, code, description, annotation, isEnabled, recordStatus, createdBy, createdOn, lastModifiedBy, lastModifiedOn, versionNo) "
					+ "VALUES(?, ?, ?, ?, 1,  'Active', 'Rahul', ?, 'Rahul', ?, 1)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(CreateCodeTableItemSQLStr);
			
			preparedStatement.setString(1, codeTableItemDetail.getTableName());
			preparedStatement.setString(2, codeTableItemDetail.getCode());
			preparedStatement.setString(3, codeTableItemDetail.getDescription());
			preparedStatement.setString(4, codeTableItemDetail.getAnnotation());
			//preparedStatement.setString(5, codeTableItemDetail.getIsEnabled());
			
			String crrentDateTime = JavaUtildates.getCurrentDateTime();

			Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
			preparedStatement.setTimestamp(5, timestamp);
			preparedStatement.setTimestamp(6, timestamp);
			
			preparedStatement.executeQuery();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;
		
	}

}
