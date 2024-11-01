package model; /* Sesuaikan dengan paket yang kamu gunakan */

import model.User; /* Mengimpor kelas User dari paket model */

/**
 *
 * @author ariyo vonda
 */
public class UserSession { /* Kelas UserSession untuk mengelola sesi pengguna */
    private static User currentUser; /* Menyimpan pengguna saat ini dalam sesi */

    /* Method untuk mengatur pengguna saat ini */

    /**
     *
     * @param user
     */

    public static void setCurrentUser(User user) {
        currentUser = user; /* Mengupdate pengguna saat ini dengan objek User yang diberikan */
    }

    /* Method untuk mendapatkan pengguna saat ini */

    /**
     *
     * @return
     */

    public static User getCurrentUser() {
        return currentUser; /* Mengembalikan objek User yang merupakan pengguna saat ini */
    }
}
