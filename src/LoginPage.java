import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginPage() {
        setTitle("Login Page");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create a panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");
        JButton forgotPasswordButton = new JButton("Forgot Password?");

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

        constraints.gridy = 2;
        panel.add(loginButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(signupButton, constraints);

        constraints.gridx = 1;
        panel.add(forgotPasswordButton, constraints);

        // Add the panel to the frame
        add(panel);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Add action listener to the login button
        loginButton.addActionListener((java.awt.event.ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Dummy authentication logic
                if (authenticate(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    // Redirect to the next page or perform other actions
                    openHomePage();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                    // Clear fields or perform other actions if login fails
                }
            }
        });

        // Add action listener to the signup button
        signupButton.addActionListener((java.awt.event.ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openSignupPage(); // Call the method to open the signup page
            }
        });

        // Add action listener to the forgot password button
        forgotPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openForgotPasswordPage(); // Call the method to open the forgot password page
            }
        });
    }

    // Dummy authentication function, replace with your actual authentication logic
    private boolean authenticate(String username, String password) {
        // Replace this with your actual authentication logic (e.g., querying a database)
        return username.equals("admin") && password.equals("password");
    }

    // Method to open the signup page
    private void openSignupPage() {
        SignupPage signupPage = new SignupPage();
        signupPage.setVisible(true);
        dispose(); // Close the login page
    }

    // Method to open the forgot password page
    private void openForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
        forgotPasswordPage.setVisible(true);
        dispose(); // Close the login page
    }

    // Method to open the home page
    
    private void openHomePage() {
        TicketBookingPage ticketBookingPage = new TicketBookingPage();
        HomePage homePage = new HomePage(ticketBookingPage);
        homePage.setVisible(true);
        dispose(); // Close the login page
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginPage loginPage = new LoginPage();
                loginPage.setVisible(true);
            }
        });
    }
}
