package rmit.sept.group4tues1430.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.repositories.UserRepository;
import rmit.sept.group4tues1430.exceptions.UserException;
import java.util.*;
import java.lang.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveOrUpdateUser(User user) {
//        // add business logic here
//        if (user.getName().isEmpty()) {
//            throw new IllegalArgumentException();
//        }
//        if (user.getUserType().isEmpty()) {
//            throw new IllegalArgumentException();
//        }
//
//        return userRepository.save(user);
        try{
            user.setId(user.getId());
            return userRepository.save(user);
        } catch (Exception e){
            throw new UserException("User ID " + user.getId() + " already exists");
        }
    }

    public User findByUserIdentifier(String userId) {
        User user = userRepository.findByUserIdentifier(userId);

        if(user == null){
            throw new UserException("User ID " + userId + " does not exist");
        }

        return user;
    }

    public Iterable<User> findAllUsers() {
//        List<User> users = new ArrayList<User>();
//        userRepository.findAll().forEach(users::add);
//        return users;
        return userRepository.findAll();
    }

    public void deleteUserByIdentifier(String userId){
        User user = userRepository.findByUserIdentifier(userId);

        if(user == null){
            throw new UserException("User ID " + userId + " does not exist");
        }

        userRepository.delete(user);
    }
}

