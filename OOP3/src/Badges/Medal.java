package Badges;

import Awards.Badge;
import Awards.Wearing;

public class Medal extends Badge {

    private String branchMerit;//заслуга перед государством
    private Form form;

    public Medal(String thankedFor,int uniqNum, Wearing wearing, String affiliation,String branchMerit) {
        super(thankedFor, uniqNum,wearing, affiliation);
        this.branchMerit=branchMerit;
        form=Form.CIRCLE;
    }

    public Medal(){
    }

    public void getMedalInfo(){
        System.out.println(form+ ": " + branchMerit+ ": " + getWearing()+": " +getAffiliation());
    }

    public String getBranchMerit(){
        return branchMerit;
    }
    public void setBranchMerit(String branchMerit){
        this.branchMerit=branchMerit;
    }
}
