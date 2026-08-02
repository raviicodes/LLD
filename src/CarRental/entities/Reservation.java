package CarRental.entities;

import CarRental.enums.ReservationStatus;
import CarRental.enums.ReservationType;


import java.time.LocalDate;

public class Reservation {
    private int reservationId;
    private User user;
    private Vehicle vehicle;
    private LocalDate  dateFrom;
    private LocalDate dateTo;
    private ReservationStatus reservationStatus;
    private ReservationType reservationType;

    public Reservation(int reservationId, User user, Vehicle vehicle, LocalDate dateFrom, LocalDate dateTo, ReservationType reservationType, ReservationStatus reservationStatus) {
        this.reservationId = reservationId;
        this.user = user;
        this.vehicle = vehicle;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.reservationType = reservationType;
        this.reservationStatus = reservationStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public User getUser() {
        return user;
    }

    public int getReservationId() {
        return reservationId;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }
    public void setReservationStatus(ReservationStatus reservationStatus){
         this.reservationStatus=reservationStatus;
    }
}
