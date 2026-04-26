package bookmyshow.entities;

import java.util.List;
import java.util.UUID;

public class Booking {
    private UUID bookingId;
    private List<Integer> seats;
   private Show show;
   private User user;
   private Payment payment;
    public Booking(List<Integer>seats, Show show,User user,Payment payment){
           this.bookingId=UUID.randomUUID();
           this.seats=seats;
           this.show=show;
            this.user=user;
             this.payment=payment;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public List<Integer> getSeats() {
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
