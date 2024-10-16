package view.Shared;

import controller.LoginController;
import javax.swing.*;
import java.awt.*;

/*   Kelas LoginForm untuk tampilan form login aplikasi   */
public class LoginForm extends javax.swing.JFrame {

    /*   Konstruktor LoginForm   */
    public LoginForm() {
        initComponents();  /*   Inisialisasi komponen-komponen UI yang dibuat dengan GUI builder   */
        setLocationRelativeTo(null);  /*   Mengatur posisi window di tengah layar   */
        getContentPane().setBackground(Color.WHITE);  /*   Mengatur warna background menjadi putih   */
    }

    /*   Method initComponents yang dihasilkan secara otomatis oleh GUI Builder untuk inisialisasi semua komponen UI   */
    private void initComponents() {
        PainComponent = new javax.swing.JPanel();  /*   Panel utama untuk background gambar   */
        BG = new javax.swing.JLabel();  /*   Label untuk menampilkan gambar background   */
        TaglineWelcome = new javax.swing.JLabel();  /*   Label untuk menampilkan teks "WELCOME TO PENS AIRLINES"   */
        Username = new javax.swing.JLabel();  /*   Label untuk teks "Username"   */
        password = new javax.swing.JLabel();  /*   Label untuk teks "Password"   */
        isiUsername = new javax.swing.JTextField();  /*   Text field untuk input username   */
        BtnLogin = new javax.swing.JButton();  /*   Tombol login untuk melakukan autentikasi   */
        isiPassword = new javax.swing.JPasswordField();  /*   Field untuk input password   */
        registerTxt = new javax.swing.JLabel();  /*   Label untuk teks "Belum punya akun?"   */
        btnRegister = new javax.swing.JLabel();  /*   Label klik untuk membuka form pendaftaran akun baru   */

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);  /*   Mengatur agar window ditutup ketika pengguna menekan tombol close   */
        setBackground(new java.awt.Color(255, 255, 255));  /*   Mengatur warna background   */

        /*   Menyiapkan panel utama dengan gambar background   */
        PainComponent.setMaximumSize(new java.awt.Dimension(410, 519));
        PainComponent.setPreferredSize(new java.awt.Dimension(410, 519));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/airplane-flying-cloudy-sky-login.jpg")));  /*   Mengatur gambar background   */
        BG.setMaximumSize(new java.awt.Dimension(410, 519));
        BG.setMinimumSize(new java.awt.Dimension(410, 519));
        BG.setPreferredSize(new java.awt.Dimension(410, 519));

        /*   Layout untuk panel PainComponent   */
        javax.swing.GroupLayout PainComponentLayout = new javax.swing.GroupLayout(PainComponent);
        PainComponent.setLayout(PainComponentLayout);
        PainComponentLayout.setHorizontalGroup(
            PainComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)  /*   Menambahkan gambar background ke panel   */
        );
        PainComponentLayout.setVerticalGroup(
            PainComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)  /*   Mengatur ukuran panel untuk menyesuaikan gambar   */
        );

        /*   Mengatur tampilan teks selamat datang   */
        TaglineWelcome.setFont(new java.awt.Font("Segoe UI", 1, 24));  /*   Mengatur font dan ukuran teks   */
        TaglineWelcome.setText("WELCOME TO PENS AIRLINES ");  /*   Teks pada label   */

        /*   Label untuk username   */
        Username.setFont(new java.awt.Font("Segoe UI", 0, 14));  /*   Mengatur font   */
        Username.setText("Username");  /*   Teks label untuk username   */

        /*   Label untuk password   */
        password.setFont(new java.awt.Font("Segoe UI", 0, 14));  /*   Mengatur font   */
        password.setText("Password");  /*   Teks label untuk password   */

        /*   Tombol untuk login, memanggil event handler BtnLoginActionPerformed   */
        BtnLogin.setFont(new java.awt.Font("Segoe UI", 0, 14));  /*   Mengatur font tombol   */
        BtnLogin.setText("Login");
        BtnLogin.addActionListener(this::BtnLoginActionPerformed);  /*   Menambahkan event listener untuk tombol login   */

        /*   Label untuk teks "Belum punya akun?"   */
        registerTxt.setText("Belum punya akun?");

        /*   Label untuk klik menuju form registrasi, diatur sebagai clickable label   */
        btnRegister.setForeground(new java.awt.Color(102, 153, 255));  /*   Mengatur warna teks agar terlihat seperti tautan   */
        btnRegister.setText("Buat akun");
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);  /*   Menambahkan event listener untuk membuka form pendaftaran   */
            }
        });

        /*   Mengatur layout untuk seluruh komponen di dalam form   */
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PainComponent, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)  /*   Panel background di kiri   */
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(isiPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)  /*   Input password   */
                                    .addComponent(BtnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)  /*   Tombol login   */
                                    .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)  /*   Label password   */
                                    .addComponent(isiUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)  /*   Input username   */
                                    .addComponent(Username, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))  /*   Label username   */
                                .addGap(88, 88, 88))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(TaglineWelcome)
                                .addGap(65, 65, 65))))  /*   Teks "WELCOME TO PENS AIRLINES" di atas   */
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(registerTxt)  /*   Teks "Belum punya akun?"   */
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegister)  /*   Teks "Buat akun" untuk pendaftaran akun baru   */
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(TaglineWelcome)  /*   Teks welcome di bagian atas   */
                .addGap(65, 65, 65)
                .addComponent(Username)  /*   Label username   */
                .addGap(18, 18, 18)
                .addComponent(isiUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)  /*   Input username   */
                .addGap(18, 18, 18)
                .addComponent(password)  /*   Label password   */
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isiPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)  /*   Input password   */
                .addGap(32, 32, 32)
                .addComponent(BtnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)  /*   Tombol login   */
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerTxt)  /*   Teks "Belum punya akun?"   */
                    .addComponent(btnRegister))  /*   Teks "Buat akun" sebagai link   */
                .addContainerGap(79, Short.MAX_VALUE))
            .addComponent(PainComponent, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)  /*   Panel background di sebelah kiri   */
        );

        pack();  /*   Mengatur ukuran frame agar sesuai dengan komponen   */
        setLocationRelativeTo(null);  /*   Menampilkan form di tengah layar   */
    }

    /*   Event handler untuk tombol login   */
    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        String username = isiUsername.getText();  /*   Mengambil input username   */
        String password = new String(isiPassword.getPassword());  /*   Mengambil input password   */

        /*   Memanggil LoginController untuk memvalidasi login   */
        LoginController loginController = new LoginController();
        loginController.login(username, password);  /*   Memanggil method login   */
    }

    /*   Event handler untuk membuka form pendaftaran akun baru ketika "Buat akun" diklik   */
    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {
        RegisterForm regist = new RegisterForm();  /*   Membuka form pendaftaran baru   */
        regist.setVisible(true);
        this.dispose();  /*   Menutup form login   */
    }

    /*   Method main untuk menjalankan aplikasi   */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new LoginForm().setVisible(true);  /*   Membuat instance LoginForm dan menampilkannya   */
        });
    }

    /* Variabel deklarasi */
    private javax.swing.JLabel BG;  /*   Label untuk background gambar   */
    private javax.swing.JButton BtnLogin;  /*   Tombol login   */
    private javax.swing.JPanel PainComponent;  /*   Panel untuk background gambar   */
    private javax.swing.JLabel TaglineWelcome;  /*   Label teks selamat datang   */
    private javax.swing.JLabel Username;  /*   Label untuk username   */
    private javax.swing.JLabel btnRegister;  /*   Label untuk pendaftaran akun baru   */
    private javax.swing.JPasswordField isiPassword;  /*   Field untuk input password   */
    private javax.swing.JTextField isiUsername;  /*   Field untuk input username   */
    private javax.swing.JLabel password;  /*   Label untuk password   */
    private javax.swing.JLabel registerTxt;  /*   Label untuk teks "Belum punya akun?"   */
}
