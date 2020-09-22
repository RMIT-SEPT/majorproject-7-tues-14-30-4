package rmit.sept.group4tues1430.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import rmit.sept.group4tues1430.model.Worker;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WorkerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private WorkerRepository workerRepository;

    @Test
    public void findByName_ReturnsWorker_IfWorkerIsPresent() {

        Worker worker = new Worker();
        worker.setName("Worker Bee");
        worker.setUserType("Worker");
        worker.setUserIdentifier("abc123");
        worker.setPassword("password");

        entityManager.persist(worker);
        entityManager.flush();

        Worker workerFound = workerRepository.findByName("Worker Bee");
        assertThat(worker).isEqualTo(workerFound);

    }

    @Test
    public void findByName_ReturnsNull_IfWorkerIsNotPresent() {
        Worker worker = new Worker();
        worker.setName("Worker Bee");
        worker.setUserType("Worker");
        worker.setUserIdentifier("abc123");
        worker.setPassword("password");

        entityManager.persist(worker);
        entityManager.flush();

        Worker workerFound = workerRepository.findByName("Worker Bee 2");
        assertNull("Not found", workerFound);
    }

    @Test
    public void findByName_ReturnsNull_IfNameToSearchIsEmpty() {
        Worker worker = new Worker();
        worker.setName("Worker Bee");
        worker.setUserType("Worker");
        worker.setUserIdentifier("abc123");
        worker.setPassword("password");

        entityManager.persist(worker);
        entityManager.flush();

        Worker workerFound = workerRepository.findByName("");
        assertNull("Not found", workerFound);
    }

    @Test
    public void findAll_ReturnsFullCollection_IfMoreThanOneWorkerPresent() {
        Worker worker = new Worker();
        worker.setName("Worker Bee");
        worker.setUserType("Worker");
        worker.setUserIdentifier("abc123");
        worker.setPassword("password");

        Worker worker2 = new Worker();
        worker2.setName("Worker Bee");
        worker2.setUserType("Worker");
        worker2.setUserIdentifier("abc1234");
        worker2.setPassword("password");

        entityManager.persist(worker);
        entityManager.persist(worker2);
        entityManager.flush();

        Iterable<Worker> allWorkers = workerRepository.findAll();
        int count = 0;
        for (Worker i  : allWorkers) {
            ++count;
        }

        assertEquals("Size of returned collection is not as expected", 2, count);
    }

    @Test
    public void findByUserIdentifier_ReturnsCorrectWorker_IfWorkerIsPresent() {
        Worker worker = new Worker();
        worker.setName("Worker Bee");
        worker.setUserType("Worker");
        worker.setUserIdentifier("abc123");
        worker.setPassword("password");

        entityManager.persist(worker);
        entityManager.flush();

        Worker workerFound = workerRepository.findByUserIdentifier("abc123");
        assertThat(worker).isEqualTo(workerFound);
    }

}
