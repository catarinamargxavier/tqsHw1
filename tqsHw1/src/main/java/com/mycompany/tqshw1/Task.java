package com.mycompany.tqshw1;

import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author catarina
 */
@Component
public class Task {
    
    private final String partialUrl = "http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/";
    
    @Autowired
    private WeatherService weatherService;
    
    public void run (int localId) {
        RestTemplate restTemplate = new RestTemplate();
        Weather weather = restTemplate.getForObject(partialUrl+localId+".json", Weather.class);
        weather.setTimestampRegister((new Timestamp(System.currentTimeMillis()).getTime()));
        weatherService.save(localId, weather);
    }
    
}
