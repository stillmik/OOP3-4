package Badges;
import Awards.Badge;
import Awards.Wearing;

public class Order extends Badge {

    private String stateMerit;//заслуга перед государством
    private Form form;

    public Order(String thankedFor, int uniqNum, Wearing wearing, String affiliation, String stateMerit, Form form) {
        super(thankedFor, uniqNum, wearing, affiliation);
        this.stateMerit=stateMerit;
        this.form = form;
    }

    protected Order(){

    }

    public void getOrderInfo(){
        System.out.println(form+ ": " + stateMerit+ ": " + getWearing()+": " +getAffiliation());
    }

    public String getStateMerit(){
        return stateMerit;
    }
    public void setStateMerit(String branchMerit){
        this.stateMerit=stateMerit;
    }
}
