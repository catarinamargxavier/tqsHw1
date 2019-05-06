package com.mycompany.tqshw1;

/**
 *
 * @author catarina
 */
public class Identifier {
    
    private int globalIdLocal;
    private String local;

    public int getGlobalIdLocal() {
        return globalIdLocal;
    }

    public void setGlobalIdLocal(int globalIdLocal) {
        this.globalIdLocal = globalIdLocal;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Identifier{" + "globalIdLocal=" + globalIdLocal + ", local=" + local + '}';
    }
    
}
