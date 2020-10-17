package rmit.sept.group4tues1430.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rmit.sept.group4tues1430.model.*;
import rmit.sept.group4tues1430.services.BookingService;
import rmit.sept.group4tues1430.services.MapValidationErrorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin("*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewBooking(@Valid @RequestBody Booking booking, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null)
        {
            return errorMap;
        }

        Booking booking1 = bookingService.addBooking(booking);
        return new ResponseEntity<Booking>(booking1, HttpStatus.CREATED);
    }

    @GetMapping("/allBookings")
    public Iterable<Booking> findAllBookings()
    {
        return bookingService.findAllBookings();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getBookingByID(@PathVariable String id)
    {
        Booking booking = bookingService.findBookingByID(id);

        return new ResponseEntity<Booking>(booking, HttpStatus.OK);
    }

    @GetMapping("/unavailableBookings/customerIdentifier/{customerID}")
    public List<Booking> getBookingsByCustomerIdentifier(@PathVariable String customerID) {
        return bookingService.getBookingsByCustomerIdentifier(customerID);
    }

    @GetMapping("/unavailableBookings/workerIdentifier/{workerID}")
    public List<Booking> getBookingsByWorkerIdentifier(@PathVariable String workerID) {
        return bookingService.getBookingsByWorkerIdentifier(workerID);
    }

    @GetMapping("/availableBookings/serviceName/{serviceName}")
    public List<Booking> getAvailableBookingsByServiceName(@PathVariable String serviceName) {
        return bookingService.getAvailableBookings(serviceName);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getBookingByServiceName(@PathVariable String name)
    {
        Booking booking = bookingService.findBookingByServiceName(name);

        return new ResponseEntity<Booking>(booking, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

}
