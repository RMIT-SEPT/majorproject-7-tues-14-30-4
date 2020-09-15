package rmit.sept.group4tues1430.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rmit.sept.group4tues1430.model.Admin;
import rmit.sept.group4tues1430.model.BusinessService;
import rmit.sept.group4tues1430.model.User;

@Repository
public interface BusinessServiceRepository extends CrudRepository<BusinessService, Long> {

//    @Override
//    Iterable<BusinessService> findAllById(Iterable<Long> iterable);

    public BusinessService findByName(String name);

    public BusinessService findByBusinessIdentifier(String id);

    public BusinessService findByAdminId(String adminId);

    @Override
    Iterable<BusinessService> findAll();

}
