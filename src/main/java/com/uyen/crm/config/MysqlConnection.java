package com.uyen.crm.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {
    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/crm_app","root", "uyen");
        }catch (Exception e){
            System.out.println("Error Connection Database" + e.getMessage());
        }
    return connection;
    }
}
