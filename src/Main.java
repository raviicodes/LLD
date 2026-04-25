import DecoratorPattern.BaseCoffee;
import DecoratorPattern.Coffee;
import DecoratorPattern.ExtraCream;

public class Main {
    public static void main(String[] args) {
        Coffee coffeeWithExtraCream=new ExtraCream(new BaseCoffee());
        System.out.println(coffeeWithExtraCream.getCost());
    }
}
