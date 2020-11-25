package fr.polytech.iwa.covid_alert.controllers;


import fr.polytech.iwa.covid_alert.models.Location;
import fr.polytech.iwa.covid_alert.models.Test;
import fr.polytech.iwa.covid_alert.services.TestService;
import org.keycloak.KeycloakPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/tests")
public class TestController {


    @Autowired
    private TestService testService;


    /**
     * GET api/tests/{id}
     *
     * @param id Long
     * @return the test by id
     */
    @GetMapping(value = "/{id}")
    public Test get(@PathVariable Long id) {
        return testService.getTest(id);
    }

    /**
     * GET api/tests/
     *
     * @return all the tests
     */
    @GetMapping
    public List<Test> get() {
        return testService.getAllTests();
    }

    /**
     * GET api/tests/user/{id}
     *
     * @param user_id String
     * @return all the tests linked to this user
     */
    @GetMapping(value = "/user/{user_id}")
    public List<Test> getByUserId(@PathVariable String user_id) {
        return testService.getTestByUserId(user_id);
    }

    /**
     * POST api/tests/
     * json data :
     * - long test_id
     * - Date test_date
     * - String user_id
     * //     * @param test Test
     *
     * @return the Test created
     */
    @PostMapping("/{timestamp}")
    @ResponseStatus(HttpStatus.CREATED)
    public Test create(
            @PathVariable Long timestamp,
            @RequestHeader String Authorization) throws Exception {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!(principal instanceof KeycloakPrincipal))
            throw new Exception("Authentication error");
        else {
            Test test = new Test();
            test.setUser_id(((KeycloakPrincipal) principal).getName());
            test.setTest_date(new Date(timestamp));
            return test;
        }
    }

    /**
     * DELETE api/tests/
     *
     * @param id Long
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        testService.deleteTest(id);
    }

}