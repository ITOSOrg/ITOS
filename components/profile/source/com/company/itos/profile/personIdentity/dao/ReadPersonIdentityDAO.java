package com.company.itos.profile.personIdentity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

public class ReadPersonIdentityDAO {

	public String readPrimaryPersonIdentity(PersonIdentityDetail personIdentityDetail) {
		String returnMassegeStr = "";
		try {

			Connection connection = DBConnection.getDBConnection();

			String personIdentitySQLStr = "SELECT * FROM PersonIdentity WHERE personID = \'" + personIdentityDetail.getPersonID()
					+ "\' AND RECORDSTATUS='Active' AND typeCode = 'Primary'";

			PreparedStatement preparedStatementpersonIdentity = connection.prepareStatement(personIdentitySQLStr);
			ResultSet resultSet = preparedStatementpersonIdentity.executeQuery();

			while (resultSet.next()) {
				personIdentityDetail.setPersonIdentityID(resultSet.getLong("personIdentityID"));
				personIdentityDetail.setPersonID(resultSet.getLong("personID"));
				personIdentityDetail.setAlternateID(resultSet.getString("alternateID"));
				personIdentityDetail.setPrimaryInd(resultSet.getString("primaryInd"));
				personIdentityDetail.setTypeCode(resultSet.getString("typeCode"));
				personIdentityDetail.setStartDate(resultSet.getDate("startDate"));
				personIdentityDetail.setEndDate(resultSet.getDate("endDate"));
				personIdentityDetail.setRecordStatus(resultSet.getString("recordStatus"));
				personIdentityDetail.setVersionNo(resultSet.getInt("versionNo"));
			}

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;
	}

	public String readPersonIdentity(PersonIdentityDetail personIdentityDetail) {
		String returnMassegeStr = "";
		try {

			Connection connection = DBConnection.getDBConnection();

			String personIdentitySQLStr = "SELECT * FROM PersonIdentity WHERE personIdentityID = \'"
					+ personIdentityDetail.getPersonIdentityID() + "\' AND RECORDSTATUS='Active'";

			PreparedStatement preparedStatementpersonIdentity = connection.prepareStatement(personIdentitySQLStr);
			ResultSet resultSet = preparedStatementpersonIdentity.executeQuery();

			while (resultSet.next()) {
				personIdentityDetail.setPersonIdentityID(resultSet.getInt("personIdentityID"));
				personIdentityDetail.setPersonID(resultSet.getInt("personID"));
				personIdentityDetail.setAlternateID(resultSet.getString("alternateID"));
				personIdentityDetail.setPrimaryInd(resultSet.getString("primaryInd"));
				personIdentityDetail.setTypeCode(resultSet.getString("typeCode"));
				personIdentityDetail.setStartDate(resultSet.getDate("startDate"));
				personIdentityDetail.setEndDate(resultSet.getDate("endDate"));
				personIdentityDetail.setRecordStatus(resultSet.getString("recordStatus"));
				personIdentityDetail.setVersionNo(resultSet.getInt("versionNo"));
			}

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;
	}

}
