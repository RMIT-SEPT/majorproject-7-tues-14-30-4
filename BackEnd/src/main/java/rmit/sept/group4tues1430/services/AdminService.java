package rmit.sept.group4tues1430.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;
import rmit.sept.group4tues1430.exceptions.InvalidUserException;
import rmit.sept.group4tues1430.model.Admin;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.repositories.AdminRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Admin saveOrUpdateAdmin(Admin admin) {
        // add business logic here
        if(admin.getName().isEmpty())
        {
            throw new IllegalArgumentException();
        }
        if(admin.getUserType().isEmpty())
        {
            throw new IllegalArgumentException();
        }

        try {
            admin.setUserIdentifier(admin.getUserIdentifier().toUpperCase());
            admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
            return adminRepository.save(admin);
        } catch (Exception e)
        {
            throw new InvalidUserException("The Admin Identifier " +
                    admin.getUserIdentifier().toUpperCase() + " already exists.");
        }
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
