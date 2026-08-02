package SplitWiseLLD.entities;

public class PercentageSplit  extends Split{
    private final double splitPercentage;
    public PercentageSplit(User user,double splitPercentage) {
        super(user);
         this.splitPercentage=splitPercentage;
    }

    public double getSplitPercentage() {
        return splitPercentage;
    }
}
