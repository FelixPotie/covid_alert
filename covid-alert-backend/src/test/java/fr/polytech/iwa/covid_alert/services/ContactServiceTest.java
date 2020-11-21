package fr.polytech.iwa.covid_alert.services;


import fr.polytech.iwa.covid_alert.models.Contact;
import fr.polytech.iwa.covid_alert.models.User;
import fr.polytech.iwa.covid_alert.repositories.ContactRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.Calendar;
import java.util.Map;

import static org.mockito.Mockito.doReturn;

@WebMvcTest(ContactService.class)
public class ContactServiceTest {

    @Qualifier("ContactServiceImpl")
    @Autowired
    private ContactService service;

    @MockBean
    private ContactRepository repository;

    @Test
    @DisplayName("Test getContactsWithDate Success ")
    void testGetContactsWithDate(){
        //Setup our mock
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        Contact mockContact = new Contact(1, "1","2",date);
        doReturn(mockContact).when(repository).findContactsByFirst_user_idOrSecond_user_idAndContact("1","2");

        // Execute the service call
        Map<User, Date> returnedContact = service.getContactsWithDate("1");


        Assertions.assertNotNull(returnedContact,"Contact was found");

    }



}
