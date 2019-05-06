package com.mycompany.tqshw1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author catarina
 */
@RestController
@RequestMapping("/api")
public class WeatherController {
    
    @Autowired
    private WeatherService weatherService;
    
    @GetMapping("/previsions/{localId}")
    public Prevision[] getWeatherByLocal (@PathVariable(value = "localId") int localId) {
        return weatherService.getPrevisions(localId);
    }
    
}
