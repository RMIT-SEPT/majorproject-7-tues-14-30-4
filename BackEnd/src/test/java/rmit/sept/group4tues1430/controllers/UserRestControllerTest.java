package rmit.sept.group4tues1430.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rmit.sept.group4tues1430.model.BusinessService;
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

    @MockBean
    MapValidationErrorService errorService;

    @Test
    public void getAllUsers_HasStatus200AndReturnsJsonArrayofSize1_IfOneUserIsPresent() throws Exception {
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
    public void getAllUsers_HasStatus200AndReturnsAllUsers_IfMoreThanOneUserPresent()
            throws Exception {
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

    @Test
    public void getUserByName_HasStatus200AndReturnsCorrectJsonData_IfUserIsPresent()
            throws Exception {

        User user1 = new User();
        user1.setName("Test");
        user1.setUserType("Admin");
        user1.setUserIdentifier("abc123");
        user1.setPassword("password");

        given(service.getUserByName("Test")).willReturn(user1);

        mvc.perform(get("/api/user/name/Test")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is("Test")));
    }

    @Test
    public void getUserById_HasStatus200AndReturnsCorrectJsonData_IfUserIsPresent()
            throws Exception {

        User user1 = new User();
        user1.setName("Test");
        user1.setUserType("Admin");
        user1.setUserIdentifier("abc123");
        user1.setPassword("password");

        given(service.getUserByID("abc123")).willReturn(user1);

        mvc.perform(get("/api/user/id/abc123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is("Test")));
    }

    @Test
    public void createNewUser_HasStatus201_IfAllDataValid() throws Exception {
        User user1 = new User();
        user1.setName("Test");
        user1.setUserType("Admin");
        user1.setUserIdentifier("abc123");
        user1.setPassword("password");
        String user1Details = "{\"name\":\"Test\", \"userType\":\"Admin\", " +
                "\"userIdentifier\":\"abc123\", \"password\":\"password\"}";

        Mockito.when(service.saveOrUpdateUser(Mockito.any(User.class)))
                .thenReturn(user1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/user")
                .accept(MediaType.APPLICATION_JSON).content(user1Details)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

    }


}
