package fr.polytech.iwa.covid_alert.controllers;


import fr.polytech.iwa.covid_alert.models.Test;
import fr.polytech.iwa.covid_alert.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tests")
public class TestController {


    @Autowired
    private TestService testService;

    /**
     * GET api/tests/{id}
     * @param id Long
     * @return the test by id
     */
    @GetMapping(value = "/{id}")
    public Test get(@PathVariable Long id) {
        return testService.getTest(id);
    }

    /**
     * GET api/tests/
     * @return all the tests
     */
    @GetMapping
    public List<Test> get() {
        return testService.getAllTests();
    }

}