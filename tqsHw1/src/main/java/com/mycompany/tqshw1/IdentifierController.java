package com.mycompany.tqshw1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author catarina
 */
@RestController
public class IdentifierController {
    
    @Autowired
    private IdentifierService identifierService;
    
    @GetMapping("/allLocations")
    private List<Identifier> getAllLocations () {
        return identifierService.getAllLocal();
    }
    
}
