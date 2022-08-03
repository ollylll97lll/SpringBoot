package com.hiberdemo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
    final static String DATABASE_URL = "jdbc:postgresql://localhost:5432/";
    final static String user = "postgres";
    final static String password = "postgres";

    private static Connection getConnect(String url, String user, String password){

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
                System.out.println(connection);
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {
        getConnect(DATABASE_URL,user,password);
    }
}
