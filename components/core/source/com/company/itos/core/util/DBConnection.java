package com.company.itos.core.util;

import java.sql.*;

/**
 * DBConnection class create logic for connecting with database
 */
public class DBConnection {

	Connection connection = null;
	String oracleUrlStr = "jdbc:oracle:thin:@//localhost:1521/orcl";

	public Connection getDBConnection() throws SQLException {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(oracleUrlStr, "pms",
					"password");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			//connection.close();
		}

		return connection;
	}
}
