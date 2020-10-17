package rmit.sept.group4tues1430.repositories;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import rmit.sept.group4tues1430.model.Booking;
import static org.springframework.test.util.AssertionErrors.assertNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookingRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    public void findByCustomerUserIdentifier_ReturnsOneBooking_IfOneBookingIsPresent() {

        Booking booking = new Booking();
        booking.setCustomerUserIdentifier("CUSTOMER");

        entityManager.persist(booking);
        entityManager.flush();

        Iterable<Booking> bookingsFound = bookingRepository.findBookingsByCustomerUserIdentifier("CUSTOMER");

        int count = 0;
        for (Booking i  : bookingsFound) {
            ++count;
        }

        assertEquals("Size of returned collection is not as expected", 1, count);
    }

    @Test
    public void findByWorkerUserIdentifier_ReturnsOneBooking_IfOneBookingIsPresent() {

        Booking booking = new Booking();
        booking.setWorkerUserIdentifier("WORKER");

        entityManager.persist(booking);
        entityManager.flush();

        Iterable<Booking> bookingsFound = bookingRepository.findBookingsByWorkerUserIdentifier("WORKER");

        int count = 0;
        for (Booking i  : bookingsFound) {
            ++count;
        }

        assertEquals("Size of returned collection is not as expected", 1, count);
    }


    @Test
    public void findBookingByServiceName_ReturnsNull_IfServiceNotPresent() {
        Booking booking = new Booking();
        booking.setServiceName("Hairdresser");

        entityManager.persist(booking);
        entityManager.flush();

        Booking bookingFound = bookingRepository.findBookingByServiceName("Dentist");
        assertNull("Not found", bookingFound);
    }

    @Test
    public void findBookingsByServiceName_ReturnsEmptyCollection_IfServiceIsNotPresent() {
        Booking booking = new Booking();
        booking.setServiceName("Hairdresser");

        entityManager.persist(booking);
        entityManager.flush();

        Iterable<Booking> bookingsFound = bookingRepository.findBookingsByServiceName("Dentist");
        int count = 0;
        for (Booking i  : bookingsFound) {
            ++count;
        }

        assertEquals("Size of returned collection is not as expected", 0, count);
    }

    @Test
    public void findAll_ReturnsFullCollection_IfMoreThanOneBookingIsPresent() {
        Booking booking = new Booking();
        booking.setServiceName("Hairdresser");
        Booking booking1 = new Booking();
        booking1.setServiceName("Dentist");
        entityManager.persist(booking);
        entityManager.persist(booking1);
        entityManager.flush();

        Iterable<Booking> allBookings = bookingRepository.findAll();
        int count = 0;
        for (Booking i  : allBookings) {
            ++count;
        }

        assertEquals("Size of returned collection is not as expected", 2, count);
    }

}

