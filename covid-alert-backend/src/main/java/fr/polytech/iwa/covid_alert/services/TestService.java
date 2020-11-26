package fr.polytech.iwa.covid_alert.services;


import fr.polytech.iwa.covid_alert.models.Contact;
import fr.polytech.iwa.covid_alert.models.Test;
import fr.polytech.iwa.covid_alert.models.User;
import fr.polytech.iwa.covid_alert.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TestService {

//    @Autowired
    private TestRepository testRepository;

//    @Autowired
    private ContactService contactService;
//    @Autowired
    private MailService mailService;

    public TestService(TestRepository testRepository, ContactService contactService, MailService mailService) {
        System.out.println("Test service called");
        this.testRepository = testRepository;
        this.contactService = contactService;
        this.mailService = mailService;
    }

    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
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
     * @return the Test created - an email is send to all the contact cases
     */
    public Test createTest( final Test test){
        String user_id=test.getUser_id();
        Map<User, Date> contacts_cases = contactService.getContactsWithDate(user_id);
        contacts_cases.forEach((contact,date) -> {
            mailService.sendEmail(contact.getEmail(),date);
        });

        return testRepository.saveAndFlush(test);
    }
}
