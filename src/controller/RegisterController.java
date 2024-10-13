package controller;

import model.User; /*   Mengimpor kelas User untuk membuat objek User baru saat pendaftaran   */
import database.Database; /*   Mengimpor kelas Database untuk mendapatkan koneksi ke database   */

import java.sql.Connection; /*   Mengimpor kelas Connection untuk mengelola koneksi ke database   */
import java.sql.PreparedStatement; /*   Mengimpor kelas PreparedStatement untuk menjalankan query SQL dengan parameter   */
import java.sql.SQLException; /*   Mengimpor kelas SQLException untuk menangani kesalahan SQL   */

public class RegisterController {

    /*   Method untuk mendaftarkan pengguna baru berdasarkan username, password, dan peran (role)   */
    public boolean register(String username, String password, String roleString) {
        User.Role role;

        /*   Validasi peran yang dimasukkan. Memeriksa apakah role yang diberikan valid (ADMIN/CUSTOMER)   */
        try {
            role = User.Role.valueOf(roleString.toUpperCase()); /*   Mengonversi string role menjadi enum Role (ADMIN/CUSTOMER)   */
        } catch (IllegalArgumentException e) {
            /*   Jika peran tidak valid, tampilkan pesan kesalahan dan kembalikan false   */
            System.out.println("Peran tidak valid. Silakan pilih 'ADMIN' atau 'CUSTOMER'.");
            return false; /*   Return false jika peran tidak valid   */
        }

        String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)"; /*   Query SQL untuk menyimpan pengguna baru ke database   */

        /*   Membuka koneksi ke database dan menjalankan query untuk menyimpan pengguna baru   */
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            /*   Hashing password sebelum menyimpan ke database (gunakan metode hashing yang sesuai)   */
            String hashedPassword = hashPassword(password); 
            
            /*   Membuat objek User baru tanpa menetapkan ID, karena ID diatur oleh auto-increment di database   */
            User newUser = new User(0, username, hashedPassword, role); /*   ID diisi 0 karena auto-increment   */

            /*   Mengisi parameter query dengan nilai yang sesuai dari objek User   */
            stmt.setString(1, newUser.getUsername()); /*   Mengisi username   */
            stmt.setString(2, newUser.getPassword()); /*   Mengisi password yang sudah di-hash   */
            stmt.setString(3, newUser.getRole().toString()); /*   Mengisi peran (role) pengguna   */

            /*   Menjalankan query dan mengecek berapa baris yang terpengaruh   */
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                /*   Jika ada baris yang terpengaruh (pengguna berhasil disimpan), tampilkan pesan sukses   */
                System.out.println("Pengguna berhasil terdaftar! Selamat datang, " + username + ".");
                return true; /*   Mengembalikan true jika pendaftaran berhasil   */
            } else {
                /*   Jika tidak ada baris yang terpengaruh, tampilkan pesan kegagalan   */
                System.out.println("Pendaftaran gagal, silakan coba lagi.");
                return false; /*   Mengembalikan false jika pendaftaran gagal   */
            }
        } catch (SQLException e) {
            /*   Menangani kesalahan SQL selama proses pendaftaran   */
            System.err.println("Error during registration: " + e.getMessage());
            return false; /*   Mengembalikan false jika terjadi kesalahan   */
        }
    }

    /*   Method untuk melakukan hashing pada password (implementasikan logika hashing yang aman di sini)   */
    private String hashPassword(String password) {
        /*   Ganti dengan implementasi hashing yang sesuai, misalnya menggunakan bcrypt atau SHA-256   */
        return password; /*   Sementara ini, password tidak di-hash, ganti ini dengan logika hashing yang benar   */
    }
}
