package rmit.sept.group4tues1430.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.services.UserService;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/{personId}")
    public ResponseEntity<?> getUserById(@PathVariable String id)
    {
        User user = userService.getUserByID(id);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getUserByName(@PathVariable String name)
    {
        User user = userService.getUserByName(name);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public Iterable<User> findAllPersons()
    {
        return userService.findAllPersons();
    }

    @GetMapping("/{personId}")
    public void deletePersonById(String id)
    {
        userService.deletePersonByIdentifier(id);
    }
}
