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

    /*   Method untuk mendapatkan semua kursi yang sudah di-check-in oleh pengguna tertentu berdasarkan username   */
    public List<Seat> getCheckedInSeatsByUser(String username) {
        List<Seat> checkedInSeats = new ArrayList<>(); /*   Membuat list untuk menampung kursi yang sudah di-check-in   */
        
        /*   Query SQL untuk mengambil nomor kursi, nama penumpang, kode pesawat, dan ID transaksi   */
        String query = "SELECT k.nomor_kursi, u.username AS nama_penumpang, t.kode_pesawat, t.id AS transaction_id " +
                       "FROM kursi k " +
                       "JOIN transaksi t ON k.transaksi_id = t.id " +
                       "JOIN users u ON t.user_id = u.id " +
                       "WHERE u.username = ? AND k.is_checked_in = true";

        /*   Membuka koneksi ke database dan menjalankan query   */
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            /*   Mengatur parameter username dalam query   */
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery(); /*   Menjalankan query dan mendapatkan hasilnya   */

            /*   Melakukan iterasi melalui hasil query dan menambahkan objek Seat ke dalam list   */
            while (resultSet.next()) {
                Seat seat = new Seat(
                    resultSet.getInt("nomor_kursi"),        /*   Nomor kursi   */
                    resultSet.getString("kode_pesawat"),    /*   Kode penerbangan   */
                    resultSet.getString("nama_penumpang"),  /*   Nama penumpang   */
                    resultSet.getLong("transaction_id")     /*   ID transaksi   */
                );
                checkedInSeats.add(seat); /*   Menambahkan objek Seat ke list checkedInSeats   */
            }

        } catch (SQLException e) {
            e.printStackTrace(); /*   Mencetak kesalahan jika ada exception SQL   */
        }

        return checkedInSeats; /*   Mengembalikan list kursi yang sudah di-check-in   */
    }
}
