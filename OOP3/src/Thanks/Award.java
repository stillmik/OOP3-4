package Thanks;

//награда
public class Award extends Thank {

    private int uniqNum;
    public Award(String thankedFor,int uniqNum) {
        super(thankedFor);
        this.uniqNum = uniqNum;
    }

    protected Award(){

    }

    public int getUniqNum() {
        return uniqNum;
    }

    public void setUniqNum(int uniqNum) {
        this.uniqNum = uniqNum;
    }
}
