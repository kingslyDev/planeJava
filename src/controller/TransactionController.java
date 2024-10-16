package controller;

import database.Database;
import model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ariyo vonda
 */
public class TransactionController {

    /*   Method untuk menyimpan transaksi ke database   */

    /**
     *
     * @param transaction
     * @return
     */

    public boolean saveTransaction(Transaction transaction) {
        String transactionQuery = "INSERT INTO transaksi (user_id, kode_pesawat, waktu_transaksi, kode_boarding, status) VALUES (?, ?, CURRENT_TIMESTAMP, ?, ?)";
        String updateSeatsQuery = "UPDATE tiket SET kursi_tersedia = kursi_tersedia - 1 WHERE kode_pesawat = ?";
        boolean isSuccess = false; /*   Flag untuk menandakan apakah transaksi berhasil disimpan   */
        Connection conn = null; /*   Inisialisasi objek Connection   */

        try {
            conn = Database.getConnection(); /*   Mendapatkan koneksi ke database   */
            conn.setAutoCommit(false); /*   Memulai transaksi database   */

            try (PreparedStatement transactionStmt = conn.prepareStatement(transactionQuery);
                 PreparedStatement updateSeatsStmt = conn.prepareStatement(updateSeatsQuery)) {

                /*   Menyimpan data transaksi   */
                System.out.println("User ID: " + transaction.getUserId());
                transactionStmt.setLong(1, transaction.getUserId());
                transactionStmt.setString(2, transaction.getFlightCode());
                transactionStmt.setString(3, transaction.getBoardingCode());
                transactionStmt.setString(4, transaction.getStatus());
                int rowsAffected = transactionStmt.executeUpdate(); /*   Eksekusi query untuk menyimpan transaksi   */

                /*   Jika transaksi berhasil, update jumlah kursi yang tersedia   */
                if (rowsAffected > 0) {
                    updateSeatsStmt.setString(1, transaction.getFlightCode());
                    int updateSeatsAffected = updateSeatsStmt.executeUpdate();

                    /*   Commit transaksi jika kedua operasi berhasil   */
                    if (updateSeatsAffected > 0) {
                        conn.commit();
                        isSuccess = true; /*   Tandai transaksi sebagai sukses   */
                    } else {
                        conn.rollback(); /*   Rollback jika gagal mengupdate kursi   */
                    }
                } else {
                    conn.rollback(); /*   Rollback jika gagal menyimpan transaksi   */
                }
            }

        } catch (SQLException e) {
            System.err.println("Error saving transaction: " + e.getMessage());
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback(); /*   Rollback transaksi jika terjadi kesalahan   */
                } catch (SQLException rollbackEx) {
                    System.err.println("Error during rollback: " + rollbackEx.getMessage());
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); /*   Mengembalikan mode autocommit   */
                    conn.close(); /*   Menutup koneksi ke database   */
                } catch (SQLException closeEx) {
                    System.err.println("Error closing connection: " + closeEx.getMessage());
                }
            }
        }

        return isSuccess; /*   Mengembalikan status transaksi (berhasil atau gagal)   */
    }

    /*   Method untuk mendapatkan semua transaksi untuk pengguna tertentu berdasarkan userId   */

    /**
     *
     * @param userId
     * @return
     */

    public List<Transaction> getTransactionsByUserId(long userId) {
        List<Transaction> transactions = new ArrayList<>(); /*   Membuat list untuk menampung transaksi   */
        String query = """
                       SELECT t.user_id, t.kode_pesawat, t.kode_boarding, t.status, tk.price 
                       FROM transaksi t
                       JOIN tiket tk ON t.kode_pesawat = tk.kode_pesawat
                       WHERE t.user_id = ?
                       """; /*   Query untuk mendapatkan transaksi pengguna   */

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setLong(1, userId); /*   Mengisi parameter userId   */
            ResultSet rs = ps.executeQuery(); /*   Menjalankan query   */

            /*   Memproses hasil query dan menambahkan objek Transaction ke dalam list   */
            while (rs.next()) {
                Transaction transaction = new Transaction(
                    userId,
                    rs.getString("kode_pesawat"),
                    rs.getString("kode_boarding"),
                    rs.getString("status"),
                    rs.getDouble("price"), /*   Mengambil harga dari tabel tiket   */
                    null /*   Role tidak diperlukan   */
                );
                transactions.add(transaction); /*   Menambahkan transaksi ke dalam list   */
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactions; /*   Mengembalikan daftar transaksi pengguna   */
    }

    /*   Method untuk mendapatkan semua transaksi (digunakan oleh Admin)   */

    /**
     *
     * @return
     */

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>(); /*   Membuat list untuk menampung semua transaksi   */
        String query = """
                       SELECT t.user_id, t.kode_pesawat, t.kode_boarding, t.status, tk.price
                       FROM transaksi t
                       JOIN tiket tk ON t.kode_pesawat = tk.kode_pesawat
                       """; /*   Query untuk mendapatkan semua transaksi   */

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            /*   Memproses hasil query dan menambahkan objek Transaction ke dalam list   */
            while (rs.next()) {
                Transaction transaction = new Transaction(
                    rs.getLong("user_id"),
                    rs.getString("kode_pesawat"),
                    rs.getString("kode_boarding"),
                    rs.getString("status"),
                    rs.getDouble("price"), /*   Mengambil harga dari tabel tiket   */
                    null /*   Role tidak diperlukan   */
                );
                transactions.add(transaction); /*   Menambahkan transaksi ke dalam list   */
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactions; /*   Mengembalikan daftar semua transaksi   */
    }
}
