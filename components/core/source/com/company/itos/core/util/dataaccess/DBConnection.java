package com.company.itos.core.util.dataaccess;

import java.sql.*;

import javax.sql.DataSource;

import com.company.itos.core.util.resources.Configuration;

/**
 * DBConnection class create logic for connecting with database
 */
public final class DBConnection {
	
	private static DataSource stDataSource = null;
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getDBConnection() throws SQLException {

		if (stDataSource == null) {
			try {
				getDataSource();
			} catch (SQLException e) {
				throw new ExceptionInInitializerError(e);
			}
			
		}
		
		Connection connection = null;
		
		String userName = Configuration.getDBUserName();
		if (userName == null) {
			throw new RuntimeException("Missing property db.username. Contact your administrator.");
			
		}
		
		String password = Configuration.getDBPassword();
		if (password == null) {
			throw new RuntimeException("Missing property db.password. Contact your administrator.");
			
		}
		
		connection = stDataSource.getConnection(userName, password);
		
		return connection;
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	static synchronized DataSource getDataSource() throws SQLException {

		if (stDataSource != null) {
			
			return stDataSource;
			
		}
		
		if (Configuration.getDBType().equalsIgnoreCase("ORA")) {
			stDataSource = OracleDataSource.createDataSource();
		}
		
		addCredentialsToDataSource(stDataSource);
		
		return stDataSource;
	}
	
	private static void addCredentialsToDataSource(DataSource dataSource) {

		if (!(Configuration.getDBType().equalsIgnoreCase("ORA")))
			return;
		OracleDataSource.setCredentialsInDataSource(dataSource);
	}
	
}
