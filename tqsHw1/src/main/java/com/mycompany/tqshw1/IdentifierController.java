package com.mycompany.tqshw1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author catarina
 */
@RestController
@RequestMapping("/api")
public class IdentifierController {
    
    @Autowired
    private IdentifierService identifierService;
    
    @GetMapping("/allLocations")
    public List<Identifier> getAllLocations () {
        return identifierService.getAllLocal();
    }
    
}
