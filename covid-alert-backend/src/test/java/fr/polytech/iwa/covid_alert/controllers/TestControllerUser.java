package fr.polytech.iwa.covid_alert.controllers;

import fr.polytech.iwa.covid_alert.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = UserController.class)
public class TestControllerUser {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /api/users/1 - Found")
    void testGetUserByIdFound() throws Exception {
        //Setup mocked service
//        User mockProduct = new User(
    }
}
