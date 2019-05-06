package com.mycompany.tqshw1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author catarina
 */
@Service
public class WeatherService {
    
    @Autowired
    private Task task;
    
    public void save (int localId, Weather weather) {
        Cache.saveWeather(localId, weather);
    }
    
    public Prevision[] getPrevisions (int localId) {
        if (!Cache.hasValidData(localId))
            task.run(localId);
        return Cache.getWeather(localId).getData();
    }
    
}
