/*
 * Klik nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt untuk mengubah lisensi ini
 * Klik nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java untuk mengedit template ini
 */
package pesawatjava; /* Mendefinisikan paket pesawatjava */

import view.Shared.LoginForm; /* Mengimpor kelas LoginForm dari paket view.Shared */

/**
 *
 * @author ariyo vonda
 */
public class PesawatJava { /* Kelas utama untuk aplikasi PesawatJava */

    /**
     *
     * @param args
     */

    public static void main(String[] args) { /* Method utama sebagai titik masuk aplikasi */
        /* Menjalankan antarmuka pengguna dalam thread terpisah */
        javax.swing.SwingUtilities.invokeLater(() -> {
            new LoginForm().setVisible(true); /* Membuat objek LoginForm dan menampilkannya */
        });
    }
}
