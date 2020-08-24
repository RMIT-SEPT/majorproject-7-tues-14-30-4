package rmit.sept.group4tues1430.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rmit.sept.group4tues1430.model.Admin;
import rmit.sept.group4tues1430.services.AdminService;
import org.springframework.http.HttpStatus;

import java.util.List;

public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{personId}")
    public ResponseEntity<?> getAdminById(@PathVariable String id)
    {
        Admin admin = adminService.findByID(id);
        return new ResponseEntity<Admin>(admin, HttpStatus.OK);
    }

    @GetMapping("/{admin}")
    public ResponseEntity<?> saveOrUpdateAdmin(Admin admin)
    {
        Admin admin1 = adminService.saveOrUpdateAdmin(admin);
        return new ResponseEntity<Admin>(admin1, HttpStatus.OK);

    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getAdminByName(String name)
    {
        Admin admin = adminService.getAdminByName(name);
        return new ResponseEntity<Admin>(admin, HttpStatus.OK);
    }

    @GetMapping("/admins")
    public Iterable<Admin> findAllAdmins()
    {
        return adminService.findAllAdmins();
    }

    @GetMapping("/{personId}")
    public void deleteAdminById(String id)
    {
        adminService.deleteAdminById(id);
    }
}
