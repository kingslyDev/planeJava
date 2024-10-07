package view.User;

import controller.TransactionController;
import model.Transaction;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Form for viewing user transactions in a JTable.
 */
public class ViewTransaksi extends javax.swing.JFrame {

    private TransactionController transactionController;
    private long userId;  // User ID, should be passed when this form is opened

    /**
     * Creates new form ViewTransaksi
     */
    public ViewTransaksi(long userId) {
        this.userId = userId;
        initComponents();
        transactionController = new TransactionController();  // Initialize the controller
        loadTransactions();  // Load transactions when form opens
    }

    // Method to load transactions into JTable
    private void loadTransactions() {
    List<Transaction> transactions = transactionController.getTransactionsByUserId(userId);
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);  // Clear existing rows

    // Check if transactions exist
    if (transactions.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No transactions found for this user.");
        return;
    }

    // Fill table with transaction data, excluding the transaction ID
    for (Transaction transaction : transactions) {
        model.addRow(new Object[]{
            transaction.getFlightCode(),
            "Asal Berangkat",  // Placeholder
            "Tujuan Berangkat",  // Placeholder
            "Jadwal Berangkat",  // Placeholder
            "Kursi Tersedia",  // Placeholder
            transaction.getStatus(),
            transaction.getPrice(),
            "Waktu Berangkat"  // Placeholder
        });
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnCheckin = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bgpanel.setBackground(new java.awt.Color(204, 204, 204));

        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "kode pesawat", "asal berangkat", "tujuan berangkat", "jadwal berangkat", "kursi tersedia", "status", "harga", "waktu berangkat"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(5).setMaxWidth(72);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(72);
        }

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Eras Demi ITC", 1, 24)); // NOI18N
        jLabel1.setText("Daftar Transaksi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("Cari Tiket");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCheckin.setText("CHECK IN");
        btnCheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckinActionPerformed(evt);
            }
        });

        jButton2.setText("Lihat Boarding");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgpanelLayout = new javax.swing.GroupLayout(bgpanel);
        bgpanel.setLayout(bgpanelLayout);
        bgpanelLayout.setHorizontalGroup(
            bgpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgpanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(bgpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgpanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(91, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgpanelLayout.createSequentialGroup()
                        .addGroup(bgpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bgpanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCheckin))
                            .addGroup(bgpanelLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(262, 262, 262)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)))
                        .addGap(66, 66, 66))))
        );
        bgpanelLayout.setVerticalGroup(
            bgpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgpanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(bgpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnCheckin)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Back to main user menu
        UserMain mainMenu = new UserMain();
        mainMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckinActionPerformed
        // Open Check-In window
        CheckIn checkIn = new CheckIn();
        checkIn.setVisible(true);
    }//GEN-LAST:event_btnCheckinActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        SeatView SeatView = new SeatView();
        SeatView.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTransaksi(1L).setVisible(true); // Example userId 1
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgpanel;
    private javax.swing.JButton btnCheckin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
