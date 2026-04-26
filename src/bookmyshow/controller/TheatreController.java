package bookmyshow.controller;

import bookmyshow.entities.*;
import bookmyshow.enums.City;
import bookmyshow.service.BookingService;
import bookmyshow.service.TheatreService;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class TheatreController {
    private TheatreService theatreService;
    public TheatreController(){
         this.theatreService=new TheatreService();
    }
    public void addTheatre(Theatre theatre){
         theatreService.addTheatre(theatre);
    }
    public void removeTheatre(Theatre theatre){
         theatreService.removeThreatre(theatre);
    }
    public Set<Movie> getMovies(City city, LocalDate date){
         return theatreService.getMovies(city,date);
    }
    public List<Theatre> getTheatres(City city, LocalDate date, Movie movie){
         return theatreService.getTheatre(city,movie,date);
    }
    public List<Show>getShows(Theatre theatre,Movie movie,LocalDate date){
         return theatreService.getShows(movie,date,theatre);
    }

}
