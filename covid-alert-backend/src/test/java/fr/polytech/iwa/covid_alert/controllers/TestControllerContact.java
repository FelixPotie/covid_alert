package fr.polytech.iwa.covid_alert.controllers;

import fr.polytech.iwa.covid_alert.models.Contact;
import fr.polytech.iwa.covid_alert.services.ContactService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.util.HashMap;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerContact {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;

    @Test
    @DisplayName("POST /api/contacts - Success")
    public void testCreateContact() throws Exception {
        //Setup mocked service
        Date date = new Date(new java.util.Date().getTime());
        Contact postContact = new Contact("a", "b", date);
        Contact mockContact = new Contact(1,"a", "b", date);
        doReturn(mockContact).when(contactService).createContact(any());

        //execute Post request
        mockMvc.perform(post("/api/contacts")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JsonString.asJsonString(postContact)))
//                Validate response code and content type
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//                Validate returned fields
                .andExpect(jsonPath("$.contact_id", is(1)))
                .andExpect(jsonPath("$.contact_date", is(date.toString())))
                .andExpect(jsonPath("$.first_user_id", is("a")))
                .andExpect(jsonPath("$.second_user_id", is("b")));
    }

    @Test
    @DisplayName("GET /api/contacts/user/1 - Found")
    public void testGetContactByIdTest() throws Exception {
        //Setup mocked service
        Date date = new Date(new java.util.Date().getTime());
        Contact mockContact = new Contact(1,"a", "b", date);

        HashMap<Contact, Date> contactsMap = new HashMap<Contact, Date>();
        contactsMap.put(mockContact, mockContact.getContact_date());

        doReturn(contactsMap).when(contactService).getContactsWithDate("a");

        //execute Get request
        mockMvc.perform(get("/api/contacts/user/{id}", "a"))
//                Validate response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//                Validate returned fields
                .andExpect(jsonPath("$.*", hasSize(1)));
    }

    @Test
    @DisplayName("GET /api/contacts/user/1 - Not Found")
    public void testGetContactByIdNotFoundTest() throws Exception {
        HashMap<Contact, Date> contactsMap = new HashMap<Contact, Date>();
        doReturn(contactsMap).when(contactService).getContactsWithDate("a");

        mockMvc.perform(get("/api/contacts/user/{id}", "a"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.*", hasSize(0)));
    }
}
