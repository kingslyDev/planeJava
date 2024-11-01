package view.User;

import controller.BoardingPassController;
import model.BoardingPass;

/*   Kelas BoardingPassView untuk menampilkan data boarding pass berdasarkan transactionId   */
public class BoardingPassView extends javax.swing.JFrame {

    /*   Konstruktor BoardingPassView yang menerima transactionId sebagai parameter   */
    public BoardingPassView(long transactionId) {
        initComponents(); /*   Inisialisasi komponen UI   */

        /*   Memanggil controller untuk mendapatkan data boarding pass berdasarkan transactionId   */
        BoardingPassController controller = new BoardingPassController();
        BoardingPass boardingPass = controller.getBoardingPassDetails(transactionId);

        /*   Mengisi field pada form dengan data boarding pass yang diterima dari controller   */
        if (boardingPass != null) {
            IsiNama.setText(boardingPass.getPassengerName()); /*   Mengisi nama penumpang   */
            isiDepartureCity.setText(boardingPass.getFromCity()); /*   Mengisi kota keberangkatan   */
            isiArrivalCity.setText(boardingPass.getToCity()); /*   Mengisi kota tujuan   */
            isiFlightCode.setText(boardingPass.getFlightCode()); /*   Mengisi kode penerbangan   */
            jTextField1.setText(String.valueOf(boardingPass.getSeatNumber())); /*   Mengisi nomor kursi   */
            isiDate.setText(boardingPass.getDate()); /*   Mengisi tanggal keberangkatan   */
            isiTime.setText(boardingPass.getTime()); /*   Mengisi waktu keberangkatan   */
        }

        /*   Menyetel posisi form di tengah layar   */
        setLocationRelativeTo(null);

        /*   Mengatur warna background form menjadi putih   */
        getContentPane().setBackground(new java.awt.Color(255, 255, 255));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        IsiNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        isiDepartureCity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        isiArrivalCity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        isiFlightCode = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        isiTime = new javax.swing.JTextField();
        isiDate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 37, -1));
        getContentPane().add(IsiNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 138, -1));

        jLabel4.setText("From");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 37, -1));
        getContentPane().add(isiDepartureCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 138, -1));

        jLabel5.setText("Destination");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));
        getContentPane().add(isiArrivalCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 138, -1));

        jLabel6.setText("Date");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 37, -1));

        jLabel8.setText("Flight");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 37, -1));
        getContentPane().add(isiFlightCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 98, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Boarding Pass");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pens Airways");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jLabel7.setText("Time");

        isiDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiDateActionPerformed(evt);
            }
        });

        jLabel9.setText("Seat");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(isiDate, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(isiTime, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isiTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isiDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 100, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void isiDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiDateActionPerformed

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new BoardingPassView(1).setVisible(true));  /*   Menjalankan aplikasi dengan Transaction ID untuk pengujian   */
    }

    /* Variabel deklarasi */
    private javax.swing.JTextField IsiNama; /*   Field untuk nama penumpang   */
    private javax.swing.JTextField isiArrivalCity; /*   Field untuk kota tujuan   */
    private javax.swing.JTextField isiDate; /*   Field untuk tanggal keberangkatan   */
    private javax.swing.JTextField isiDepartureCity; /*   Field untuk kota keberangkatan   */
    private javax.swing.JTextField isiFlightCode; /*   Field untuk kode penerbangan   */
    private javax.swing.JTextField isiTime; /*   Field untuk waktu keberangkatan   */
    private javax.swing.JLabel jLabel1; /*   Label untuk judul   */
    private javax.swing.JLabel jLabel2; /*   Label untuk nama maskapai   */
    private javax.swing.JLabel jLabel3; /*   Label untuk nama penumpang   */
    private javax.swing.JLabel jLabel4; /*   Label untuk keberangkatan   */
    private javax.swing.JLabel jLabel5; /*   Label untuk tujuan   */
    private javax.swing.JLabel jLabel6; /*   Label untuk tanggal   */
    private javax.swing.JLabel jLabel7; /*   Label untuk waktu   */
    private javax.swing.JLabel jLabel8; /*   Label untuk penerbangan   */
    private javax.swing.JLabel jLabel9; /*   Label untuk nomor kursi   */
    private javax.swing.JPanel jPanel3; /*   Panel utama   */
    private javax.swing.JPanel jPanel4; /*   Panel header   */
    private javax.swing.JTextField jTextField1; /*   Field untuk nomor kursi   */
    /*   mengakhiri deklarasi variabel */                  
}