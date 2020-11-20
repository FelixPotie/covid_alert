package fr.polytech.iwa.covid_alert.controllers;

import fr.polytech.iwa.covid_alert.models.User;
import fr.polytech.iwa.covid_alert.repositories.UserRepository;
import fr.polytech.iwa.covid_alert.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * GET api/users/{id}
     * @param id String
     * @return the user by id
     */
    @GetMapping(value = "/{id}")
    public User get(@PathVariable String id) {
        return userService.getUser(id);
    }

    /**
     * GET api/users/
     * @return all the users
     */
    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }


}
