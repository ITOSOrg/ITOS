package com.company.itos.profile.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

import com.company.itos.core.audittrail.dao.ReadAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.audittrail.pojo.AuditTrailDtls;
import com.company.itos.core.audittrail.pojo.AuditTrailkey;
import com.company.itos.core.codetable.dao.ReadCodeTableItemDAO;
import com.company.itos.core.codetable.pojo.CodeTableItemKey;
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
				personDetail.setRegistrationDate(resultSet.getTimestamp("registrationDate"));
				personDetail.setVersionNo(resultSet.getInt("versionNo"));
				
				// For Gender Retriving desription from table for code
				CodeTableItemKey codeTableItemKey = new CodeTableItemKey();
				codeTableItemKey.setCode(personDetail.getGender());

				codeTableItemKey.setTableName("Gender");

				ReadCodeTableItemDAO readCodeTableItemDAO = new ReadCodeTableItemDAO();
				readCodeTableItemDAO.readCodeTableItemDescription(codeTableItemKey);

				personDetail.setGender(codeTableItemKey.getDescription());

				
				//Retriving audit info from AuditTrail Table
				AuditTrailkey auditTrailkey = new AuditTrailkey();
				auditTrailkey.setRelatedID(personDetail.getPersonID());
				auditTrailkey.setTableName("Person");
				
				ReadAuditTrailDAO readAuditTrailDAO = new ReadAuditTrailDAO();
				AuditTrailDtls auditTrailDtls = readAuditTrailDAO.readAuditTrailBaseOnCondition(auditTrailkey);
				
				personDetail.setAuditTrailDtls(auditTrailDtls);

				personDetailList.add(personDetail);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return personDetailList;

	}

}
