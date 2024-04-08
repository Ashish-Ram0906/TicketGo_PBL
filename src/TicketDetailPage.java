import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class TicketDetailPage extends JFrame {

    private JLabel movieLabel;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JLabel snacksLabel;

    public TicketDetailPage() {
        setTitle("Ticket Details");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.LIGHT_GRAY); // Set background color

        // Initialize labels with modern font and styling
        movieLabel = createLabel("Movie:");
        dateLabel = createLabel("Date:");
        timeLabel = createLabel("Time:");
        snacksLabel = createLabel("Snacks:");

        // Add labels to panel with borders and background color
        panel.add(createPanelWithBorderAndBackground("Movie:", movieLabel));
        panel.add(createPanelWithBorderAndBackground("Date:", dateLabel));
        panel.add(createPanelWithBorderAndBackground("Time:", timeLabel));
        panel.add(createPanelWithBorderAndBackground("Snacks:", snacksLabel));

        add(panel);
    }

    // Method to create a JLabel with custom styling
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        return label;
    }

    // Method to create a panel with border and background color
    private JPanel createPanelWithBorderAndBackground(String labelText, JLabel valueLabel) {
        JPanel valuePanel = new JPanel();
        valuePanel.setLayout(new BorderLayout());
        valuePanel.setBorder(new CompoundBorder(new LineBorder(Color.BLACK, 1), new EmptyBorder(5, 5, 5, 5)));
        valuePanel.setBackground(Color.WHITE);
        valueLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        valuePanel.add(valueLabel, BorderLayout.CENTER);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        valuePanel.add(label, BorderLayout.WEST);

        return valuePanel;
    }

    // Method to update ticket details
    public void updateDetails(String movie, String date, String time, String snacks) {
        movieLabel.setText(movie);
        dateLabel.setText( date);
        timeLabel.setText( time);
        snacksLabel.setText(snacks);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicketDetailPage ticketDetailPage = new TicketDetailPage();
            ticketDetailPage.setVisible(true);
        });
    }
}
