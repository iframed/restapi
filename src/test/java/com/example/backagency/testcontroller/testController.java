package com.example.backagency.testcontroller;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.backagency.controller.Controller;
import com.example.backagency.model.Model;
import com.example.backagency.service.ContactService;
import com.fasterxml.jackson.databind.ObjectMapper;






@WebMvcTest(Controller.class)
@AutoConfigureMockMvc
public class testController {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ContactService contactservice;

    @Test
    public void testPostdetailsContact() throws Exception {
        // Create a sample Model object
        Model testData = new Model();
        testData.setFirsname("John");
        testData.setLastname("Doe");
        // Set other properties of testData...

        // Mock the behavior of the contactService
        Mockito.when(contactservice.cree(Mockito.any(Model.class))).thenReturn(testData);

        // Perform the POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/contact/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testData)))
                // Assert the response status
                .andExpect(MockMvcResultMatchers.status().isOk())
                // Assert the response body
                .andExpect(MockMvcResultMatchers.jsonPath("$.firsname").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastname").value("Doe"));
                // Add other assertions as needed based on the expected response data
    }
}
