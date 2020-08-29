package rmit.sept.group4tues1430.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rmit.sept.group4tues1430.model.Admin;
import rmit.sept.group4tues1430.services.AdminService;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAdminById(@PathVariable String id)
    {
        Admin admin = adminService.findByID(id);
        return new ResponseEntity<Admin>(admin, HttpStatus.OK);
    }

//    @GetMapping("/{admin}")
//    public ResponseEntity<?> saveOrUpdateAdmin(Admin admin)
//    {
//        Admin admin1 = adminService.saveOrUpdateAdmin(admin);
//        return new ResponseEntity<Admin>(admin1, HttpStatus.OK);
//
//    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getAdminByName(@PathVariable String name)
    {
        Admin admin = adminService.getAdminByName(name);
        return new ResponseEntity<Admin>(admin, HttpStatus.OK);
    }

    @GetMapping("/allAdmins")
    public Iterable<Admin> findAllAdmins()
    {
        return adminService.findAllAdmins();
    }

//    @GetMapping("/{id}")
//    public void deleteAdminById(@PathVariable String id)
//    {
//        adminService.deleteAdminById(id);
//    }
}
