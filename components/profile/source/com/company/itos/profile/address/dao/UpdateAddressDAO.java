package com.company.itos.profile.address.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.itos.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.itos.core.audittrail.pojo.AuditTrailDetails;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.core.util.JavaUtildates;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.profile.address.pojo.AddressDetail;
import com.company.itos.profile.address.pojo.AddressLinkDetail;

public class UpdateAddressDAO {

	public String updateAddress(AddressLinkDetail addressLinkDetail) {

		String returnMassegeStr = "";
		Connection connection = null;

		AddressDetail addressDetail = addressLinkDetail.getAddressDetail();

		int addressLinkVersionNoFromUpdate = addressLinkDetail.getVersionNo();

		int addressLinkVersionNoFromDatabase = returnVersionNumberFromAddressLink(addressLinkDetail);

		int addressVersionNoFromUpdate = addressDetail.getVersionNo();

		int addressVersionNoFromDatabase = returnVersionNumberFromAddress(addressLinkDetail);

		if (addressLinkVersionNoFromUpdate == addressLinkVersionNoFromDatabase) {

			if (addressVersionNoFromUpdate == addressVersionNoFromDatabase) {

				addressLinkVersionNoFromDatabase++;
				addressVersionNoFromDatabase++;

				try {

					connection = DBConnection.getDBConnection();

					String AddressSQLStr = "UPDATE Address SET streetOne = ?, streetTwo = ?, aptUnit = ?, city = ?, county = ?, state = ?, country = ?, zipCode = ? WHERE addressId = '"
							+ addressLinkDetail.getAddressID() + "'";

					PreparedStatement preparedStatementAddressSQLStr = connection.prepareStatement(AddressSQLStr);

					preparedStatementAddressSQLStr.setString(1, addressDetail.getStreetOne());
					preparedStatementAddressSQLStr.setString(2, addressDetail.getStreetTwo());
					preparedStatementAddressSQLStr.setString(3, addressDetail.getAptUnit());
					preparedStatementAddressSQLStr.setString(4, addressDetail.getCity());
					preparedStatementAddressSQLStr.setString(5, addressDetail.getCounty());
					preparedStatementAddressSQLStr.setString(6, addressDetail.getState());
					preparedStatementAddressSQLStr.setString(7, addressDetail.getCountry());
					preparedStatementAddressSQLStr.setInt(8, addressDetail.getZipCode());

					preparedStatementAddressSQLStr.execute();

					String addressLinkSQLStr = "UPDATE AddressLink SET typeCode = ?, startDate = ?, endDate = ? WHERE addressLinkID = '"
							+ addressLinkDetail.getAddressLinkID() + "'";

					PreparedStatement preparedStatementaddressLinkSQLStr = connection.prepareStatement(addressLinkSQLStr);

					preparedStatementaddressLinkSQLStr.setString(1, addressLinkDetail.getTypeCode());
					preparedStatementaddressLinkSQLStr.setDate(2, JavaUtildates.convertUtilToSql(addressLinkDetail.getStartDate()));
					preparedStatementaddressLinkSQLStr.setDate(3, JavaUtildates.convertUtilToSql(addressLinkDetail.getEndDate()));

					preparedStatementaddressLinkSQLStr.execute();
					
					//inserting data into AuditTrail Table for Address Table
					AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
					
					auditTrailDetails.setTableName("Address");
					auditTrailDetails.setOperationType("Update");
					auditTrailDetails.setUserName("Rahul");
					auditTrailDetails.setRelatedID(addressLinkDetail.getAddressLinkID());
					auditTrailDetails.setTransactionType("Online");
					
					CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
					createAuditTrailDAO.createAuditTrail(auditTrailDetails);
					returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

				} catch (SQLException e) {

					e.printStackTrace();
					returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
				}
			}
		}

		return returnMassegeStr;
	}

	public int returnVersionNumberFromAddressLink(AddressLinkDetail addressLinkDetail) {

		int versionNo = 0;
		try {

			Connection connection = DBConnection.getDBConnection();

			String addressLinkSQLStr = "SELECT	versionNo, relatedID, addressID	FROM	AddressLink	WHERE	 addressLinkID = '"
					+ addressLinkDetail.getAddressLinkID() + "'";

			PreparedStatement preparedStatementAddressLink = connection.prepareStatement(addressLinkSQLStr);
			ResultSet resultSet = preparedStatementAddressLink.executeQuery();

			while (resultSet.next()) {

				versionNo = resultSet.getInt("versionNo");
				addressLinkDetail.setRelatedID(resultSet.getLong("relatedID"));
				addressLinkDetail.setAddressID(resultSet.getLong("addressID"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return versionNo;
	}

	public int returnVersionNumberFromAddress(AddressLinkDetail addressLinkDetail) {

		int versionNo = 0;
		try {

			Connection connection = DBConnection.getDBConnection();

			String addressSQLStr = "SELECT	versionNo	FROM	Address	WHERE	 addressID = '" + addressLinkDetail.getAddressID() + "'";

			PreparedStatement preparedStatementAddress = connection.prepareStatement(addressSQLStr);
			ResultSet resultSet = preparedStatementAddress.executeQuery();

			while (resultSet.next()) {

				versionNo = resultSet.getInt("versionNo");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return versionNo;
	}
	

}
