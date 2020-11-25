package fr.polytech.iwa.covid_alert.repositories;

import fr.polytech.iwa.covid_alert.models.Alert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.Calendar;

import static org.mockito.Mockito.doReturn;


@SpringBootTest
public class AlertRepositoryTest {

    @Autowired
    private AlertRepository repository;
    @MockBean
    private AlertRepository mockRepository;
    
    @Test
    @DisplayName("Test findAlertsByUser Success ")
    void testCreateContact() {
        //Setup our mock
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        Alert mockAlert = new Alert(1,date,date, "1");
        doReturn(mockAlert).when(mockRepository).saveAndFlush(mockAlert);

        // Execute the service call
        Alert returnedAlert = repository.saveAndFlush(mockAlert);

        Assertions.assertNotNull(returnedAlert,"Alert was created");
        Assertions.assertSame(returnedAlert,mockAlert);
    }

}