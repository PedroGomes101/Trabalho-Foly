package com.iff.livraria.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnFactory {
    
     public static Connection getConnection() throws SQLException {
       
       Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/livraria", "root", "mysql");

       return conn;
     }    
    
}