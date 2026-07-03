package ooad_booking_assignment_2025;


import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.util.HashMap;

public class Camping_Reservation_System {

    public JFrame frame;
    public JLayeredPane layeredPane;
    public CardLayout cardLayout;

    public HashMap<String, String> users = new HashMap<>();
    public viewbooking viewBookingPanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Camping_Reservation_System window = new Camping_Reservation_System();
                window.frame.setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public Camping_Reservation_System() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Camping Reservation System");
        frame.setBounds(100, 100, 1341, 853);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblHeader = new JLabel();
        lblHeader.setIcon(new ImageIcon("C:\\Users\\Intel\\Pictures\\Saved Pictures\\Add a subheading.png"));
        lblHeader.setBounds(0, 10, 1328, 244);
        frame.getContentPane().add(lblHeader);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(225, 264, 1102, 542);
        cardLayout = new CardLayout();
        layeredPane.setLayout(cardLayout);
        frame.getContentPane().add(layeredPane);

        // ✅ Add panels with updated names
        layeredPane.add(new LoginPanel(this), "User_Login_System");
        layeredPane.add(new RegisterPanel(this), "Registered_NewUser");
        layeredPane.add(new BookingPanel(this), "Booking");
        layeredPane.add(new AdminPanel(), "Administrator_site");

        viewBookingPanel = new viewbooking();
        layeredPane.add(viewBookingPanel, "ViewBooking");

        // ✅ Buttons to switch between panels using updated names
        JButton btnLogin = new JButton("Log In");
        btnLogin.setBounds(41, 352, 157, 50);
        btnLogin.addActionListener(e -> cardLayout.show(layeredPane, "User_Login_System"));
        frame.getContentPane().add(btnLogin);

        JButton btnRegister = new JButton("Register Account");
        btnRegister.setBounds(41, 435, 157, 50);
        btnRegister.addActionListener(e -> cardLayout.show(layeredPane, "Registered_NewUser"));
        frame.getContentPane().add(btnRegister);

        JButton btnAdmin = new JButton("Administrator");
        btnAdmin.setBounds(41, 533, 157, 44);
        btnAdmin.addActionListener(e -> cardLayout.show(layeredPane, "Administrator_site"));
        frame.getContentPane().add(btnAdmin);

        JButton btnViewBooking = new JButton("View Booking");
        btnViewBooking.setBounds(41, 600, 157, 44);
        btnViewBooking.addActionListener(e -> cardLayout.show(layeredPane, "ViewBooking"));
        frame.getContentPane().add(btnViewBooking);
    }
}

