package DecoratorPattern;

public class ExtraCream  extends CoffeeDecorator{
     protected  Coffee basecoffee;
    public  ExtraCream(Coffee coffee){
         this.basecoffee=coffee;
    }
    @Override
   public double getCost() {
        return 10.0+basecoffee.getCost();
    }
}
