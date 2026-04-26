package bookmyshow.repository;

import bookmyshow.entities.Booking;

import java.util.*;

public class BookingRepository {
    private Map<UUID, List<Booking>> userBookings;

    public BookingRepository() {
        this.userBookings = new HashMap<>();
    }
    public void addUserBooking(UUID userId,Booking booking){
         userBookings.computeIfAbsent(userId,k->new ArrayList<>()).add(booking);
    }
    public void removeBooking(UUID userId,Booking booking){
          userBookings.getOrDefault(userId,new ArrayList<>()).remove(booking);
    }
    public List<Booking>getUserBooking(UUID userId){
         return userBookings.getOrDefault(userId,new ArrayList<>());
    }


}
