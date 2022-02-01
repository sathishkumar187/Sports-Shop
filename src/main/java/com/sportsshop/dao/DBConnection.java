package com.sportsshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String JDBC_URL = "jdbc:postgresql://localhost:1818/SportsShop";
	private static final String JDBC_USERNAME = "postgres";
	private static final String JDBC_PASSWORD = "Ssk18187";
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    
	/**
	 * It connects database.
	 * @return established connection by connection.
	 */
	Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
		} catch(Exception e) {
			System.out.println("Connection Failed \n    Please Check Connection");
		}
		return connection;
	}
}
