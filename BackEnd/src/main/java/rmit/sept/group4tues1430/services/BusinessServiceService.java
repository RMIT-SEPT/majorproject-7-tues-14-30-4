package rmit.sept.group4tues1430.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.sept.group4tues1430.model.BusinessService;
import rmit.sept.group4tues1430.repositories.ServiceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public BusinessService saveOrUpdateService(BusinessService service) {

        return serviceRepository.save(service);
    }

    public BusinessService getBusinessServiceByName(String name) {
        return serviceRepository.findByName(name);
    }

    public BusinessService getBusinessServiceByID(String id) {return serviceRepository.findByID(id);}

    public List<BusinessService> getAllBusinessServices() {
        List<BusinessService> businessServices = new ArrayList<BusinessService>();
        serviceRepository.findAll().forEach(businessServices::add);
        return businessServices;
    }

    public Iterable<BusinessService> findAllBusinessServices(){
        return serviceRepository.findAll();
    }

    public void deleteServiceByIdentifier(String id){
        BusinessService serviceToDelete = serviceRepository.findByID(id);

        serviceRepository.delete(serviceToDelete);
    }


}
