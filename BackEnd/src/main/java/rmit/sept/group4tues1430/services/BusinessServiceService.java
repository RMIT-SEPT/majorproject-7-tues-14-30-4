package rmit.sept.group4tues1430.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.sept.group4tues1430.model.BusinessService;
import rmit.sept.group4tues1430.repositories.BusinessServiceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessServiceService {
    @Autowired
    private BusinessServiceRepository businessServiceRepository;

    public BusinessService saveOrUpdateService(BusinessService service) {

        if (service.getName().isEmpty()) {
            throw new IllegalArgumentException();
        }
        return businessServiceRepository.save(service);
    }

    public BusinessService getBusinessServiceByName(String name) {
        return businessServiceRepository.findByName(name);
    }

    public BusinessService getBusinessServiceByID(String id) {return businessServiceRepository.findById(id);}

    public List<BusinessService> getAllBusinessServices() {
        List<BusinessService> businessServices = new ArrayList<BusinessService>();
        businessServiceRepository.findAll().forEach(businessServices::add);
        return businessServices;
    }

    public Iterable<BusinessService> findAllBusinessServices(){
        return businessServiceRepository.findAll();
    }

    public void deleteServiceByIdentifier(String id){
        BusinessService serviceToDelete = businessServiceRepository.findById(id);

        businessServiceRepository.delete(serviceToDelete);
    }


}
