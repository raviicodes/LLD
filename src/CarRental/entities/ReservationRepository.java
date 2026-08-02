package CarRental.entities;

import CarRental.enums.ReservationStatus;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ReservationRepository {
    private ConcurrentHashMap<Integer, Reservation>reservations;
    private ConcurrentHashMap<Integer,List<Reservation>>vehicleReservations;
    public ReservationRepository() {
        this.reservations =new ConcurrentHashMap<>();
         this.vehicleReservations=new ConcurrentHashMap<>();
    }
    public Optional<Reservation> getReservationById(int reservationId){
         return Optional.ofNullable(reservations.get(reservationId));
    }
    public void save(Reservation reservation){
         reservations.put(reservation.getReservationId(),reservation);
    }
    public List<Reservation>getVehicleReservations(int vehicleId){
         return vehicleReservations.get(vehicleId);
    }
    public void addVehicleReservation(Reservation reservation){
         vehicleReservations.computeIfAbsent(reservation.getVehicle().getVehicleId(),k->List.of()).add(reservation);
    }
}
