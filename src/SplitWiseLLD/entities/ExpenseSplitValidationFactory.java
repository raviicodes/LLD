package SplitWiseLLD.entities;

import SplitWiseLLD.enums.SplitType;

public class ExpenseSplitValidationFactory {
    public ExpenseSplitValidator getExpenseSplitValidator(SplitType splitType){
       return   switch (splitType){
             case EQUAL ->   new EqualSplitValidator();
             case  UNEQUAL -> new NonEqualExpenseValidator();
             case PERCENTAGE -> new PercentageSplitValidator();
             default ->  throw new RuntimeException(splitType+" is not supported");
         };

    }
}
