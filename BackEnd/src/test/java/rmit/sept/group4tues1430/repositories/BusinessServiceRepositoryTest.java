package rmit.sept.group4tues1430.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import rmit.sept.group4tues1430.model.BusinessService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BusinessServiceRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BusinessServiceRepository businessServiceRepository;

    @Test
    public void findByName_ReturnsBusinessService_IfBusinessIsPresent() {

        BusinessService service = new BusinessService();
        service.setName("Hairdresser");

        entityManager.persist(service);
        entityManager.flush();

        BusinessService serviceFound = businessServiceRepository.findByName("Hairdresser");

        assertThat(service).isEqualTo(serviceFound);

    }

    @Test
    public void findByName_ReturnsNull_IfBusinessIsNotPresent() {
        BusinessService service = new BusinessService();
        service.setName("Hairdresser");

        entityManager.persist(service);
        entityManager.flush();

        BusinessService serviceFound = businessServiceRepository.findByName("Dentist");
        assertNull("Not found", serviceFound);
    }

    @Test
    public void findByName_ReturnsNull_IfNameToSearchIsEmpty() {
        BusinessService service = new BusinessService();
        service.setName("Hairdresser");
        entityManager.persist(service);
        entityManager.flush();

        BusinessService serviceFound = businessServiceRepository.findByName("");
        assertNull("Not found", serviceFound);
    }

    @Test
    public void findAll_ReturnsFullCollection_IfMoreThanOneBusinessServicePresent() {
        BusinessService service = new BusinessService();
        service.setName("Hairdresser");
        BusinessService service1 = new BusinessService();
        service1.setName("Dentist");
        entityManager.persist(service);
        entityManager.persist(service1);
        entityManager.flush();

        Iterable<BusinessService> allBusinessServices = businessServiceRepository.findAll();
        int count = 0;
        for (BusinessService i  : allBusinessServices) {
            ++count;
        }

        assertEquals("Size of returned collection is not as expected", 2, count);
    }
//  Test findById()?



}
