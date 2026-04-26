package bookmyshow.entities;

import bookmyshow.enums.City;
import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private int theatreId;
    private String theatreName;
    private City city;
    private List<Screen> screens;

    public Theatre(int theatreId, String theatreName, City city) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.city = city;
        this.screens =new ArrayList<Screen>();
    }
    public void  addScreen(Screen screen){
         screens.add(screen);
    }
    public void removeScreen(Screen screen){
         screens.remove(screen);
    }

    public String getTheatreName() {
        return theatreName;
    }

    public City getCity() {
        return city;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public int getTheatreId() {
        return theatreId;
    }
}
