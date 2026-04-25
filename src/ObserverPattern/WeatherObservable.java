package ObserverPattern;

import java.util.List;

public class WeatherObservable implements Observable<Integer>{
    private java.lang.Integer temprature;
    private List<Observer> observerList;
    @Override
    public void addObserver(Observer observer) {
              observerList.add(observer);
    }

    @Override
    public void notifyObserver() {
           for(Observer e:observerList)e.update();
    }

    @Override
    public void removeObserver(Observer observer) {
              observerList.remove(observer);
    }

    @Override
    public Integer getState() {
       return  this.temprature;
    }

    public void updateTemperature(int temprature) {
              this.temprature=temprature;
              notifyObserver();
    }
}
