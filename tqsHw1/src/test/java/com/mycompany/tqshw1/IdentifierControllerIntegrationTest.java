package com.mycompany.tqshw1;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 *
 * @author catarina
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IdentifierControllerIntegrationTest {
    
    private MockMvc mockMvc;

    @Autowired
    private IdentifierController controller;
    
    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.controller).build();
    }
    
    @Test
    public void testGetAllLocations() throws Exception {
        mockMvc.perform(get("/api/allLocations")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(30)))
                .andExpect(jsonPath("$.*.local", hasItem("Aveiro")));
    }
    
}
