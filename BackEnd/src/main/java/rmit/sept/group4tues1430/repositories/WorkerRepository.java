package rmit.sept.group4tues1430.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rmit.sept.group4tues1430.model.Worker;

@Repository
public interface WorkerRepository extends CrudRepository<Worker, Long> {

    @Override
    Iterable<Worker> findAllById(Iterable<Long> iterable);

    public Worker findByName(String name);

    public Worker findById(String id);


    public Worker findByPhone(String phone);




}
