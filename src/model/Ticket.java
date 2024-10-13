package model; /* Mendefinisikan paket model */

public class Ticket { /* Kelas Ticket yang merepresentasikan tiket penerbangan */
    private String flightCode;        /* Kode penerbangan, seperti "GA123" */
    private String departureCity;     /* Kota keberangkatan */
    private String arrivalCity;       /* Kota tujuan */
    private java.util.Date departureDate; /* Tanggal keberangkatan */
    private String departureTime;      /* Jam keberangkatan sebagai String */
    private int availableSeats;        /* Jumlah kursi yang tersedia */
    private String status;             /* Status tiket, bisa berupa "available", "booked", dll. */
    private double price;              /* Harga tiket */

    /* Constructor untuk menginisialisasi objek Ticket dengan parameter yang diberikan */
    public Ticket(String flightCode, String departureCity, String arrivalCity, 
                  java.util.Date departureDate, String departureTime, 
                  int availableSeats, String status, double price) {
        this.flightCode = flightCode;          /* Mengatur kode penerbangan */
        this.departureCity = departureCity;    /* Mengatur kota keberangkatan */
        this.arrivalCity = arrivalCity;        /* Mengatur kota tujuan */
        this.departureDate = departureDate;    /* Mengatur tanggal keberangkatan */
        this.departureTime = departureTime;    /* Mengatur jam keberangkatan */
        this.availableSeats = availableSeats;  /* Mengatur jumlah kursi yang tersedia */
        this.status = status;                   /* Mengatur status tiket */
        this.price = price;                     /* Mengatur harga tiket */
    }

    /* Getter dan Setter untuk masing-masing atribut */

    public String getFlightCode() {
        return flightCode; /* Mengembalikan kode penerbangan */
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode; /* Mengupdate kode penerbangan */
    }

    public String getDepartureCity() {
        return departureCity; /* Mengembalikan kota keberangkatan */
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity; /* Mengupdate kota keberangkatan */
    }

    public String getArrivalCity() {
        return arrivalCity; /* Mengembalikan kota tujuan */
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity; /* Mengupdate kota tujuan */
    }

    public java.util.Date getDepartureDate() {
        return departureDate; /* Mengembalikan tanggal keberangkatan */
    }

    public void setDepartureDate(java.util.Date departureDate) {
        this.departureDate = departureDate; /* Mengupdate tanggal keberangkatan */
    }

    public String getDepartureTime() {
        return departureTime; /* Mengembalikan jam keberangkatan */
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime; /* Mengupdate jam keberangkatan */
    }

    public int getAvailableSeats() {
        return availableSeats; /* Mengembalikan jumlah kursi yang tersedia */
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats; /* Mengupdate jumlah kursi yang tersedia */
    }

    public String getStatus() {
        return status; /* Mengembalikan status tiket */
    }

    public void setStatus(String status) {
        this.status = status; /* Mengupdate status tiket */
    }

    public double getPrice() {
        return price; /* Mengembalikan harga tiket */
    }

    public void setPrice(double price) {
        this.price = price; /* Mengupdate harga tiket */
    }
}
