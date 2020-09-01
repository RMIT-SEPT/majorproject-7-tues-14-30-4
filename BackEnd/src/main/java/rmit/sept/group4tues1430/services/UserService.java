package rmit.sept.group4tues1430.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.sept.group4tues1430.exceptions.InvalidUserException;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveOrUpdateUser(User user) {
        // add business logic here
        if (user.getName().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (user.getUserType().isEmpty()) {
            throw new IllegalArgumentException();
        }

        try {
            user.setUserIdentifier(user.getUserIdentifier().toUpperCase());
            return userRepository.save(user);

        } catch(Exception e) {
            throw new InvalidUserException("The User Identifier " +
                    user.getUserIdentifier().toUpperCase() + " already exists.");
        }
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public User getUserByID(String id) {
        return userRepository.findByUserIdentifier(id);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public Iterable<User> findAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUserByIdentifier(String id){
        User user = userRepository.findByUserIdentifier(id);

        if(user == null){
            throw  new  InvalidUserException("Cannot find User with ID '"
                    + id + "'. This user does not exist");
        }
        else {
            userRepository.delete(user);
        }
    }
}
