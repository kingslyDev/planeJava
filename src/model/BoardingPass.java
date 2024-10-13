package model;

public class BoardingPass {
    /*   Variabel untuk menyimpan informasi boarding pass   */
    private String passengerName; /*   Nama penumpang   */
    private String fromCity; /*   Kota keberangkatan   */
    private String toCity; /*   Kota tujuan   */
    private String flightCode; /*   Kode penerbangan   */
    private int seatNumber; /*   Nomor kursi   */
    private String date; /*   Tanggal penerbangan   */
    private String time; /*   Waktu penerbangan   */

    /*   Konstruktor untuk menginisialisasi objek BoardingPass dengan data yang diberikan   */
    public BoardingPass(String passengerName, String fromCity, String toCity, String flightCode, int seatNumber, String date, String time) {
        this.passengerName = passengerName;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.flightCode = flightCode;
        this.seatNumber = seatNumber;
        this.date = date;
        this.time = time;
    }

    /*   Getters dan Setters untuk mengakses dan memodifikasi data boarding pass   */
    public String getPassengerName() {
        return passengerName; /*   Mendapatkan nama penumpang   */
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName; /*   Mengatur nama penumpang   */
    }

    public String getFromCity() {
        return fromCity; /*   Mendapatkan kota keberangkatan   */
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity; /*   Mengatur kota keberangkatan   */
    }

    public String getToCity() {
        return toCity; /*   Mendapatkan kota tujuan   */
    }

    public void setToCity(String toCity) {
        this.toCity = toCity; /*   Mengatur kota tujuan   */
    }

    public String getFlightCode() {
        return flightCode; /*   Mendapatkan kode penerbangan   */
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode; /*   Mengatur kode penerbangan   */
    }

    public int getSeatNumber() {
        return seatNumber; /*   Mendapatkan nomor kursi   */
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber; /*   Mengatur nomor kursi   */
    }

    public String getDate() {
        return date; /*   Mendapatkan tanggal penerbangan   */
    }

    public void setDate(String date) {
        this.date = date; /*   Mengatur tanggal penerbangan   */
    }

    public String getTime() {
        return time; /*   Mendapatkan waktu penerbangan   */
    }

    public void setTime(String time) {
        this.time = time; /*   Mengatur waktu penerbangan   */
    }

    /*   Method untuk mengubah objek BoardingPass menjadi string yang mudah dibaca   */
    @Override
    public String toString() {
        return "BoardingPass{" +
                "passengerName='" + passengerName + '\'' +
                ", fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", flightCode='" + flightCode + '\'' +
                ", seatNumber=" + seatNumber +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
