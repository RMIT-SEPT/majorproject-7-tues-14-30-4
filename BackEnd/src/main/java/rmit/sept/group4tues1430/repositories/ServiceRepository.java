package rmit.sept.group4tues1430.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rmit.sept.group4tues1430.model.Service;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Long> {

    @Override
    Iterable<Service> findAllById(Iterable<Long> iterable);

    public Service findByName(String name);

    public Service findByID(String id);


}
