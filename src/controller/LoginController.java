package controller;

import model.User; /*   Mengimpor kelas User, digunakan untuk membuat objek User setelah berhasil login   */
import model.UserSession; /*   Mengimpor kelas UserSession, digunakan untuk menyimpan data pengguna yang sedang login ke dalam sesi   */
import database.Database; /*   Mengimpor kelas Database, digunakan untuk mendapatkan koneksi ke database   */

import java.sql.Connection; /*   Mengimpor kelas Connection, digunakan untuk membuat koneksi ke database   */
import java.sql.PreparedStatement; /*   Mengimpor kelas PreparedStatement, digunakan untuk menjalankan query SQL dengan parameter dinamis   */
import java.sql.ResultSet; /*   Mengimpor kelas ResultSet, digunakan untuk menyimpan hasil query SQL   */
import java.sql.SQLException; /*   Mengimpor kelas SQLException, digunakan untuk menangani kesalahan yang terjadi selama operasi database   */
import view.Admin.ViewTransaksiAdmin; /*   Mengimpor tampilan ViewTransaksiAdmin, digunakan untuk menampilkan halaman khusus admin setelah login   */
import view.User.ViewTransaksi; /*   Mengimpor tampilan ViewTransaksi, digunakan untuk menampilkan halaman transaksi untuk customer setelah login   */

public class LoginController {
    /*   Method untuk melakukan login berdasarkan username dan password   */
    public void login(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?"; /*   Query SQL untuk mengambil data pengguna yang cocok dengan username dan password   */

        try (Connection conn = Database.getConnection(); /*   Mendapatkan koneksi ke database   */
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username); /*   Mengisi parameter username dalam query   */
            stmt.setString(2, password); /*   Mengisi parameter password dalam query   */

            try (ResultSet rs = stmt.executeQuery()) { /*   Menjalankan query dan mendapatkan hasilnya   */
                if (rs.next()) {
                    /*   Jika ditemukan pengguna yang cocok, buat objek User   */
                    User user = new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        User.Role.valueOf(rs.getString("role").toUpperCase()) /*   Mengonversi string role dari database ke enum Role   */
                    );

                    /*   Menyimpan informasi pengguna ke dalam sesi menggunakan UserSession   */
                    UserSession.setCurrentUser(user); /*   Menyimpan pengguna ke sesi   */

                    /*   Menentukan tampilan yang akan dibuka berdasarkan peran pengguna (ADMIN atau CUSTOMER)   */
                    if (user.getRole() == User.Role.ADMIN) {
                        new ViewTransaksiAdmin().show(); /*   Menampilkan tampilan transaksi untuk admin   */
                    } else if (user.getRole() == User.Role.CUSTOMER) {
                        new ViewTransaksi(user.getId()).show(); /*   Menampilkan tampilan transaksi untuk customer, dengan userId sebagai argumen   */
                    }
                } else {
                    System.out.println("Username atau password salah."); /*   Menampilkan pesan jika username atau password tidak cocok   */
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during login: " + e.getMessage()); /*   Menangani kesalahan SQL yang mungkin terjadi selama proses login   */
        }
    }
}
