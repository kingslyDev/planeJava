package controller;

import database.Database;
import model.Ticket;  // Import the Ticket model
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class FlightController {

    // Method to populate comboBox for cities (departure/arrival)
    public void populateCityComboBox(JComboBox<String> comboBox, String columnName) {
        comboBox.removeAllItems();  // Clear existing items
        try (Connection conn = Database.getConnection()) {
            String query = "SELECT DISTINCT " + columnName + " FROM tiket";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                comboBox.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch all tickets and return a List of Ticket objects
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        try (Connection conn = Database.getConnection()) {
            String query = "SELECT * FROM tiket";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ticket ticket = new Ticket(
                    rs.getString("kode_pesawat"),
                    rs.getString("kota_keberangkatan"),
                    rs.getString("kota_kedatangan"),
                    rs.getDate("jadwal_keberangkatan"),
                    rs.getString("jam_keberangkatan"),
                    rs.getInt("kursi_tersedia"),
                    rs.getString("status"),
                    rs.getDouble("price")
                );
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    // Populate the JTable with all tickets
    public void loadAllTicketData(DefaultTableModel model) {
        model.setRowCount(0);  // Clear the table
        List<Ticket> tickets = getAllTickets();  // Fetch all ticket data
        for (Ticket ticket : tickets) {
            model.addRow(new Object[]{
                ticket.getFlightCode(),
                ticket.getDepartureCity(),
                ticket.getArrivalCity(),
                ticket.getDepartureDate(),
                ticket.getDepartureTime(), // Tambahkan jam keberangkatan
                ticket.getAvailableSeats(),
                ticket.getStatus(),
                ticket.getPrice()
            });
        }
    }

    // Search tickets based on selected filters
    public List<Ticket> searchTickets(String departureCity, String arrivalCity, Date selectedDate) {
        List<Ticket> filteredTickets = new ArrayList<>();
        try (Connection conn = Database.getConnection()) {
            String query = "SELECT * FROM tiket WHERE kota_keberangkatan = ? AND kota_kedatangan = ? AND jadwal_keberangkatan = ? AND kursi_tersedia > 0";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, departureCity);
            ps.setString(2, arrivalCity);
            ps.setDate(3, new java.sql.Date(selectedDate.getTime()));  // Convert Date to SQL date
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ticket ticket = new Ticket(
                    rs.getString("kode_pesawat"),
                    rs.getString("kota_keberangkatan"),
                    rs.getString("kota_kedatangan"),
                    rs.getDate("jadwal_keberangkatan"),
                    rs.getString("jam_keberangkatan"), // Tambahkan jam keberangkatan
                    rs.getInt("kursi_tersedia"),
                    rs.getString("status"),
                    rs.getDouble("price")
                );
                filteredTickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filteredTickets;
    }

    // Populate JTable with search results
    public void populateSearchResults(DefaultTableModel model, String departureCity, String arrivalCity, Date selectedDate) {
        model.setRowCount(0);  // Clear table before loading search results
        List<Ticket> tickets = searchTickets(departureCity, arrivalCity, selectedDate);
        for (Ticket ticket : tickets) {
            model.addRow(new Object[]{
                ticket.getFlightCode(),
                ticket.getDepartureCity(),
                ticket.getArrivalCity(),
                ticket.getDepartureDate(),
                ticket.getDepartureTime(), // Tambahkan jam keberangkatan
                ticket.getAvailableSeats(),
                ticket.getStatus(),
                ticket.getPrice()
            });
        }
    }
}
