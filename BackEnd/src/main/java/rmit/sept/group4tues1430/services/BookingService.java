package rmit.sept.group4tues1430.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.sept.group4tues1430.model.Booking;
import rmit.sept.group4tues1430.model.BusinessService;
import rmit.sept.group4tues1430.model.Customer;
import rmit.sept.group4tues1430.model.Worker;
import rmit.sept.group4tues1430.repositories.BookingRespository;

import java.util.Date;

@Service
public class BookingService {
    @Autowired
    private BookingRespository bookingRespository;

    public Customer getCustomer()
    {
        return bookingRespository.getCustomer();
    }

    public Worker getWorker()
    {
        return bookingRespository.getWorker();
    }

    public Date getDate()
    {
        return bookingRespository.getDate();
    }

    public BusinessService getService()
    {
        return bookingRespository.getService();
    }

    public Booking addBooking(Booking booking) { return bookingRespository.save(booking); }

}
