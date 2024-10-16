package model;

/**
 *
 * @author ariyo vonda
 */
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

    /**
     *
     * @param passengerName
     * @param fromCity
     * @param toCity
     * @param flightCode
     * @param seatNumber
     * @param date
     * @param time
     */

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

    /**
     *
     * @return
     */

    public String getPassengerName() {
        return passengerName; /*   Mendapatkan nama penumpang   */
    }

    /**
     *
     * @param passengerName
     */
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName; /*   Mengatur nama penumpang   */
    }

    /**
     *
     * @return
     */
    public String getFromCity() {
        return fromCity; /*   Mendapatkan kota keberangkatan   */
    }

    /**
     *
     * @param fromCity
     */
    public void setFromCity(String fromCity) {
        this.fromCity = fromCity; /*   Mengatur kota keberangkatan   */
    }

    /**
     *
     * @return
     */
    public String getToCity() {
        return toCity; /*   Mendapatkan kota tujuan   */
    }

    /**
     *
     * @param toCity
     */
    public void setToCity(String toCity) {
        this.toCity = toCity; /*   Mengatur kota tujuan   */
    }

    /**
     *
     * @return
     */
    public String getFlightCode() {
        return flightCode; /*   Mendapatkan kode penerbangan   */
    }

    /**
     *
     * @param flightCode
     */
    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode; /*   Mengatur kode penerbangan   */
    }

    /**
     *
     * @return
     */
    public int getSeatNumber() {
        return seatNumber; /*   Mendapatkan nomor kursi   */
    }

    /**
     *
     * @param seatNumber
     */
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber; /*   Mengatur nomor kursi   */
    }

    /**
     *
     * @return
     */
    public String getDate() {
        return date; /*   Mendapatkan tanggal penerbangan   */
    }

    /**
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date; /*   Mengatur tanggal penerbangan   */
    }

    /**
     *
     * @return
     */
    public String getTime() {
        return time; /*   Mendapatkan waktu penerbangan   */
    }

    /**
     *
     * @param time
     */
    public void setTime(String time) {
        this.time = time; /*   Mengatur waktu penerbangan   */
    }

    /*   Method untuk mengubah objek BoardingPass menjadi string yang mudah dibaca   */

    /**
     *
     * @return
     */

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
