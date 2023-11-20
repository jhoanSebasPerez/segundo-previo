package com.perez.simpledemo.dao;

import com.perez.simpledemo.models.User;
import com.perez.simpledemo.utils.ConnectionDB;
import com.perez.simpledemo.utils.ConnectionMysqldb;
import com.perez.simpledemo.utils.ConnectionPostgresDB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements Serializable {

    private final ConnectionDB connectionDB = new ConnectionPostgresDB();

    public User getUserByUsername(String username){
        User user = null;
        try{
            Connection connection = connectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            preparedStatement.setString(1, username);

            // Execute the select statement and store the result set in a ResultSet.
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate over the ResultSet and add each row to a list of users.
            while (resultSet.next()) {
                user = User.builder()
                        .id(resultSet.getInt("id"))
                        .username(resultSet.getString("username"))
                        .email(resultSet.getString("email"))
                        .pass(resultSet.getString("pass"))
                        .build();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return user;
    }

    public boolean userExistsByUsername(String username){
        boolean exists = false;
        try{
            Connection connection = connectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            preparedStatement.setString(1, username);

            // Execute the select statement and store the result set in a ResultSet.
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate over the ResultSet and add each row to a list of users.
            while (resultSet.next()) {
                exists = true;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return exists;
    }
}
