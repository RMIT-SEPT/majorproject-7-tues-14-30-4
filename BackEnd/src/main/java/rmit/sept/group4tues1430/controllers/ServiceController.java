package rmit.sept.group4tues1430.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import rmit.sept.group4tues1430.model.BusinessService;
import org.springframework.http.HttpStatus;
import rmit.sept.group4tues1430.services.BusinessServiceService;

import java.util.List;

public class ServiceController {
    private BusinessServiceService businessServiceService;

    @GetMapping("/{name}")
    public ResponseEntity<?> getBusinessServiceByName(String name)
    {
        BusinessService businessService = businessServiceService.getBusinessServiceByName(name);

        return new ResponseEntity<BusinessService>(businessService, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBusinessServiceByID(String id) {

        BusinessService businessService = businessServiceService.getBusinessServiceByID(id);

        return new ResponseEntity<BusinessService>(businessService, HttpStatus.OK);
    }

    @GetMapping("/businesses")
    public List<BusinessService> getAllBusinessServices()
    {
        return businessServiceService.getAllBusinessServices();
    }

    @GetMapping("/businesses")
    public Iterable<BusinessService> findAllBusinessServices()
    {
        return businessServiceService.findAllBusinessServices();
    }

    @GetMapping("/{id}")
    public void deleteServiceByIdentifier(String id)
    {
        businessServiceService.deleteServiceByIdentifier(id);
    }

    @GetMapping("/{service}")
    public ResponseEntity<?> saveOrUpdateService(BusinessService service)
    {
        BusinessService businessService = businessServiceService.saveOrUpdateService(service);

        return new ResponseEntity<BusinessService>(businessService, HttpStatus.OK);
    }
}
