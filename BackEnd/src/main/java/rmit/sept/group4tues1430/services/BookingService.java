package rmit.sept.group4tues1430.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.sept.group4tues1430.model.Booking;
import rmit.sept.group4tues1430.model.BusinessService;
import rmit.sept.group4tues1430.model.Customer;
import rmit.sept.group4tues1430.model.Worker;
import rmit.sept.group4tues1430.repositories.BookingRespository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRespository bookingRespository;


    public Booking addBooking(Booking booking) { return bookingRespository.save(booking); }

    public Iterable<Booking> findAllBookings() { return bookingRespository.findAll(); }

    public Booking findBookingByID(String id) { return bookingRespository.findBookingByIdentifier(id); }

    public Booking findBookingByServiceName(String name) { return bookingRespository.findBookingByServiceName(name); }

    public List<Booking> getAllBookings()
    {
        List<Booking> bookings = new ArrayList<Booking>();
        bookingRespository.findAll().forEach(bookings::add);
        return bookings;
    }
}
