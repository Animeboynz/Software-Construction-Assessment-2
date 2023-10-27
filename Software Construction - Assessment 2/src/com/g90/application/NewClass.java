package com.g90.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NewClass {
    public static void main(String[] args) {
        String dbUrl = "jdbc:derby://localhost:1527/InvDB;user=db;password=123";
        String backupDir = "C:\\Proxmark3";
        
        try {
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl);

            // Create a statement
            Statement stmt = conn.createStatement();

            // Perform the backup
            stmt.execute("CALL SYSCS_UTIL.SYSCS_BACKUP_DATABASE('" + backupDir + "')");

            // Close the statement and connection
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
