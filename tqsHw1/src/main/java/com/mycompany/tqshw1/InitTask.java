package com.mycompany.tqshw1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author catarina
 */
@Component
public class InitTask {
    
    private static final String URL = "http://api.ipma.pt/open-data/distrits-islands.json";
    
    @Autowired
    private IdentifierService identifierService;
        
    public void run () {
        RestTemplate restTemplate = new RestTemplate();
        IdentifiersJSON json = restTemplate.getForObject(URL, IdentifiersJSON.class);
        for (Identifier identifier : json.getData()) {
            identifierService.save(identifier);
        }
    }

    
}
