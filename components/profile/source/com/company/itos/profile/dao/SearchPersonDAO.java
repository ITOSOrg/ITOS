package com.company.itos.profile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.pojo.PersonDetail;
import com.company.itos.profile.pojo.PersonSearchCriteria;
import com.company.itos.profile.pojo.PersonSearchDetails;

public class SearchPersonDAO {

	DBConnection dbConnection = new DBConnection();

	Connection connection = null;

	public List<PersonDetail> searchPersonInfo(PersonSearchDetails personSearchDetails) {

		List<PersonDetail> PersonDetailList = new ArrayList<PersonDetail>();
		PersonSearchCriteria personSearchCriteria = personSearchDetails.getPersonSearchCriteria();
		PersonDetail personDetail = null;

		String whereStr = "";

		String emptyStr = "";

		if (personSearchCriteria.getFirstName() != null && !personSearchCriteria.getFirstName().equals(emptyStr)) {
			whereStr += (whereStr == "") ? " WHERE " : " AND ";
			whereStr += " firstName = '" + personSearchCriteria.getFirstName() + "'";
		}
		if (personSearchCriteria.getMiddleName() != null && !personSearchCriteria.getMiddleName().equals(emptyStr)) {
			whereStr += (whereStr == "") ? " WHERE " : " AND ";
			whereStr += " middleName = '" + personSearchCriteria.getMiddleName() + "'";
		}
		if (personSearchCriteria.getLastName() != null && !personSearchCriteria.getLastName().equals(emptyStr)) {
			whereStr += (whereStr == "") ? " WHERE " : " AND ";
			whereStr += " lastName = '" + personSearchCriteria.getLastName() + "'";
		}

		if (!whereStr.equals(emptyStr)) {

			try {
				connection = dbConnection.getDBConnection();
				String personSQLStr = "SELECT * " + " FROM Person " + whereStr;

				PreparedStatement preparedstatement = connection.prepareStatement(personSQLStr);

				ResultSet resultSet = preparedstatement.executeQuery();

				while (resultSet.next()) {

					personDetail = new PersonDetail();
					personDetail.setPersonID(resultSet.getInt("personID"));
					personDetail.setRefrenceNumber(resultSet.getInt("refrenceNumber"));
					personDetail.setTitle(resultSet.getString("title"));
					personDetail.setFirstName(resultSet.getString("firstName"));
					personDetail.setMiddleName(resultSet.getString("middleName"));
					personDetail.setLastName(resultSet.getString("lastName"));
					personDetail.setGender(resultSet.getString("gender"));
					personDetail.setDateOfBirth(resultSet.getDate("dateOfBirth"));
					PersonDetailList.add(personDetail);
				}

			} catch (Exception exception) {
				exception.printStackTrace();
			}

		} else {
			String errorMessage = "";

			errorMessage = "Please enter at least one attribute";
			personSearchDetails.setErrorMessage(errorMessage);
			;

		}

		return PersonDetailList;

	}
}
