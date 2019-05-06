package com.mycompany.tqshw1;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author catarina
 */
@Service
public class IdentifierService {
    
    //private static final Logger log = LoggerFactory.getLogger(IdentifierService.class);
    
    public void save (Identifier identifier) {
        Cache.addIdentifier(identifier);
    }
    
    public List<Identifier> getAllLocal() {
        return Cache.getIdentifiers();
    }
    
}
