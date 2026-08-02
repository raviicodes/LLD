package SplitWiseLLD.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BalanceSheet {
    private final Map<UUID,FriendBalance> friendBalanceMap;
    private double totalExpense;
    private double totalOweAmount;
    private double totalGetBackAmount;

    public BalanceSheet() {
         this.friendBalanceMap=new HashMap<>();
         this.totalExpense=0;
         this.totalGetBackAmount=0;
         this.totalOweAmount=0;
    }
    public void updateBalance(User user,double getBackAmount){
        FriendBalance balance =
                friendBalanceMap.computeIfAbsent(
                        user.getUserId(),
                        k -> new FriendBalance()
                );
        double oldOweAmount=balance.getOweAmount();
        double oldGetBackAmount=balance.getGetBackAmount();
        double resultantAmount=oldGetBackAmount+getBackAmount-oldOweAmount;
         if(resultantAmount>0){
             balance.setGetBackAmount(resultantAmount);
             balance.setOweAmount(0);
         }
         else {
             balance.setOweAmount(Math.abs(resultantAmount));
             balance.setGetBackAmount(0);
         }
    }
    public void setTotalGetBack(double splitAmount){
          double resultant=totalGetBackAmount-totalOweAmount+splitAmount;
           if(resultant<0){
               totalGetBackAmount=0;
               totalOweAmount=Math.abs(resultant);
           }
           else {
                totalOweAmount=0;
                totalGetBackAmount=resultant;
           }

    }
    public void setTotalExpense(double splitAmount){
         totalExpense+=splitAmount;
    }

}
