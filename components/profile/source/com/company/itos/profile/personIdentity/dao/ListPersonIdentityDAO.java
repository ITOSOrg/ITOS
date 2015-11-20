package com.company.itos.profile.personIdentity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

public class ListPersonIdentityDAO {
	
	public List<PersonIdentityDetail> personIdentityList(PersonIdentityDetail personIdentityDetailkey){
		
		List<PersonIdentityDetail> personIdentityDetailList = new ArrayList<PersonIdentityDetail>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;

		try {
			connection = dbConnection.getDBConnection();
			
			String personIdentitySQLStr = "SELECT * FROM PersonIdentity WHERE personID = '"+personIdentityDetailkey.getPersonID()+"' AND RECORDSTATUS='Active'";
			
			PreparedStatement preparedStatement = connection.prepareStatement(personIdentitySQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				PersonIdentityDetail personIdentityDetail = new PersonIdentityDetail();
				
				personIdentityDetail.setPersonIdentityID(resultSet.getInt("personIdentityID"));
				personIdentityDetail.setPersonID(resultSet.getInt("personID"));
				personIdentityDetail.setAlternateID(resultSet.getInt("alternateID"));
				personIdentityDetail.setPrimaryInd(resultSet.getString("primaryInd"));
				personIdentityDetail.setTypeCode(resultSet.getString("typeCode"));
				personIdentityDetail.setStartDate(resultSet.getDate("startDate"));
				personIdentityDetail.setEndDate(resultSet.getDate("endDate"));
				personIdentityDetail.setRecordStatus(resultSet.getString("recordStatus"));
				personIdentityDetail.setVersionNo(resultSet.getInt("versionNo"));
				
				personIdentityDetailList.add(personIdentityDetail);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return personIdentityDetailList;
		
	}

}
