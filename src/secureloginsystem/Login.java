package secureloginsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Login extends JDialog {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private List<User> users;

    public Login(Signup parent, List<User> users) {
        super(parent);
        this.users = users;
        setTitle("Login");
        setSize(400, 250); // Increased window size for a better layout
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Panel setup with a modern blue background
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Use GridBagLayout for better control
        panel.setBackground(new Color(52, 152, 219)); // Attractive blue color for the background
        setContentPane(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components for more space
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill the space horizontally

        // Username Label
        gbc.gridx = 0; gbc.gridy = 0; // First row for username
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(Color.WHITE); // Set text color to white for contrast
        panel.add(lblUsername, gbc);

        // Username Field
        gbc.gridx = 1; // Second column for the text field
        txtUsername = new JTextField(15); // Increase the size of the text field
        txtUsername.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2)); // Add a border around the field
        panel.add(txtUsername, gbc);

        // Password Label
        gbc.gridx = 0; gbc.gridy = 1; // Next row for password
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.WHITE); // Set text color to white for contrast
        panel.add(lblPassword, gbc);

        // Password Field
        gbc.gridx = 1; // Second column for the text field
        txtPassword = new JPasswordField(15); // Increase the size of the password field
        txtPassword.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2)); // Add a border around the field
        panel.add(txtPassword, gbc);

        // Login Button
        gbc.gridx = 0; gbc.gridy = 2; // New row for login button
        btnLogin = new JButton("Login");
        btnLogin.setPreferredSize(new Dimension(100, 30)); // Set button size
        btnLogin.setBackground(new Color(46, 204, 113)); // Set green background color for login
        btnLogin.setForeground(Color.WHITE); // Set text color to white
        panel.add(btnLogin, gbc);

        // Cancel Button
        gbc.gridx = 1; // Next column for cancel button
        btnCancel = new JButton("Cancel");
        btnCancel.setPreferredSize(new Dimension(100, 30)); // Set button size
        btnCancel.setBackground(new Color(231, 76, 60)); // Set red background color for cancel
        btnCancel.setForeground(Color.WHITE); // Set text color to white
        panel.add(btnCancel, gbc);

        // Button action for login
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText().trim();
                String password = new String(txtPassword.getPassword()).trim();
                if (login(username, password)) {
                    dispose();
                } else {
                    // Message box for invalid login
                    JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Button action for cancel
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog
            }
        });

        setVisible(true);
    }

    private boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                new Welcome(user.getName(), user.getRegNumber());
                return true;
            }
        }
        return false; // User not found
    }

    public static void main(String[] args) {
        // For testing purposes
        SwingUtilities.invokeLater(() -> {
            new Login(null, List.of(new User("test", "testUser", "12345", "password")));
        });
    }
}
