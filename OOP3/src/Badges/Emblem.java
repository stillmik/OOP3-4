package Badges;

import Awards.Badge;
import Awards.Wearing;

public class Emblem extends Badge {

    private String universityMerit;//заслуга перед государством
    private Form formOfOrder;

    public Emblem(String thankedFor,int uniqNum, Wearing wearing, String affiliation,String universityMerit) {
        super(thankedFor, uniqNum, wearing, affiliation);
        this.universityMerit = universityMerit;
        formOfOrder=Form.TRIANGLE;
    }

    protected Emblem(){

    }

    public void getEmblemInfo(){
        System.out.println(getThankedFor()+ ": " + universityMerit+ ": " + getWearing()+": " +getAffiliation());
    }

    public String getUniversityMerit(){
        return universityMerit;
    }
    public void setUniversityMerit(String universityMerit){
        this.universityMerit=universityMerit;
    }
}
