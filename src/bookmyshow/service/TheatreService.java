package bookmyshow.service;

import bookmyshow.entities.Movie;
import bookmyshow.entities.Screen;
import bookmyshow.entities.Show;
import bookmyshow.entities.Theatre;
import bookmyshow.enums.City;

import java.time.LocalDate;
import java.util.*;

public class TheatreService {
    private Map<City, List<Theatre>> theatresByCity;
     public void ThreatreService(){
          this.theatresByCity=new HashMap<>();
     }
     // addTheatre
     public void addTheatre(Theatre theatre){
          theatresByCity.computeIfAbsent(theatre.getCity(),k->new ArrayList<>()).add(theatre);
     }
     public void removeThreatre(Theatre theatre){
        theatresByCity.getOrDefault(theatre.getCity(),new ArrayList<>()).remove(theatre);
     }

     // getMovie in specific city and date
    public Set<Movie> getMovies(City city, LocalDate showDate){
         List<Theatre>theatres=theatresByCity.getOrDefault(city,new ArrayList<>());
        Set<Movie>movies=new HashSet<>();
         for(Theatre theatre:theatres){
              for(Screen screen:theatre.getScreens()){
                   List<Show>shows=screen.getShowByDates(showDate);
                       for(Show show:shows ){
                            movies.add(show.getMovie());
                       }
              }
         }
          return movies;
    }
    public List<Theatre>getTheatre(City city,Movie movie,LocalDate date){
              List<Theatre>theatres=theatresByCity.getOrDefault(city,new ArrayList<>());
              return  theatres.stream().filter(th->th.getScreens().stream().anyMatch(screen -> screen.getShowByDates(date).stream().anyMatch(show -> show.getMovie().equals(movie)))).toList();
    }
    public List<Show>getShows(Movie movie,LocalDate date,Theatre theatre){
         List<Show>ans=new ArrayList<>();
         for(Screen screen:theatre.getScreens()){
              for(Show show: screen.getShowByDates(date)){
                  if(show.getMovie().equals(movie)) ans.add(show);
              }
         }
          return ans;
    }


 }
