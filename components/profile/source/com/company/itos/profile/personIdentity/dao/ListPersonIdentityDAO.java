package com.company.itos.profile.personIdentity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.audittrail.dao.ReadAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDtls;
import com.company.itos.core.audittrail.pojo.AuditTrailkey;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

public class ListPersonIdentityDAO {

	public List<PersonIdentityDetail> personIdentityList(PersonIdentityDetail personIdentityDetailkey) {

		List<PersonIdentityDetail> personIdentityDetailList = new ArrayList<PersonIdentityDetail>();

		Connection connection = null;

		try {
			connection = DBConnection.getDBConnection();

			String personIdentitySQLStr = "SELECT * FROM PersonIdentity WHERE personID = '" + personIdentityDetailkey.getPersonID()
					+ "' AND RECORDSTATUS='Active'";

			PreparedStatement preparedStatement = connection.prepareStatement(personIdentitySQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				PersonIdentityDetail personIdentityDetail = new PersonIdentityDetail();

				personIdentityDetail.setPersonIdentityID(resultSet.getLong("personIdentityID"));
				personIdentityDetail.setPersonID(resultSet.getLong("personID"));
				personIdentityDetail.setAlternateID(resultSet.getString("alternateID"));
				personIdentityDetail.setPrimaryInd(resultSet.getString("primaryInd"));
				personIdentityDetail.setTypeCode(resultSet.getString("typeCode"));
				personIdentityDetail.setStartDate(resultSet.getDate("startDate"));
				personIdentityDetail.setEndDate(resultSet.getDate("endDate"));
				personIdentityDetail.setRecordStatus(resultSet.getString("recordStatus"));
				personIdentityDetail.setVersionNo(resultSet.getInt("versionNo"));
				
				//Retriving audit info from AuditTrail Table
				AuditTrailkey auditTrailkey = new AuditTrailkey();
				auditTrailkey.setRelatedID(personIdentityDetail.getPersonIdentityID());
				auditTrailkey.setTableName("PersonIdentity");
				
				ReadAuditTrailDAO readAuditTrailDAO = new ReadAuditTrailDAO();
				AuditTrailDtls auditTrailDtls = readAuditTrailDAO.readAuditTrailBaseOnCondition(auditTrailkey);
				
				
				personIdentityDetail.setAuditTrailDtls(auditTrailDtls);

				personIdentityDetailList.add(personIdentityDetail);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return personIdentityDetailList;

	}

}
