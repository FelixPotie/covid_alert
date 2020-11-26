package fr.polytech.iwa.covid_alert.controllers;

import fr.polytech.iwa.covid_alert.services.MailService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerMail {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MailService mailService;

    @Test
    @DisplayName("POST /api/mails/{mail} - Success")
    public void testSendMail() throws Exception {
        Date date = new Date(new java.util.Date().getTime());
        String mail = "mail";
        doNothing().when(mailService).sendEmail(mail, date);

        mockMvc.perform(post("/api/mails/", mail));
    }
}
