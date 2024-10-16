package controller;

import database.Database;
import model.Ticket;  /*   Mengimpor model Ticket   */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ariyo vonda
 */
public class FlightController {

    /*   Method untuk mengisi comboBox dengan data kota (kota keberangkatan/kedatangan)   */

    /**
     *
     * @param comboBox
     * @param columnName
     */

    public void populateCityComboBox(JComboBox<String> comboBox, String columnName) {
        comboBox.removeAllItems();  /*   Menghapus item yang ada di comboBox   */
        try (Connection conn = Database.getConnection()) {
            String query = "SELECT DISTINCT " + columnName + " FROM tiket";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                comboBox.addItem(rs.getString(1));  /*   Menambahkan kota ke comboBox   */
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*   Method untuk mengambil semua tiket dan mengembalikan List objek Ticket   */

    /**
     *
     * @return
     */

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
                tickets.add(ticket);  /*   Menambahkan objek Ticket ke dalam List   */
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;  /*   Mengembalikan daftar tiket   */
    }

    /*   Method untuk mengisi JTable dengan data semua tiket   */

    /**
     *
     * @param model
     */

    public void loadAllTicketData(DefaultTableModel model) {
        model.setRowCount(0);  /*   Mengosongkan isi tabel   */
        List<Ticket> tickets = getAllTickets();  /*   Mengambil semua data tiket   */
        for (Ticket ticket : tickets) {
            model.addRow(new Object[]{
                ticket.getFlightCode(),
                ticket.getDepartureCity(),
                ticket.getArrivalCity(),
                ticket.getDepartureDate(),
                ticket.getDepartureTime(),  /*   Menambahkan jam keberangkatan ke tabel   */
                ticket.getAvailableSeats(),
                ticket.getStatus(),
                ticket.getPrice()
            });
        }
    }

    /*   Method untuk mencari tiket berdasarkan filter yang dipilih (kota keberangkatan, kota kedatangan, dan tanggal)   */

    /**
     *
     * @param departureCity
     * @param arrivalCity
     * @param selectedDate
     * @return
     */

    public List<Ticket> searchTickets(String departureCity, String arrivalCity, Date selectedDate) {
        List<Ticket> filteredTickets = new ArrayList<>();
        try (Connection conn = Database.getConnection()) {
            String query = "SELECT * FROM tiket WHERE kota_keberangkatan = ? AND kota_kedatangan = ? AND jadwal_keberangkatan = ? AND kursi_tersedia > 0";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, departureCity);
            ps.setString(2, arrivalCity);
            ps.setDate(3, new java.sql.Date(selectedDate.getTime()));  /*   Mengonversi Date ke SQL date   */
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ticket ticket = new Ticket(
                    rs.getString("kode_pesawat"),
                    rs.getString("kota_keberangkatan"),
                    rs.getString("kota_kedatangan"),
                    rs.getDate("jadwal_keberangkatan"),
                    rs.getString("jam_keberangkatan"),  /*   Menambahkan jam keberangkatan   */
                    rs.getInt("kursi_tersedia"),
                    rs.getString("status"),
                    rs.getDouble("price")
                );
                filteredTickets.add(ticket);  /*   Menambahkan tiket yang sesuai filter ke dalam List   */
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filteredTickets;  /*   Mengembalikan daftar tiket yang sesuai filter   */
    }

    /*   Method untuk mengisi JTable dengan hasil pencarian tiket   */

    /**
     *
     * @param model
     * @param departureCity
     * @param arrivalCity
     * @param selectedDate
     */

    public void populateSearchResults(DefaultTableModel model, String departureCity, String arrivalCity, Date selectedDate) {
        model.setRowCount(0);  /*   Mengosongkan tabel sebelum menampilkan hasil pencarian   */
        List<Ticket> tickets = searchTickets(departureCity, arrivalCity, selectedDate);  /*   Mencari tiket sesuai filter   */
        for (Ticket ticket : tickets) {
            model.addRow(new Object[]{
                ticket.getFlightCode(),
                ticket.getDepartureCity(),
                ticket.getArrivalCity(),
                ticket.getDepartureDate(),
                ticket.getDepartureTime(),  /*   Menambahkan jam keberangkatan ke tabel hasil pencarian   */
                ticket.getAvailableSeats(),
                ticket.getStatus(),
                ticket.getPrice()
            });
        }
    }
}
