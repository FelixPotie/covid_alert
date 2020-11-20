package fr.polytech.iwa.covid_alert.controllers;

import fr.polytech.iwa.covid_alert.models.User;
import fr.polytech.iwa.covid_alert.services.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = UserController.class)
public class UserController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("GET /api/users/1 - Found")
    void testGetUserByIdFound() throws Exception {
        //Setup mocked service
        User mockUser = new User("a","firstName","lastName","email");
        doReturn(mockUser).when(userService).getUser("a");

        //execute Get request
        mockMvc.perform(get("/api/users/{id}","a"))
//                Validate response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//                Validate headers
//                .andExpect(header().string(HttpHeaders.ETAG, "1"))
//                .andExpect(header().string(HttpHeaders.LOCATION, "/api/users/1"))
//                Validate returned fields
                .andExpect(jsonPath("$.user_id", is("a")))
                .andExpect(jsonPath("$.first_name", is("firstName")))
                .andExpect(jsonPath("$.last_name", is("lastName")))
                .andExpect(jsonPath("$.email", is("email")));
    }

    @Test
    @DisplayName("GET /api/users/1 - Not Found")
    void testGetUserByIdNotFound() throws Exception {
        //Setup mocked service
        doReturn(null).when(userService).getUser("8");

        //execute Get request
        mockMvc.perform(get("/api/users/{id}","8"));
//                Validate 404 Not Found response
//                .andExpect(status().isNotFound());
    }
}
