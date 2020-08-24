package rmit.sept.group4tues1430.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rmit.sept.group4tues1430.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Override
    Iterable<Customer> findAllById(Iterable<Long> iterable);

    public Customer findByName(String name);

    public Customer findByID(String id);

    public Customer findByAddress(String address);

}
