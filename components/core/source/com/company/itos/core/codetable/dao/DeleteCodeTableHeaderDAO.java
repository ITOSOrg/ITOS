package com.company.itos.core.codetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.company.itos.core.codetable.pojo.CodeTableHeaderDetail;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;

public class DeleteCodeTableHeaderDAO {
	
	public String deleteCodeTableHeader(CodeTableHeaderDetail codeTableHeaderDetail){
		
		String returnMassegeStr = "";


		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getDBConnection();
			
			String codeTableHeaderSQLStr = "UPDATE CodeTableHeader SET recordStatus='cancel' WHERE defaultCode= '"+ codeTableHeaderDetail.getDefaultCode()+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(codeTableHeaderSQLStr);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnMassegeStr  = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		}

}
