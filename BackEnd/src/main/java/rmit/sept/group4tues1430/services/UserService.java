package rmit.sept.group4tues1430.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

        return userRepository.save(user);
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public User getUserByID(String id) {return userRepository.findByID(id);}

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public Iterable<User> findAllPersons(){
        return userRepository.findAll();
    }

    public void deletePersonByIdentifier(String id){
        User user = userRepository.findByID(id);

//        if(person == null){
//            throw  new  PersonException("Cannot Person with ID '"+personId+"'. This person does not exist");
//        }

        userRepository.delete(user);
    }
}
