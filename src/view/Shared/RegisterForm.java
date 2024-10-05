package view.Shared;

import controller.RegisterController;
import javax.swing.*;
import java.awt.*;

public class RegisterForm extends JFrame {

    public RegisterForm() {
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JLabel paintComponent = new JLabel();
        JLabel registerLabel = new JLabel();
        JLabel usernameLabel = new JLabel();
        JLabel passwordLabel = new JLabel();
        JLabel roleLabel = new JLabel();
        JComboBox<String> roleComboBox = new JComboBox<>(new String[]{"CUSTOMER", "ADMIN"});
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JLabel loginText = new JLabel();
        JLabel loginLink = new JLabel();
        JButton registerButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        paintComponent.setMaximumSize(new Dimension(500, 600));
        paintComponent.setMinimumSize(new Dimension(410, 519));
        paintComponent.setPreferredSize(new Dimension(500, 600));

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

        registerLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        registerLabel.setText("REGISTER HERE!");

        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        usernameLabel.setText("Username");

        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordLabel.setText("Password");

        roleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        roleLabel.setText("Role");

        loginText.setText("Sudah punya akun?");

        loginLink.setForeground(new Color(102, 153, 255));
        loginLink.setText("Login");
        loginLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginLinkMouseClicked(evt);
            }
        });

        registerButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        registerButton.setText("Register");
        registerButton.addActionListener(evt -> registerButtonActionPerformed(evt, usernameField, passwordField, roleComboBox));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(passwordLabel)
                        .addComponent(usernameLabel)
                        .addComponent(roleLabel)
                        .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
                        .addComponent(registerLabel)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(roleComboBox, GroupLayout.Alignment.LEADING, 0, 259, Short.MAX_VALUE)
                            .addComponent(passwordField, GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(loginText)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(loginLink, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                        .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addComponent(registerLabel)
                    .addGap(29, 29, 29)
                    .addComponent(usernameLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(passwordLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(roleLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(roleComboBox, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33)
                    .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(loginText)
                        .addComponent(loginLink))
                    .addGap(54, 54, 54))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void loginLinkMouseClicked(java.awt.event.MouseEvent evt) {
        new LoginForm().setVisible(true);
        this.dispose();
    }

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt, JTextField usernameField, JPasswordField passwordField, JComboBox<String> roleComboBox) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String role = (String) roleComboBox.getSelectedItem();

        RegisterController registerController = new RegisterController();
        boolean success = registerController.register(username, password, role);

        if (success) {
            JOptionPane.showMessageDialog(this, "Registration Successful!");
            new LoginForm().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Registration Failed! Please try again.");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new RegisterForm().setVisible(true));
    }
}
