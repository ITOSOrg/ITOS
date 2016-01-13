package com.company.itos.profile.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.person.pojo.PersonDetail;

/**
 * PersonDeleteDAO class create logic for deleting student
 */
public class PersonDeleteDAO {

	Connection connection = null;
	ResultSet resultSet = null;

	public String deleteStudent(PersonDetail personDetail) {
		/**
		 * creating object of DBConnection class
		 */
		String returnMassegeStr = "";

		try {
			/**
			 * get connected with database by calling getDBConnection() method
			 * of DBConnection class
			 */
			connection = DBConnection.getDBConnection();
			String personSQLStr = "UPDATE	PERSON	SET	RECORDSTATUS='cancel'	WHERE	personID=" + personDetail.getPersonID();
			/**
			 * sending sql statement to the database
			 */
			PreparedStatement preparedStatement = connection.prepareStatement(personSQLStr);
			preparedStatement.executeUpdate();
			
			//inserting data into AuditTrail Table for Person Table
			AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
			
			auditTrailDetails.setTableName("Person");
			auditTrailDetails.setOperationType("Delete");
			auditTrailDetails.setUserName("Rahul");
			auditTrailDetails.setRelatedID(personDetail.getPersonID());
			auditTrailDetails.setTransactionType("Online");
			
			CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
			createAuditTrailDAO.createAuditTrail(auditTrailDetails);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
	}

}
