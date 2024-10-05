package view.Shared;

import controller.LoginController;
import javax.swing.*;
import java.awt.*;

public class LoginForm extends javax.swing.JFrame {

    public LoginForm() {
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
    }

    private void initComponents() {
        PainComponent = new javax.swing.JPanel();
        BG = new javax.swing.JLabel();
        TaglineWelcome = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        isiUsername = new javax.swing.JTextField();
        BtnLogin = new javax.swing.JButton();
        isiPassword = new javax.swing.JPasswordField();
        registerTxt = new javax.swing.JLabel();
        btnRegister = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        PainComponent.setMaximumSize(new java.awt.Dimension(410, 519));
        PainComponent.setPreferredSize(new java.awt.Dimension(410, 519));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/airplane-flying-cloudy-sky-login.jpg")));
        BG.setMaximumSize(new java.awt.Dimension(410, 519));
        BG.setMinimumSize(new java.awt.Dimension(410, 519));
        BG.setPreferredSize(new java.awt.Dimension(410, 519));

        javax.swing.GroupLayout PainComponentLayout = new javax.swing.GroupLayout(PainComponent);
        PainComponent.setLayout(PainComponentLayout);
        PainComponentLayout.setHorizontalGroup(
            PainComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );
        PainComponentLayout.setVerticalGroup(
            PainComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TaglineWelcome.setFont(new java.awt.Font("Segoe UI", 1, 24));
        TaglineWelcome.setText("WELCOME TO PENS AIRLINES ");

        Username.setFont(new java.awt.Font("Segoe UI", 0, 14));
        Username.setText("Username");

        password.setFont(new java.awt.Font("Segoe UI", 0, 14));
        password.setText("Password");

        BtnLogin.setFont(new java.awt.Font("Segoe UI", 0, 14));
        BtnLogin.setText("Login");
        BtnLogin.addActionListener(this::BtnLoginActionPerformed);

        registerTxt.setText("Belum punya akun?");

        btnRegister.setForeground(new java.awt.Color(102, 153, 255));
        btnRegister.setText("Buat akun");
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PainComponent, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(isiPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(isiUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Username, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(88, 88, 88))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(TaglineWelcome)
                                .addGap(65, 65, 65))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(registerTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegister)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(TaglineWelcome)
                .addGap(65, 65, 65)
                .addComponent(Username)
                .addGap(18, 18, 18)
                .addComponent(isiUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isiPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(BtnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerTxt)
                    .addComponent(btnRegister))
                .addContainerGap(79, Short.MAX_VALUE))
            .addComponent(PainComponent, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        String username = isiUsername.getText();
        String password = new String(isiPassword.getPassword());

        LoginController loginController = new LoginController();
        loginController.login(username, password);
    }

    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {
        RegisterForm regist = new RegisterForm();
        regist.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }

    // Variabel deklarasi
    private javax.swing.JLabel BG;
    private javax.swing.JButton BtnLogin;
    private javax.swing.JPanel PainComponent;
    private javax.swing.JLabel TaglineWelcome;
    private javax.swing.JLabel Username;
    private javax.swing.JLabel btnRegister;
    private javax.swing.JPasswordField isiPassword;
    private javax.swing.JTextField isiUsername;
    private javax.swing.JLabel password;
    private javax.swing.JLabel registerTxt;
}
