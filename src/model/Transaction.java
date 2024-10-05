package model;

import java.util.Date;

public class Transaction {
    private long userId;          // Assuming this is a long
    private String flightCode;     // Flight code (e.g., QZ-850)
    private String boardingCode;   // Unique boarding code
    private String status;         // Transaction status
    private double price;          // Ticket price
    private String role;           // User role (e.g., ADMIN or CUSTOMER)
    private String notes;          // Additional notes (optional)
    
    // Constructor
    public Transaction(long userId, String flightCode, String boardingCode, String status, double price, String role, String notes) {
        this.userId = userId;
        this.flightCode = flightCode;
        this.boardingCode = boardingCode;
        this.status = status;
        this.price = price;
        this.role = role;
        this.notes = notes;
    }

    // Getters
    public long getUserId() {
        return userId;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public String getBoardingCode() {
        return boardingCode;
    }

    public String getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }

    public String getRole() {
        return role;
    }

    public String getNotes() {
        return notes;
    }
}
