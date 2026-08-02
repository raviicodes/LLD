package SplitWiseLLD.entities;

import java.util.List;

public class PercentageSplitValidator implements ExpenseSplitValidator{
    @Override
    public List<Split> validate(List<Split> splits, double totalAmount) {
        return List.of();
    }
}
