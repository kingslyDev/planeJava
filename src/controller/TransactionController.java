package controller;

import database.Database;
import model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionController {

    // Method to save a transaction to the database
    // Method to save a transaction to the database
public boolean saveTransaction(Transaction transaction) {
    String transactionQuery = "INSERT INTO transaksi (user_id, kode_pesawat, waktu_transaksi, kode_boarding, status) VALUES (?, ?, CURRENT_TIMESTAMP, ?, ?)";
    String updateSeatsQuery = "UPDATE tiket SET kursi_tersedia = kursi_tersedia - 1 WHERE kode_pesawat = ?";
    boolean isSuccess = false;
    Connection conn = null;

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
                    isSuccess = true;
                } else {
                    conn.rollback(); // Rollback on seat update failure
                }
            } else {
                conn.rollback(); // Rollback on transaction failure
            }
        }

    } catch (SQLException e) {
        System.err.println("Error saving transaction: " + e.getMessage());
        e.printStackTrace();
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
                conn.setAutoCommit(true); // Restore autocommit
                conn.close();
            } catch (SQLException closeEx) {
                System.err.println("Error closing connection: " + closeEx.getMessage());
            }
        }
    }

    return isSuccess; // Return success status
}


    // Method to get all transactions for a specific user
    public List<Transaction> getTransactionsByUserId(long userId) {
        List<Transaction> transactions = new ArrayList<>();
        String query = """
                       SELECT t.user_id, t.kode_pesawat, t.kode_boarding, t.status, tk.price 
                       FROM transaksi t
                       JOIN tiket tk ON t.kode_pesawat = tk.kode_pesawat
                       WHERE t.user_id = ?
                       """;

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setLong(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Transaction transaction = new Transaction(
                    userId,
                    rs.getString("kode_pesawat"),
                    rs.getString("kode_boarding"),
                    rs.getString("status"),
                    rs.getDouble("price"), // Price retrieved from joined tiket table
                    null // Role not needed
                );
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactions;
    }

    // Method to get all transactions (for Admin)
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String query = """
                       SELECT t.user_id, t.kode_pesawat, t.kode_boarding, t.status, tk.price
                       FROM transaksi t
                       JOIN tiket tk ON t.kode_pesawat = tk.kode_pesawat
                       """;

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Transaction transaction = new Transaction(
                    rs.getLong("user_id"),
                    rs.getString("kode_pesawat"),
                    rs.getString("kode_boarding"),
                    rs.getString("status"),
                    rs.getDouble("price"), // Price retrieved from tiket table
                    null // Role not needed here
                );
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactions;
    }
}
