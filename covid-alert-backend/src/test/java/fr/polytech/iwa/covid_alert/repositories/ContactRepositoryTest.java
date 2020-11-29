package fr.polytech.iwa.covid_alert.repositories;

import ch.qos.logback.core.net.SyslogOutputStream;
import fr.polytech.iwa.covid_alert.models.Contact;
import fr.polytech.iwa.covid_alert.models.User;
import fr.polytech.iwa.covid_alert.services.ContactService;
import fr.polytech.iwa.covid_alert.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository repository;
    @MockBean
    private ContactRepository mockRepository;

    @Test
    @DisplayName("Test getContactsWithDate ")
    void testGetContactsWithDate(){
        //Setup our mock
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        Contact mockContact = new Contact(1, "1","2",date);
        Contact mockContact2 = new Contact(2, "1","3",date);
        Contact mockContact3 = new Contact(3, "3","1",date);
        doReturn(Arrays.asList(mockContact,mockContact2,mockContact3)).when(mockRepository).findContactsByFirst_user_idOrSecond_user_idAndContact("1");
        // Execute the service call
        List<Contact> returnedContact =repository.findContactsByFirst_user_idOrSecond_user_idAndContact("1");

        Assertions.assertNotNull(returnedContact,"Contact was found");
        Assertions.assertEquals(3,returnedContact.size(),"getContactsWithDate succeed with good number of contact");
    }

    @Test
    @DisplayName("Test CreateContact Success ")
    void testCreateContact(){
        //Setup our mock
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        Contact mockContact = new Contact(1, "1","2",date);
        doReturn(mockContact).when(mockRepository).saveAndFlush(mockContact);

        // Execute the service call
        Contact returnedContact = repository.saveAndFlush(mockContact);

        Assertions.assertNotNull(returnedContact,"Contact was found");
        Assertions.assertSame(returnedContact,mockContact,"Contact was created");

    }

}
