package CarRental;

import CarRental.entities.Reservation;

import java.time.LocalDate;

public class Utility {
    public static boolean isOverLapping(Reservation reservation, LocalDate bookedFrom,LocalDate bookedTo){
         return !(bookedFrom.isAfter(reservation.getDateTo()) || bookedTo.isBefore(reservation.getDateFrom()));
    }
}
