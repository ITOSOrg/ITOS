/**
 * 
 */
package com.company.itos.core.util.resources;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 
 * @author Rahul
 */
public final class Configuration {
	
	private static volatile String stDataSetsDirectory;
	
	private static volatile Boolean stRunningInAppServer;
	
	private static volatile String stAppServerVendor;
	
	private static volatile String stBindingsLocation;
	
	private static volatile String stAppServerPassword;
	
	private static volatile String stAppServerEncryptedPassword;
	
	private static volatile String stDBType;
	
	private static volatile String stDBName;
	
	private static volatile String stDBUsername;
	
	private static volatile String stDBPassword;
	
	private static volatile Integer stQueryTimeOutValue;
	
	private static final String kErrorMessageBadPw1 = "The database password specified by the 'db.password' property in Bootstrap.properties file is not encrypted. Please encrypt the password.";
	
	private static final String kErrorMessageBadPw2 = "The database password specified by the 'db.password' property in Bootstrap.properties file is not encrypted correctly. Please re-encrypt the password.";
	
	private static final String kErrorMessageBadPw3 = "The Application Server admin password specified by the 'security.password' property in AppServer.properties file is not encrypted correctly. Please re-encrypt the password.";
	
	public static String getStaticProperty(String key) {

		String propertyValue = System.getProperty(key);
		
		if (propertyValue == null) {
			
			ResourceBundle resourceBundle = null;
			
			try {
				
				resourceBundle = ResourceBundle.getBundle("database");
				
				propertyValue = resourceBundle.getString(key);
				
			} catch (MissingResourceException e) {
				
			}
		}
		
		if (propertyValue == null) {
			
			return null;
			
		}
		
		String trimString = StringUtil.rtrimSpacesOnly(propertyValue);
		
		if (trimString.length() == 0) {
			return null;
		}
		
		return trimString;
	}
	
	/**
	 * 
	 * @return
	 */
	public static String getDBType() {

		if (stDBType == null) {
			
			stDBType = getStaticProperty("db.type");
			
		}
		// return DB type
		return stDBType;
	}
	
	/**
	 * 
	 * @return
	 */
	public static String getDBName() {

		if (stDBName == null) {
			
			stDBName = getStaticProperty("db.name");
			
		}
		// return DB Name
		return stDBName;
	}
	
	/**
	 * 
	 * @return
	 */
	public static String getDBUserName() {

		if (stDBUsername == null) {
			
			stDBUsername = getStaticProperty("db.username");
			
		}
		// return DB User Name
		return stDBUsername;
	}
	
	/**
	 * 
	 * @return
	 */
	public static String getDBPassword() {

		if (stDBPassword == null) {
			
			stDBPassword = getStaticProperty("db.password");
			
		}
		// return DB Name
		return stDBPassword;
	}
	
}
