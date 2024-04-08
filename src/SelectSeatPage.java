import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class SelectSeatPage extends JFrame implements ActionListener {

    private JButton[][] seatButtons;
    private JTextField selectedSeatField;
    private JButton confirmSeatButton;
    private TicketBookingPage ticketBookingPage;

    public SelectSeatPage(TicketBookingPage ticketBookingPage) {
        this.ticketBookingPage = ticketBookingPage;
        setTitle("Select Seat Page");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(ticketBookingPage);
        setLayout(new BorderLayout());

        JPanel seatPanel = new JPanel(new GridLayout(6, 10, 5, 5));
        seatPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        seatButtons = new JButton[6][10];

        // Create seat buttons
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                seatButtons[i][j] = new JButton((i * 10 + j + 1) + "");
                seatButtons[i][j].setBackground(Color.WHITE);
                seatButtons[i][j].setOpaque(true);
                seatButtons[i][j].setBorderPainted(false);
                seatButtons[i][j].addActionListener(this);
                seatPanel.add(seatButtons[i][j]);
            }
        }

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        selectedSeatField = new JTextField(5);
        confirmSeatButton = new JButton("Confirm Seat");
        confirmSeatButton.addActionListener(this);
        inputPanel.add(new JLabel("Selected Seat: "));
        inputPanel.add(selectedSeatField);
        inputPanel.add(confirmSeatButton);

        add(seatPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                if (e.getSource() == seatButtons[i][j]) {
                    selectedSeatField.setText((i * 10 + j + 1) + "");
                }
            }
        }

        if (e.getSource() == confirmSeatButton) {
            String selectedSeat = selectedSeatField.getText();
            ticketBookingPage.updateSelectSeatButton(selectedSeat); // Update select seat button in TicketBookingPage
            dispose(); // Close the SelectSeatPage
        }
    }
}
