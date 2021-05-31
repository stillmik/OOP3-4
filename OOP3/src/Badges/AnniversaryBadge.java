package Badges;

import Awards.Badge;
import Awards.Wearing;

public class AnniversaryBadge extends Badge {

    private String anniversary;

    public AnniversaryBadge(String thankedFor, int uniqNum, Wearing wearing, String affiliation,String anniversary) {
        super(thankedFor, uniqNum, wearing, affiliation);
        this.anniversary = anniversary;
    }

    protected AnniversaryBadge(){

    }

    public void getMilitaryInfo(){
        System.out.println(getThankedFor()+ ": " + anniversary+ ": " + getWearing()+": " +getAffiliation());
    }

    public String getAnniversary(){
        return anniversary;
    }
    public void setAnniversary(String anniversary){
        this.anniversary=anniversary;
    }
}
