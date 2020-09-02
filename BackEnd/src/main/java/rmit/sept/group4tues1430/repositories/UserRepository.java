package rmit.sept.group4tues1430.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rmit.sept.group4tues1430.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserIdentifier(String userId);
    @Override
    Iterable<User> findAll();
}
