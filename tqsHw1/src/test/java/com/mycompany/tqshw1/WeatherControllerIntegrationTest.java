package com.mycompany.tqshw1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author catarina
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherControllerIntegrationTest {
    
    private MockMvc mockMvc;

    @Autowired
    private WeatherController controller;
    
    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.controller).build();
    }
    
    @Test
    public void testGetWeatherByLocal() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
        String dateString = dateFormat.format(date);
        mockMvc.perform(get("/api/previsions/1110600")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$.*.forecastDate", hasItem(dateString)));
    }
    
}
