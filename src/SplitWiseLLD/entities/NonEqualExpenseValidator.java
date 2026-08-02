package SplitWiseLLD.entities;

import java.util.ArrayList;
import java.util.List;

public class NonEqualExpenseValidator implements ExpenseSplitValidator{
    @Override
    public List<Split> validate(List<Split> splits, double totalAmount) {
         double splitAmounts=0;
         List<Split>exactSplits=new ArrayList<>();
          for(Split split:splits){
               ExactSplit temp=(ExactSplit)split;
               exactSplits.add(temp);
               splitAmounts+=temp.getSplitAmount();
          }
           if(splitAmounts!=totalAmount){
                throw new RuntimeException("invalid amount splits");
           }
           return exactSplits;
    }
}
