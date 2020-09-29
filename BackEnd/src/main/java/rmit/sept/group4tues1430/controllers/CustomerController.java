package rmit.sept.group4tues1430.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rmit.sept.group4tues1430.model.Customer;
import org.springframework.http.HttpStatus;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.services.CustomerService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rmit.sept.group4tues1430.services.MapValidationErrorService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewCustomer(@Valid @RequestBody Customer customer, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap !=null )
        {
            return errorMap;
        }

        Customer customer1 = customerService.saveOrUpdateUser(customer);
        return new ResponseEntity<User>(customer1, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getCustomerByIdentifier(@PathVariable String id)
    {
        Customer customer = customerService.getCustomerByID(id);

        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getCustomerByName(String name)
    {
        Customer customer = customerService.getCustomerByName(name);

        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @GetMapping("/customer/{customer}")
    public ResponseEntity<?> saveOrUpdateUser(Customer customer)
    {
        Customer customer1 = customerService.saveOrUpdateUser(customer);
        return new ResponseEntity<Customer>(customer1, HttpStatus.OK);
    }


    @GetMapping("/address/{address}")
    public ResponseEntity<?> getCustomerByAddress(String address)
    {
        Customer customer = customerService.getCustomerByAddress(address);

        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
}
