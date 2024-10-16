package model; /* Mendefinisikan paket model */

/**
 *
 * @author ariyo vonda
 */


public class User { /* Kelas User yang merepresentasikan pengguna sistem */
    private long id;              /* ID pengguna (biasanya sebagai primary key) */
    private String username;      /* Nama pengguna untuk login */
    private String password;      /* Kata sandi pengguna */
    private Role role;           /* Menggunakan Enum untuk peran pengguna */

    /* Enum untuk mendefinisikan peran pengguna */

    /**
     *
     */

    public enum Role {

        /**
         *
         */
        ADMIN,

        /**
         *
         */
        CUSTOMER /* Peran yang mungkin dimiliki pengguna */
    }

    /* Constructor untuk menginisialisasi objek User dengan parameter yang diberikan */

    /**
     *
     * @param id
     * @param username
     * @param password
     * @param role
     */

    public User(long id, String username, String password, Role role) {
        this.id = id;               /* Mengatur ID pengguna */
        this.username = username;   /* Mengatur nama pengguna */
        this.password = password;   /* Mengatur kata sandi */
        this.role = role;           /* Mengatur peran pengguna */
    }

    /* Getter dan Setter untuk masing-masing atribut */

    /**
     *
     * @return
     */


    public long getId() {
        return id; /* Mengembalikan ID pengguna */
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id; /* Mengupdate ID pengguna */
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username; /* Mengembalikan nama pengguna */
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username; /* Mengupdate nama pengguna */
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password; /* Mengembalikan kata sandi pengguna */
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password; /* Mengupdate kata sandi pengguna */
    }

    /**
     *
     * @return
     */
    public Role getRole() {
        return role; /* Mengembalikan peran pengguna */
    }

    /**
     *
     * @param role
     */
    public void setRole(Role role) {
        this.role = role; /* Mengupdate peran pengguna */
    }

    /* Method untuk menampilkan informasi pengguna */

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return "User{" +
                "id=" + id + /* Menampilkan ID pengguna */
                ", username='" + username + '\'' + /* Menampilkan nama pengguna */
                ", role=" + role + /* Menampilkan peran pengguna */
                '}'; /* Mengakhiri string */
    }
}
