package rmit.sept.group4tues1430.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rmit.sept.group4tues1430.model.BusinessService;

@Repository
public interface BusinessServiceRepository extends CrudRepository<BusinessService, Long> {


    public BusinessService findByName(String name);

    public BusinessService findById(String id);

    @Override
    Iterable<BusinessService> findAll();

    public Iterable<BusinessService> findBusinessServicesByCategory(String category);

}
