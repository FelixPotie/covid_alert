package fr.polytech.iwa.covid_alert;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

//    @Test
//    public void greetingShouldReturnDefaultMessage() throws Exception {
//        assertThat(
//                this.restTemplate.getForObject(
//                        "http://localhost:"+port+"/api/users",
//                        String.class)
//        ).contains("{\"first_name\":\"Chouki\",\"last_name\":\"Tibermacine\",\"email\":\"chouki.tibermacine@test.com\",\"user_id\":\"1\"}");
//    }
}
