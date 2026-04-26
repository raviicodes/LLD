package bookmyshow;

import bookmyshow.controller.BookingController;
import bookmyshow.controller.TheatreController;
import bookmyshow.entities.*;
import bookmyshow.enums.City;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class BookingApplication {
     private BookingController bookingController;
     private TheatreController theatreController;
     public BookingApplication(){
          this.bookingController=new BookingController();
          this.theatreController=new TheatreController();
     }
     public void addTheatre(Theatre theatre){
          theatreController.addTheatre(theatre);
     }
     public Set<Movie> getMovies(City city, LocalDate date){
         return   theatreController.getMovies(city,date);
     }
     public List<Show>getShows(Theatre theatre,Movie movie,LocalDate date){
          return theatreController.getShows(theatre,movie,date);
     }
     public List<Theatre>getTheatre(City city,Movie movie,LocalDate date){
          return  theatreController.getTheatres(city,date,movie);
     }
     public void bookSeats(Show show, List<Seat>seats, User user){
          try{
              bookingController.book(show,seats,user);
          }
          catch (Exception e){
              System.out.println(e.getMessage());
          }
     }

}
