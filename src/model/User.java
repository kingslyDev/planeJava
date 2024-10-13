package model; /* Mendefinisikan paket model */

public class User { /* Kelas User yang merepresentasikan pengguna sistem */
    private long id;              /* ID pengguna (biasanya sebagai primary key) */
    private String username;      /* Nama pengguna untuk login */
    private String password;      /* Kata sandi pengguna */
    private Role role;           /* Menggunakan Enum untuk peran pengguna */

    /* Enum untuk mendefinisikan peran pengguna */
    public enum Role {
        ADMIN, CUSTOMER /* Peran yang mungkin dimiliki pengguna */
    }

    /* Constructor untuk menginisialisasi objek User dengan parameter yang diberikan */
    public User(long id, String username, String password, Role role) {
        this.id = id;               /* Mengatur ID pengguna */
        this.username = username;   /* Mengatur nama pengguna */
        this.password = password;   /* Mengatur kata sandi */
        this.role = role;           /* Mengatur peran pengguna */
    }

    /* Getter dan Setter untuk masing-masing atribut */

    public long getId() {
        return id; /* Mengembalikan ID pengguna */
    }

    public void setId(long id) {
        this.id = id; /* Mengupdate ID pengguna */
    }

    public String getUsername() {
        return username; /* Mengembalikan nama pengguna */
    }

    public void setUsername(String username) {
        this.username = username; /* Mengupdate nama pengguna */
    }

    public String getPassword() {
        return password; /* Mengembalikan kata sandi pengguna */
    }

    public void setPassword(String password) {
        this.password = password; /* Mengupdate kata sandi pengguna */
    }

    public Role getRole() {
        return role; /* Mengembalikan peran pengguna */
    }

    public void setRole(Role role) {
        this.role = role; /* Mengupdate peran pengguna */
    }

    /* Method untuk menampilkan informasi pengguna */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id + /* Menampilkan ID pengguna */
                ", username='" + username + '\'' + /* Menampilkan nama pengguna */
                ", role=" + role + /* Menampilkan peran pengguna */
                '}'; /* Mengakhiri string */
    }
}
