package fr.polytech.iwa.covid_alert.controllers;

import fr.polytech.iwa.covid_alert.models.Alert;
import fr.polytech.iwa.covid_alert.services.AlertService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerAlert {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlertService alertService;

    @Test
    @DisplayName("POST /api/alerts - Success")
    public void testCreateAlert() throws Exception {
        Date date = new Date(new java.util.Date().getTime());
        Alert postAlert = new Alert(date, date, "a");
        Alert mockAlert = new Alert(1, date, date, "a");
        doReturn(mockAlert).when(alertService).createAlert(any());

        mockMvc.perform(post("/api/alerts")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(JsonString.asJsonString(postAlert)))
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.alert_id", is(1)))
        .andExpect(jsonPath("$.user_id", is("a")))
        .andExpect(jsonPath("$.contamination_date", is(date.toString())))
        .andExpect(jsonPath("$.alert_date", is(date.toString())));
    }

    @Test
    @DisplayName("GET /api/alerts/user/1 - Found")
    public void testGetAlertByIdTest() throws Exception {
        //Setup mocked service
        Date date = new Date(new java.util.Date().getTime());
        Alert mockAlert = new Alert(1, date, date, "a");
        doReturn(Arrays.asList(mockAlert)).when(alertService).getAlertByUserId("a");

        //execute Get request
        mockMvc.perform(get("/api/alerts/user/{id}", "a"))
//                Validate response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//                Validate returned fields
                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$.*", hasSize(1)))
                .andExpect(jsonPath("$[0].alert_id", is(1)))
                .andExpect(jsonPath("$[0].contamination_date", is(date.toString())))
                .andExpect(jsonPath("$[0].alert_date", is(date.toString())))
                .andExpect(jsonPath("$[0].user_id", is("a")));
    }

    @Test
    @DisplayName("GET /api/alerts/user/1 - Not Found")
    public void testGetTestByIdNotFoundTest() throws Exception {
        doReturn(Arrays.asList()).when(alertService).getAlertByUserId("a");

        mockMvc.perform(get("/api/alerts/user/{id}","a"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$.*", hasSize(0)));
    }
}
