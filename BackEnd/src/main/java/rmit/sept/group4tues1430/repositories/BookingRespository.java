package rmit.sept.group4tues1430.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rmit.sept.group4tues1430.model.Booking;
import rmit.sept.group4tues1430.model.BusinessService;
import rmit.sept.group4tues1430.model.Customer;
import rmit.sept.group4tues1430.model.Worker;

import java.util.Date;

@Repository
public interface BookingRespository extends CrudRepository<Booking, Long>
{
    public Customer getCustomer();

    public Worker getWorker();

    public Date getDate();

    public BusinessService getService();
}
