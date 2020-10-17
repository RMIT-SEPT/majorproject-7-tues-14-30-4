package rmit.sept.group4tues1430.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.sept.group4tues1430.model.Booking;
import rmit.sept.group4tues1430.repositories.BookingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking addBooking(Booking booking) { return bookingRepository.save(booking); }

    public Iterable<Booking> findAllBookings() { return bookingRepository.findAll(); }

    public Booking findBookingByID(String id) { return bookingRepository.findBookingById(id); }

    public Booking findBookingByServiceName(String name) { return bookingRepository.findBookingByServiceName(name); }

    public List<Booking> getAllBookings()
    {
        List<Booking> bookings = new ArrayList<Booking>();
        bookingRepository.findAll().forEach(bookings::add);
        return bookings;
    }

    public List<Booking> getBookingsByCustomerIdentifier(String customerID) {
        List<Booking> bookings = new ArrayList<Booking>();
        bookingRepository.findBookingsByCustomerUserIdentifier(customerID).forEach(bookings::add);
        return bookings;
    }

    public List<Booking> getBookingsByWorkerIdentifier(String workerID) {
        List<Booking> bookings = new ArrayList<Booking>();
        Iterable<Booking> allBookingsForWorker = bookingRepository.findBookingsByWorkerUserIdentifier(workerID);
        for (Booking booking : allBookingsForWorker) {
            if (booking.getCustomerUserIdentifier() != null) {
                bookings.add(booking);
            }
        }
        return bookings;
    }

    public List<Booking> getAvailableBookings(String serviceName) {
        List<Booking> bookings = new ArrayList<Booking>();
        Iterable<Booking> allBookings = bookingRepository.findBookingsByServiceName(serviceName);
        for (Booking booking : allBookings) {
            if (booking.getCustomerUserIdentifier() == null) {
                bookings.add(booking);
            }
        }
        return bookings;
    }
}
