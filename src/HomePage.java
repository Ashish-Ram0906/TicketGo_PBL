import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame {
    private TicketBookingPage ticketBookingPage;
    private String[] movieNames = {"Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5", "Movie 6", "Movie 7", "Movie 8"};
    private String[] eventNames = {"Event 1", "Event 2", "Event 3", "Event 4", "Event 5", "Event 6", "Event 7", "Event 8", "Event 9", "Event 10"};

    public HomePage(TicketBookingPage ticketBookingPage) {
        this.ticketBookingPage = ticketBookingPage;
        setTitle("Home Page - Ticket Booking System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Search panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchPanel.setBackground(Color.BLUE);
        JTextField searchBar = new JTextField();
        searchBar.setPreferredSize(new Dimension(300, 30));
        JButton searchButton = new JButton("Search");
        searchButton.setBackground(Color.BLUE);
        searchButton.setForeground(Color.black);
        searchPanel.add(searchBar);
        searchPanel.add(searchButton);
        mainPanel.add(searchPanel, BorderLayout.NORTH);

        // Movie panel within JScrollPane
        JPanel moviesPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        moviesPanel.setBackground(Color.WHITE);
        moviesPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2), "Movies", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.ORANGE));
        for (String movieName : movieNames) {
            JButton movieButton = new JButton(movieName);
            movieButton.setPreferredSize(new Dimension(120, 150));
            movieButton.setBackground(Color.LIGHT_GRAY);
            movieButton.setForeground(Color.BLACK);
            movieButton.setFont(new Font("Arial", Font.BOLD, 14));
            movieButton.addActionListener(new MovieButtonListener());
            moviesPanel.add(movieButton);
        }
        JScrollPane moviesScrollPane = new JScrollPane(moviesPanel);
        moviesScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(moviesScrollPane, BorderLayout.CENTER);

        // Event panel within JScrollPane
        JPanel eventsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        eventsPanel.setBackground(Color.WHITE);
        eventsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2), "Events", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.BLUE));
        for (String eventName : eventNames) {
            JButton eventButton = new JButton(eventName);
            eventButton.setPreferredSize(new Dimension(150, 30));
            eventButton.setBackground(Color.LIGHT_GRAY);
            eventButton.setForeground(Color.BLACK);
            eventButton.setFont(new Font("Arial", Font.BOLD, 14));
            eventButton.addActionListener(new EventButtonListener());
            eventsPanel.add(eventButton);
        }
        JScrollPane eventsScrollPane = new JScrollPane(eventsPanel);
        eventsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(eventsScrollPane, BorderLayout.SOUTH);

        // Add main panel to the frame
        add(mainPanel);

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }

    class MovieButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton) e.getSource();
            String selectedMovie = sourceButton.getText();
            ticketBookingPage.updateMovieComboBox(selectedMovie, true);
            ticketBookingPage.setVisible(true);
        }
    }

    class EventButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton) e.getSource();
            String selectedEvent = sourceButton.getText();
            ticketBookingPage.updateMovieComboBox(selectedEvent, false);
            ticketBookingPage.setVisible(true);
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