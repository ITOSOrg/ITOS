package com.company.itos.profile.personIdentity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

public class UpdatePersonIdentityDAO {
	
	public String UpdatePersonIdentity(PersonIdentityDetail personIdentityDetail){
		
		Connection connection = null;
		String returnMassegeStr = "";
		DBConnection dbConnection = new DBConnection();
		
		int personIdentityVersionNoFromUpdate = personIdentityDetail.getVersionNo();
		
		int personIdentityVersionNoFromDatabase = returnVersionNumberFromPersonIdentity(personIdentityDetail);
		
		if(personIdentityVersionNoFromUpdate == personIdentityVersionNoFromDatabase){
			
			personIdentityVersionNoFromDatabase++;
		
		try {
			connection = dbConnection.getDBConnection();
			String personIdentitySQLStr = "UPDATE	PersonIdentity	SET alternateID = ?, primaryInd = ?, typeCode = ?, startDate = ?, endDate = ?" + " WHERE personIdentityID = '" + personIdentityDetail.getPersonIdentityID() + "'";
			
			PreparedStatement preparedStatementpersonIdentity = connection.prepareStatement(personIdentitySQLStr);
			
			preparedStatementpersonIdentity.setInt(1, personIdentityDetail.getAlternateID());
			preparedStatementpersonIdentity.setString(2, personIdentityDetail.getPrimaryInd());
			preparedStatementpersonIdentity.setString(3, personIdentityDetail.getTypeCode());
			preparedStatementpersonIdentity.setDate(4, personIdentityDetail.getStartDate());
			preparedStatementpersonIdentity.setDate(5, personIdentityDetail.getEndDate());
			
			preparedStatementpersonIdentity.executeUpdate();
			
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
			
		} catch (SQLException e) {

			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		}
		return returnMassegeStr;
	}
	
	public int returnVersionNumberFromPersonIdentity(PersonIdentityDetail personIdentityDetail){
		
		int versionNo = 0;
		try {
			DBConnection dbConnection = new DBConnection();

			Connection connection = dbConnection.getDBConnection();
			
			String emailAddressSQLStr = "SELECT	versionNo, personID	FROM	PersonIdentity	WHERE	 personIdentityID = '"
					+ personIdentityDetail.getPersonIdentityID() + "'";
			
			PreparedStatement preparedStatement = connection.prepareStatement(emailAddressSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				versionNo = resultSet.getInt("versionNo");
				personIdentityDetail.setPersonID(resultSet.getInt("personID"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return versionNo;
	}

}
