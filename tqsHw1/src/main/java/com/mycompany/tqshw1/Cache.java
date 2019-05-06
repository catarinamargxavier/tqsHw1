package com.mycompany.tqshw1;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author catarina
 */
public class Cache {
    
    private static List<Identifier> identifiers = new ArrayList <>();
    private static Map<Integer, Weather> previsions = new HashMap<>();
    
    private Cache() {
        throw new IllegalStateException("Cache class");
    }
    
    public static void addIdentifier (Identifier identifier) {
        identifiers.add(identifier);
    }
    
    public static List<Identifier> getIdentifiers () {
        return identifiers;
    }
    
    public static void saveWeather (int globalId, Weather weather) {
        previsions.put(globalId, weather);
    }
    
    public static boolean hasValidData (int localId) {
        long currentTime = new Timestamp(System.currentTimeMillis()).getTime();
        return (previsions.containsKey(localId) && currentTime - previsions.get(localId).getTimestampRegister() < 900000);
    }
    
    public static Weather getWeather (int localId) {
        return previsions.get(localId);
    }
    
}
