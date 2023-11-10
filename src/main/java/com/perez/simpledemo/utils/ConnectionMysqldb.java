package com.perez.simpledemo.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysqldb {
    private static Connection connection;

    /** SET YOUR DATABASE NAME, BY DEFAULT IS "SYSTEM"*/
    private static final String DB_URL = "jdbc:mysql://localhost:3306/system";

    /** SET YOUR USERNAME NAME*/
    private static final String DB_USER = "root";

    /** SET YOUR PASSWORD*/
    private static final String DB_PASSWORD = "admin1234";


    private ConnectionMysqldb() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                // Handle exceptions appropriately
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle exceptions appropriately
            }
        }
    }
}