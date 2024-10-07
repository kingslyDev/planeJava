package model;

public class Transaction {
    private long userId;          // User ID (primary key in users table)
    private long transactionId;   // Transaction ID (primary key in transactions table)
    private String flightCode;    // Flight code (e.g., QZ-850)
    private String boardingCode;  // Unique boarding code
    private String status;        // Transaction status (e.g., BELUM, BERANGKAT)
    private double price;         // Ticket price
    private String role;          // User role (e.g., ADMIN or CUSTOMER)

    // Constructor with transaction ID (for retrieving existing transactions)
    public Transaction(long transactionId, long userId, String flightCode, String boardingCode, String status, double price, String role) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.flightCode = flightCode;
        this.boardingCode = boardingCode;
        this.status = status;
        this.price = price;
        this.role = role;
    }

    // Constructor without transaction ID (for creating new transactions)
    public Transaction(long userId, String flightCode, String boardingCode, String status, double price, String role) {
        this.userId = userId;
        this.flightCode = flightCode;
        this.boardingCode = boardingCode;
        this.status = status;
        this.price = price;
        this.role = role;
    }

    // Getters
    public long getTransactionId() {
        return transactionId;
    }

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
}
