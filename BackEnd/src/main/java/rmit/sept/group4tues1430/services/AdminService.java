package rmit.sept.group4tues1430.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;
import rmit.sept.group4tues1430.model.Admin;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.repositories.AdminRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin saveOrUpdateAdmin(Admin admin) {
        // add business logic here
        return adminRepository.save(admin);
    }

    public Admin getAdminByName(String name) {

        return adminRepository.findByName(name);
    }

    public Admin findByID(String id) {
        return adminRepository.findByUserIdentifier(id);
    }

    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<Admin>();
        adminRepository.findAll().forEach(admins::add);
        return admins;
    }

    public Iterable<Admin> findAllAdmins(){
        return adminRepository.findAll();
    }

    public void deleteAdminById(String id){
        Admin admin = adminRepository.findByUserIdentifier(id);

        adminRepository.delete(admin);
    }


}
