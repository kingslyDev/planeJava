package model; // Mendefinisikan paket model

public class Seat { // Kelas Seat yang merepresentasikan kursi penerbangan
    private int seatNumber;        /* Nomor kursi penumpang */
    private String flightCode;     /* Kode penerbangan, seperti "GA123" */
    private String passengerName;  /* Nama penumpang yang memesan kursi */
    private long transactionId;    /* ID unik untuk transaksi pemesanan */

    /* Constructor untuk inisialisasi objek Seat dengan parameter yang diberikan */
    public Seat(int seatNumber, String flightCode, String passengerName, long transactionId) {
        this.seatNumber = seatNumber; // Mengatur nomor kursi
        this.flightCode = flightCode; // Mengatur kode penerbangan
        this.passengerName = passengerName; // Mengatur nama penumpang
        this.transactionId = transactionId; // Mengatur ID transaksi
    }

    /* Mengambil nomor kursi */
    public int getSeatNumber() {
        return seatNumber; // Mengembalikan nomor kursi
    }

    /* Mengatur nomor kursi */
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber; // Mengupdate nomor kursi
    }

    /* Mengambil kode penerbangan */
    public String getFlightCode() {
        return flightCode; // Mengembalikan kode penerbangan
    }

    /* Mengatur kode penerbangan */
    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode; // Mengupdate kode penerbangan
    }

    /* Mengambil nama penumpang */
    public String getPassengerName() {
        return passengerName; // Mengembalikan nama penumpang
    }

    /* Mengatur nama penumpang */
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName; // Mengupdate nama penumpang
    }

    /* Mengambil ID transaksi */
    public long getTransactionId() {
        return transactionId; // Mengembalikan ID transaksi
    }

    /* Mengatur ID transaksi */
    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId; // Mengupdate ID transaksi
    }

    /* Method untuk menampilkan informasi lengkap tentang kursi */
    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber=" + seatNumber + // Menampilkan nomor kursi
                ", flightCode='" + flightCode + '\'' + // Menampilkan kode penerbangan
                ", passengerName='" + passengerName + '\'' + // Menampilkan nama penumpang
                ", transactionId=" + transactionId + // Menampilkan ID transaksi
                '}'; // Mengakhiri string
    }
}
