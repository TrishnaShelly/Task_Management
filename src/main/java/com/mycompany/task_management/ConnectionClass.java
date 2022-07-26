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
               
                
                String sql = "CREATE TABLE IF NOT EXISTS users ( ID INT NOT NULL AUTO_INCREMENT ,name VARCHAR(255) NOT NULL"
                        + ",joiningDate VARCHAR(255)  ,role INT NOT NULL,  age INT  , address VARCHAR(255) , email VARCHAR(255) NOT NULL ,"
                        + "password VARCHAR(255) NOT NULL, contactNumber VARCHAR(255), "
                        + "PRIMARY KEY(ID) )";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.execute();
                System.out.println("Created table addEmplooye successfully");
                  
                String sql2="CREATE TABLE IF NOT EXISTS tasks (ID INT NOT NULL AUTO_INCREMENT ,title  VARCHAR(255) NOT NULL,"
                        + "description VARCHAR(255) NOT NULL , startDate VARCHAR(255) NOT NULL , dueDate VARCHAR(255) NOT NULL,"
                        + "employeeID INT NOT NULL,managerID INT NOT NULL,status INT,"
                        + "  PRIMARY KEY(ID))";
                PreparedStatement ps2 = connection.prepareStatement(sql2);
              if(     ps2.executeUpdate()>0) {
                  System.out.println("creater table tasks ");
              } else {
              }
              
//              String sql3 = "CREATE TABLE IF NOT EXISTS status ( ID INT NOT NULL AUTO_INCREMENT ,"
//                      + "taskID INT NOT NULL ,"
//                      + "complete INT ,"   // 1 for completed 
//                      + "PRIMARY KEY(ID) )";
//                PreparedStatement ps3 = connection.prepareStatement(sql3);
//                ps3.execute();
//                System.out.println("Created table status "
//                        + " successfully");
                
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
