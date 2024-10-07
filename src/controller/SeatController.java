package controller;

import database.Database;
import model.Seat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatController {

    // Method to get all seats that have been checked-in by a specific user
    public List<Seat> getCheckedInSeatsByUser(String username) {
        List<Seat> checkedInSeats = new ArrayList<>();
        String query = "SELECT k.nomor_kursi, u.username AS nama_penumpang, t.kode_pesawat, t.id AS transaction_id " +
                       "FROM kursi k " +
                       "JOIN transaksi t ON k.transaksi_id = t.id " +
                       "JOIN users u ON t.user_id = u.id " +
                       "WHERE u.username = ? AND k.is_checked_in = true";

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set the username parameter
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Loop through the result set and add Seat objects to the list
            while (resultSet.next()) {
                Seat seat = new Seat(
                    resultSet.getInt("nomor_kursi"),        // Seat number
                    resultSet.getString("kode_pesawat"),    // Flight code
                    resultSet.getString("nama_penumpang"),  // Passenger name
                    resultSet.getLong("transaction_id")     // Transaction ID
                );
                checkedInSeats.add(seat);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception for debugging
        }

        return checkedInSeats;
    }
}
