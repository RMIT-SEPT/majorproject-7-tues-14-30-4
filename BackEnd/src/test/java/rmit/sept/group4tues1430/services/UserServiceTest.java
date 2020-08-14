package rmit.sept.group4tues1430.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.repositories.UserRepository;

@SpringBootTest
public class UserServiceTest {


    // Business logic tests
    @Test
    public void saveOrUpdateUser_ThrowsIllegalArgException_IfUserNameIsEmpty() {
        UserService userService = new UserService();
        User user1 = new User();
        user1.setName("");

        assertThrows(IllegalArgumentException.class, () ->
                userService.saveOrUpdateUser(user1));
    }

    @Test
    public void saveOrUpdateUser_ThrowsIllegalArgException_IfUserTypeIsEmpty() {
        UserService userService = new UserService();
        User user1 = new User();
        user1.setName("TestName");
        user1.setUserType("");

        assertThrows(IllegalArgumentException.class, () ->
                userService.saveOrUpdateUser(user1));
    }
    


}
