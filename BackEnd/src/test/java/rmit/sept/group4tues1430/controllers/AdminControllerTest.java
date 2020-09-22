package rmit.sept.group4tues1430.controllers;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
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
import rmit.sept.group4tues1430.model.Admin;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.services.AdminService;
import rmit.sept.group4tues1430.services.MapValidationErrorService;
import rmit.sept.group4tues1430.services.UserService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserRestController.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    MapValidationErrorService errorService;

    @MockBean
    private AdminService service;

    @MockBean
    private UserService userService;

//    @Test
//    public void createNewAdmin_HasStatus201_IfAllDataValid() throws Exception {
//        Admin admin1 = new Admin();
//        admin1.setName("Test");
//        admin1.setUserType("Admin");
//        admin1.setUserIdentifier("abc123");
//        admin1.setPassword("password");
//        String admin1Details = "{\"name\":\"Test\", \"userType\":\"Admin\", " +
//                "\"userIdentifier\":\"abc123\", \"password\":\"password\"}";
//
//        Mockito.when(service.saveOrUpdateAdmin(Mockito.any(Admin.class)))
//                .thenReturn(admin1);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/api/admin")
//                .accept(MediaType.APPLICATION_JSON).content(admin1Details)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mvc.perform(requestBuilder).andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//
//        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//
//    }
//
//    @Test
//    public void getAllAdmins_HasStatus200AndReturnsJsonArrayofSize0_IfNilAdminPresent() throws Exception {
//        Admin admin1 = new Admin();
//        admin1.setName("Test Name");
//        admin1.setUserType("Admin");
//
//        List<Admin> admins = Arrays.asList();
//
//        given(service.getAllAdmins()).willReturn(admins);
//
//        mvc.perform(get("/api/admin/all")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(0)));
//    }

}
