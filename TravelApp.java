 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.List;

public class TravelApp {
    private static TravelService service = new TravelService();
    private static Customer customer = new Customer("C001", "John Doe");

    public static void main(String[] args) {
        JFrame frame = new JFrame("Travel Booking System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnSearchFlights = new JButton("Search Flights");
        JButton btnSearchHotels = new JButton("Search Hotels");
        JButton btnMyBookings = new JButton("View My Bookings");
        JButton btnExit = new JButton("Exit");

        btnSearchFlights.addActionListener(e -> searchFlightsUI());
        btnSearchHotels.addActionListener(e -> searchHotelsUI());
        btnMyBookings.addActionListener(e -> viewBookingsUI());
        btnExit.addActionListener(e -> System.exit(0));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(btnSearchFlights);
        panel.add(btnSearchHotels);
        panel.add(btnMyBookings);
        panel.add(btnExit);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void searchFlightsUI() {
        String dep = JOptionPane.showInputDialog("Enter Departure City:");
        String arr = JOptionPane.showInputDialog("Enter Arrival City:");
        String dateStr = JOptionPane.showInputDialog("Enter Departure Date (yyyy-MM-dd):");

        try {
            LocalDate date = LocalDate.parse(dateStr);
            List<Flight> flights = service.searchFlights(dep, arr, date);
            if (flights.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No flights found.");
                return;
            }
            Flight selected = (Flight) JOptionPane.showInputDialog(null, "Select a flight:",
                    "Flights", JOptionPane.QUESTION_MESSAGE, null,
                    flights.toArray(), flights.get(0));
            if (selected != null) {
                String numStr = JOptionPane.showInputDialog("Enter number of passengers:");
                int num = Integer.parseInt(numStr);
                Booking b = service.bookFlight(customer, selected, num);
                if (b != null) {
                    JOptionPane.showMessageDialog(null, "Flight booked!\n" + b);
                } else {
                    JOptionPane.showMessageDialog(null, "Not enough seats.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input.");
        }
    }

    private static void searchHotelsUI() {
        String city = JOptionPane.showInputDialog("Enter Hotel City:");
        List<Hotel> hotels = service.searchHotels(city);
        if (hotels.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hotels found.");
            return;
        }
        Hotel selected = (Hotel) JOptionPane.showInputDialog(null, "Select a hotel:",
                "Hotels", JOptionPane.QUESTION_MESSAGE, null,
                hotels.toArray(), hotels.get(0));
        if (selected != null) {
            try {
                LocalDate checkIn = LocalDate.parse(JOptionPane.showInputDialog("Enter Check-In Date (yyyy-MM-dd):"));
                LocalDate checkOut = LocalDate.parse(JOptionPane.showInputDialog("Enter Check-Out Date (yyyy-MM-dd):"));
                int guests = Integer.parseInt(JOptionPane.showInputDialog("Enter number of guests:"));
                Booking b = service.bookHotel(customer, selected, checkIn, checkOut, guests);
                if (b != null) {
                    JOptionPane.showMessageDialog(null, "Hotel booked!\n" + b);
                } else {
                    JOptionPane.showMessageDialog(null, "Not enough rooms.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid input.");
            }
        }
    }

    private static void viewBookingsUI() {
        List<Booking> bookings = service.getBookings(customer);
        if (bookings.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No bookings found.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Booking b : bookings) {
                sb.append(b).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}