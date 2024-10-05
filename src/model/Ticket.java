package model;

public class Ticket {
    private String flightCode;
    private String departureCity;
    private String arrivalCity;
    private java.util.Date departureDate;
    private String departureTime; // Jam keberangkatan sebagai String
    private int availableSeats;
    private String status;
    private double price;

    // Constructor
    public Ticket(String flightCode, String departureCity, String arrivalCity, java.util.Date departureDate, String departureTime, int availableSeats, String status, double price) {
        this.flightCode = flightCode;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureDate = departureDate;
        this.departureTime = departureTime; // Inisialisasi jam keberangkatan
        this.availableSeats = availableSeats;
        this.status = status;
        this.price = price;
    }

    // Getter dan Setter
    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public java.util.Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(java.util.Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime; // Getter untuk jam keberangkatan
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime; // Setter untuk jam keberangkatan
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
