package rmit.sept.group4tues1430.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import rmit.sept.group4tues1430.exceptions.InvalidUserException;

import org.springframework.boot.test.context.SpringBootTest;
import rmit.sept.group4tues1430.model.User;


@SpringBootTest
public class UserServiceTest {


    // Add Business logic tests here
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

//    @Test
//    public void deleteUserByIdentifier_ThrowsInvalidUserException_IfUserNotPresentInSystem() {
//        UserService userService = new UserService();
//
//        assertThrows(InvalidUserException.class, () ->
//                userService.deleteUserByIdentifier("abc123"));
//    }
    


}
