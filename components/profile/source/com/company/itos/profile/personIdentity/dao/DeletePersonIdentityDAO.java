package com.company.itos.profile.personIdentity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.company.itos.core.util.dataaccess.DBConnection;
import com.company.itos.core.util.CRUDConstants;
import com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail;

public class DeletePersonIdentityDAO {
	
	public String DeletePersonIdentity(PersonIdentityDetail personIdentityDetail){
		
		Connection connection = null;
		String returnMassegeStr = "";
		try {
			
			connection = DBConnection.getDBConnection();
			
			String PersonIdentitySQLStr = "UPDATE PersonIdentity SET	recordStatus='cancel'	WHERE personIdentityID= "
					+ personIdentityDetail.getPersonIdentityID();
			PreparedStatement preparedStatement = connection.prepareStatement(PersonIdentitySQLStr);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		
	}

}
