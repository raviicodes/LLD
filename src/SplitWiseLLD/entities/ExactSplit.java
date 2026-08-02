package SplitWiseLLD.entities;

public class ExactSplit extends Split {
    private final double splitAmount;

    public ExactSplit(User user,double splitAmount) {
        super(user);
         this.splitAmount=splitAmount;
    }

    public double getSplitAmount() {
        return splitAmount;
    }
}
