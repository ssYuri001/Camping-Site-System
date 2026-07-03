package ooad_booking_assignment_2025;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginPanel extends JPanel {

    private static final String CSV_FILE = "User_Data.ftxt";

    public LoginPanel(Camping_Reservation_System) {
        setLayout(null);

        JLabel lblLogin = new JLabel("Log In");
        lblLogin.setFont(new Font("Tahoma", Font.BOLD, 36));
        lblLogin.setBounds(400, 20, 300, 50);
        add(lblLogin);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUsername.setBounds(250, 150, 150, 30);
        add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(400, 150, 300, 30);
        add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPassword.setBounds(250, 200, 150, 30);
        add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(400, 200, 300, 30);
        add(txtPassword);

        JButton btnLogin = new JButton("Log In");
        btnLogin.setBounds(400, 260, 150, 40);
        add(btnLogin);

        JButton btnGoRegister = new JButton("Register Instead");
        btnGoRegister.setBounds(560, 260, 150, 40);
        add(btnGoRegister);

        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText().trim();
            String password = new String(txtPassword.getPassword()).trim();

            boolean found = false;

            try (Scanner scanner = new Scanner(new File(CSV_FILE))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] data = line.split(",");
                    if (data.length >= 3 && data[1].equals(username) && data[2].equals(password)) {
                        JOptionPane.showMessageDialog(this,
                                "Login Successful!\nWelcome " + data[3] + " (ID: " + data[0] + ")");
                        found = true;
                        break;
                    }
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Users file not found.");
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Invalid credentials.");
            }

            txtUsername.setText("");
            txtPassword.setText("");
        });

        btnGoRegister.addActionListener(e -> app.cardLayout.show(app.mainPanel, "Register"));
    }
}
