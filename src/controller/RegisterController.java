package controller;

import model.User;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterController {

    public boolean register(String username, String password, String roleString) {
        User.Role role;

        // Validasi peran
        try {
            role = User.Role.valueOf(roleString.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Peran tidak valid. Silakan pilih 'ADMIN' atau 'CUSTOMER'.");
            return false; // Return false if role is invalid
        }

        String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Hashing password sebelum menyimpan (implementasikan hashing yang sesuai)
            String hashedPassword = hashPassword(password);
            // Buat objek User tanpa menetapkan ID
            User newUser = new User(0, username, hashedPassword, role); // ID diisi 0 karena auto-increment

            stmt.setString(1, newUser.getUsername());
            stmt.setString(2, newUser.getPassword());
            stmt.setString(3, newUser.getRole().toString());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pengguna berhasil terdaftar! Selamat datang, " + username + ".");
                return true; // Return true if registration is successful
            } else {
                System.out.println("Pendaftaran gagal, silakan coba lagi.");
                return false; // Return false if registration failed
            }
        } catch (SQLException e) {
            System.err.println("Error during registration: " + e.getMessage());
            return false; // Return false if an exception occurs
        }
    }

    private String hashPassword(String password) {
        // Implementasikan logika hashing yang aman di sini, misalnya menggunakan bcrypt
        return password; // Ganti dengan hashing yang sesuai
    }
}
