package com.company.itos.profile.codetableheader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.codetableheader.pojo.CodeTableHeaderDetail;

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
