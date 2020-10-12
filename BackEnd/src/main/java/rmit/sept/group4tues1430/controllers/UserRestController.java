package rmit.sept.group4tues1430.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.services.MapValidationErrorService;
import rmit.sept.group4tues1430.services.UserService;
import org.springframework.http.HttpStatus;
import rmit.sept.group4tues1430.validator.UserValidator;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private UserValidator userValidator;

    @PostMapping("")
    public ResponseEntity<?> createNewUser(@Valid @RequestBody User user, BindingResult result) {
        //validate password
        userValidator.validate(user, result);

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) {
            return errorMap;
        }

        User user1 = userService.saveOrUpdateUser(user);
        return new ResponseEntity<User>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    // Have to include the column you're looking for e.g. "id/{id}" instead of just "/{id}"
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id)
    {
        User user = userService.getUserByID(id);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getUserByName(@PathVariable String name)
    {
        User user = userService.getUserByName(name);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/allUsers")
    public Iterable<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @DeleteMapping("/id/{id}")
    public void deleteUserById(@PathVariable String id) {
        userService.deleteUserByIdentifier(id);
    }
}
