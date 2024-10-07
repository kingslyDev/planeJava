package model;

public class BoardingPass {
    private String passengerName;
    private String fromCity;
    private String toCity;
    private String flightCode;
    private int seatNumber;
    private String date;
    private String time;

    public BoardingPass(String passengerName, String fromCity, String toCity, String flightCode, int seatNumber, String date, String time) {
        this.passengerName = passengerName;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.flightCode = flightCode;
        this.seatNumber = seatNumber;
        this.date = date;
        this.time = time;
    }

    // Getters dan Setters
    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

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
