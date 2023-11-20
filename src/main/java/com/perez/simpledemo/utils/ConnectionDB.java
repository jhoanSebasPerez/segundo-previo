package com.perez.simpledemo.utils;

import java.sql.Connection;

public interface ConnectionDB {

    Connection getConnection();
    void closeConnection();
}
