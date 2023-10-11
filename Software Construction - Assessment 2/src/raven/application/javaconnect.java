/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author Animeboynz
 */
public class javaconnect {
    
    public static Connection con;
    public static String url="jdbc:derby://localhost:1527/InvDB;create=true";
    public static String username="db";
    public static String password="123";
    
    public static Connection connectdb()
    {
        try
        {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            con=DriverManager.getConnection(url, username, password);
            System.out.println(url +" connected...");
            return con;
        }
        catch (SQLException ex) 
        {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return null;
    }


    
}
