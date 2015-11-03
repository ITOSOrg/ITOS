package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.EmailAddressDetail;
import com.company.itos.profile.pojo.PersonDetail;

public class ListEmailAddressDAO {
	
	Statement statement;
	ResultSet resultSet;

	public List<EmailAddressDetail> listAllStudent(EmailAddressDetail emailAddressDetail) {
		List<EmailAddressDetail> emailAddressDetailList = new ArrayList<EmailAddressDetail>();
		
		//EmailAddressDetail emailAddressDetail = new EmailAddressDetail();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		try {
			connection = dbConnection.getDBConnection();

			String EmailAddressLinkSQLStr = "SELECT * FROM EmailAddressLink	WHERE	RECORDSTATUS='Active' AND relatedID = \'"+emailAddressDetail.getRelatedID()+"\'";

			statement = connection.createStatement();

			resultSet = statement.executeQuery(EmailAddressLinkSQLStr);

			if (resultSet.next()) {
				emailAddressDetail.setEmailAddressLinkID(resultSet.getInt("emailAddressLinkID"));
				emailAddressDetail.setRelatedID(resultSet.getInt("relatedID"));
				emailAddressDetail.setEmailAddressID(resultSet.getInt("emailAddressID"));
				emailAddressDetail.setTypeCode(resultSet.getString("typeCode"));
				emailAddressDetail.setPrimaryInd(resultSet.getString("primaryInd"));
				emailAddressDetail.setStartDate(resultSet.getDate("startDate"));
				emailAddressDetail.setEndDate(resultSet.getDate("endDate"));
				emailAddressDetail.setRelatedID(resultSet.getInt("relatedID"));
			}
			String EmailAddressSQLStr = "SELECT * FROM EmailAddress WHERE emailAddressID ='"+emailAddressDetail.getEmailAddressID()+"' AND RECORDSTATUS='Active'";
			
			statement = connection.createStatement();

			resultSet = statement.executeQuery(EmailAddressSQLStr);
			if (resultSet.next()){
				emailAddressDetail.setEmailAddress(resultSet.getString("emailAddress"));
			}
			emailAddressDetailList.add(emailAddressDetail);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return emailAddressDetailList;
	}
}
