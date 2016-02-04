package com.company.itos.core.codetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.company.itos.core.codetable.pojo.CodeTableItemDetail;
import com.company.itos.core.codetable.pojo.CodeTableItemKey;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.dataaccess.DBConnection;

public class ReadCodeTableItemDAO {

	public String readCodeTableItem(CodeTableItemDetail codeTableItemDetail) {

		String returnMassegeStr = "";
		Connection connection = null;

		try {
			connection = DBConnection.getDBConnection();

			String codeTableItemSQLStr = "SELECT * FROM CodeTableItem WHERE code = \'" + codeTableItemDetail.getCode()
					+ "\' AND recordStatus='Active'";

			PreparedStatement preparedStatement = connection.prepareStatement(codeTableItemSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

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
				codeTableItemDetail.setRecordStatus(resultSet.getString("recordStatus"));
			}
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

		} catch (SQLException e) {

			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;
	}

	public void readCodeTableItemDescription(CodeTableItemKey codeTableItemKey) {

		Connection connection = null;

		try {
			connection = DBConnection.getDBConnection();

			String codeTableItemSQLStr = "SELECT description FROM CodeTableItem WHERE tableName = '" + codeTableItemKey.getTableName()
					+ "' AND code = '" + codeTableItemKey.getCode() + "' ";

			PreparedStatement preparedStatement = connection.prepareStatement(codeTableItemSQLStr);

			// preparedStatement.setString(1, codeTableItemKey.getTableName());
			// preparedStatement.setString(2, codeTableItemKey.getCode());

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				codeTableItemKey.setDescription(resultSet.getString("description"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public HashMap<String, String> litGender() {


		HashMap<String, String> genderMap = new HashMap<String, String>();

		Connection connection = null;

		try {
			connection = DBConnection.getDBConnection();

			String CodeTableItemSQLStr = "SELECT code, description FROM CodeTableItem WHERE tableName = 'Gender'";

			PreparedStatement preparedStatement = connection.prepareStatement(CodeTableItemSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();

			CodeTableItemDetail codeTableItemDetail = null;

			while (resultSet.next()) {

				codeTableItemDetail = new CodeTableItemDetail();
				codeTableItemDetail.setCode(resultSet.getString("code"));
				codeTableItemDetail.setDescription(resultSet.getString("description"));
				genderMap.put(codeTableItemDetail.getCode(), codeTableItemDetail.getDescription());
				// codeTableItemList.add(codeTableItemDetail);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return genderMap;
	}
	
	public HashMap<String, String> litState() {


		HashMap<String, String> stateMap = new HashMap<String, String>();

		Connection connection = null;

		try {
			connection = DBConnection.getDBConnection();

			String CodeTableItemSQLStr = "SELECT code, description FROM CodeTableItem WHERE tableName = 'State'";

			PreparedStatement preparedStatement = connection.prepareStatement(CodeTableItemSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();

			CodeTableItemDetail codeTableItemDetail = null;

			while (resultSet.next()) {

				codeTableItemDetail = new CodeTableItemDetail();
				codeTableItemDetail.setCode(resultSet.getString("code"));
				codeTableItemDetail.setDescription(resultSet.getString("description"));
				stateMap.put(codeTableItemDetail.getCode(), codeTableItemDetail.getDescription());
				// codeTableItemList.add(codeTableItemDetail);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return stateMap;
	}

}