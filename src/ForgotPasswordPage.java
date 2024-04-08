import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ForgotPasswordPage extends JFrame {
    private JTextField usernameOrEmailField;
    private JButton submitButton;

    public ForgotPasswordPage() {
        setTitle("Forgot Password");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create a panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel usernameOrEmailLabel = new JLabel("Username or Email:");
        usernameOrEmailField = new JTextField(20);
        submitButton = new JButton("Submit");

        // Add components to the panel using GridBagConstraints
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(usernameOrEmailLabel, constraints);

        constraints.gridx = 1;
        panel.add(usernameOrEmailField, constraints);

        constraints.gridy = 1;
        panel.add(submitButton, constraints);

        // Add the panel to the frame
        add(panel);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usernameOrEmail = usernameOrEmailField.getText();

                // Dummy logic: display entered username/email
                JOptionPane.showMessageDialog(null, "Entered Username or Email: " + usernameOrEmail);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
                forgotPasswordPage.setVisible(true);
            }
        });
    }
}
