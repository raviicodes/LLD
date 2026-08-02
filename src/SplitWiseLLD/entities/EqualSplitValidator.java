package SplitWiseLLD.entities;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitValidator implements ExpenseSplitValidator{
    @Override
    public List<Split> validate(List<Split> splits,double totalAmount) {
        List<Split>equalSplits=new ArrayList<>();
        double splitAmount=totalAmount/splits.size();
        for(Split split:splits){
            equalSplits.add(new ExactSplit(split.getUser(),splitAmount));
        }
         return equalSplits;
    }
}
