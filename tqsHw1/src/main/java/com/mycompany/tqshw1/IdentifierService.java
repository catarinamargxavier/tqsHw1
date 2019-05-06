package com.mycompany.tqshw1;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author catarina
 */
@Service
public class IdentifierService {
    
    public void save (Identifier identifier) {
        Cache.addIdentifier(identifier);
    }
    
    public List<Identifier> getAllLocal() {
        return Cache.getIdentifiers();
    }
    
}
