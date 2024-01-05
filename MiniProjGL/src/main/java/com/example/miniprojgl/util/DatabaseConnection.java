package com.example.miniprojgl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/school_management";
    private static final String USER = "root";
    private static final String PASS = "";

    static {
        try {
            // This explicitly loads the JDBC driver
            // It's optional in JDBC 4.0 and later
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // This is a critical failure, we cannot recover from this
            throw new ExceptionInInitializerError("Failed to load MySQL JDBC driver");
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DATABASE_URL, USER, PASS);
        } catch (SQLException e) {
            // Don't just print the stack trace, throw a runtime exception
            throw new RuntimeException("Failed to connect to the database", e);
        }
    }
}
