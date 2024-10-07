package controller;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Transaction;

public class CheckInController {

    // Method to get available seats for a flight that haven't been checked in
    public List<Integer> getAvailableSeats(String flightCode) {
        List<Integer> availableSeats = new ArrayList<>();
        List<Integer> checkedInSeats = new ArrayList<>();
        int totalSeats = 0;

        String seatCountQuery = "SELECT kursi_tersedia FROM tiket WHERE kode_pesawat = ?";
        String checkedInQuery = "SELECT nomor_kursi FROM kursi WHERE is_checked_in = true AND transaksi_id IN (SELECT id FROM transaksi WHERE kode_pesawat = ?)";

        try (Connection conn = Database.getConnection()) {
            // 1. Get total seats from tiket table
            try (PreparedStatement seatCountStmt = conn.prepareStatement(seatCountQuery)) {
                seatCountStmt.setString(1, flightCode);
                ResultSet rs = seatCountStmt.executeQuery();
                if (rs.next()) {
                    totalSeats = rs.getInt("kursi_tersedia");
                } else {
                    System.out.println("No tickets found for flight code: " + flightCode);
                    return availableSeats;  // Return empty if no tickets found
                }
            }

            // 2. Get checked-in seats from kursi table
            try (PreparedStatement checkedInStmt = conn.prepareStatement(checkedInQuery)) {
                checkedInStmt.setString(1, flightCode);
                ResultSet rs = checkedInStmt.executeQuery();
                while (rs.next()) {
                    checkedInSeats.add(rs.getInt("nomor_kursi"));
                }
            }

            // 3. Build list of seats that haven't been checked in
            for (int i = 1; i <= totalSeats; i++) {
                if (!checkedInSeats.contains(i)) {
                    availableSeats.add(i);
                }
            }

            System.out.println("Available seats for flight code " + flightCode + ": " + availableSeats.size());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return availableSeats;
    }

    // Method to validate boarding code and return related transaction
    public Transaction validateBoardingCode(String boardingCode) {
        String query = "SELECT * FROM transaksi WHERE kode_boarding = ?";
        Transaction transaction = null;

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, boardingCode);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                transaction = new Transaction(
                    rs.getLong("user_id"),
                    rs.getString("kode_pesawat"),
                    rs.getString("kode_boarding"),
                    rs.getString("status"),
                    0.0,  // Price is not needed for check-in
                    null  // No need for role here
                );
            } else {
                System.out.println("No transaction found for boarding code: " + boardingCode);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transaction;
    }

    // Method to check-in seat and update transaction status
    public boolean checkInSeat(long transactionId, int seatNumber) {
        String checkIfCheckedInQuery = "SELECT COUNT(*) FROM kursi WHERE transaksi_id = ? AND nomor_kursi = ? AND is_checked_in = true";
        String checkInQuery = "INSERT INTO kursi (transaksi_id, nomor_kursi, is_checked_in) VALUES (?, ?, true)";
        String updateStatusQuery = "UPDATE transaksi SET status = 'BERANGKAT' WHERE id = ?";
        boolean success = false;

        try (Connection conn = Database.getConnection();
             PreparedStatement checkIfCheckedInStmt = conn.prepareStatement(checkIfCheckedInQuery);
             PreparedStatement checkInStmt = conn.prepareStatement(checkInQuery);
             PreparedStatement updateStatusStmt = conn.prepareStatement(updateStatusQuery)) {

            conn.setAutoCommit(false);  // Start transaction

            // Check if the seat is already checked in
            checkIfCheckedInStmt.setLong(1, transactionId);
            checkIfCheckedInStmt.setInt(2, seatNumber);
            ResultSet rs = checkIfCheckedInStmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Seat " + seatNumber + " is already checked in for transaction ID: " + transactionId);
                return false;  // Seat already checked in
            }

            // Debugging: Print the transaction ID and seat number
            System.out.println("Transaction ID: " + transactionId);
            System.out.println("Seat Number: " + seatNumber);

            // 1. Perform check-in for the seat (insert into kursi table)
            checkInStmt.setLong(1, transactionId);
            checkInStmt.setInt(2, seatNumber);
            int rowsUpdated = checkInStmt.executeUpdate();

            // If the seat is successfully checked in, update the transaction status
            if (rowsUpdated > 0) {
                System.out.println("Seat check-in success. Updating status...");
                updateStatusStmt.setLong(1, transactionId);
                int statusUpdated = updateStatusStmt.executeUpdate();

                if (statusUpdated > 0) {
                    conn.commit();  // Commit transaction if everything is successful
                    success = true;
                    System.out.println("Check-in and status update successful.");
                } else {
                    conn.rollback();  // Rollback if there is an issue updating the status
                    System.out.println("Status update failed. Rolling back...");
                }
            } else {
                conn.rollback();  // Rollback if the seat fails to check in
                System.out.println("Seat check-in failed. Rolling back...");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
}
