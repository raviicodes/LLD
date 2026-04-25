package ObserverPattern;

public class TVobserver  extends Observer{
    public TVobserver(Observable observable) {
        super(observable);
    }

    @Override
    void update() {
        System.out.println(observable.getState());
    }
}
