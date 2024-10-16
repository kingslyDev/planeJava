package view.User;

import controller.SeatController;
import controller.BoardingPassController;  /*   Impor controller BoardingPass untuk mencetak boarding pass   */
import model.Seat;
import model.UserSession;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/*   Kelas untuk menampilkan kursi yang sudah di-check-in oleh pengguna   */
public class SeatView extends javax.swing.JFrame {

    private SeatController seatController;  /*   Kontroler untuk mengelola kursi pengguna   */

    /*   Konstruktor SeatView   */
    public SeatView() {
        initComponents();  /*   Inisialisasi komponen UI   */
        seatController = new SeatController();  /*   Inisialisasi SeatController   */
        setLocationRelativeTo(null);  /*   Mengatur posisi window di tengah layar   */
        loadSeats();  /*   Memuat daftar kursi yang sudah di-check-in   */
    }

    /*   Method untuk memuat kursi ke dalam JTable   */
    private void loadSeats() {
        String currentUser = UserSession.getCurrentUser().getUsername();  /*   Mendapatkan username pengguna yang sedang login dari UserSession   */
        List<Seat> seatList = seatController.getCheckedInSeatsByUser(currentUser);  /*   Mendapatkan daftar kursi yang sudah di-check-in oleh pengguna   */

        /*   Mendapatkan model tabel dan membersihkan data yang ada   */
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);  /*   Mengosongkan tabel sebelum memasukkan data baru   */

        /*   Loop melalui daftar kursi dan tambahkan ke dalam tabel   */
        for (Seat seat : seatList) {
            model.addRow(new Object[]{
                    seat.getTransactionId(),  /*   Menampilkan ID transaksi   */
                    seat.getFlightCode(),     /*   Menampilkan kode penerbangan   */
                    seat.getPassengerName(),  /*   Menampilkan nama penumpang   */
                    seat.getSeatNumber()      /*   Menampilkan nomor kursi   */
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

        /*   Mengatur latar belakang panel utama   */
        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        /*   Mengatur model untuk JTable   */
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Transaction ID", "Flight Code", "Passenger Name", "Seat Number"  /*   Header tabel untuk kursi   */
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        /*   Tombol untuk mencetak boarding pass   */
        btnBoarding.setText("Cetak");
        btnBoarding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoardingActionPerformed(evt);  /*   Menambahkan event listener untuk tombol Cetak   */
            }
        });

        /*   Menyusun layout untuk jPanel1   */
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

        /*   Mengatur layout keseluruhan form   */
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

        pack();  /*   Mengatur ukuran form agar sesuai dengan konten   */
    }// </editor-fold>                        

    /*   Method yang dipanggil ketika tombol Cetak (Boarding Pass) diklik   */
    private void btnBoardingActionPerformed(java.awt.event.ActionEvent evt) {
        /*   Ambil baris yang dipilih dari tabel   */
        int selectedRow = jTable1.getSelectedRow();
        
        if (selectedRow == -1) {
            /*   Jika tidak ada baris yang dipilih, tampilkan pesan error   */
            JOptionPane.showMessageDialog(this, "Pilih kursi terlebih dahulu untuk mencetak boarding pass.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        /*   Ambil kode transaksi dari baris yang dipilih   */
        long transactionId = (long) jTable1.getValueAt(selectedRow, 0);  /*   Mendapatkan ID transaksi dari baris yang dipilih   */
        
        /*   Panggil BoardingPassView dan kirimkan transactionId   */
        BoardingPassView boardingPassView = new BoardingPassView(transactionId);  /*   Membuka tampilan boarding pass dengan transactionId   */
        boardingPassView.setVisible(true);  /*   Menampilkan form BoardingPassView   */
    }

    /**
     * Method main untuk menjalankan aplikasi ini.
     * @param args
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new SeatView().setVisible(true));  /*   Membuat dan menampilkan form SeatView   */
    }

    /*   Deklarasi variabel komponen UI   */
    private javax.swing.JButton btnBoarding;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    /*   mengakhiri deklarasi variabel */
}
