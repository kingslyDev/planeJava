package view.User;

import controller.FlightController;
import controller.TransactionController;
import model.Transaction;
import model.User; /*   Mengimpor model User   */
import model.UserSession; /*   Mengimpor UserSession untuk mendapatkan data pengguna yang sedang login   */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

/*   Kelas UserMain adalah tampilan utama bagi pengguna, yang memungkinkan mereka mencari dan membeli tiket   */
public class UserMain extends javax.swing.JFrame {

    /*   Inisialisasi controller untuk penerbangan dan transaksi serta model untuk list tiket   */
    private FlightController flightController;
    private TransactionController transactionController;
    private DefaultListModel<String> ticketListModel;

    /*   Konstruktor UserMain   */
    public UserMain() {
        initComponents(); /*   Inisialisasi komponen UI   */
        getContentPane().setBackground(Color.WHITE); /*   Mengatur background warna putih   */
        setLocationRelativeTo(null); /*   Mengatur posisi window di tengah layar   */
        flightController = new FlightController(); /*   Membuat objek FlightController   */
        transactionController = new TransactionController(); /*   Membuat objek TransactionController   */
        ticketListModel = new DefaultListModel<>(); /*   Membuat model untuk menampilkan daftar tiket   */
        listTiket.setModel(ticketListModel); /*   Mengaitkan model tiket ke listTiket   */
        populateCityComboBoxes(); /*   Mengisi combobox kota keberangkatan dan kedatangan   */
        setupTableClickListener(); /*   Menambahkan event listener untuk klik pada tabel tiket   */
    }

    /*   Method untuk mengisi combobox kota keberangkatan dan kedatangan dari database   */
    private void populateCityComboBoxes() {
        flightController.populateCityComboBox(cmbDeparture, "kota_keberangkatan");
        flightController.populateCityComboBox(cmbArrival, "kota_kedatangan");
    }

    /*   Method untuk menambahkan event listener ketika pengguna mengklik baris pada tabel tiket   */
    private void setupTableClickListener() {
        DataTicket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                DataTicketMouseClicked(evt); /*   Menangani event klik pada tabel tiket   */
            }
        });
    }

    /*   Method yang dipanggil ketika baris dalam tabel tiket diklik   */
    private void DataTicketMouseClicked(MouseEvent evt) {
        int selectedRow = DataTicket.getSelectedRow(); /*   Mendapatkan baris yang diklik   */
        if (selectedRow != -1) {
            /*   Mengambil data tiket dari tabel berdasarkan baris yang dipilih   */
            String flightCode = (String) DataTicket.getValueAt(selectedRow, 0);
            String departureCity = (String) DataTicket.getValueAt(selectedRow, 1);
            String arrivalCity = (String) DataTicket.getValueAt(selectedRow, 2);
            String date = DataTicket.getValueAt(selectedRow, 3).toString();
            String time = (String) DataTicket.getValueAt(selectedRow, 4);
            String status = (String) DataTicket.getValueAt(selectedRow, 6);
            double price = (Double) DataTicket.getValueAt(selectedRow, 7);

            /*   Menampilkan informasi tiket yang dipilih ke dalam JList   */
            ticketListModel.clear(); /*   Mengosongkan list sebelum menambahkan data baru   */
            ticketListModel.addElement("Flight Code: " + flightCode);
            ticketListModel.addElement("Departure: " + departureCity);
            ticketListModel.addElement("Arrival: " + arrivalCity);
            ticketListModel.addElement("Date: " + date);
            ticketListModel.addElement("Time: " + time);
            ticketListModel.addElement("Status: " + status);
            ticketListModel.addElement("Price: " + price);
        }
    }

    /*   Method yang dipanggil saat tombol Search diklik   */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        String departureCity = cmbDeparture.getSelectedItem().toString();
        String arrivalCity = cmbArrival.getSelectedItem().toString();
        Date selectedDate = dateDeparture.getDate(); /*   Mendapatkan tanggal keberangkatan dari date picker   */

        if (selectedDate != null) {
            /*   Jika tanggal dipilih, tampilkan hasil pencarian di tabel   */
            DefaultTableModel model = (DefaultTableModel) DataTicket.getModel();
            flightController.populateSearchResults(model, departureCity, arrivalCity, selectedDate);
        } else {
            /*   Jika tanggal belum dipilih, tampilkan pesan error   */
            JOptionPane.showMessageDialog(this, "Silakan pilih tanggal keberangkatan.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*   Method yang dipanggil saat tombol Buy diklik untuk membeli tiket   */
    private void BtnBuyActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = DataTicket.getSelectedRow(); /*   Mendapatkan baris yang dipilih   */
        if (selectedRow == -1) {
            /*   Jika tidak ada baris yang dipilih, tampilkan pesan error   */
            JOptionPane.showMessageDialog(this, "Silakan pilih tiket terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /*   Mengambil data tiket yang dipilih   */
        String flightCode = (String) DataTicket.getValueAt(selectedRow, 0);
        double price = (Double) DataTicket.getValueAt(selectedRow, 7);
        long userId = getCurrentUserId(); /*   Mendapatkan ID pengguna yang sedang login   */
        String boardingCode = "boardingCode"; /*   Mengatur boarding code (harus di-generate atau diambil dari sistem)   */
        String status = "BELUM"; /*   Status awal transaksi   */

        /*   Konfirmasi pembelian tiket   */
        int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin memesan tiket ini?\nHarga: " + price, "Konfirmasi Pemesanan", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            /*   Jika pengguna mengonfirmasi pembelian, buat transaksi baru   */
            Transaction transaction = new Transaction(userId, flightCode, boardingCode, status, price, "CUSTOMER");

            /*   Simpan transaksi   */
            if (transactionController.saveTransaction(transaction)) {
                JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan transaksi.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /*   Method untuk mendapatkan ID pengguna yang sedang login dari UserSession   */
    private long getCurrentUserId() {
        User currentUser = UserSession.getCurrentUser(); /*   Mengambil pengguna yang sedang login   */
        return currentUser != null ? currentUser.getId() : -1; /*   Kembalikan ID pengguna atau -1 jika tidak ada pengguna yang login   */
    }

    @SuppressWarnings("unchecked")
    /*   Method untuk inisialisasi komponen UI   */
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
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); /*   Menetapkan operasi default ketika window ditutup   */
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        /*   Mengatur header form   */
        Header.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Header.setForeground(new java.awt.Color(255, 255, 255));
        Header.setText("TAMBAH TIKET");
        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, 35));
        
        /*   Mengatur tabel DataTicket dengan kolom-kolom yang sesuai untuk informasi tiket   */
        DataTicket.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Flight Code", "Departure City", "Arrival City", "Date", "Time", "Ticket", "Status", "Price"
                }
        ));
        jScrollPane1.setViewportView(DataTicket);
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 960, 88));

        /*   Tombol Search untuk mencari tiket berdasarkan filter   */
        btnSearch.setText("Search");
        btnSearch.addActionListener(this::btnSearchActionPerformed);
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 100, 30));

        /*   Combobox untuk memilih kota keberangkatan dan kedatangan   */
        getContentPane().add(cmb
