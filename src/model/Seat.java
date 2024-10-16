package model; // Mendefinisikan paket model

/**
 *
 * @author ariyo vonda
 */

public class Seat { // Kelas Seat yang merepresentasikan kursi penerbangan
    private int seatNumber;        /* Nomor kursi penumpang */
    private String flightCode;     /* Kode penerbangan, seperti "GA123" */
    private String passengerName;  /* Nama penumpang yang memesan kursi */
    private long transactionId;    /* ID unik untuk transaksi pemesanan */

    /* Constructor untuk inisialisasi objek Seat dengan parameter yang diberikan */

    /**
     *
     * @param seatNumber
     * @param flightCode
     * @param passengerName
     * @param transactionId
     */

    public Seat(int seatNumber, String flightCode, String passengerName, long transactionId) {
        this.seatNumber = seatNumber; // Mengatur nomor kursi
        this.flightCode = flightCode; // Mengatur kode penerbangan
        this.passengerName = passengerName; // Mengatur nama penumpang
        this.transactionId = transactionId; // Mengatur ID transaksi
    }

    /* Mengambil nomor kursi */

    /**
     *
     * @return
     */

    public int getSeatNumber() {
        return seatNumber; // Mengembalikan nomor kursi
    }

    /* Mengatur nomor kursi */

    /**
     *
     * @param seatNumber
     */

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber; // Mengupdate nomor kursi
    }

    /* Mengambil kode penerbangan */

    /**
     *
     * @return
     */

    public String getFlightCode() {
        return flightCode; // Mengembalikan kode penerbangan
    }

    /* Mengatur kode penerbangan */

    /**
     *
     * @param flightCode
     */

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode; // Mengupdate kode penerbangan
    }

    /* Mengambil nama penumpang */

    /**
     *
     * @return
     */

    public String getPassengerName() {
        return passengerName; // Mengembalikan nama penumpang
    }

    /* Mengatur nama penumpang */

    /**
     *
     * @param passengerName
     */

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName; // Mengupdate nama penumpang
    }

    /* Mengambil ID transaksi */

    /**
     *
     * @return
     */

    public long getTransactionId() {
        return transactionId; // Mengembalikan ID transaksi
    }

    /* Mengatur ID transaksi */

    /**
     *
     * @param transactionId
     */

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId; // Mengupdate ID transaksi
    }

    /* Method untuk menampilkan informasi lengkap tentang kursi */

    /**
     *
     * @return
     */

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
