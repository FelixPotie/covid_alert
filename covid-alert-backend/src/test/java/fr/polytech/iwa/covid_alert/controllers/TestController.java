//package fr.polytech.iwa.covid_alert.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import fr.polytech.iwa.covid_alert.models.Test;
//import fr.polytech.iwa.covid_alert.services.TestService;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.sql.Date;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(controllers = TestController.class)
//public class TestController {
//
//        @Autowired
//        private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//        @MockBean
//        private TestService testService;
//
//        @org.junit.jupiter.api.Test
//        void whenValidInput_thenReturns200() throws Exception {
//            Date date = new Date(new java.util.Date().getTime());
//            Test postTest = new Test(date, "a");
//            Test mockTest = new Test(1, date, "a");
//
//            mockMvc.perform(post("/api/tests")
//                            .contentType(MediaType.APPLICATION_JSON_VALUE))
////                            .content(objectMapper)
//                    .andExpect(status().isOk());
////                .content(asJsonString(postTest)))));
//        }
//
//}
