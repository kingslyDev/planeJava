package controller;

import database.Database;
import model.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionController {

    // Method to save a transaction to the database
    public boolean saveTransaction(Transaction transaction) {
        String transactionQuery = "INSERT INTO transaksi (user_id, kode_pesawat, waktu_transaksi, kode_boarding, status) VALUES (?, ?, CURRENT_TIMESTAMP, ?, ?)";
        String updateSeatsQuery = "UPDATE tiket SET kursi_tersedia = kursi_tersedia - 1 WHERE kode_pesawat = ?";
        boolean isSuccess = false; // Flag to indicate success
        Connection conn = null; // Declare connection outside try block

        try {
            conn = Database.getConnection();
            conn.setAutoCommit(false); // Start transaction
            
            try (PreparedStatement transactionStmt = conn.prepareStatement(transactionQuery);
                 PreparedStatement updateSeatsStmt = conn.prepareStatement(updateSeatsQuery)) {

                // Insert transaction data
                 System.out.println("User ID: " + transaction.getUserId());
                transactionStmt.setLong(1, transaction.getUserId());
                transactionStmt.setString(2, transaction.getFlightCode());
                transactionStmt.setString(3, transaction.getBoardingCode());
                transactionStmt.setString(4, transaction.getStatus());
                int rowsAffected = transactionStmt.executeUpdate();

                // If the transaction was successful, update seat availability
                if (rowsAffected > 0) {
                    updateSeatsStmt.setString(1, transaction.getFlightCode());
                    int updateSeatsAffected = updateSeatsStmt.executeUpdate();
                    
                    // Commit transaction only if both operations succeed
                    if (updateSeatsAffected > 0) {
                        conn.commit();
                        isSuccess = true; // Transaction and seat update successful
                    } else {
                        conn.rollback(); // Rollback in case seat update fails
                    }
                } else {
                    conn.rollback(); // Rollback in case transaction fails
                }
            }

        } catch (SQLException e) {
            System.err.println("Error saving transaction: " + e.getMessage());
            e.printStackTrace(); // Debugging
            if (conn != null) {
                try {
                    conn.rollback(); // Ensure rollback on failure
                } catch (SQLException rollbackEx) {
                    System.err.println("Error during rollback: " + rollbackEx.getMessage());
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); // Restore default autocommit behavior
                    conn.close(); // Close the connection
                } catch (SQLException closeEx) {
                    System.err.println("Error closing connection: " + closeEx.getMessage());
                }
            }
        }

        return isSuccess; // Return the success flag
    }
}
