package com.freshfold;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class LoginForm extends JFrame {

    private static final String DB_URL = "jdbc:mysql://localhost:3307/laundritify";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    private JLabel lblTitle;
    private JLabel lblUser;
    private JLabel lblPass;
    private JTextField txtUname;
    private JPasswordField txtPass;
    private JButton btnSubmit;

    public LoginForm() {
        buildUI();
        setLocationRelativeTo(null);
    }

    private void buildUI() {
        setTitle("Login");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        lblTitle = new JLabel("LOGIN");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblUser = new JLabel("Username");
        lblPass = new JLabel("Password");
        txtUname = new JTextField(15);
        txtPass = new JPasswordField(15);
        btnSubmit = new JButton("SUBMIT");

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 10, 8, 10);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        add(lblTitle, c);

        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0;
        c.gridy = 1;
        add(lblUser, c);
        c.gridx = 1;
        add(txtUname, c);

        c.gridx = 0;
        c.gridy = 2;
        add(lblPass, c);
        c.gridx = 1;
        add(txtPass, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        add(btnSubmit, c);

        btnSubmit.addActionListener(e -> prosesLogin());
        getRootPane().setDefaultButton(btnSubmit); // tekan Enter = klik SUBMIT

        pack();
    }

    private void prosesLogin() {
        String username = txtUname.getText().trim();
        String password = new String(txtPass.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username dan Password wajib diisi!");
            return;
        }

        String sql = "SELECT * FROM pengguna WHERE username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Login Berhasil! Selamat Datang, " + username);
                    // Pindah ke form lain, contoh:
                    // new MenuUtama().setVisible(true);
                    // this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Username atau Password salah!");
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Koneksi database gagal: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }

        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}