package fr.polytech.iwa.covid_alert.services;


import fr.polytech.iwa.covid_alert.models.Alert;
import fr.polytech.iwa.covid_alert.models.Contact;
import fr.polytech.iwa.covid_alert.models.User;
import fr.polytech.iwa.covid_alert.repositories.AlertRepository;
import fr.polytech.iwa.covid_alert.repositories.ContactRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.Calendar;
import java.util.Map;

import static org.mockito.Mockito.doReturn;

@WebMvcTest(AlertService.class)
public class AlertServiceTest {

    @Autowired
    private AlertService service;

    @MockBean
    private AlertRepository repository;

    @Test
    @DisplayName("Test createAlert Success ")
    void testCreateAlert(){
        //Setup our mock
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        Alert mockAlert = new Alert(1,date,date, "1");
        doReturn(mockAlert).when(repository).saveAndFlush(mockAlert);

        // Execute the service call
        Alert returnedAlert = service.createAlert(mockAlert);


        Assertions.assertNotNull(returnedAlert,"Contact was found");
        Assertions.assertSame(returnedAlert,mockAlert);

    }


}
