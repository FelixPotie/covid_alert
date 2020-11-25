package fr.polytech.iwa.covid_alert.services;

import fr.polytech.iwa.covid_alert.models.Contact;
import fr.polytech.iwa.covid_alert.models.User;
import fr.polytech.iwa.covid_alert.repositories.ContactRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;

import static org.mockito.Mockito.doReturn;

@WebMvcTest({ContactService.class,UserService.class})
public class ContactServiceTest {

    @Autowired
    private ContactService service;
    @MockBean
    private ContactRepository repository;
    @MockBean
    private UserService serviceUser;

    @Test
    @DisplayName("Test getContactsWithDate Success ")
    void testGetContactsWithDate(){
        service.setUserService(serviceUser);
        //Setup our mock
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        Contact mockContact = new Contact(1, "1","2",date);
        Contact mockContact2 = new Contact(2, "1","3",date);
        Contact mockContact3 = new Contact(3, "3","1",date);
        System.out.println(doReturn(Arrays.asList(mockContact,mockContact2,mockContact3)).when(repository).findContactsByFirst_user_idOrSecond_user_idAndContact("1"));

        // Execute the service call
        Map<User, Date> returnedContact =service.getContactsWithDate("1");
        System.out.println(returnedContact);

        Assertions.assertNotNull(returnedContact,"Contact was found");
        //Assertions.assertEquals(3,returnedContact.size(),"getContactsWithDate succeed with good number of contact");


    }

    @Test
    @DisplayName("Test CreateContact Success ")
    void testCreateContact(){
        service.setUserService(serviceUser);
        //Setup our mock
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        Contact mockContact = new Contact(1, "1","2",date);
        doReturn(mockContact).when(repository).saveAndFlush(mockContact);

        // Execute the service call
        Contact returnedContact = service.createContact(mockContact);


        Assertions.assertNotNull(returnedContact,"Contact was found");
        Assertions.assertSame(returnedContact,mockContact,"Contact was created");

    }


}
