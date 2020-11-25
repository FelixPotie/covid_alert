package fr.polytech.iwa.covid_alert.repositories;

import fr.polytech.iwa.covid_alert.services.ContactService;
import fr.polytech.iwa.covid_alert.services.MailService;
import fr.polytech.iwa.covid_alert.services.TestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Arrays;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class TestRepositoryTest {

    @Autowired
    private TestRepository repository;
    @MockBean
    private TestRepository mockRepository;

    @Test
    @DisplayName("Test getTestByUserId")
    void testGetTestByUserId(){
        //Setup our mock
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        fr.polytech.iwa.covid_alert.models.Test mockTest = new fr.polytech.iwa.covid_alert.models.Test(1, date, "1");
        fr.polytech.iwa.covid_alert.models.Test mockTest2 = new fr.polytech.iwa.covid_alert.models.Test(2, date, "1");
        doReturn(Arrays.asList(mockTest,mockTest2)).when(mockRepository).findTestsByUser_id("1");

        // Execute the service call
        List<fr.polytech.iwa.covid_alert.models.Test> returnedTestList = repository.findTestsByUser_id("1");

        Assertions.assertNotNull(returnedTestList,"Tests was found");
        Assertions.assertEquals(2,returnedTestList.size(),"getTestByUserId suceed with good number of tests");

    }

    @Test
    @DisplayName("Test createTest Success ")
    void testCreateTest(){
        //Setup our mock
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        fr.polytech.iwa.covid_alert.models.Test mockTest = new fr.polytech.iwa.covid_alert.models.Test(1, date, "1");
        doReturn(mockTest).when(repository).saveAndFlush(mockTest);

        // Execute the service call
        fr.polytech.iwa.covid_alert.models.Test returnedTest = repository.saveAndFlush(mockTest);

        Assertions.assertNotNull(returnedTest,"Test was created");
        Assertions.assertSame(returnedTest,mockTest);

    }

}
