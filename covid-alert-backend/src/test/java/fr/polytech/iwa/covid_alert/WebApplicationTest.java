package fr.polytech.iwa.covid_alert;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

//Démarrer tout le contexte d'applciation Spring avec ses objets mais pas le serveur

@SpringBootTest
@AutoConfigureMockMvc
public class WebApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/api/users")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"first_name\":\"Chouki\",\"last_name\":\"Tibermacine\",\"email\":\"chouki.tibermacine@test.com\",\"user_id\":\"1\"}")));
    }
}
