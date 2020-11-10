package fr.polytech.iwa.covid_alert.services;


import fr.polytech.iwa.covid_alert.models.Test;
import fr.polytech.iwa.covid_alert.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public Test getTest(Long id){
        if(testRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Test with ID "+id+" not found");
        }
        return testRepository.getOne(id);
    }

    public List<Test> getAllTests() {
        return testRepository.findAll();
    }
}
