package ObserverPattern;


public interface Observable<T> {
    void addObserver(Observer observer);
    void  notifyObserver();
    void removeObserver(Observer observer);
     T getState();
}
