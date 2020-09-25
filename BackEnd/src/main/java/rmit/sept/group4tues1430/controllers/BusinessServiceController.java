package rmit.sept.group4tues1430.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rmit.sept.group4tues1430.model.BusinessService;
import org.springframework.http.HttpStatus;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.services.BusinessServiceService;
import rmit.sept.group4tues1430.services.MapValidationErrorService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/businessService")
public class BusinessServiceController {

    @Autowired
    private BusinessServiceService businessServiceService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewBusinessService(@Valid @RequestBody BusinessService service, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) {
            return errorMap;
        }

        BusinessService businessService = businessServiceService.saveOrUpdateService(service);
        return new ResponseEntity<BusinessService>(businessService, HttpStatus.CREATED);
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<?> getBusinessServiceByName(@PathVariable String name)
    {
        BusinessService businessService = businessServiceService.getBusinessServiceByName(name);

        return new ResponseEntity<BusinessService>(businessService, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getBusinessServiceByID(@PathVariable String id) {

        BusinessService businessService = businessServiceService.getBusinessServiceByID(id);

        return new ResponseEntity<BusinessService>(businessService, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<BusinessService> getAllBusinessServices()
    {
        return businessServiceService.getAllBusinessServices();
    }

//    @GetMapping("/allBusinessServices")
//    public Iterable<BusinessService> findAllBusinessServices()
//    {
//        return businessServiceService.findAllBusinessServices();
//    }
//

    @DeleteMapping("/id/{id}")
    public void deleteServiceByIdentifier(@PathVariable String id)
    {
        businessServiceService.deleteServiceByIdentifier(id);
    }

//    @GetMapping("/{service}")
//    public ResponseEntity<?> saveOrUpdateService(BusinessService service)
//    {
//        BusinessService businessService = businessServiceService.saveOrUpdateService(service);
//
//        return new ResponseEntity<BusinessService>(businessService, HttpStatus.OK);
//    }
}
