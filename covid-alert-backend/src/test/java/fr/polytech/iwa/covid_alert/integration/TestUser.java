package fr.polytech.iwa.covid_alert.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.sql.DataSource;

@ExpendWith({DBUnitEtension.class, SpringExtension.class})
@SpringBootTest
@Profile(("test"))
@AutoConfigureMockMvc
public class TestUser {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private DataSource dataSource;

//    public ConnectionHolder getConnectionHandler() {
//        //return function that retrieves connection
//        return () -> dataSource.getConnection();
//    }


}
