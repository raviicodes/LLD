package bookmyshow.controller;

import bookmyshow.entities.Booking;
import bookmyshow.entities.Seat;
import bookmyshow.entities.Show;
import bookmyshow.entities.User;
import bookmyshow.repository.BookingRepository;
import bookmyshow.service.BookingService;

import java.util.List;

public class BookingController {
     private BookingService bookingService;
     public BookingController(){
           this.bookingService =new BookingService();
     }
     public Booking book(Show show, List<Seat>seats, User user){
             return bookingService.bookSeats(show,seats,user);
     }


}
