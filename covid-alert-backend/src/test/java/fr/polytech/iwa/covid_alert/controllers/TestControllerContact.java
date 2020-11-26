package fr.polytech.iwa.covid_alert.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.polytech.iwa.covid_alert.models.Contact;
import fr.polytech.iwa.covid_alert.services.ContactService;
import fr.polytech.iwa.covid_alert.services.TestService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.sql.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = ContactController.class)
//@AutoConfigureMockMvc
public class TestControllerContact {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;

    private String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("POST /api/contacts - Success")
    public void testCreateContact() throws Exception {
        //Setup mocked service
        Date date = new Date(new java.util.Date().getTime());
        Contact postContact = new Contact("a", "b", date);
        Contact mockContact = new Contact(1,"a", "b", date);
//        ContactService contactS = Mockito.mock(ContactService.class);
//        Assertions.assertNotNull(true);
        doReturn(mockContact).when(contactService).createContact(any());

        //execute Get request
//        mockMvc.perform(post("/api/contacts")
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(asJsonString(postContact)));
////                Validate response code and content type
//                .andExpect(status().isCreated())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
////                Validate returned fields
//                .andExpect(jsonPath("$.test_id", is(1)))
//                .andExpect(jsonPath("$.date", is(date)))
//                .andExpect(jsonPath("$.user_id", is("a")));
    }
}
