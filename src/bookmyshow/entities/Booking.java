package bookmyshow.entities;

import java.util.List;
import java.util.UUID;

public class Booking {
    private UUID bookingId;
    private List<String> seats;
   private Show show;
   private User user;
   private Payment payment;
    public Booking(List<Seat>seats, Show show,User user,Payment payment){
           this.bookingId=UUID.randomUUID();
           this.seats=seats.stream().map(Seat::getSeatId).toList();
           this.show=show;
            this.user=user;
             this.payment=payment;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public List<String> getSeats() {
        return seats;
    }

    public Show getShow() {
        return show;
    }

    public User getUser() {
        return user;
    }

    public Payment getPayment() {
        return payment;
    }
}
