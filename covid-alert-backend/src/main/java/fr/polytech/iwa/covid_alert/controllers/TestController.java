package fr.polytech.iwa.covid_alert.controllers;


import fr.polytech.iwa.covid_alert.models.Location;
import fr.polytech.iwa.covid_alert.models.Test;
import fr.polytech.iwa.covid_alert.models.TestData;
import fr.polytech.iwa.covid_alert.services.TestService;
import org.keycloak.KeycloakPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/tests")
public class TestController {

    @Autowired
    private TestService testService;

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
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Test create(
            @RequestBody TestData body,
            @RequestHeader String Authorization) throws Exception {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!(principal instanceof KeycloakPrincipal))
            throw new Exception("Authentication error");
        else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(format.parse(body.getDate()).getTime());
            Test test = new Test();
            test.setTest_date(date);
            test.setUser_id(((KeycloakPrincipal) principal).getName());
            return testService.createTest(test);
        }
    }
}