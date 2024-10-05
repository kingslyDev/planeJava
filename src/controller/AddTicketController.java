package controller;

import database.Database;
import model.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddTicketController {

    // Method untuk menambahkan tiket baru ke database
    public boolean addTicket(Ticket ticket) {
        Connection conn = Database.getConnection();
        String query = "INSERT INTO tiket (kode_pesawat, kota_keberangkatan, kota_kedatangan, jadwal_keberangkatan, jam_keberangkatan, kursi_tersedia, status, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ticket.getFlightCode());
            ps.setString(2, ticket.getDepartureCity());
            ps.setString(3, ticket.getArrivalCity());
            ps.setDate(4, new java.sql.Date(ticket.getDepartureDate().getTime()));
            ps.setString(5, ticket.getDepartureTime()); // Menyimpan jam keberangkatan
            ps.setInt(6, ticket.getAvailableSeats());
            ps.setString(7, ticket.getStatus());
            ps.setDouble(8, ticket.getPrice());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Tiket berhasil ditambahkan!");
                return true; // Tiket berhasil ditambahkan
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false; // Gagal menambahkan tiket
    }
}
