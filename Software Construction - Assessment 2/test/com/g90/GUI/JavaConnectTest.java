package com.g90.GUI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class JavaConnectTest {

    private Connection connection;

    @Before
    public void setUp() {
        connection = javaconnect.connectdb();
        assertNotNull("Connection should not be null", connection);
    }

    @After
    public void tearDown() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                fail("SQLException while closing connection: " + e.getMessage());
            }
        }
    }

    @Test
    public void testLoginTableExists() {
        assertTableExists("LOGIN");
    }

    @Test
    public void testDataTableExists() {
        assertTableExists("DATA");
    }

    @Test
    public void testProductsTableExists() {
        assertTableExists("PRODUCTS");
    }

    @Test
    public void testLocationsTableExists() {
        assertTableExists("LOCATIONS");
    }

    private void assertTableExists(String tableName) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT 1 FROM " + tableName);
            assertNotNull("Table " + tableName + " should exist", resultSet);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            fail("SQLException while checking table " + tableName + ": " + e.getMessage());
        }
    }
}
