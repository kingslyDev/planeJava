package view.Admin;

import controller.AddTicketController;
import model.Ticket;
import java.util.Date;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*   Kelas AddData untuk menambahkan tiket pesawat baru   */
public class AddData extends javax.swing.JFrame {

    /*   Konstruktor untuk inisialisasi form AddData   */
    public AddData() {
        initComponents();  /*   Inisialisasi komponen-komponen UI yang dibuat dengan GUI builder   */
        setLocationRelativeTo(null);  /*   Mengatur lokasi form di tengah layar   */
        getContentPane().setBackground(Color.WHITE);  /*   Mengatur latar belakang form menjadi putih   */
    }

    /*   Method ini dipanggil di dalam konstruktor untuk menginisialisasi form. 
         Jangan memodifikasi kode ini secara manual karena selalu dihasilkan ulang oleh Form Editor   */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();  /*   Label untuk judul form   */
        btnAddData = new javax.swing.JButton();  /*   Tombol untuk menambahkan data tiket   */
        isiFlightCode = new javax.swing.JTextField();  /*   Text field untuk memasukkan kode penerbangan   */
        isiDepartureCity = new javax.swing.JTextField();  /*   Text field untuk memasukkan kota keberangkatan   */
        isiArrivalCity = new javax.swing.JTextField();  /*   Text field untuk memasukkan kota kedatangan   */
        jamKeberangkatan = new javax.swing.JTextField();  /*   Text field untuk memasukkan jam keberangkatan   */
        JumlahTicket = new javax.swing.JTextField();  /*   Text field untuk memasukkan jumlah tiket tersedia   */
        Harga = new javax.swing.JTextField();  /*   Text field untuk memasukkan harga tiket   */
        isiStatus = new javax.swing.JComboBox<>();  /*   Dropdown untuk memilih status tiket   */
        jLabel2 = new javax.swing.JLabel();  /*   Label untuk kode penerbangan   */
        jLabel3 = new javax.swing.JLabel();  /*   Label untuk kota keberangkatan   */
        jLabel4 = new javax.swing.JLabel();  /*   Label untuk kota kedatangan   */
        jLabel5 = new javax.swing.JLabel();  /*   Label untuk tanggal keberangkatan   */
        jLabel6 = new javax.swing.JLabel();  /*   Label untuk jam keberangkatan   */
        jLabel7 = new javax.swing.JLabel();  /*   Label untuk jumlah tiket   */
        jLabel8 = new javax.swing.JLabel();  /*   Label untuk status tiket   */
        jLabel9 = new javax.swing.JLabel();  /*   Label untuk harga tiket   */
        jLabel10 = new javax.swing.JLabel();  /*   Label tidak digunakan (placeholder)   */
        jDateChooser1 = new com.toedter.calendar.JDateChooser();  /*   Date picker untuk memilih tanggal keberangkatan   */
        JLabel BG = new javax.swing.JLabel();  /*   Label untuk background gambar   */

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);  /*   Mengatur aksi default ketika window ditutup   */
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());  /*   Menggunakan Absolute Layout untuk mengatur posisi komponen   */

        /*   Menambahkan label "TAMBAH TIKET" di atas form   */
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));  // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TAMBAH TIKET");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, 35));

        /*   Tombol untuk menambah data tiket   */
        btnAddData.setText("Add");
        btnAddData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDataActionPerformed(evt);  /*   Mengatur event handler saat tombol ditekan   */
            }
        });
        getContentPane().add(btnAddData, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 680, -1, 32));

        /*   Menambahkan field input kode penerbangan   */
        getContentPane().add(isiFlightCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 163, 30));

        /*   Menambahkan field input kota keberangkatan   */
        getContentPane().add(isiDepartureCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 163, 30));

        /*   Menambahkan field input kota kedatangan   */
        getContentPane().add(isiArrivalCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 163, 30));

        /*   Menambahkan field input jam keberangkatan   */
        getContentPane().add(jamKeberangkatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 163, 30));

        /*   Menambahkan field input jumlah tiket   */
        getContentPane().add(JumlahTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 163, 30));

        /*   Menambahkan field input harga tiket   */
        getContentPane().add(Harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, 163, 30));

        /*   Menambahkan dropdown untuk status tiket (tersedia/kosong)   */
        isiStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TERSEDIA", "KOSONG" }));
        getContentPane().add(isiStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 163, 35));

        /*   Label untuk menandakan Flight Code   */
        jLabel2.setText("Flight Code");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        /*   Label untuk menandakan Departure City   */
        jLabel3.setText("Departure City");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        /*   Label untuk menandakan Arrival City   */
        jLabel4.setText("Arrival City");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        /*   Label untuk menandakan Date   */
        jLabel5.setText("Date");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        /*   Label untuk menandakan Time   */
        jLabel6.setText("Time");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        /*   Label untuk menandakan Tickets   */
        jLabel7.setText("Tickets");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, -1));

        /*   Label untuk menandakan Status   */
        jLabel8.setText("Status");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, -1, -1));

        /*   Label untuk menandakan Harga   */
        jLabel9.setText("Harga");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, -1, -1));

        /*   Label placeholder tidak digunakan   */
        jLabel10.setText("cw;canei");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, -100, 670, -1));

        /*   Date picker untuk memilih tanggal keberangkatan   */
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 160, -1));

        /*   Menambahkan background gambar   */
        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/BG.jpg")));  // Path to your image
        BG.setText("");
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 750));

        pack();  /*   Menyesuaikan ukuran form agar sesuai dengan komponen yang ada   */
    }// </editor-fold>                        

    /*   Method yang dipanggil ketika tombol "Add" ditekan untuk menambahkan data tiket   */
    private void btnAddDataActionPerformed(java.awt.event.ActionEvent evt) {                                           
        /*   Mengambil data dari input field   */
        String flightCode = isiFlightCode.getText();
        String departureCity = isiDepartureCity.getText();
        String arrivalCity = isiArrivalCity.getText();
        Date departureDate = jDateChooser1.getDate();
        String departureTime = jamKeberangkatan.getText();
        int availableSeats = Integer.parseInt(JumlahTicket.getText());
        String status = isiStatus.getSelectedItem().toString();
        double price = Double.parseDouble(Harga.getText());

        /*   Membuat objek Ticket dengan data yang diambil   */
        Ticket ticket = new Ticket(flightCode, departureCity, arrivalCity, departureDate, departureTime, availableSeats, status, price);

        /*   Memanggil controller untuk menambahkan tiket   */
        AddTicketController controller = new AddTicketController();
        boolean success = controller.addTicket(ticket);  /*   Memeriksa apakah tiket berhasil ditambahkan   */
        
        if (success) {
            JOptionPane.showMessageDialog(this, "Berhasil menambahkan tiket!");  /*   Menampilkan pesan sukses jika berhasil   */
            new AdminMain().setVisible(true);  /*   Membuka tampilan AdminMain setelah menambahkan tiket   */
            this.dispose();  /*   Menutup form AddData   */
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menambahkan tiket!");  /*   Menampilkan pesan error jika gagal   */
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*   Membuat dan menampilkan form AddData   */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddData().setVisible(true);
            }
        });
    }

    /* Deklarasi variabel komponen UI */
    private javax.swing.JTextField Harga;
    private javax.swing.JTextField JumlahTicket;
    private javax.swing.JButton btnAddData;
    private javax.swing.JTextField isiArrivalCity;
    private javax.swing.JTextField isiDepartureCity;
    private javax.swing.JTextField isiFlightCode;
    private javax.swing.JComboBox<String> isiStatus;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jamKeberangkatan;
    /* mengakhiri deklarasi variabel */
}
