package secureloginsystem;

import javax.swing.*;
import java.awt.*;

public class Welcome extends JFrame {
    public Welcome(String name, String regNumber) {
        setTitle("Welcome");
        setSize(500, 300); // Increased size for better spacing
        setLocationRelativeTo(null); // Center the window on the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel setup with a modern background
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Use GridBagLayout for better control
        panel.setBackground(new Color(41, 128, 185)); // Attractive blue background color

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); // Increased padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill the space horizontally

        // Welcome message label
        gbc.gridx = 0; gbc.gridy = 0; // First row for the welcome message
        JLabel welcomeLabel = new JLabel("Welcome, " + name + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Bigger font for the welcome message
        welcomeLabel.setForeground(Color.WHITE); // White text for better contrast
        panel.add(welcomeLabel, gbc);

        // Registration number label
        gbc.gridx = 0; gbc.gridy = 1; // Second row for registration number
        JLabel regNumberLabel = new JLabel("Your Registration Number is: " + regNumber, SwingConstants.CENTER);
        regNumberLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Adjusted font size for the reg number
        regNumberLabel.setForeground(Color.WHITE); // White text for better visibility
        panel.add(regNumberLabel, gbc);

        // Logout button
        gbc.gridx = 0; gbc.gridy = 2; // Third row for logout button
        JButton btnLogout = new JButton("Exit Application");
        btnLogout.setPreferredSize(new Dimension(160, 40)); // Bigger button size
        btnLogout.setBackground(new Color(231, 76, 60)); // Red background for logout button
        btnLogout.setForeground(Color.WHITE); // White text on the button
        btnLogout.setFont(new Font("Arial", Font.BOLD, 16)); // Bold font for the button text
        btnLogout.addActionListener(e -> dispose()); // Close the window when clicked
        panel.add(btnLogout, gbc);

        add(panel);
        setVisible(true); // Show the welcome page
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Welcome("John Doe", "12345"));
    }
}
