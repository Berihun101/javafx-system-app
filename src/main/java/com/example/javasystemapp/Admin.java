package com.example.javasystemapp;

import java.sql.*;

public class Admin {
    static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost/sims";
    static String DB_USER = "root";
    static String DB_PASS = "";
    private static String adminName;

    public static String getAdminName() throws ClassNotFoundException, SQLException {
        Class.forName(DB_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
        Statement stmt =connection.createStatement();
        String query = "SELECT * from admin";
        ResultSet result = stmt.executeQuery(query);
        while (result.next()) {
            adminName = result.getString("username");

        }
        return adminName;
    }

}
