/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.task_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author login
 */
public class ConnectionClass {
      private static ConnectionClass single_instance = null;
    Connection connection;

    private ConnectionClass() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskmanagement", "root", "");
            if (connection != null) {
                System.out.println("connected");
               
                
                String sql = "CREATE TABLE IF NOT EXISTS addEmployee ( ID INT NOT NULL AUTO_INCREMENT ,name VARCHAR(255) NOT NULL"
                        + ",joiningDate VARCHAR(255) NOT NULL , age INT NOT NULL , address VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL ,"
                        + "password VARCHAR(255) NOT NULL, contactNumber VARCHAR(255) NOT NULL , adharNumber VARCHAR(255) NOT NULL,"
                        + "PRIMARY KEY(ID) )";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.execute();
                System.out.println("Created table addEmplooye successfully");
                
                
            }
        } catch (SQLException ex) {
            System.out.println("Exception in connection class"+ex);
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static ConnectionClass getInstance() {
        if (single_instance == null) {
            single_instance = new ConnectionClass();
        }
        return single_instance;
    }
}
