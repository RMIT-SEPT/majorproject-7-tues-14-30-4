package rmit.sept.group4tues1430.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rmit.sept.group4tues1430.model.BusinessService;
import org.springframework.http.HttpStatus;
import rmit.sept.group4tues1430.services.BusinessServiceService;

import java.util.List;

@RestController
@RequestMapping("/api/service")
public class BusinessServiceController {

    @Autowired
    private BusinessServiceService businessServiceService;

//    @GetMapping("/{name}")
//    public ResponseEntity<?> getBusinessServiceByName(@PathVariable String name)
//    {
//        BusinessService businessService = businessServiceService.getBusinessServiceByName(name);
//
//        return new ResponseEntity<BusinessService>(businessService, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getBusinessServiceByID(@PathVariable String id) {
//
//        BusinessService businessService = businessServiceService.getBusinessServiceByID(id);
//
//        return new ResponseEntity<BusinessService>(businessService, HttpStatus.OK);
//    }
//
//    @GetMapping("/all")
//    public List<BusinessService> getAllBusinessServices()
//    {
//        return businessServiceService.getAllBusinessServices();
//    }
//
//    @GetMapping("/allBusinessServices")
//    public Iterable<BusinessService> findAllBusinessServices()
//    {
//        return businessServiceService.findAllBusinessServices();
//    }
//
//    @GetMapping("/{id}")
//    public void deleteServiceByIdentifier(@PathVariable String id)
//    {
//        businessServiceService.deleteServiceByIdentifier(id);
//    }

//    @GetMapping("/{service}")
//    public ResponseEntity<?> saveOrUpdateService(BusinessService service)
//    {
//        BusinessService businessService = businessServiceService.saveOrUpdateService(service);
//
//        return new ResponseEntity<BusinessService>(businessService, HttpStatus.OK);
//    }
}
