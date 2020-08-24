package rmit.sept.group4tues1430.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rmit.sept.group4tues1430.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {

    @Override
    Iterable<Admin> findAllById(Iterable<Long> iterable);

    public Admin findByName(String name);
}
