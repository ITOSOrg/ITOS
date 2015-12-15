/**
 * 
 */
package com.company.itos.core.util.dataaccess;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.company.itos.core.util.resources.Configuration;
import com.company.itos.core.util.resources.StringUtil;

/**
 * 
 * @author Rahul
 */
public final class OracleDataSource {
	
	private static final String kErrorMessagePartOne = "Missing property ";
	
	private static final String kErrorMessagePartTwo = ". Contact your administrator.";
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static DataSource createDataSource() throws SQLException {

		String machineName = Configuration.getStaticProperty("db.servername");
		
		String databaseName = Configuration.getDBName();
		
		String oracleDatabaseServiceName = Configuration.getStaticProperty("db.oracle.servicename");
		
		String serverPort = Configuration.getStaticProperty("db.serverport");
		
		oracle.jdbc.pool.OracleDataSource dataSource = new oracle.jdbc.pool.OracleDataSource();
		
		dataSource.setServerName(machineName);
		
		if ((oracleDatabaseServiceName != null) && (oracleDatabaseServiceName.trim().length() > 0)) {
			dataSource.setServiceName(oracleDatabaseServiceName);
			
		} else
			dataSource.setDatabaseName(databaseName);
		
		dataSource.setPortNumber(Integer.parseInt(serverPort));
		dataSource.setDriverType("thin");
		dataSource.setImplicitCachingEnabled(true);
		//dataSource.setMaxStatements(Configuration.getOracleStatementCacheSize());
		
		if (isConnectionCacheEnabled()) {
			dataSource.setConnectionCachingEnabled(true);
			
			Properties properties = new Properties();
			
			String minLimit = Configuration.getStaticProperty("db.oracle.connectioncache.minlimit");
			
			if (StringUtil.isNullOrEmpty(minLimit)) {
				throw new RuntimeException("Missing property db.oracle.connectioncache.minlimit. Contact your administrator.");
				
			}
			
			properties.setProperty("MinLimit", minLimit);
			
			String maxLimit = Configuration.getStaticProperty("db.oracle.connectioncache.maxlimit");
			
			if (StringUtil.isNullOrEmpty(maxLimit)) {
				throw new RuntimeException("Missing property db.oracle.connectioncache.maxlimit. Contact your administrator.");
				
			}
			
			properties.setProperty("MaxLimit", maxLimit);
			
			String initialLimit = Configuration.getStaticProperty("db.oracle.connectioncache.initiallimit");
			
			if (StringUtil.isNullOrEmpty(initialLimit)) {
				throw new RuntimeException("Missing property db.oracle.connectioncache.initiallimit. Contact your administrator.");
				
			}
			
			properties.setProperty("InitialLimit", initialLimit);
			
			String cacheName = Configuration.getStaticProperty("db.oracle.connectioncache.name");
			
			if (!(StringUtil.isNullOrEmpty(cacheName))) {
				dataSource.setConnectionCacheName(cacheName);
				
			}
			
			String maxPreparedStmtLimit = "";//String.valueOf(Configuration.getOracleStatementCacheSize());
			
			properties.setProperty("MaxStatementsLimit", maxPreparedStmtLimit);
			
			dataSource.setConnectionCacheProperties(properties);
		}
		
		return dataSource;
	}

	/**
	 * 
	 * @param ds
	 */
	public static void setCredentialsInDataSource(DataSource ds) {

		if (!(isConnectionCacheEnabled()))
			return;
		oracle.jdbc.pool.OracleDataSource dataSource = (oracle.jdbc.pool.OracleDataSource) ds;
		
		if (StringUtil.isNullOrEmpty(dataSource.getUser())) {
			dataSource.setUser(Configuration.getDBUserName());
			dataSource.setPassword(Configuration.getDBPassword());
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private static boolean isConnectionCacheEnabled() {

		return "true".equalsIgnoreCase(Configuration.getStaticProperty("db.oracle.connectioncache.enabled"));
	}
	
}
