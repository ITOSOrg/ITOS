package com.company.itos.core.codetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.codetable.pojo.CodeTableItemDetail;

public class ListCodeTableItemDAO {

	public List<CodeTableItemDetail> listCodeTableItem(CodeTableItemDetail codeTableItemDetailkey) {

		List<CodeTableItemDetail> codeTableItemDetailList = new ArrayList<CodeTableItemDetail>();
		Connection connection = null;

		try {
			connection = DBConnection.getDBConnection();

			String codeTableItemSQLStr = "SELECT * FROM CodeTableItem WHERE tableName = '" + codeTableItemDetailkey.getTableName()
					+ "' AND recordStatus='Active'";

			PreparedStatement preparedStatement = connection.prepareStatement(codeTableItemSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				CodeTableItemDetail codeTableItemDetail = new CodeTableItemDetail();

				codeTableItemDetail.setTableName(resultSet.getString("tableName"));
				codeTableItemDetail.setCode(resultSet.getString("code"));
				codeTableItemDetail.setDescription(resultSet.getString("description"));
				codeTableItemDetail.setAnnotation(resultSet.getString("annotation"));
				codeTableItemDetail.setIsEnabled(resultSet.getString("isEnabled"));
				codeTableItemDetail.setCreatedBy(resultSet.getString("createdBy"));
				codeTableItemDetail.setLastModifiedBy(resultSet.getString("lastModifiedBy"));
				codeTableItemDetail.setCreatedOn(resultSet.getTimestamp("createdOn"));
				codeTableItemDetail.setLastModifiedOn(resultSet.getTimestamp("lastModifiedOn"));
				codeTableItemDetail.setVersionNo(resultSet.getInt("versionNo"));

				codeTableItemDetailList.add(codeTableItemDetail);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return codeTableItemDetailList;
	}

}
