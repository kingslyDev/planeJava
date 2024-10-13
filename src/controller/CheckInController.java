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

    /* Method untuk mendapatkan kursi yang tersedia pada penerbangan 
       yang belum melakukan check-in berdasarkan kode penerbangan */
    public List<Integer> getAvailableSeats(String flightCode) {
        List<Integer> availableSeats = new ArrayList<>();  /* List untuk kursi yang tersedia */
        List<Integer> checkedInSeats = new ArrayList<>();  /* List untuk kursi yang sudah check-in */
        int totalSeats = 0;  /* Variabel untuk menyimpan total kursi yang tersedia */

        /* Query untuk mendapatkan jumlah kursi yang tersedia dari tabel tiket */
        String seatCountQuery = "SELECT kursi_tersedia FROM tiket WHERE kode_pesawat = ?";
        /* Query untuk mendapatkan nomor kursi yang sudah di-check-in dari tabel kursi */
        String checkedInQuery = "SELECT nomor_kursi FROM kursi WHERE is_checked_in = true AND transaksi_id IN (SELECT id FROM transaksi WHERE kode_pesawat = ?)";

        try (Connection conn = Database.getConnection()) {
            /* 1. Mengambil total kursi yang tersedia dari tabel tiket */
            try (PreparedStatement seatCountStmt = conn.prepareStatement(seatCountQuery)) {
                seatCountStmt.setString(1, flightCode);
                ResultSet rs = seatCountStmt.executeQuery();
                if (rs.next()) {
                    totalSeats = rs.getInt("kursi_tersedia");  /* Menyimpan total kursi */
                } else {
                    /* Jika tiket tidak ditemukan untuk kode penerbangan tersebut */
                    System.out.println("No tickets found for flight code: " + flightCode);
                    return availableSeats;  /* Kembalikan List kosong jika tidak ada tiket */
                }
            }

            /* 2. Mengambil nomor kursi yang sudah di-check-in dari tabel kursi */
            try (PreparedStatement checkedInStmt = conn.prepareStatement(checkedInQuery)) {
                checkedInStmt.setString(1, flightCode);
                ResultSet rs = checkedInStmt.executeQuery();
                while (rs.next()) {
                    checkedInSeats.add(rs.getInt("nomor_kursi"));  /* Menyimpan kursi yang sudah check-in */
                }
            }

            /* 3. Membuat list kursi yang belum di-check-in */
            for (int i = 1; i <= totalSeats; i++) {
                if (!checkedInSeats.contains(i)) {
                    availableSeats.add(i);  /* Menambahkan kursi yang belum check-in ke List */
                }
            }

            /* Menampilkan jumlah kursi yang tersedia */
            System.out.println("Available seats for flight code " + flightCode + ": " + availableSeats.size());

        } catch (SQLException e) {
            /* Menangani kesalahan SQL */
            e.printStackTrace();
        }

        return availableSeats;  /* Mengembalikan List kursi yang tersedia */
    }

    /* Method untuk memvalidasi kode boarding dan mengembalikan transaksi terkait */
    public Transaction validateBoardingCode(String boardingCode) {
        /* Query untuk mendapatkan data transaksi berdasarkan kode boarding */
        String query = "SELECT * FROM transaksi WHERE kode_boarding = ?";
        Transaction transaction = null;  /* Inisialisasi objek Transaction */

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, boardingCode);  /* Mengatur kode boarding sebagai parameter */
            ResultSet rs = ps.executeQuery();  /* Menjalankan query */

            if (rs.next()) {
                /* Membuat objek Transaction jika transaksi ditemukan */
                transaction = new Transaction(
                    rs.getLong("user_id"),        /* ID pengguna */
                    rs.getString("kode_pesawat"), /* Kode penerbangan */
                    rs.getString("kode_boarding"),/* Kode boarding */
                    rs.getString("status"),       /* Status transaksi */
                    0.0,  /* Harga tidak diperlukan untuk proses check-in */
                    null  /* Tidak diperlukan peran di sini */
                );
            } else {
                /* Jika transaksi tidak ditemukan */
                System.out.println("No transaction found for boarding code: " + boardingCode);
            }
        } catch (SQLException e) {
            /* Menangani kesalahan SQL */
            e.printStackTrace();
        }

        return transaction;  /* Mengembalikan objek Transaction atau null jika tidak ditemukan */
    }

    /* Method untuk melakukan check-in pada kursi dan mengupdate status transaksi */
    public boolean checkInSeat(long transactionId, int seatNumber) {
        /* Query untuk memeriksa apakah kursi sudah di-check-in */
        String checkIfCheckedInQuery = "SELECT COUNT(*) FROM kursi WHERE transaksi_id = ? AND nomor_kursi = ? AND is_checked_in = true";
        /* Query untuk melakukan check-in pada kursi */
        String checkInQuery = "INSERT INTO kursi (transaksi_id, nomor_kursi, is_checked_in) VALUES (?, ?, true)";
        /* Query untuk mengupdate status transaksi setelah check-in */
        String updateStatusQuery = "UPDATE transaksi SET status = 'BERANGKAT' WHERE id = ?";
        boolean success = false;  /* Variabel untuk menandai apakah check-in berhasil */

        try (Connection conn = Database.getConnection();
             PreparedStatement checkIfCheckedInStmt = conn.prepareStatement(checkIfCheckedInQuery);
             PreparedStatement checkInStmt = conn.prepareStatement(checkInQuery);
             PreparedStatement updateStatusStmt = conn.prepareStatement(updateStatusQuery)) {

            conn.setAutoCommit(false);  /* Memulai transaksi database */

            /* Memeriksa apakah kursi sudah di-check-in sebelumnya */
            checkIfCheckedInStmt.setLong(1, transactionId);
            checkIfCheckedInStmt.setInt(2, seatNumber);
            ResultSet rs = checkIfCheckedInStmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                /* Jika kursi sudah di-check-in, tampilkan pesan dan kembalikan false */
                System.out.println("Seat " + seatNumber + " is already checked in for transaction ID: " + transactionId);
                return false;
            }

            /* Debugging: Menampilkan transaction ID dan nomor kursi */
            System.out.println("Transaction ID: " + transactionId);
            System.out.println("Seat Number: " + seatNumber);

            /* 1. Melakukan check-in untuk kursi (memasukkan data ke tabel kursi) */
            checkInStmt.setLong(1, transactionId);
            checkInStmt.setInt(2, seatNumber);
            int rowsUpdated = checkInStmt.executeUpdate();

            /* Jika check-in berhasil, lanjutkan untuk mengupdate status transaksi */
            if (rowsUpdated > 0) {
                System.out.println("Seat check-in success. Updating status...");
                updateStatusStmt.setLong(1, transactionId);
                int statusUpdated = updateStatusStmt.executeUpdate();

                if (statusUpdated > 0) {
                    conn.commit();  /* Commit transaksi jika semua berhasil */
                    success = true;
                    System.out.println("Check-in and status update successful.");
                } else {
                    conn.rollback();  /* Rollback jika update status gagal */
                    System.out.println("Status update failed. Rolling back...");
                }
            } else {
                conn.rollback();  /* Rollback jika check-in kursi gagal */
                System.out.println("Seat check-in failed. Rolling back...");
            }

        } catch (SQLException e) {
            /* Menangani kesalahan SQL */
            e.printStackTrace();
        }

        return success;  /* Mengembalikan true jika check-in berhasil, false jika gagal */
    }
}
