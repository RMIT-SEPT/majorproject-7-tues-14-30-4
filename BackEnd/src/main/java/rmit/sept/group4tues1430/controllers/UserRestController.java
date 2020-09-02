package rmit.sept.group4tues1430.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    public UserRestController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() { return userService.getAllUsers(); }

    // might need to use @PostMapping() here but not sure

}
