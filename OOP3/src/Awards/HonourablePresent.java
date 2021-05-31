package Awards;

import Thanks.Award;

public class HonourablePresent extends Award {

    private Type type;

    public HonourablePresent(String thankedFor,int uniqNum,Type typeOfPresent) {
        super(thankedFor, uniqNum);
        this.type=typeOfPresent;
    }
}
