package fr.polytech.iwa.covid_alert.services;


import fr.polytech.iwa.covid_alert.models.Test;
import fr.polytech.iwa.covid_alert.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    /**
     * @param id Long
     * @return the test by id
     */
    public Test getTest(Long id){
        if(testRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Test with ID "+id+" not found");
        }
        return testRepository.getOne(id);
    }

    /**
     * @return all the tests
     */
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    public List<Test> getTestByUserId(String user_id) {
        return testRepository.findTestsByUser_id(user_id);
    }

    /**
     *  json data :
     *      - long test_id
     *      - Date test_date
     *      - String user_id
     * @param test Test
     * @return the Test created
     */
    public Test createTest(@RequestBody final Test test){
        return testRepository.saveAndFlush(test);
    }

    /**
     * @param id Long
     */
    public void deleteTest(@PathVariable Long id){
        testRepository.deleteById(id);
    }


}
