package com.mycompany.tqshw1;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author catarina
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IdentifierServiceIntegrationTest {
    
    @Autowired
    private IdentifierService identifierService;
    
    @Test
    public void testGetAllIdentifiers() {
        List<Identifier> allIdentifiers = identifierService.getAllLocal();
        assertThat(allIdentifiers).isNotNull().isNotEmpty();
    }
    
}
