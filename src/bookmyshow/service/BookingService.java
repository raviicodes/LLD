package bookmyshow.service;

import bookmyshow.entities.*;
import bookmyshow.enums.PaymentStatus;
import bookmyshow.enums.SeatStatus;
import bookmyshow.repository.BookingRepository;

import java.util.List;
import java.util.UUID;

public class BookingService {
    private BookingRepository bookingRepository;
    public BookingService(){
         this.bookingRepository=new BookingRepository();
    }
    public Booking bookSeats(Show show, List<Seat> seatList, User user){
         if(!show.lockSeats(seatList)){
              throw new RuntimeException("No seats Available");
         }
        // Payment flow goes here
        Payment payment=new Payment(1000, PaymentStatus.SUCCESS,show.getShowDate());
          if(payment.getPaymentStatus()==PaymentStatus.SUCCESS){
               show.confirmSeats(seatList);
               Booking booking=new Booking(seatList,show,user,payment);
               bookingRepository.addUserBooking(user.getUserId(),booking);
                return booking;
          }
          else {
              show.releaseSeats(seatList);
               throw new RuntimeException("Payment Failed");
          }
    }
   public  List<Booking> getUserBooking(UUID userId){
         return bookingRepository.getUserBooking(userId);
   }
}
