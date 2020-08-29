package rmit.sept.group4tues1430.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.sept.group4tues1430.model.Customer;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.repositories.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveOrUpdateUser(Customer customer) {

        return customerRepository.save(customer);
    }

    public Customer getCustomerByName(String name) {
        return customerRepository.findByName(name);
    }

    public Customer getCustomerByID(String id) {
        return customerRepository.findById(id);
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
