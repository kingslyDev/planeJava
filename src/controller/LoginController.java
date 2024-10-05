package controller;

import model.User;
import model.UserSession; // Impor UserSession
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import view.Admin.AdminMain;
import view.User.UserMain;

public class LoginController {
    public void login(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password); // Pastikan untuk membandingkan hashed password

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Membuat objek User dari hasil query
                    User user = new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        User.Role.valueOf(rs.getString("role").toUpperCase()) // Menggunakan enum Role
                    );

                    // Menyimpan pengguna ke sesi
                    UserSession.setCurrentUser(user); // Tambahkan ini

                    // Menentukan tampilan berdasarkan role
                    if (user.getRole() == User.Role.ADMIN) {
                        new AdminMain().show();
                    } else if (user.getRole() == User.Role.CUSTOMER) {
                        new UserMain().show();
                    }
                } else {
                    System.out.println("Username atau password salah.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during login: " + e.getMessage());
        }
    }
}
