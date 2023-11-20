package com.perez.simpledemo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionPostgresDB implements ConnectionDB{

    private static Connection connection;

    /** SET YOUR DATABASE NAME, BY DEFAULT IS "SYSTEM"*/
    private static final String DB_URL = "jdbc:postgresql://db.eigzbbtaqbpehuzcsjpj.supabase.co:5432/postgres";

    /** SET YOUR USERNAME NAME*/
    private static final String DB_USER = "postgres";

    /** SET YOUR PASSWORD*/
    private static final String DB_PASSWORD = "-GvFte*ze9Phg7w";

    private final static Logger logger = Logger.getLogger(ConnectionPostgresDB.class.getName());

    public Connection getConnection(){
        //Make connection to postgres database by using constant values above
        logger.log(Level.INFO, "DATABASE URL: " + DB_URL);
        logger.log(Level.INFO, "DATABASE USER: " + DB_USER);

        if(connection == null){
            try{
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            }catch(SQLException | ClassNotFoundException e){
                logger.log(Level.SEVERE, e.getMessage());
            }
        }

        return connection;

    }

    public void closeConnection(){
        if(connection != null){
            try{
                connection.close();
            }catch(SQLException e){
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }
}
