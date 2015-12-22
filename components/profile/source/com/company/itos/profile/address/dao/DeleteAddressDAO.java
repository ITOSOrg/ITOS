package com.company.itos.profile.address.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.address.pojo.AddressLinkDetail;

public class DeleteAddressDAO {
	
	public String deleteAddress(AddressLinkDetail addressLinkDetail){
		
		Connection connection = null;
		String returnMassegeStr = "";
		
		try {
			
			connection = DBConnection.getDBConnection();
			
			String addressLinkSQLStr = "UPDATE	AddressLink	SET	recordStatus='cancel'	WHERE addressLinkID = '"
					+ addressLinkDetail.getAddressLinkID()+"'";
			
			PreparedStatement preparedStatementAddressLink = connection.prepareStatement(addressLinkSQLStr);
			preparedStatementAddressLink.executeQuery();
			
			 returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		} catch (SQLException e) {

			e.printStackTrace();
			 returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;
		
	}

}
