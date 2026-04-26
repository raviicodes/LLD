package bookmyshow.entities;

import java.time.LocalDate;
import java.util.*;

public class Screen {
    private int screenId;
    private String screenName;
    private Map<LocalDate, List<Show>>showByDates;
    private List<Seat>seats;

    public Screen(String screenName, int screenId, List<Seat> seats) {
        this.screenName = screenName;
        this.screenId = screenId;
        this.showByDates = new HashMap<>();
        this.seats = seats;
    }
    public  void  addShow(Show show){
         showByDates.computeIfAbsent(show.getShowDate(),k->new ArrayList<>()).add(show);
    }

    public List<Show> getShowByDates(LocalDate date) {
               return showByDates.getOrDefault(date,new ArrayList<>());
    }

}
