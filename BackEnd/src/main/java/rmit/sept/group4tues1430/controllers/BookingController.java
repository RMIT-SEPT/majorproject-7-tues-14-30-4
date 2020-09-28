package rmit.sept.group4tues1430.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rmit.sept.group4tues1430.model.*;
import rmit.sept.group4tues1430.services.BookingService;
import rmit.sept.group4tues1430.services.MapValidationErrorService;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;
import java.util.Date;
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
        if(errorMap !=null)
        {
            return errorMap;
        }

        Booking booking1 = bookingService.addBooking(booking);
        return new ResponseEntity<Booking>(booking1, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getCustomer()
    {
        Customer customer = bookingService.getCustomer();
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getWorker()
    {
        Worker worker = bookingService.getWorker();
        return new ResponseEntity<Worker>(worker, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getDate()
    {
        Date date = bookingService.getDate();
        return new ResponseEntity<Date>(date, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getService()
    {
        BusinessService businessService = bookingService.getService();
        return new ResponseEntity<BusinessService>(businessService, HttpStatus.OK);
    }
}
