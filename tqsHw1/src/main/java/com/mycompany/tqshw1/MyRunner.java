package com.mycompany.tqshw1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author catarina
 */
@Component
public class MyRunner implements CommandLineRunner {
    
    @Autowired
    private InitTask task;

    @Override
    public void run(String... args) {
        task.run();
    }
    
    
    
}
