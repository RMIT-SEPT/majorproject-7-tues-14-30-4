package rmit.sept.group4tues1430.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.services.UserService;
import rmit.sept.group4tues1430.services.MapValidationErrorService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(UserRestController.class)
public class UserRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;

    @MockBean MapValidationErrorService errorService;

    @Test
    public void ifGetUser_thenStatus200AndReturnJsonArray() throws Exception {
        User user1 = new User();
        user1.setName("Test Name");
        user1.setUserType("Admin");

        List<User> users = Arrays.asList(user1);

        given(service.getAllUsers()).willReturn(users);

        mvc.perform(get("/api/user/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(user1.getName())));

    }

    @Test
    public void ifGetUsers_thenStatus200AndReturnJsonArrayOfAllUsers() throws Exception {
        User user1 = new User();
        user1.setName("Test Name");
        user1.setUserType("Admin");

        User user2 = new User();
        user2.setName("User2");
        user2.setUserType("Customer");

        List<User> users = Arrays.asList(user1, user2);

        given(service.getAllUsers()).willReturn(users);

        mvc.perform(get("/api/user/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Test Name")))
                .andExpect(jsonPath("$[1].name", is("User2")));
    }



}
