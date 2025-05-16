 
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class TravelService {
    private List<Flight> flights = new ArrayList<>();
    private List<Hotel> hotels = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public TravelService() {
        flights.add(new Flight("FL101", "New York", "London",
                LocalDateTime.of(2025, 6, 1, 10, 0),
                LocalDateTime.of(2025, 6, 1, 22, 0),
                800, 5));
        hotels.add(new Hotel("H101", "The Grand Hotel", "London",
                "123 London Street", 150, 10));
    }

    public List<Flight> searchFlights(String departure, String arrival, LocalDate date) {
        List<Flight> results = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getDepartureCity().equalsIgnoreCase(departure)
                    && f.getArrivalCity().equalsIgnoreCase(arrival)
                    && f.getDepartureDateTime().toLocalDate().equals(date)) {
                results.add(f);
            }
        }
        return results;
    }

    public List<Hotel> searchHotels(String city) {
        List<Hotel> results = new ArrayList<>();
        for (Hotel h : hotels) {
            if (h.getCity().equalsIgnoreCase(city)) {
                results.add(h);
            }
        }
        return results;
    }

    public Booking bookFlight(Customer c, Flight f, int passengers) {
        if (f.getAvailableSeats() >= passengers) {
            f.setAvailableSeats(f.getAvailableSeats() - passengers);
            Booking b = new Booking(c, f, null, null, null, passengers);
            bookings.add(b);
            return b;
        }
        return null;
    }

    public Booking bookHotel(Customer c, Hotel h, LocalDate checkIn, LocalDate checkOut, int guests) {
        if (h.getAvailableRooms() >= 1) {
            h.setAvailableRooms(h.getAvailableRooms() - 1);
            Booking b = new Booking(c, null, h, checkIn, checkOut, guests);
            bookings.add(b);
            return b;
        }
        return null;
    }

    public List<Booking> getBookings(Customer c) {
        List<Booking> result = new ArrayList<>();
        for (Booking b : bookings) {
            if (b.getCustomer().getCustomerId().equals(c.getCustomerId())) {
                result.add(b);
            }
        }
        return result;
    }
}