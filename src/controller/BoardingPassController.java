package controller;

import database.Database;
import model.BoardingPass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardingPassController {

    // Method untuk mendapatkan data boarding pass berdasarkan transactionId
    public BoardingPass getBoardingPassDetails(long transactionId) {
        String query = "SELECT u.username, t.kode_pesawat, tk.kota_keberangkatan, tk.kota_kedatangan, k.nomor_kursi, tk.jadwal_keberangkatan, tk.jam_keberangkatan " +
                       "FROM transaksi t " +
                       "JOIN users u ON t.user_id = u.id " +
                       "JOIN kursi k ON k.transaksi_id = t.id " +
                       "JOIN tiket tk ON tk.kode_pesawat = t.kode_pesawat " +
                       "WHERE t.id = ?";
        
        BoardingPass boardingPass = null;
        
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setLong(1, transactionId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                boardingPass = new BoardingPass(
                    rs.getString("username"),               // Nama penumpang
                    rs.getString("kota_keberangkatan"),     // Kota keberangkatan
                    rs.getString("kota_kedatangan"),        // Kota kedatangan
                    rs.getString("kode_pesawat"),           // Kode penerbangan
                    rs.getInt("nomor_kursi"),               // Nomor kursi
                    rs.getString("jadwal_keberangkatan"),   // Tanggal keberangkatan
                    rs.getString("jam_keberangkatan")       // Waktu keberangkatan
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return boardingPass;
    }
}
