package rmit.sept.group4tues1430.services;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import rmit.sept.group4tues1430.model.BusinessService;
import rmit.sept.group4tues1430.model.User;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BusinessServiceServiceTest
{

    // business logic tests (service name must not be empty)
    @Test
    public void saveOrUpdateBusinessService_ThrowsIllegalArgException_IfNameIsEmpty() {
        BusinessServiceService service = new BusinessServiceService();
        BusinessService business = new BusinessService();
        business.setName("");

        assertThrows(IllegalArgumentException.class, () ->
                service.saveOrUpdateService(business));
    }
}
