package SplitWiseLLD.entities;

import java.util.List;

public interface ExpenseSplitValidator {
    List<Split>validate(List<Split>splits,double totalAmount);
}
