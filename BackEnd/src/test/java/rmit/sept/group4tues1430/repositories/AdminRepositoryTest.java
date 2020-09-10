package rmit.sept.group4tues1430.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import rmit.sept.group4tues1430.model.Admin;
import rmit.sept.group4tues1430.model.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AdminRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void findByName_ReturnsNull_IfAdminIsNotPresent() {
        Admin admin = new Admin();
        admin.setName("Admin name");
        admin.setUserType("Admin");
        admin.setUserIdentifier("abc123");
        admin.setPassword("password");

        entityManager.persist(admin);
        entityManager.flush();

        Admin adminFound = adminRepository.findByName("Other Name");
        assertNull("Not found", adminFound);
    }

    @Test
    public void findByName_ReturnsNull_IfNameToSearchIsEmpty() {
        Admin admin = new Admin();
        admin.setName("Admin name");
        admin.setUserType("Admin");
        admin.setUserIdentifier("abc123");
        admin.setPassword("password");

        entityManager.persist(admin);
        entityManager.flush();

        Admin adminFound = adminRepository.findByName("");
        assertNull("Not found", adminFound);
    }

    @Test
    public void findByName_ReturnsUser_IfUserIsPresentInSystem() {
        Admin admin = new Admin();
        admin.setName("Some name");
        admin.setUserType("Admin");
        admin.setUserIdentifier("abc123");
        admin.setPassword("password");

        entityManager.persist(admin);
        entityManager.flush();

        Admin adminFound = adminRepository.findByName("Some name");
        assertThat(adminFound.getName()).isEqualTo(admin.getName());
    }

    @Test
    public void findByUserIdentifier_ReturnsAdmin_IfAdminIsPresentInSystem() {
        Admin admin = new Admin();
        admin.setName("Some name");
        admin.setUserType("Admin");
        admin.setUserIdentifier("abc123");
        admin.setPassword("password");

        entityManager.persist(admin);
        entityManager.flush();

        Admin adminFound = adminRepository.findByUserIdentifier("abc123");
        assertThat(admin).isEqualTo(adminFound);
    }


}
