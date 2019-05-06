package com.mycompany.tqshw1;

import java.sql.Timestamp;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author catarina
 */
public class CacheUnitTest {
    
    private Weather weather;
    private int localId;
    
    @Before
    public void prepare() {
        localId = 1234;
        weather = new Weather();
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
    }
    
    @Test
    public void testAddIdentifier() {
        Identifier identifier = new Identifier();
        identifier.setGlobalIdLocal(1234);
        identifier.setLocal("AlgumSitio");
        Cache.addIdentifier(identifier);
        List<Identifier> identifiers = Cache.getIdentifiers();
        boolean expected = true;
        assertEquals(true, identifiers.contains(identifier));
    }
    
    @Test
    public void testGetIdentifiers() {
        Identifier identifier = new Identifier();
        identifier.setGlobalIdLocal(localId);
        identifier.setLocal("AlgumSitio");
        Cache.addIdentifier(identifier);
        List<Identifier> identifiers = Cache.getIdentifiers();
        int expected = 31;
        assertEquals(expected, identifiers.size());
    }
    
    @Test
    public void testSaveWeather() {
        weather.setTimestampRegister(new Timestamp(System.currentTimeMillis()).getTime());
        Cache.saveWeather(localId, weather);
        Weather result = Cache.getWeather(localId);
        assertEquals(weather, result);
    }
    
    @Test
    public void testDataHasValidity() {
        weather.setTimestampRegister(new Timestamp(System.currentTimeMillis()).getTime());
        Cache.saveWeather(localId, weather);
        boolean expected = true;
        assertEquals(expected, Cache.hasValidData(localId));
    }
    
    @Test
    public void testDataHasNoValidity() {
        weather.setTimestampRegister(1556984205);
        Cache.saveWeather(localId, weather);
        boolean expected = false;
        assertEquals(expected, Cache.hasValidData(localId));
    }
    
}
