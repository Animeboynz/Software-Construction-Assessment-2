package com.g90.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class javaconnect {

    public static Connection con;
    public static String url2 = "jdbc:derby:InvEmbeddedDB;create=true";
    public static String username = "db";
    public static String password = "123";

    public static Connection connectdb() {
        try {
            con = DriverManager.getConnection(url2, username, password);
            System.out.println(url2 + " connected...");
            return con;
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return null;
    }
}
