package com.company.itos.core.codetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.codetable.pojo.CodeTableItemDetail;
import com.company.itos.core.util.CRUDConstants;

public class DeleteCodeTableItemDAO {
	public String deleteCodeTableItem(CodeTableItemDetail codeTableItemDetail) {
		String returnMassegeStr = "";

		Connection connection = null;
		try {

			connection = DBConnection.getDBConnection();

			String CodeTableItemSQLStr = "UPDATE CodeTableItem SET recordStatus='cancel' WHERE code= '" + codeTableItemDetail.getCode()
					+ "'";
			PreparedStatement preparedStatement = connection.prepareStatement(CodeTableItemSQLStr);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
	}

}
