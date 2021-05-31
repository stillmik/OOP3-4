package Thanks;

import java.io.Serializable;

// благодарность
public class Thank implements Serializable {

    private String thankedFor;

    Thank(String thankedFor){
        this.thankedFor = thankedFor;
    }

    Thank(){

    }

    public String getThankedFor(){
        return thankedFor;
    }

    public void setThankedFor(String thankedFor){
        this.thankedFor=thankedFor;
    }
}
