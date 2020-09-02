//package rmit.sept.group4tues1430.repositories;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//import rmit.sept.group4tues1430.model.User;
//
//import java.util.ArrayList;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.test.util.AssertionErrors.assertNull;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class UserRepositoryTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void whenFindByName_thenReturnsUser() {
//
//        User user = new User();
//        user.setName("Test Name");
//        user.setUserType("Admin");
//
//        entityManager.persist(user);
//        entityManager.flush();
//
//        User userFound = userRepository.findByName(user.getName());
//
//        assertThat(userFound.getName()).isEqualTo(user.getName());
//
//    }
//
//    @Test
//    public void ifNotPresent_ThenFindByNameReturnsNull() {
//        User user = new User();
//        user.setName("Test Name");
//        user.setUserType("Admin");
//
//        entityManager.persist(user);
//        entityManager.flush();
//
//        User userFound = userRepository.findByName("Another Name");
//        assertNull("Not found", userFound);
//    }
//
//    @Test
//    public void ifNameToSearchIsEmpty_ThenFindByNameReturnsNull() {
//        User user = new User();
//        user.setName("Test Name");
//        user.setUserType("Admin");
//
//        entityManager.persist(user);
//        entityManager.flush();
//
//        User userFound = userRepository.findByName("");
//        assertNull("Not found", userFound);
//    }
//
//}
