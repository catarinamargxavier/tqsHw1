package com.mycompany.tqshw1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author catarina
 */
public abstract class Cache {
    
    private static List<Identifier> identifiers = new ArrayList <Identifier>();
    
    public static void addIdentifier (Identifier identifier) {
        identifiers.add(identifier);
    }
    
    public static List<Identifier> getIdentifiers () {
        return identifiers;
    }
    
    public static int getIdLocal (String local) {
        for (Identifier identifier : identifiers) {
            if (identifier.getLocal().equals(local)) {
                return identifier.getGlobalIdLocal();
            }
        }
        return -1;
    }
    
}
