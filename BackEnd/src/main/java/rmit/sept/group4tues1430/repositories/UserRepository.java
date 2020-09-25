package rmit.sept.group4tues1430.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rmit.sept.group4tues1430.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    Iterable<User> findAllById(Iterable<Long> iterable);

    @Override
    Iterable<User> findAll();

    public User findByName(String name);

    public User findByUserIdentifier(String userIdentifier);

    public User findByUserType(String userType);
}
