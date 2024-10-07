package view.User;

import controller.SeatController;
import controller.BoardingPassController;  // Menambahkan controller BoardingPass
import model.Seat;
import model.UserSession;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class SeatView extends javax.swing.JFrame {

    private SeatController seatController;

    public SeatView() {
        initComponents();
        seatController = new SeatController();
        setLocationRelativeTo(null);
        loadSeats();  // Load seats ketika view diinisialisasi
    }

    /**
     * Load the seats into the JTable.
     */
    private void loadSeats() {
        String currentUser = UserSession.getCurrentUser().getUsername();  // Dapatkan user yang sedang login
        List<Seat> seatList = seatController.getCheckedInSeatsByUser(currentUser);

        // Get the table model dan kosongkan data yang ada
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        // Loop melalui daftar kursi dan tambahkan ke tabel
        for (Seat seat : seatList) {
            model.addRow(new Object[]{
                    seat.getTransactionId(),  // Transaction ID
                    seat.getFlightCode(),     // Flight code
                    seat.getPassengerName(),  // Passenger name
                    seat.getSeatNumber()      // Seat number
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBoarding = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Transaction ID", "Flight Code", "Passenger Name", "Seat Number"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnBoarding.setText("Cetak");
        btnBoarding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoardingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(btnBoarding)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBoarding)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void btnBoardingActionPerformed(java.awt.event.ActionEvent evt) {
        // Ambil baris yang dipilih
        int selectedRow = jTable1.getSelectedRow();
        
        if (selectedRow == -1) {
            // Jika tidak ada baris yang dipilih
            JOptionPane.showMessageDialog(this, "Pilih kursi terlebih dahulu untuk mencetak boarding pass.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Ambil kode transaksi dari baris yang dipilih
        long transactionId = (long) jTable1.getValueAt(selectedRow, 0);  // Transaction ID
        
        // Panggil BoardingPassView dan kirimkan transactionId
        BoardingPassView boardingPassView = new BoardingPassView(transactionId);
        boardingPassView.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new SeatView().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton btnBoarding;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}
