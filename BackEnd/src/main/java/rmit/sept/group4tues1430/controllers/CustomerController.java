package rmit.sept.group4tues1430.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rmit.sept.group4tues1430.model.Customer;
import org.springframework.http.HttpStatus;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

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
//
//    @GetMapping("/{name}")
//    public ResponseEntity<?> getCustomerByName(String name)
//    {
//        Customer customer = customerService.getCustomerByName(name);
//
//        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
//    }
//
//    @GetMapping("/{customer}")
//    public ResponseEntity<?> saveOrUpdateUser(Customer customer)
//    {
//        Customer customer1 = customerService.saveOrUpdateUser(customer);
//        return new ResponseEntity<Customer>(customer1, HttpStatus.OK);
//    }
//
//
//    @GetMapping("/{address}")
//    public ResponseEntity<?> getCustomerByAddress(String address)
//    {
//        Customer customer = customerService.getCustomerByAddress(address);
//
//        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
//    }
}
