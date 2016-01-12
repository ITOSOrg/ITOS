package com.company.itos.profile.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

import com.company.itos.core.audittrail.dao.ReadAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.profile.person.pojo.PersonDetail;

/**
 * PersonListDAO class create logic for displaying person list
 */
public class PersonListDAO {
	Statement statement;
	ResultSet resultSet;

	public List<PersonDetail> listAllStudent() {
		List<PersonDetail> personDetailList = new ArrayList<PersonDetail>();
		Connection connection = null;
		try {
			connection = DBConnection.getDBConnection();

			String personSQLStr = "SELECT * FROM PERSON	WHERE	RECORDSTATUS='Active'";

			// statement = connection.createStatement();

			PreparedStatement preparedStatement = connection.prepareStatement(personSQLStr);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				PersonDetail personDetail = new PersonDetail();
				personDetail.setPersonID(resultSet.getLong("personID"));
				personDetail.setRefrenceNumber(resultSet.getInt("REFRENCENUMBER"));
				personDetail.setTitle(resultSet.getString("title"));
				personDetail.setFirstName(resultSet.getString("FIRSTNAME"));
				personDetail.setMiddleName(resultSet.getString("MIDDLENAME"));
				personDetail.setLastName(resultSet.getString("LASTNAME"));
				personDetail.setUserName(resultSet.getString("USERNAME"));
				personDetail.setDateOfBirth(resultSet.getDate("dateOfBirth"));
				personDetail.setGender(resultSet.getString("gender"));
				personDetail.setModifiedBy(resultSet.getString("modifiedBy"));
				personDetail.setModifiedOn(resultSet.getTimestamp("modifiedOn"));
				personDetail.setRegistrationDate(resultSet.getTimestamp("registrationDate"));
				personDetail.setVersionNo(resultSet.getInt("versionNo"));
				
				//Retriving audit info from AuditTrail Table
				AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
				auditTrailDetails.setRelatedID(personDetail.getPersonID());
				auditTrailDetails.setOperationType("Create");
				auditTrailDetails.setTableName("Person");
				
				ReadAuditTrailDAO readAuditTrailDAO = new ReadAuditTrailDAO();
				readAuditTrailDAO.readAuditTrailBaseOnCondition(auditTrailDetails);
				
				personDetail.setAuditTrailDetails(auditTrailDetails);

				personDetailList.add(personDetail);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return personDetailList;

	}

}
