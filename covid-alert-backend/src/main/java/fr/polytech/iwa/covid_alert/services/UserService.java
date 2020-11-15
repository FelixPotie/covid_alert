package fr.polytech.iwa.covid_alert.services;

import fr.polytech.iwa.covid_alert.models.User;
import fr.polytech.iwa.covid_alert.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @param id String
     * @return the user by id
     */
    public User getUser(String id){
        if(userRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID "+id+" not found");
        }
        return userRepository.findById(id).get(0);
    }

    /**
     *
     * @return all the users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
