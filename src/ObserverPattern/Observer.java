package ObserverPattern;

public abstract class Observer<T> {
    protected Observable<T> observable;

    public Observer(Observable<T> observable) {
        this.observable = observable;
    }

    abstract void update();
}