package com.perez.simpledemo.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionMysqldb {
    private static Connection connection;

    /** SET YOUR DATABASE NAME, BY DEFAULT IS "SYSTEM"*/
    private static final String DB_URL = "jdbc:mysql://mysql:3306/sistema";

    /** SET YOUR USERNAME NAME*/
    private static final String DB_USER = "prueba";

    /** SET YOUR PASSWORD*/
    private static final String DB_PASSWORD = "test1234";

    private final static Logger logger = Logger.getLogger(ConnectionMysqldb.class.getName());


    private ConnectionMysqldb() {
    }

    public static Connection getConnection() {
        logger.log(Level.INFO, "DATABASE URL: " + DB_URL);
        logger.log(Level.INFO, "DATABASE USER: " + DB_USER);
        logger.log(Level.INFO, "DATABASE PASSWORD: " + DB_PASSWORD);

        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }
}