package rmit.sept.group4tues1430.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import rmit.sept.group4tues1430.model.BusinessService;
import rmit.sept.group4tues1430.services.BusinessServiceService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BusinessServiceController.class)
public class BusinessServiceControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private BusinessServiceService service;

    @Test
    public void getAllBusinessServices_HasStatus200AndReturnJsonArrayOfSizeOne_IfOneServiceIsPresent()
            throws Exception {
        BusinessService businessService = new BusinessService();
        businessService.setName("Hairdresser");

        List<BusinessService> businessServices = Arrays.asList(businessService);

        given(service.getAllBusinessServices()).willReturn(businessServices);

        mvc.perform(get("/api/businessService/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("Hairdresser")));

    }

    @Test
    public void getAllBusinessServices_HasStatus200AndReturnsCorrectSizeJsonArray_IfMultipleServicesPresent()
            throws Exception {
        BusinessService businessService = new BusinessService();
        businessService.setName("Hairdresser");

        BusinessService businessService2 = new BusinessService();
        businessService2.setName("Dentist");

        List<BusinessService> businessServices = Arrays.asList(businessService, businessService2);

        given(service.getAllBusinessServices()).willReturn(businessServices);

        mvc.perform(get("/api/businessService/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getBusinesSServiceByName_HasStatus200AndReturnsCorrectJsonData_IfBusinessServiceIsPresent()
            throws Exception {

        BusinessService businessService = new BusinessService();
        businessService.setName("Hairdresser");

        given(service.getBusinessServiceByName("Hairdresser")).willReturn(businessService);

        mvc.perform(get("/api/businessService/name/Hairdresser")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is("Hairdresser")));
    }


}
