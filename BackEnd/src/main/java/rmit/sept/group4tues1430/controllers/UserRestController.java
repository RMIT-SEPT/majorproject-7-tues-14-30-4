package rmit.sept.group4tues1430.controllers;


import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.services.UserService;
import rmit.sept.group4tues1430.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;
import java.lang.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;


    @PostMapping("")
    public ResponseEntity<?> createNewUser(@Valid @RequestBody User user, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        User user1 = userService.saveOrUpdateUser(user);
        return new ResponseEntity<User>(user1, HttpStatus.CREATED);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable String userId){

        User user = userService.findByUserIdentifier(userId);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


    @GetMapping("/users")
    public Iterable<User> getAllUsers(){return userService.findAllUsers();}


    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteProject(@PathVariable String userId){
        userService.deleteUserByIdentifier(userId);

        return new ResponseEntity<String>("User with ID: " + userId + " was deleted", HttpStatus.OK);
    }
}