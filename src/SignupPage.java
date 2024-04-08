import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextField emailField;
    private JButton signupButton;

    public SignupPage() {
        setTitle("Sign Up Page");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create a panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        JLabel emailLabel = new JLabel("Email:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        confirmPasswordField = new JPasswordField(20);
        emailField = new JTextField(20);
        signupButton = new JButton("Sign Up");

        // Add components to the panel using GridBagConstraints
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(usernameLabel, constraints);

        constraints.gridx = 1;
        panel.add(usernameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(passwordLabel, constraints);

        constraints.gridx = 1;
        panel.add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(confirmPasswordLabel, constraints);

        constraints.gridx = 1;
        panel.add(confirmPasswordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(emailLabel, constraints);

        constraints.gridx = 1;
        panel.add(emailField, constraints);

        constraints.gridy = 4;
        panel.add(signupButton, constraints);

        // Add the panel to the frame
        add(panel);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Add action listener to the signup button
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                String email = emailField.getText();

                // Dummy signup logic (you can replace this with your actual signup logic)
                // For demonstration purposes, we'll just display the entered information
                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Username: " + username + "\nPassword: " + password + "\nEmail: " + email);
                }
            }
        });
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(new Runnable() {
    //         public void run() {
    //             SignupPage signupPage = new SignupPage();
    //             signupPage.setVisible(true);
    //         }
    //     });
    // }
}
