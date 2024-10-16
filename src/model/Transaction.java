package model; /* Mendefinisikan paket model */

/**
 *
 * @author ariyo vonda
 */


public class Transaction { /* Kelas Transaction yang merepresentasikan transaksi tiket penerbangan */
    private long userId;          /* User ID (primary key di tabel users) */
    private long transactionId;   /* Transaction ID (primary key di tabel transactions) */
    private String flightCode;    /* Kode penerbangan (contoh: QZ-850) */
    private String boardingCode;  /* Kode boarding unik untuk penumpang */
    private String status;        /* Status transaksi (contoh: BELUM, BERANGKAT) */
    private double price;         /* Harga tiket */
    private String role;          /* Peran pengguna (contoh: ADMIN atau CUSTOMER) */

    /* Constructor dengan transaction ID untuk mengambil transaksi yang ada */

    /**
     *
     * @param transactionId
     * @param userId
     * @param flightCode
     * @param boardingCode
     * @param status
     * @param price
     * @param role
     */

    public Transaction(long transactionId, long userId, String flightCode, String boardingCode, String status, double price, String role) {
        this.transactionId = transactionId; /* Mengatur ID transaksi */
        this.userId = userId;               /* Mengatur User ID */
        this.flightCode = flightCode;       /* Mengatur kode penerbangan */
        this.boardingCode = boardingCode;   /* Mengatur kode boarding */
        this.status = status;               /* Mengatur status transaksi */
        this.price = price;                 /* Mengatur harga tiket */
        this.role = role;                   /* Mengatur peran pengguna */
    }

    /* Constructor tanpa transaction ID untuk membuat transaksi baru */

    /**
     *
     * @param userId
     * @param flightCode
     * @param boardingCode
     * @param status
     * @param price
     * @param role
     */

    public Transaction(long userId, String flightCode, String boardingCode, String status, double price, String role) {
        this.userId = userId;               /* Mengatur User ID */
        this.flightCode = flightCode;       /* Mengatur kode penerbangan */
        this.boardingCode = boardingCode;   /* Mengatur kode boarding */
        this.status = status;               /* Mengatur status transaksi */
        this.price = price;                 /* Mengatur harga tiket */
        this.role = role;                   /* Mengatur peran pengguna */
    }

    /* Getters untuk mengakses atribut kelas */

    /**
     *
     * @return
     */

    public long getTransactionId() {
        return transactionId; /* Mengembalikan ID transaksi */
    }

    /**
     *
     * @return
     */
    public long getUserId() {
        return userId; /* Mengembalikan User ID */
    }

    /**
     *
     * @return
     */
    public String getFlightCode() {
        return flightCode; /* Mengembalikan kode penerbangan */
    }

    /**
     *
     * @return
     */
    public String getBoardingCode() {
        return boardingCode; /* Mengembalikan kode boarding */
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status; /* Mengembalikan status transaksi */
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price; /* Mengembalikan harga tiket */
    }

    /**
     *
     * @return
     */
    public String getRole() {
        return role; /* Mengembalikan peran pengguna */
    }
}
