package rmit.sept.group4tues1430.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rmit.sept.group4tues1430.exceptions.InvalidUserException;
import rmit.sept.group4tues1430.model.Customer;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.repositories.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Customer saveOrUpdateUser(Customer customer) {
        if(customer.getName().isEmpty())
        {
            throw new IllegalArgumentException();
        }
        if(customer.getUserType().isEmpty())
        {
            throw new IllegalArgumentException();
        }

        try {
            customer.setUserIdentifier(customer.getUserIdentifier().toUpperCase());
            customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
            return customerRepository.save(customer);
        } catch (Exception e) {
            throw new InvalidUserException("The Customer Identifier " +
                    customer.getUserIdentifier().toUpperCase() + " already exists.");
        }
    }

    public Customer getCustomerByName(String name) {
        return customerRepository.findByName(name);
    }

    public Customer getCustomerByID(String id) {
        return customerRepository.findByUserIdentifier(id);
    }

    public Customer getCustomerByAddress(String address) {
        return customerRepository.findByAddress(address);
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

}
