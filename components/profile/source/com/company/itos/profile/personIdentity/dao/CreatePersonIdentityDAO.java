package com.company.itos.profile.personIdentity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

public class CreatePersonIdentityDAO {
	
	public String CreatePersonIdentity(PersonIdentityDetail personIdentityDetail){
		
		String returnMassegeStr = "";


		Connection connection = null;
		try {
			
			connection = DBConnection.getDBConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT PersonIdentitySEQ.nextval FROM DUAL");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				personIdentityDetail.setPersonIdentityID(resultSet.getInt(1));
			}
			
			String personIdentitySQLStr = "INSERT INTO PersonIdentity ( personIdentityID, personID, alternateID, primaryInd, typeCode, startDate, endDate, recordStatus, versionNo) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, 'Active', 1)";
			
			PreparedStatement preparedStatementpersonIdentity = connection.prepareStatement(personIdentitySQLStr);
			
			preparedStatementpersonIdentity.setInt(1, personIdentityDetail.getPersonIdentityID());
			preparedStatementpersonIdentity.setInt(2, personIdentityDetail.getPersonID());
			preparedStatementpersonIdentity.setInt(3, personIdentityDetail.getAlternateID());
			preparedStatementpersonIdentity.setString(4, personIdentityDetail.getPrimaryInd());
			preparedStatementpersonIdentity.setString(5, personIdentityDetail.getTypeCode());
			preparedStatementpersonIdentity.setDate(6, personIdentityDetail.getStartDate());
			preparedStatementpersonIdentity.setDate(7, personIdentityDetail.getEndDate());
			
			preparedStatementpersonIdentity.executeQuery();
			
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;
		
	}

}
