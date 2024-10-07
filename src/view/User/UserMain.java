package view.User;

import controller.FlightController;
import controller.TransactionController;
import model.Transaction;
import model.User; // Impor model User
import model.UserSession; // Impor UserSession
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class UserMain extends javax.swing.JFrame {

    private FlightController flightController;
    private TransactionController transactionController;
    private DefaultListModel<String> ticketListModel;

    public UserMain() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        flightController = new FlightController();
        transactionController = new TransactionController();
        ticketListModel = new DefaultListModel<>();
        listTiket.setModel(ticketListModel);
        populateCityComboBoxes();
        setupTableClickListener();
    }

    private void populateCityComboBoxes() {
        flightController.populateCityComboBox(cmbDeparture, "kota_keberangkatan");
        flightController.populateCityComboBox(cmbArrival, "kota_kedatangan");
    }

    private void setupTableClickListener() {
        DataTicket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                DataTicketMouseClicked(evt);
            }
        });
    }

    private void DataTicketMouseClicked(MouseEvent evt) {
        int selectedRow = DataTicket.getSelectedRow();
        if (selectedRow != -1) {
            String flightCode = (String) DataTicket.getValueAt(selectedRow, 0);
            String departureCity = (String) DataTicket.getValueAt(selectedRow, 1);
            String arrivalCity = (String) DataTicket.getValueAt(selectedRow, 2);
            String date = DataTicket.getValueAt(selectedRow, 3).toString();
            String time = (String) DataTicket.getValueAt(selectedRow, 4);
            String status = (String) DataTicket.getValueAt(selectedRow, 6);
            double price = (Double) DataTicket.getValueAt(selectedRow, 7);

            // Update the JList with selected ticket information
            ticketListModel.clear();
            ticketListModel.addElement("Flight Code: " + flightCode);
            ticketListModel.addElement("Departure: " + departureCity);
            ticketListModel.addElement("Arrival: " + arrivalCity);
            ticketListModel.addElement("Date: " + date);
            ticketListModel.addElement("Time: " + time);
            ticketListModel.addElement("Status: " + status);
            ticketListModel.addElement("Price: " + price);
        }
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        String departureCity = cmbDeparture.getSelectedItem().toString();
        String arrivalCity = cmbArrival.getSelectedItem().toString();
        Date selectedDate = dateDeparture.getDate();

        if (selectedDate != null) {
            DefaultTableModel model = (DefaultTableModel) DataTicket.getModel();
            flightController.populateSearchResults(model, departureCity, arrivalCity, selectedDate);
        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih tanggal keberangkatan.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void BtnBuyActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = DataTicket.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Silakan pilih tiket terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String flightCode = (String) DataTicket.getValueAt(selectedRow, 0);
        double price = (Double) DataTicket.getValueAt(selectedRow, 7);
        long userId = getCurrentUserId(); // Mendapatkan ID pengguna yang sedang login
        String boardingCode = "boardingCode"; // Generate atau ambil boarding code yang sesuai
        String status = "BELUM"; // Status awal

        int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin memesan tiket ini?\nHarga: " + price, "Konfirmasi Pemesanan", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            // Buat objek Transaction dengan argumen yang diperlukan
            Transaction transaction = new Transaction(userId, flightCode, boardingCode, status, price, "CUSTOMER");

            if (transactionController.saveTransaction(transaction)) {
                JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan transaksi.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private long getCurrentUserId() {
        User currentUser = UserSession.getCurrentUser(); // Mengambil pengguna yang sedang login
        return currentUser != null ? currentUser.getId() : -1; // Kembalikan ID atau -1 jika tidak ada pengguna
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        DataTicket = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        cmbDeparture = new javax.swing.JComboBox<>();
        cmbArrival = new javax.swing.JComboBox<>();
        dateDeparture = new com.toedter.calendar.JDateChooser();
        listTiket = new javax.swing.JList<>();
        BtnBuy = new javax.swing.JButton();
        JLabel BG = new javax.swing.JLabel();
        JLabel Header = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JLabel jLabel4 = new javax.swing.JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Header.setForeground(new java.awt.Color(255, 255, 255));
        Header.setText("TAMBAH TIKET");
        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, 35));
        
        DataTicket.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Flight Code", "Departure City", "Arrival City", "Date", "Time", "Ticket", "Status", "Price"
                }
        ));
        jScrollPane1.setViewportView(DataTicket);
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 960, 88));

        btnSearch.setText("Search");
        btnSearch.addActionListener(this::btnSearchActionPerformed);
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 100, 30));

        getContentPane().add(cmbDeparture, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 150, -1));
        getContentPane().add(cmbArrival, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 150, -1));
        getContentPane().add(dateDeparture, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 150, -1));
        
        jLabel2.setText("Departure");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 150, -1));

        jLabel3.setText("Arrival");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 150, -1));
        
        jLabel4.setText("Date");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 150, -1));
        
        listTiket.setModel(new DefaultListModel<>());
        getContentPane().add(new JScrollPane(listTiket), new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 250, 230));

        BtnBuy.setText("Buy");
        BtnBuy.addActionListener(this::BtnBuyActionPerformed);
        getContentPane().add(BtnBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 160, 100, 30));

         // Set background image for JLabel BG
        BG.setIcon(new ImageIcon(getClass().getResource("/assets/BG.jpg")));
        BG.setMaximumSize(new java.awt.Dimension(1000, 600));
        BG.setMinimumSize(new java.awt.Dimension(1000, 600));
        BG.setPreferredSize(new java.awt.Dimension(1000, 600));

        // Add BG JLabel to layout
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1263, 835));
        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new UserMain().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JTable DataTicket;
    private javax.swing.JButton BtnBuy;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbArrival;
    private javax.swing.JComboBox<String> cmbDeparture;
    private com.toedter.calendar.JDateChooser dateDeparture;
    private javax.swing.JList<String> listTiket;
    private javax.swing.JScrollPane jScrollPane1;
}
