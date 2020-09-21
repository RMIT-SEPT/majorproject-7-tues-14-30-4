package rmit.sept.group4tues1430.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import rmit.sept.group4tues1430.model.Admin;
import rmit.sept.group4tues1430.model.Customer;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void findByName_ReturnsNull_IfCustomerIsNotPresent() {
        Customer customer = new Customer();
        customer.setName("Jane Smith");
        customer.setUserType("Customer");
        customer.setUserIdentifier("abc123");
        customer.setPassword("password");

        entityManager.persist(customer);
        entityManager.flush();

        Customer customerFound = customerRepository.findByName("John Smith");
        assertNull("Not found", customerFound);
    }

    @Test
    public void findByName_ReturnsNull_IfNameToSearchIsEmpty() {
        Customer customer = new Customer();
        customer.setName("Tim Smith");
        customer.setUserType("Customer");
        customer.setUserIdentifier("abc123");
        customer.setPassword("password");

        entityManager.persist(customer);
        entityManager.flush();

        Customer customerFound = customerRepository.findByName("");
        assertNull("Not found", customerFound);
    }

    @Test
    public void findByName_ReturnsCustomer_IfCustomerIsPresentInSystem() {
        Customer customer = new Customer();
        customer.setName("Timmy Smith");
        customer.setUserType("Customer");
        customer.setUserIdentifier("abc123");
        customer.setPassword("password");

        entityManager.persist(customer);
        entityManager.flush();

        Customer customerFound = customerRepository.findByName("Timmy Smith");
        //assertThat(customerFound.getName()).isEqualTo(customer.getName());
        assertThat(customer).isEqualTo(customerFound);
    }

    @Test
    public void findByUserIdentifier_ReturnsCustomer_IfCustomerIsPresentInSystem() {
        Customer customer = new Customer();
        customer.setName("Some name");
        customer.setUserType("Customer");
        customer.setUserIdentifier("abc123");
        customer.setPassword("password");

        entityManager.persist(customer);
        entityManager.flush();

        Customer customerFound = customerRepository.findByUserIdentifier("abc123");
        assertThat(customer).isEqualTo(customerFound);
    }

}
