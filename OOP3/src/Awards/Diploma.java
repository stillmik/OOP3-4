package Awards;

import Thanks.Award;

public class Diploma extends Award {

    private String text;

    public Diploma(String thankedFor,int uniqNum, String text) {
        super(thankedFor,uniqNum);
        this.text = text;
    }
}
