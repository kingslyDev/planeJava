package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/planejava"; // Change to your database name
    private static final String USER = "root"; // Change if your username is different
    private static final String PASSWORD = ""; // Change if you have a password

    // Method to get the connection
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Attempting to get a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
        return connection;
    }

    // Main method to test the connection
    public static void main(String[] args) {
        Connection conn = Database.getConnection();
        
        // Check if the connection is successful before proceeding
        if (conn != null) {
            try {
                // Perform desired operations here

            } finally {
                // Always close the connection in the finally block
                try {
                    conn.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    System.err.println("Failed to close connection: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Connection was not established, skipping operations.");
        }
    }
}
