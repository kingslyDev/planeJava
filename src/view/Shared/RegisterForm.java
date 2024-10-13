package view.Shared; /* Mendefinisikan paket view.Shared untuk tampilan bersama */

import controller.RegisterController; /* Mengimpor kelas RegisterController */
import javax.swing.*; /* Mengimpor semua kelas dari paket javax.swing */
import java.awt.*; /* Mengimpor semua kelas dari paket java.awt */

public class RegisterForm extends JFrame { /* Kelas RegisterForm yang merupakan jendela pendaftaran */

    /* Constructor untuk inisialisasi form pendaftaran */
    public RegisterForm() {
        initComponents(); /* Memanggil method untuk inisialisasi komponen GUI */
        setLocationRelativeTo(null); /* Mengatur posisi jendela di tengah layar */
        getContentPane().setBackground(Color.WHITE); /* Mengatur warna latar belakang jendela */
    }

    @SuppressWarnings("unchecked") /* Mengabaikan peringatan untuk generik yang tidak aman */
    private void initComponents() { /* Method untuk menginisialisasi komponen GUI */
        JPanel jPanel1 = new JPanel(); /* Panel untuk menampung komponen latar belakang */
        JLabel paintComponent = new JLabel(); /* Label untuk gambar latar belakang */
        JLabel registerLabel = new JLabel(); /* Label untuk teks "REGISTER HERE!" */
        JLabel usernameLabel = new JLabel(); /* Label untuk teks "Username" */
        JLabel passwordLabel = new JLabel(); /* Label untuk teks "Password" */
        JLabel roleLabel = new JLabel(); /* Label untuk teks "Role" */
        JComboBox<String> roleComboBox = new JComboBox<>(new String[]{"CUSTOMER", "ADMIN"}); /* ComboBox untuk memilih peran */
        JTextField usernameField = new JTextField(); /* Field untuk memasukkan username */
        JPasswordField passwordField = new JPasswordField(); /* Field untuk memasukkan password */
        JLabel loginText = new JLabel(); /* Label untuk teks pendaftaran */
        JLabel loginLink = new JLabel(); /* Label untuk link ke form login */
        JButton registerButton = new JButton(); /* Tombol untuk melakukan pendaftaran */

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); /* Mengatur operasi penutupan jendela */

        /* Mengatur ukuran dan preferensi label gambar latar belakang */
        paintComponent.setMaximumSize(new Dimension(500, 600));
        paintComponent.setMinimumSize(new Dimension(410, 519));
        paintComponent.setPreferredSize(new Dimension(500, 600));

        /* Mengatur layout untuk jPanel1 */
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(paintComponent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(paintComponent, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        /* Mengatur gambar latar belakang */
        paintComponent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/airplane-flying-cloudy-sky-login.jpg")));
        paintComponent.setMaximumSize(new java.awt.Dimension(410, 519));
        paintComponent.setMinimumSize(new java.awt.Dimension(410, 519));
        paintComponent.setPreferredSize(new java.awt.Dimension(410, 519));

        /* Mengatur label pendaftaran */
        registerLabel.setFont(new Font("Segoe UI", Font.BOLD, 24)); /* Mengatur font */
        registerLabel.setText("REGISTER HERE!"); /* Mengatur teks label */

        /* Mengatur label username */
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); /* Mengatur font */
        usernameLabel.setText("Username"); /* Mengatur teks label */

        /* Mengatur label password */
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); /* Mengatur font */
        passwordLabel.setText("Password"); /* Mengatur teks label */

        /* Mengatur label role */
        roleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); /* Mengatur font */
        roleLabel.setText("Role"); /* Mengatur teks label */

        /* Mengatur teks untuk pendaftaran */
        loginText.setText("Sudah punya akun?"); /* Mengatur teks label */

        /* Mengatur link untuk login */
        loginLink.setForeground(new Color(102, 153, 255)); /* Mengatur warna teks */
        loginLink.setText("Login"); /* Mengatur teks label */
        loginLink.addMouseListener(new java.awt.event.MouseAdapter() { /* Menambahkan event handler untuk mouse click */
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginLinkMouseClicked(evt); /* Memanggil method saat link diklik */
            }
        });

        /* Mengatur tombol pendaftaran */
        registerButton.setFont(new Font("Segoe UI", Font.PLAIN, 14)); /* Mengatur font */
        registerButton.setText("Register"); /* Mengatur teks tombol */
        registerButton.addActionListener(evt -> registerButtonActionPerformed(evt, usernameField, passwordField, roleComboBox)); /* Menambahkan event handler untuk pendaftaran */

        /* Mengatur layout untuk konten jendela */
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(106, 106, 106) /* Mengatur jarak awal */
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordLabel) /* Menampilkan label password */
                                        .addComponent(usernameLabel) /* Menampilkan label username */
                                        .addComponent(roleLabel) /* Menampilkan label role */
                                        .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE) /* Field untuk username */
                                        .addComponent(registerLabel) /* Menampilkan label pendaftaran */
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(roleComboBox, GroupLayout.Alignment.LEADING, 0, 259, Short.MAX_VALUE) /* ComboBox untuk role */
                                                .addComponent(passwordField, GroupLayout.Alignment.LEADING)) /* Field untuk password */
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(loginText) /* Menampilkan label pendaftaran */
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(loginLink, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)) /* Menampilkan link login */
                                        .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)) /* Menampilkan tombol pendaftaran */
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE) /* Mengatur jarak akhir */
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)) /* Menambahkan panel ke layout */
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) /* Menampilkan panel */
                        .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96) /* Mengatur jarak atas */
                                .addComponent(registerLabel) /* Menampilkan label pendaftaran */
                                .addGap(29, 29, 29) /* Mengatur jarak antara label */
                                .addComponent(usernameLabel) /* Menampilkan label username */
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE) /* Field untuk username */
                                .addGap(18, 18, 18)
                                .addComponent(passwordLabel) /* Menampilkan label password */
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE) /* Field untuk password */
                                .addGap(30, 30, 30)
                                .addComponent(roleLabel) /* Menampilkan label role */
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roleComboBox, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE) /* ComboBox untuk role */
                                .addGap(33, 33, 33)
                                .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE) /* Tombol pendaftaran */
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginText) /* Menampilkan label pendaftaran */
                                        .addComponent(loginLink)) /* Menampilkan link login */
                                .addGap(54, 54, 54)) /* Mengatur jarak akhir */
        );

        pack(); /* Mengatur ukuran jendela berdasarkan komponen yang ada */
        setLocationRelativeTo(null); /* Mengatur posisi jendela di tengah layar */
    }

    /* Event handler untuk link login */
    private void loginLinkMouseClicked(java.awt.event.MouseEvent evt) {
        new LoginForm().setVisible(true); /* Membuka form login */
        this.dispose(); /* Menutup jendela pendaftaran */
    }

    /* Event handler untuk tombol pendaftaran */
    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt, JTextField usernameField, JPasswordField passwordField, JComboBox<String> roleComboBox) {
        String username = usernameField.getText(); /* Mengambil teks dari field username */
        String password = new String(passwordField.getPassword()); /* Mengambil teks dari field password */
        String role = (String) roleComboBox.getSelectedItem(); /* Mengambil pilihan dari ComboBox role */

        RegisterController registerController = new RegisterController(); /* Membuat objek RegisterController */
        boolean success = registerController.register(username, password, role); /* Memanggil method register dan menyimpan hasilnya */

        /* Memeriksa apakah pendaftaran berhasil */
        if (success) {
            JOptionPane.showMessageDialog(this, "Registration Successful!"); /* Menampilkan pesan sukses */
            new LoginForm().setVisible(true); /* Membuka form login */
            this.dispose(); /* Menutup jendela pendaftaran */
        } else {
            JOptionPane.showMessageDialog(this, "Registration Failed! Please try again."); /* Menampilkan pesan gagal */
        }
    }

    /* Method utama untuk menjalankan aplikasi */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new RegisterForm().setVisible(true)); /* Menampilkan jendela pendaftaran */
    }
}
