package com.mycompany.tqshw1;

import java.sql.Timestamp;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

/**
 *
 * @author catarina
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherServiceIntegrationTest {
    
    @Autowired
    private WeatherService weatherService;
    
    @Test
    public void testGetPrevisionsByValidId() {
        int localId = 1110600;
        Prevision[] previsionsById = weatherService.getPrevisions(localId);
        assertThat(previsionsById).isNotNull().isNotEmpty();
    }
    
    @Test(expected = HttpClientErrorException.class)
    public void testGetPrevisionsByInvalidId() {
        int localId = 1234;
        weatherService.getPrevisions(localId);
    }
    
    @Test
    public void testSavePrevisionsById() {
        int localId = 1234;
        Weather weather = new Weather();
        Prevision[] previsions = new Prevision[2];
        Prevision prevision0 = new Prevision();
        prevision0.setForecastDate("06-05-19");
        prevision0.settMax("11.2");
        prevision0.settMin("5.6");
        prevision0.setIdWeatherType(2);
        Prevision prevision1 = new Prevision();
        prevision1.setForecastDate("07-05-19");
        prevision1.settMax("15.6");
        prevision1.settMin("2.0");
        prevision1.setIdWeatherType(3);
        previsions[0] = prevision0;
        previsions[1] = prevision1;
        weather.setData(previsions);
        weather.setTimestampRegister(new Timestamp(System.currentTimeMillis()).getTime());
        weatherService.save(localId, weather);
        Prevision[] previsionsById = weatherService.getPrevisions(localId);
        assertThat(previsionsById).isNotNull().isNotEmpty();
    }    
}
