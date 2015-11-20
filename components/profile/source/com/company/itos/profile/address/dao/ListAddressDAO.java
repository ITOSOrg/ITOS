package com.company.itos.profile.address.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.itos.core.util.DBConnection;
import com.company.itos.profile.address.pojo.AddressDetail;
import com.company.itos.profile.address.pojo.AddressLinkDetail;

public class ListAddressDAO {
	
	public List<AddressLinkDetail> ListAllAddress(AddressLinkDetail addressLinkDetailkey){
		
		List<AddressLinkDetail> addressLinkDetailList = new ArrayList<AddressLinkDetail>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		try {

			connection = dbConnection.getDBConnection();
			
			String addressLinkSQLStr = "SELECT * FROM AddressLink	WHERE	recordStatus='Active' AND relatedID = ?";
			
			PreparedStatement preparedStatementaddressLink = connection.prepareStatement(addressLinkSQLStr);
			preparedStatementaddressLink.setInt(1, addressLinkDetailkey.getRelatedID());
			ResultSet  resultSetAddressLink = preparedStatementaddressLink.executeQuery();
			
			String addressSQLStr = "SELECT * FROM Address WHERE addressId = ?";
			PreparedStatement preparedStatementaddress = connection.prepareStatement(addressSQLStr);
			
			while(resultSetAddressLink.next()){
				AddressLinkDetail addressLinkDetail = new AddressLinkDetail();
				AddressDetail addressDetail = new AddressDetail();
				
				addressLinkDetail.setAddressLinkID(resultSetAddressLink.getInt("addressLinkID"));
				addressLinkDetail.setRelatedID(resultSetAddressLink.getInt("relatedID"));
				addressDetail.setAddressId(resultSetAddressLink.getInt("addressID"));
				addressLinkDetail.setTypeCode(resultSetAddressLink.getString("typeCode"));
				addressLinkDetail.setPrimaryInd(resultSetAddressLink.getString("primaryInd"));
				addressLinkDetail.setStartDate(resultSetAddressLink.getDate("startDate"));
				addressLinkDetail.setEndDate(resultSetAddressLink.getDate("endDate"));
				
				
				preparedStatementaddress.setInt(1, addressDetail.getAddressId());
				ResultSet resultSetAddress = preparedStatementaddress.executeQuery();
				
				while(resultSetAddress.next()){
					addressDetail.setStreetOne(resultSetAddress.getString("streetOne"));
					addressDetail.setStreetTwo(resultSetAddress.getString("streetTwo"));
					addressDetail.setAptUnit(resultSetAddress.getString("aptUnit"));
					addressDetail.setCity(resultSetAddress.getString("city"));
					addressDetail.setCounty(resultSetAddress.getString("county"));
					addressDetail.setState(resultSetAddress.getString("state"));
					addressDetail.setCountry(resultSetAddress.getString("country"));
					addressDetail.setZipCode(resultSetAddress.getInt("zipCode"));
				}
				addressLinkDetail.setAddressDetail(addressDetail);
				addressLinkDetailList.add(addressLinkDetail);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		
		return addressLinkDetailList;
		
	}

}
