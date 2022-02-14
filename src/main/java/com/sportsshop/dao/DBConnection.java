package com.sportsshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.sportsshop.customexceptions.CustomException;

public class DBConnection {
	
    private static final String JDBC_URL = "jdbc:postgresql://localhost:1818/SportsShop";
    private static final String JDBC_USERNAME = "postgres";
    private static final String JDBC_PASSWORD = "Ssk18187";
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    
    /**
     * It connects database.
     * @return established connection by connection.
     */
    static final Connection getConnection() {

        try {
            Class.forName(JDBC_DRIVER);
            final Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            return connection;
        } catch(Exception e) {
            throw new CustomException.UnableToConnectException("Connection Failed \n    Please Check Connection");
        }
    }
}
