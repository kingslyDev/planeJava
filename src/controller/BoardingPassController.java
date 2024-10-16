package controller;

import database.Database;
import model.BoardingPass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ariyo vonda
 */
public class BoardingPassController {

    /* Method untuk mendapatkan data boarding pass berdasarkan transactionId */

    /**
     *
     * @param transactionId
     * @return
     */

    public BoardingPass getBoardingPassDetails(long transactionId) {
        /* Query untuk mengambil data boarding pass, termasuk nama pengguna, kode penerbangan, 
           kota keberangkatan, kota kedatangan, nomor kursi, tanggal, dan waktu keberangkatan */
        String query = "SELECT u.username, t.kode_pesawat, tk.kota_keberangkatan, tk.kota_kedatangan, k.nomor_kursi, tk.jadwal_keberangkatan, tk.jam_keberangkatan " +
                       "FROM transaksi t " +
                       "JOIN users u ON t.user_id = u.id " +
                       "JOIN kursi k ON k.transaksi_id = t.id " +
                       "JOIN tiket tk ON tk.kode_pesawat = t.kode_pesawat " +
                       "WHERE t.id = ?";
        
        BoardingPass boardingPass = null;  /* Inisialisasi BoardingPass dengan null */
        
        try (Connection conn = Database.getConnection();  /* Membuka koneksi ke database */
             PreparedStatement ps = conn.prepareStatement(query)) {

            /* Mengatur nilai parameter query (transactionId) */
            ps.setLong(1, transactionId);
            ResultSet rs = ps.executeQuery();  /* Menjalankan query dan mendapatkan hasilnya */

            /* Jika hasil query ada, maka buat objek BoardingPass dengan data dari database */
            if (rs.next()) {
                boardingPass = new BoardingPass(
                    rs.getString("username"),               /* Nama penumpang */
                    rs.getString("kota_keberangkatan"),     /* Kota keberangkatan */
                    rs.getString("kota_kedatangan"),        /* Kota kedatangan */
                    rs.getString("kode_pesawat"),           /* Kode penerbangan */
                    rs.getInt("nomor_kursi"),               /* Nomor kursi */
                    rs.getString("jadwal_keberangkatan"),   /* Tanggal keberangkatan */
                    rs.getString("jam_keberangkatan")       /* Waktu keberangkatan */
                );
            }
        } catch (SQLException e) {
            /* Menangani kesalahan SQL dan mencetak stack trace */
            e.printStackTrace();
        }

        /* Mengembalikan objek BoardingPass jika ditemukan, atau null jika tidak ditemukan */
        return boardingPass;
    }
}
