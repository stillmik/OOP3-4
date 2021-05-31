package Awards;

import Thanks.Award;

// нагрудной знак
public class Badge extends Award {

    private Wearing wearing;
    private String affiliation;//принадлежность(компании, гос-ву)
    public Badge(String thankedFor,int uniqNum, Wearing wearing,String affiliation) {
        super(thankedFor,uniqNum);
        this.wearing=wearing;
        this.affiliation=affiliation;
    }

    protected Badge(){
    }

    public Wearing getWearing() {
        return wearing;
    }

    public void setWearing(Wearing wearing) {
        this.wearing = wearing;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }
}
