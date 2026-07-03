package ooad_booking_assignment_2025;


import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class Registeration_NewUser extends JPanel {

    private static final String CSV_FILE = "User_Data.ftxt";

    public Registeration_NewUser(Camping_Reservation_System) {
        setLayout(null);

        JLabel lblRegister = new JLabel("Register");
        lblRegister.setFont(new Font("Tahoma", Font.BOLD, 36));
        lblRegister.setBounds(400, 20, 300, 50);
        add(lblRegister);

        String[] labels = {"User ID:", "Username:", "Password:", "Name:", "Phone:", "Email:"};
        JTextField[] fields = new JTextField[6];

        int y = 100;
        for (int i = 0; i < labels.length; i++) {
            JLabel lbl = new JLabel(labels[i]);
            lbl.setBounds(250, y, 150, 30);
            lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
            add(lbl);

            fields[i] = (i == 2) ? new JPasswordField() : new JTextField();
            fields[i].setBounds(400, y, 300, 30);
            add(fields[i]);
            y += 50;
        }

        JButton btnSubmit = new JButton("Register");
        btnSubmit.setBounds(400, y, 150, 40);
        add(btnSubmit);

        btnSubmit.addActionListener(e -> {
            try (FileWriter writer = new FileWriter(CSV_FILE, true)) {
                String id = fields[0].getText().trim();
                String username = fields[1].getText().trim();
                String password = fields[2].getText().trim();
                String name = fields[3].getText().trim();
                String phone = fields[4].getText().trim();
                String email = fields[5].getText().trim();

                if (id.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "ID, Username, and Password are required!");
                    return;
                }

                User user = new User(id, username, password, name, phone, email);
                writer.write(user.toCSV() + "\n");

                JOptionPane.showMessageDialog(this, "Registration successful!");
                for (JTextField field : fields) field.setText("");

                app.cardLayout.show(app.mainPanel, "Login");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving user: " + ex.getMessage());
            }
        });
    }
}
