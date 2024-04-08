import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class TicketBookingPage extends JFrame implements ActionListener {

    private JComboBox<String> movieComboBox;
    private JDateChooser dateChooser;
    private JComboBox<String> timeComboBox;
    private JComboBox<String> snacksComboBox;
    private JButton selectSeatsButton;
    private JButton bookTicketButton;

    private TicketDetailPage ticketDetailPage; // Reference to ticket detail page

    public TicketBookingPage() {
        setTitle("Ticket Booking Page");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Movie Selection
        JLabel movieLabel = new JLabel("Select Movie:");
        String[] movieOptions = {"Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5", "Movie 6", "Movie 7", "Movie 8", "Event 1", "Event 2", "Event 3", "Event 4", "Event 5", "Event 6", "Event 7", "Event 8", "Event 9", "Event 10"};
        movieComboBox = new JComboBox<>(movieOptions);
        movieComboBox.addActionListener(this); // Add action listener
        formPanel.add(movieLabel);
        formPanel.add(movieComboBox);

        // Date Selection
        JLabel dateLabel = new JLabel("Select Date:");
        dateChooser = new JDateChooser();
        formPanel.add(dateLabel);
        formPanel.add(dateChooser);

        // Time Selection
        JLabel timeLabel = new JLabel("Select Time:");
        timeComboBox = new JComboBox<>(new String[]{"Time 1", "Time 2", "Time 3"});
        formPanel.add(timeLabel);
        formPanel.add(timeComboBox);

        // Snacks Option
        JLabel snacksLabel = new JLabel("Select Snack:");
        snacksComboBox = new JComboBox<>(new String[]{"Popcorn", "Vada Pav", "Samosa", "Chips", "Biscuits", });
        formPanel.add(snacksLabel);
        formPanel.add(snacksComboBox);

        // Button to select seats
        selectSeatsButton = new JButton("Select Seats");
        selectSeatsButton.addActionListener(this);
        selectSeatsButton.setBackground(new Color(255, 165, 0));
        selectSeatsButton.setForeground(Color.DARK_GRAY);
        formPanel.add(selectSeatsButton);
        formPanel.add(new JLabel()); // Placeholder

        // Button to book ticket
        bookTicketButton = new JButton("Confirm Ticket");
        bookTicketButton.addActionListener(this);
        bookTicketButton.setBackground(new Color(50, 205, 50));
        bookTicketButton.setForeground(Color.DARK_GRAY);
        formPanel.add(bookTicketButton);
        formPanel.add(new JLabel()); // Placeholder

        add(formPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectSeatsButton) {
            SelectSeatPage selectSeatPage = new SelectSeatPage(this);
            selectSeatPage.setVisible(true);
        } else if (e.getSource() == bookTicketButton) {
            // Code to process the booking
            JOptionPane.showMessageDialog(this, "Confirming ticket...");
            
            // Create an instance of TicketDetailPage
            TicketDetailPage ticketDetailPage = new TicketDetailPage();
            
            // Update details on TicketDetailPage
            String selectedItem = (String) movieComboBox.getSelectedItem();
            String selectedDate = dateChooser.getDate().toString(); // Example: Fetch date from JDateChooser
            String selectedTime = (String) timeComboBox.getSelectedItem();
            String selectedSnack = (String) snacksComboBox.getSelectedItem();
            
            ticketDetailPage.updateDetails(selectedItem, selectedDate, selectedTime, selectedSnack);
            
            // Show TicketDetailPage
            ticketDetailPage.setVisible(true);
        } else if (e.getSource() == movieComboBox) {
            String selectedItem = (String) movieComboBox.getSelectedItem();
            // Update the ticket detail page with the selected movie or event
        }
    }

    public void updateSelectSeatButton(String selectedSeat) {
        selectSeatsButton.setText("Selected Seat: " + selectedSeat);
    }

    public void setTicketDetailPage(TicketDetailPage ticketDetailPage) {
        this.ticketDetailPage = ticketDetailPage;
    }

    public void updateMovieComboBox(String selectedItem, boolean isMovie) {
        if (isMovie) {
            for (int i = 0; i < movieComboBox.getItemCount(); i++) {
                if (movieComboBox.getItemAt(i).equals(selectedItem)) {
                    movieComboBox.setSelectedIndex(i);
                    return;
                }
            }
        } else {
            for (int i = 0; i < movieComboBox.getItemCount(); i++) {
                if (movieComboBox.getItemAt(i).equals(selectedItem)) {
                    movieComboBox.setSelectedIndex(i);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            TicketBookingPage ticketBookingPage = new TicketBookingPage();
            HomePage homePage = new HomePage(ticketBookingPage);
            homePage.setVisible(true);
        });
    }
}