package rmit.sept.group4tues1430.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rmit.sept.group4tues1430.model.BusinessService;

@Repository
public interface ServiceRepository extends CrudRepository<BusinessService, Long> {

    @Override
    Iterable<BusinessService> findAllById(Iterable<Long> iterable);

    public BusinessService findByName(String name);

    public BusinessService findByID(String id);


}
