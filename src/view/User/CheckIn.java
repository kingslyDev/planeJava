package view.User;

import controller.CheckInController;
import java.util.List;
import javax.swing.JOptionPane;
import model.Transaction;

/**
 * Form for Check-In process where users can input their boarding code and select available seats.
 */
public class CheckIn extends javax.swing.JFrame {

    private CheckInController checkInController;

    /**
     * Creates new form CheckIn
     */
    public CheckIn() {
        initComponents();
        checkInController = new CheckInController();  // Initialize the controller
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        isiKodeBooking = new javax.swing.JTextField();
        seatComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnCheckin = new javax.swing.JButton();
        btnCariKursi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("MASUKAN KODE BOOKING");

        isiKodeBooking.setText("Masukan kode");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("PILIH KURSI");

        btnCheckin.setText("Check-in");
        btnCheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckinActionPerformed(evt);
            }
        });

        btnCariKursi.setText("Cari Kursi");
        btnCariKursi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariKursiActionPerformed(evt);
            }
        });

        // Layout setup
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(isiKodeBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnCariKursi))
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCheckin)
                            .addComponent(seatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(isiKodeBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariKursi))
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCheckin)
                .addContainerGap(162, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    // Action for searching available seats
    private void btnCariKursiActionPerformed(java.awt.event.ActionEvent evt) {
        String boardingCode = isiKodeBooking.getText().trim();

        if (boardingCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan kode booking!");
            return;
        }

        // Validate the boarding code and fetch transaction details
        Transaction transaction = checkInController.validateBoardingCode(boardingCode);
        if (transaction == null) {
            JOptionPane.showMessageDialog(this, "Kode boarding tidak valid!");
            return;
        }

        // Fetch available seats using the flight code from the transaction
        List<Integer> availableSeats = checkInController.getAvailableSeats(transaction.getFlightCode());

        // Populate the comboBox with available seats
        seatComboBox.removeAllItems();  // Clear current items
        if (availableSeats.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tidak ada kursi tersedia untuk penerbangan ini.");
        } else {
            for (Integer seat : availableSeats) {
                seatComboBox.addItem(seat.toString());  // Add available seats to comboBox
            }
        }
    }

    // Action for checking in a seat
    private void btnCheckinActionPerformed(java.awt.event.ActionEvent evt) {
        String boardingCode = isiKodeBooking.getText().trim();
        String selectedSeat = (String) seatComboBox.getSelectedItem();  // Get the selected seat from comboBox

        if (selectedSeat == null || boardingCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih kursi dan masukkan kode booking!");
            return;
        }

        // Validate the boarding code and fetch transaction details
        Transaction transaction = checkInController.validateBoardingCode(boardingCode);
        if (transaction == null) {
            JOptionPane.showMessageDialog(this, "Kode boarding tidak valid!");
            return;
        }

        // Attempt to check in for the selected seat
        boolean success = checkInController.checkInSeat(transaction.getUserId(), Integer.parseInt(selectedSeat));
        if (success) {
            JOptionPane.showMessageDialog(this, "Check-in berhasil untuk kursi: " + selectedSeat);
        } else {
            JOptionPane.showMessageDialog(this, "Check-in gagal. Silakan coba lagi.");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariKursi;
    private javax.swing.JButton btnCheckin;
    private javax.swing.JTextField isiKodeBooking;
    private javax.swing.JComboBox<String> seatComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}