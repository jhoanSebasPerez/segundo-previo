package com.perez.simpledemo.dao;

import com.perez.simpledemo.models.Bill;
import com.perez.simpledemo.models.User;
import com.perez.simpledemo.utils.ConnectionDB;
import com.perez.simpledemo.utils.ConnectionPostgresDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {

    private final ConnectionDB connectionDB = new ConnectionPostgresDB();

    public void save(Bill bill){
        try{
            Connection connection = connectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO bill (date_bill, user_id, value, type, observation) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setDate(1, java.sql.Date.valueOf(bill.getDateBill()));
            preparedStatement.setInt(2, bill.getUserId());
            preparedStatement.setFloat(3, bill.getValue());
            preparedStatement.setInt(4, bill.getType());
            preparedStatement.setString(5, bill.getObservation());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Bill> getBillsByUserId(int userId){
        List<Bill> bills = new ArrayList<>();

        try{
            Connection connection = connectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bill WHERE user_id = ?");
            preparedStatement.setInt(1, userId);

            // Execute the select statement and store the result set in a ResultSet.
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate over the ResultSet and add each row to a list of users.
            while (resultSet.next()) {
                 Bill bill= Bill.builder()
                        .id(resultSet.getInt("id"))
                        .userId(resultSet.getInt("user_id"))
                        .dateBill(resultSet.getDate("date_bill").toLocalDate())
                        .value(resultSet.getFloat("value"))
                        .type(resultSet.getInt("type"))
                        .observation(resultSet.getString("observation"))
                        .build();
                bills.add(bill);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return bills;
    }
}
