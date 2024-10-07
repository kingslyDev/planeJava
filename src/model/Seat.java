package model;

public class Seat {
    private int seatNumber;        // Nomor kursi
    private String flightCode;     // Kode penerbangan
    private String passengerName;  // Nama penumpang
    private long transactionId;    // ID Transaksi

    // Constructor untuk inisialisasi
    public Seat(int seatNumber, String flightCode, String passengerName, long transactionId) {
        this.seatNumber = seatNumber;
        this.flightCode = flightCode;
        this.passengerName = passengerName;
        this.transactionId = transactionId;
    }

    // Getters dan Setters
    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    // Method untuk menampilkan informasi kursi
    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber=" + seatNumber +
                ", flightCode='" + flightCode + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", transactionId=" + transactionId +
                '}';
    }
}
