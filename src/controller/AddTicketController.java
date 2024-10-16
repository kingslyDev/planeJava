package controller;

import database.Database;
import model.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ariyo vonda
 */
public class AddTicketController {

    /* Method untuk menambahkan tiket baru ke database */

    /**
     *
     * @param ticket
     * @return
     */

    public boolean addTicket(Ticket ticket) {
        /* Mendapatkan koneksi ke database */
        Connection conn = Database.getConnection();
        
        /* Query SQL untuk menambahkan data tiket ke tabel 'tiket' */
        String query = "INSERT INTO tiket (kode_pesawat, kota_keberangkatan, kota_kedatangan, jadwal_keberangkatan, jam_keberangkatan, kursi_tersedia, status, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            /* Mempersiapkan statement untuk menjalankan query */
            PreparedStatement ps = conn.prepareStatement(query);
            
            /* Mengisi parameter query dengan nilai dari objek Ticket */
            ps.setString(1, ticket.getFlightCode());
            ps.setString(2, ticket.getDepartureCity());
            ps.setString(3, ticket.getArrivalCity());
            ps.setDate(4, new java.sql.Date(ticket.getDepartureDate().getTime()));
            ps.setString(5, ticket.getDepartureTime()); // Menyimpan jam keberangkatan
            ps.setInt(6, ticket.getAvailableSeats());
            ps.setString(7, ticket.getStatus());
            ps.setDouble(8, ticket.getPrice());

            /* Menjalankan query dan memeriksa jumlah baris yang dimasukkan */
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Tiket berhasil ditambahkan!");
                return true; // Tiket berhasil ditambahkan
            }
        } catch (SQLException e) {
            /* Menangani kesalahan SQL */
            e.printStackTrace();
        } finally {
            try {
                /* Menutup koneksi setelah selesai */
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                /* Menangani kesalahan saat menutup koneksi */
                e.printStackTrace();
            }
        }
        return false; // Gagal menambahkan tiket
    }
}
