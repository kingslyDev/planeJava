package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    
    /* URL untuk koneksi ke database MySQL */
    private static final String URL = "jdbc:mysql://localhost:3306/tiketoop"; 
    
    /* Username untuk MySQL */
    private static final String USER = "root"; 
    
    /* Password untuk MySQL (kosong jika tidak ada) */
    private static final String PASSWORD = ""; 

    /* Mendapatkan koneksi ke database */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            /* Membuat koneksi ke database */
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");
        } catch (SQLException e) {
            /* Jika koneksi gagal, tampilkan pesan error */
            System.err.println("Connection failed: " + e.getMessage());
        }
        return connection;
    }

    /* Metode utama untuk menguji koneksi */
    public static void main(String[] args) {
        Connection conn = Database.getConnection();
        
        if (conn != null) {
            try {
                /* Tempat untuk menjalankan operasi database */

            } finally {
                /* Tutup koneksi setelah selesai */
                try {
                    conn.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    /* Jika gagal menutup koneksi */
                    System.err.println("Failed to close connection: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Connection was not established, skipping operations.");
        }
    }
}
