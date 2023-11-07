package com.perez.simpledemo.dao;

import com.perez.simpledemo.models.User;
import com.perez.simpledemo.utils.ConnectionMysqldb;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements Serializable {

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();

        try{
            Connection connection = ConnectionMysqldb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");

            // Execute the select statement and store the result set in a ResultSet.
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate over the ResultSet and add each row to a list of users.
            while (resultSet.next()) {
                User user = User.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .email(resultSet.getString("email"))
                        .country(resultSet.getString("country"))
                        .build();
                users.add(user);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return users;
    }

    public void delete(int id){
        try {
            Connection connection = ConnectionMysqldb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM users WHERE id = ?");
            preparedStatement.setInt(1, id);

            // Execute the delete statement
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("Deletion failed.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(User user){
        try {
            Connection connection = ConnectionMysqldb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users (name, email, country) VALUES (?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());

            // Execute the insert statement
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Insertion failed.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(User user){
        try {
            Connection connection = ConnectionMysqldb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE users SET name = ?, email = ?, country = ? WHERE id = ?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());

            // Execute the update statement
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("Update failed.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserById(int id){
        User user = null;
        try{
            Connection connection = ConnectionMysqldb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            preparedStatement.setInt(1, id);

            // Execute the select statement and store the result set in a ResultSet.
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate over the ResultSet and add each row to a list of users.
            while (resultSet.next()) {
                user = User.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .email(resultSet.getString("email"))
                        .country(resultSet.getString("country"))
                        .build();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return user;
    }
}
