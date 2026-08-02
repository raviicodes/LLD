package CarRental.controllers;

import CarRental.entities.*;
import CarRental.enums.ReservationStatus;
import CarRental.enums.ReservationType;

import java.time.LocalDate;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReservationManager {
    private final Inventory inventory;
    private ReservationRepository reservationRepository;
    private final ConcurrentHashMap<Integer, ReentrantLock> locks;
    private final AtomicInteger reservationIdGenerator=new AtomicInteger(0);
    public ReservationManager(Inventory inventory, int reservationManagerId) {
        this.inventory = inventory;
         this.locks=new ConcurrentHashMap<>();
    }
    public void setReservationRepository(ReservationRepository reservationRepository){
         this.reservationRepository=reservationRepository;
    }

    private ReentrantLock getLock(int vehicleId){
        return locks.computeIfAbsent(vehicleId,k->new ReentrantLock());
    }
     public Reservation reserveVehicle(Vehicle vehicle, User user, LocalDate bookFrom, LocalDate bookTo){
              ReentrantLock lock=getLock(vehicle.getVehicleId());
               try{
                   lock.lock();
                    if(inventory.isAvailable(vehicle.getVehicleId(), bookFrom,bookTo)){
                        int reservationId=reservationIdGenerator.getAndIncrement();
                        Reservation reservation=new Reservation(reservationId,user,vehicle,bookFrom,bookTo,ReservationType.DAILY,ReservationStatus.CREATED);
                        reservationRepository.save(reservation);
                        reservationRepository.addVehicleReservation(reservation);
                         return reservation;
                    }
                    throw new RuntimeException("Vehilce is not available");
               }
                finally {
                   lock.unlock();
               }
     }

     public Reservation getReservationById(int reservationId){
           return reservationRepository.getReservationById(reservationId).orElseThrow(()->new RuntimeException("Reservation not found"));
     }
     public void cancelReservation(int reservationId){
         Reservation reservation=reservationRepository.getReservationById(reservationId).orElseThrow(()->  new RuntimeException("No reservation found"));
         Lock lock=getLock(reservation.getVehicle().getVehicleId());
          try{
               lock.lock();
               reservation.setReservationStatus(ReservationStatus.CANCELED);
          }
          finally {
              lock.unlock();
          }
     }
    public void startTrip(int reservationId){
        Reservation reservation=reservationRepository.getReservationById(reservationId).orElseThrow(()->  new RuntimeException("No reservation found"));
        Lock lock=getLock(reservation.getVehicle().getVehicleId());
        try{
            lock.lock();
            reservation.setReservationStatus(ReservationStatus.IN_PROGRESS);
        }
        finally {
            lock.unlock();
        }
    }
    public void completeTrip(int reservationId){
        Reservation reservation=reservationRepository.getReservationById(reservationId).orElseThrow(()->  new RuntimeException("No reservation found"));
        Lock lock=getLock(reservation.getVehicle().getVehicleId());
        try{
            lock.lock();
            reservation.setReservationStatus(ReservationStatus.COMPLETED);
        }
        finally {
            lock.unlock();
        }
    }

}
