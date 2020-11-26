package fr.polytech.iwa.covid_alert.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.polytech.iwa.covid_alert.models.Test;
import fr.polytech.iwa.covid_alert.services.TestService;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TestService testService;

    private String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @org.junit.jupiter.api.Test
    @DisplayName("POST /api/tests - Success")
    public void testCreateTest() throws Exception {
        //Setup mocked service
        Date date = new Date(new java.util.Date().getTime());
        Test postTest = new Test(date, "a");
        Test mockTest = new Test(1, date, "a");
        doReturn(mockTest).when(testService).createTest(any());

        //execute Post request
        mockMvc.perform(post("/api/tests")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(postTest)))
//                Validate response code and content type
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//                Validate returned fields
                .andExpect(jsonPath("$.test_id", is(1)))
                .andExpect(jsonPath("$.test_date", is(date.toString())))
                .andExpect(jsonPath("$.user_id", is("a")));
    }

//    @org.junit.jupiter.api.Test
//    @DisplayName("GET /api/tests/1 - Found")
//    public void testGetTest() throws Exception {
//        //Setup mocked service
//        Date date = new Date(new java.util.Date().getTime());
//        Test mockTest = new Test(1, date, "a");
//        doReturn(Arrays.asList(mockTest)).when(testService).getTestByUserId("a");
//
//        //execute Post request
//        mockMvc.perform(get("/api/tests/{id}", "a"))
////                Validate response code and content type
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
////                Validate returned fields
//                .andExpect(jsonPath("$.test_id", is(1)))
//                .andExpect(jsonPath("$.test_date", is(date.toString())))
//                .andExpect(jsonPath("$.user_id", is("a")));
//    }
}