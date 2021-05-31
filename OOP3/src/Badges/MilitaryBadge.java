package Badges;

import Awards.Badge;
import Awards.Wearing;

public class MilitaryBadge extends Badge {

    private String post;

    public MilitaryBadge(String thankedFor, int uniqNum, Wearing wearing, String affiliation,String post) {
        super(thankedFor, uniqNum, wearing, affiliation);
        this.post = post;
    }

    protected MilitaryBadge(){

    }

    public void getMilitaryInfo(){
        System.out.println(getThankedFor()+ ": " + post+ ": " + getWearing()+": " +getAffiliation());
    }

    public String getPost(){
        return post;
    }
    public void setPost(String post){
        this.post=post;
    }
}
