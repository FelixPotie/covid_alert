package fr.polytech.iwa.covid_alert.controllers;


import fr.polytech.iwa.covid_alert.models.Test;
import fr.polytech.iwa.covid_alert.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/tests")
public class TestController {

    @Autowired
    private TestService testService;


    /**
     * GET api/tests/user/{id}
     * @param user_id String
     * @return all the tests linked to this user
     */
    @GetMapping(value = "/user/{user_id}")
    public List<Test> getByUserId(@PathVariable String user_id){
        return testService.getTestByUserId(user_id);
    }

    /**
     * POST api/tests/
     *  json data :
     *      - long test_id
     *      - Date test_date
     *      - String user_id
     * @param test Test
     * @return the Test created
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Test create(@RequestBody final Test test){
        return testService.createTest(test);
    }


}