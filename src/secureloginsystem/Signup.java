package secureloginsystem;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Signup extends JDialog {
    private JTextField txtfieldName;
    private JTextField txtfieldUsername;
    private JTextField txtfieldRegNumber;
    private JPasswordField psfieldPassword;
    private JButton btnSignUp;
    private JPanel panel;
    private List<User> users;
    private JButton btnLogin;

    public Signup(JFrame parent) {
        super(parent);
        setTitle("Sign Up");
        setSize(500, 400); // Window size
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Custom window icon removal
        setIconImage(null);

        // Initialize user list
        users = new ArrayList<>();

        // Set panel layout and background
        panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Use GridBagLayout for precise positioning
        panel.setBackground(new Color(240, 248, 255)); // Light blue background color
        setContentPane(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill the space horizontally

        // Custom font for labels and buttons
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 12);

        // Add labels and text fields with custom appearance
        gbc.gridx = 0; gbc.gridy = 0; // First row for name
        JLabel lblName = new JLabel("Student Name:");
        lblName.setFont(labelFont);
        panel.add(lblName, gbc);

        gbc.gridx = 1; // Second column for the text field
        txtfieldName = new JTextField(15);
        txtfieldName.setFont(textFieldFont);
        txtfieldName.setBorder(new LineBorder(Color.GRAY, 1));
        panel.add(txtfieldName, gbc);

        gbc.gridx = 0; gbc.gridy = 1; // Next row for username
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(labelFont);
        panel.add(lblUsername, gbc);

        gbc.gridx = 1; // Second column for the text field
        txtfieldUsername = new JTextField(15);
        txtfieldUsername.setFont(textFieldFont);
        txtfieldUsername.setBorder(new LineBorder(Color.GRAY, 1));
        panel.add(txtfieldUsername, gbc);

        gbc.gridx = 0; gbc.gridy = 2; // Next row for registration number
        JLabel lblRegNumber = new JLabel("Reg Number:");
        lblRegNumber.setFont(labelFont);
        panel.add(lblRegNumber, gbc);

        gbc.gridx = 1; // Second column for the text field
        txtfieldRegNumber = new JTextField(15);
        txtfieldRegNumber.setFont(textFieldFont);
        txtfieldRegNumber.setBorder(new LineBorder(Color.GRAY, 1));
        panel.add(txtfieldRegNumber, gbc);

        gbc.gridx = 0; gbc.gridy = 3; // Next row for password
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(labelFont);
        panel.add(lblPassword, gbc);

        gbc.gridx = 1; // Second column for the text field
        psfieldPassword = new JPasswordField(15);
        psfieldPassword.setFont(textFieldFont);
        psfieldPassword.setBorder(new LineBorder(Color.GRAY, 1));
        panel.add(psfieldPassword, gbc);

        // Customizing buttons
        gbc.gridx = 0; gbc.gridy = 4; // New row for sign-up button
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setPreferredSize(new Dimension(100, 30));
        btnSignUp.setFont(buttonFont);
        btnSignUp.setBackground(new Color(173, 216, 230)); // Light blue button
        btnSignUp.setForeground(Color.BLACK);
        panel.add(btnSignUp, gbc);

        gbc.gridx = 1; // Next column for the login button
        btnLogin = new JButton("Login");
        btnLogin.setPreferredSize(new Dimension(100, 30));
        btnLogin.setFont(buttonFont);
        btnLogin.setBackground(new Color(173, 216, 230)); // Light blue button
        btnLogin.setForeground(Color.BLACK);
        panel.add(btnLogin, gbc);

        // Sign-up button action
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtfieldName.getText().trim();
                String regNumber = txtfieldRegNumber.getText().trim();
                String username = txtfieldUsername.getText().trim();
                String password = new String(psfieldPassword.getPassword()).trim();

                if (name.isEmpty() || regNumber.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    addUser(name, username, regNumber, password);
                }
            }
        });

        // Login button action
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login(Signup.this, users); // Assuming Login is another class
            }
        });

        setVisible(true);
    }

    // Add new user method
    private void addUser(String name, String username, String regNumber, String password) {
        User newUser = new User(name, username, regNumber, password);
        users.add(newUser);

        JOptionPane.showMessageDialog(null, "User registered successfully!");
        clearInputFields();
    }

    // Clear input fields method
    private void clearInputFields() {
        txtfieldName.setText("");
        txtfieldUsername.setText("");
        txtfieldRegNumber.setText("");
        psfieldPassword.setText("");
    }

    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Signup(null));
    }
}