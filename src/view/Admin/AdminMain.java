package view.Admin; /* Mendefinisikan paket view.Admin untuk tampilan admin */

import controller.FlightController; /* Mengimpor kelas FlightController */
import java.awt.Color; /* Mengimpor kelas Color untuk pengaturan warna */
import javax.swing.ImageIcon; /* Mengimpor kelas ImageIcon untuk menampilkan gambar */
import javax.swing.table.DefaultTableModel; /* Mengimpor DefaultTableModel untuk tabel */

/* AdminMain - Tampilan utama bagi Admin untuk mengelola data penerbangan */
public class AdminMain extends javax.swing.JFrame { /* Kelas AdminMain yang merupakan jendela utama */

    private final FlightController controllerFlight; /* Kontroler untuk mengelola data penerbangan */

    /* Constructor */
    public AdminMain() { /* Constructor untuk inisialisasi tampilan */
        initComponents(); /* Memanggil method untuk inisialisasi komponen GUI */

        /* Mengatur posisi jendela di tengah layar */
        setLocationRelativeTo(null); 

        /* Mengatur warna latar belakang jendela */
        getContentPane().setBackground(Color.WHITE);

        /* Menginisialisasi FlightController */
        controllerFlight = new FlightController();

        /* Memuat data penerbangan ke dalam tabel */
        loadFlightData();
    }

    /* Memuat data penerbangan ke dalam JTable */
    private void loadFlightData() {
        /* Mengambil data penerbangan dari kontroler */
        var flightList = controllerFlight.getAllTickets();

        /* Mengosongkan tabel terlebih dahulu */
        DefaultTableModel model = (DefaultTableModel) DataTicket.getModel();
        model.setRowCount(0);  /* Menghapus baris yang ada */

        /* Mengisi tabel dengan data penerbangan */
        for (var flight : flightList) {
            Object[] rowData = {
                flight.getFlightCode(),      /* Kode penerbangan */
                flight.getDepartureCity(),   /* Kota keberangkatan */
                flight.getArrivalCity(),     /* Kota tujuan */
                flight.getDepartureDate(),    /* Tanggal keberangkatan */
                flight.getDepartureTime(),    /* Jam keberangkatan */
                flight.getAvailableSeats(),   /* Jumlah kursi yang tersedia */
                flight.getStatus(),          /* Status penerbangan */
                flight.getPrice()            /* Harga tiket */
            };
            model.addRow(rowData); /* Menambahkan baris data ke tabel */
        }
    }

    /* Event handler untuk menambah data penerbangan baru */
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        /* Membuka form untuk menambah data penerbangan */
        AddData tambahData = new AddData();
        tambahData.setVisible(true); /* Menampilkan form AddData */
    }

    /* Method untuk menginisialisasi komponen GUI */
    private void initComponents() {
        /* Inisialisasi komponen GUI */
        jDialog1 = new javax.swing.JDialog(); /* Dialog tambahan (belum digunakan) */
        DataTiketTxt = new javax.swing.JLabel(); /* Label untuk judul tabel */
        jScrollPane1 = new javax.swing.JScrollPane(); /* Scroll pane untuk tabel */
        DataTicket = new javax.swing.JTable(); /* Tabel untuk menampilkan data penerbangan */
        btnAdd = new javax.swing.JButton(); /* Tombol untuk menambah data penerbangan */
        BG = new javax.swing.JLabel(); /* Label untuk gambar latar belakang */

        /* Mengatur layout untuk jDialog1 */
        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        /* Menutup aplikasi saat jendela ditutup */
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); 
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout()); /* Mengatur layout jendela utama */

        /* Mengatur label judul tabel */
        DataTiketTxt.setFont(new java.awt.Font("Segoe UI", 1, 24)); /* Mengatur font dan ukuran */
        DataTiketTxt.setForeground(new java.awt.Color(0, 0, 0)); /* Mengatur warna teks */
        DataTiketTxt.setText("DATA TIKET"); /* Mengatur teks label */
        getContentPane().add(DataTiketTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 143, -1)); /* Menambahkan label ke layout */

        /* Mengatur model tabel untuk menampilkan data penerbangan */
        DataTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null} /* Baris awal kosong */
            },
            new String [] {
                "Flight Code", "Departure City", "Arrival City", "Date", "Time", "Available Seats", "Status", "Ticket Price" /* Judul kolom */
            }
        ) {
            boolean[] canEdit = new boolean [] { /* Menentukan apakah sel bisa diedit */
                false, false, false, false, false, false, false, false
            };

            /* Mengatur agar sel tidak bisa diedit */
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) { 
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(DataTicket); /* Menambahkan tabel ke dalam scroll pane */

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 191, 913, 88)); /* Menambahkan scroll pane ke layout */

        /* Mengatur tombol untuk menambah data penerbangan */
        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); /* Mengatur font tombol */
        btnAdd.setText("+ Add"); /* Mengatur teks tombol */
        btnAdd.setBorder(null); /* Menghapus border tombol */
        btnAdd.addActionListener(new java.awt.event.ActionListener() { /* Menambahkan event handler untuk tombol */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt); /* Memanggil method saat tombol ditekan */
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(883, 143, 74, 30)); /* Menambahkan tombol ke layout */

        /* Mengatur gambar latar belakang untuk JLabel BG */
        BG.setIcon(new ImageIcon(getClass().getResource("/assets/BG.jpg"))); /* Mengatur ikon dari resource */
        BG.setMaximumSize(new java.awt.Dimension(1000, 665)); /* Mengatur ukuran maksimum */
        BG.setMinimumSize(new java.awt.Dimension(1000, 665)); /* Mengatur ukuran minimum */
        BG.setPreferredSize(new java.awt.Dimension(1000, 665)); /* Mengatur ukuran yang diinginkan */

        /* Menambahkan JLabel BG ke layout */
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600)); /* Menambahkan background ke layout */

        pack(); /* Mengatur ukuran jendela berdasarkan komponen yang ada */
    }

    /* Method utama untuk menjalankan aplikasi */
    public static void main(String args[]) { 
        /* Membuat dan menampilkan form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminMain().setVisible(true); /* Menampilkan jendela AdminMain */
            }
        });
    }

    /* Variabel deklarasi - jangan ubah */
    private javax.swing.JLabel BG; /* Label untuk gambar latar belakang */
    private javax.swing.JTable DataTicket; /* Tabel untuk menampilkan data tiket */
    private javax.swing.JLabel DataTiketTxt; /* Label untuk judul tabel */
    private javax.swing.JButton btnAdd; /* Tombol untuk menambah data penerbangan */
    private javax.swing.JDialog jDialog1; /* Dialog tambahan (belum digunakan) */
    private javax.swing.JScrollPane jScrollPane1; /* Scroll pane untuk tabel */
}
