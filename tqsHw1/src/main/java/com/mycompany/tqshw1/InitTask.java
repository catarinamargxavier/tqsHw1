package com.mycompany.tqshw1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author catarina
 */
@Component
public class InitTask {
    
    private final String identifiersUrl = "http://api.ipma.pt/open-data/distrits-islands.json";
    
    @Autowired
    private IdentifierService identifierService;
        
    public void run () {
        RestTemplate restTemplate = new RestTemplate();
        IdentifiersJSON json = restTemplate.getForObject(identifiersUrl, IdentifiersJSON.class);
        for (Identifier identifier : json.getData()) {
            identifierService.save(identifier);
        }
    }

    
}
