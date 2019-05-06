package com.mycompany.tqshw1;

/**
 *
 * @author catarina
 */
public class Weather {
    
    private Prevision[] data;
    private long timestampRegister;
    
    public Weather () {
    }

    public Prevision[] getData() {
        return data;
    }

    public void setData(Prevision[] data) {
        this.data = data;
    }
    
    public long getTimestampRegister() {
        return timestampRegister;
    }

    public void setTimestampRegister(long timestampRegister) {
        this.timestampRegister = timestampRegister;
    }
    
}
