package model; /* Mendefinisikan paket model */

public class Transaction { /* Kelas Transaction yang merepresentasikan transaksi tiket penerbangan */
    private long userId;          /* User ID (primary key di tabel users) */
    private long transactionId;   /* Transaction ID (primary key di tabel transactions) */
    private String flightCode;    /* Kode penerbangan (contoh: QZ-850) */
    private String boardingCode;  /* Kode boarding unik untuk penumpang */
    private String status;        /* Status transaksi (contoh: BELUM, BERANGKAT) */
    private double price;         /* Harga tiket */
    private String role;          /* Peran pengguna (contoh: ADMIN atau CUSTOMER) */

    /* Constructor dengan transaction ID untuk mengambil transaksi yang ada */
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
    public Transaction(long userId, String flightCode, String boardingCode, String status, double price, String role) {
        this.userId = userId;               /* Mengatur User ID */
        this.flightCode = flightCode;       /* Mengatur kode penerbangan */
        this.boardingCode = boardingCode;   /* Mengatur kode boarding */
        this.status = status;               /* Mengatur status transaksi */
        this.price = price;                 /* Mengatur harga tiket */
        this.role = role;                   /* Mengatur peran pengguna */
    }

    /* Getters untuk mengakses atribut kelas */
    public long getTransactionId() {
        return transactionId; /* Mengembalikan ID transaksi */
    }

    public long getUserId() {
        return userId; /* Mengembalikan User ID */
    }

    public String getFlightCode() {
        return flightCode; /* Mengembalikan kode penerbangan */
    }

    public String getBoardingCode() {
        return boardingCode; /* Mengembalikan kode boarding */
    }

    public String getStatus() {
        return status; /* Mengembalikan status transaksi */
    }

    public double getPrice() {
        return price; /* Mengembalikan harga tiket */
    }

    public String getRole() {
        return role; /* Mengembalikan peran pengguna */
    }
}
