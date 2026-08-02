package SplitWiseLLD.entities;

public class FriendBalance {
    private double oweAmount;
    private double getBackAmount;
    public FriendBalance(){
         this.getBackAmount=0;
         this.oweAmount=0;
    }

    public double getOweAmount() {
        return oweAmount;
    }

    public double getGetBackAmount() {
        return getBackAmount;
    }

    public void setOweAmount(double oweAmount) {
        this.oweAmount = oweAmount;
    }

    public void setGetBackAmount(double getBackAmount) {
        this.getBackAmount = getBackAmount;
    }
}
