//package rmit.sept.group4tues1430.services;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit4.SpringRunner;
//import rmit.sept.group4tues1430.model.User;
//import rmit.sept.group4tues1430.repositories.UserRepository;
//
//@RunWith(SpringRunner.class)
//public class UserServiceIntegrationTest {
//
//    @TestConfiguration
//    static class UserServiceTestContextConfiguration {
//
//        @Bean
//        public UserService userService() {
//            return new UserService();
//        }
//    }
//
//    @Autowired
//    private UserService userService;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @Before
//    public void init() {
//        User user1 = new User();
//        user1.setName("Test Name");
//        user1.setUserType("Admin");
//
//        Mockito.when(userRepository.findByName(user1.getName())).thenReturn(user1);
//    }
//
//    @Test
//    public void whenValidName_thenUserShouldBeFound() {
//        String name = "Test Name";
//        User userFound = userService.getUserByName(name);
//
//        assertThat(userFound.getName()).isEqualTo(name);
//    }
//}
