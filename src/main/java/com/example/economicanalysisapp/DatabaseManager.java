package com.example.economicanalysisapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseManager {
    private String url;
    private String user;
    private String password;
    private Connection conn;

    public DatabaseManager(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    /**
     * Метод для підключення до бази даних
     */
    public void connect() throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
    }

    /**
     * Метод для виконання SQL запиту
     */
    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    /**
     * Метод для закриття з'єднання
     */
    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

}
