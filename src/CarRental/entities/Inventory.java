package CarRental.entities;

import CarRental.Utility;
import CarRental.enums.ReservationStatus;
import CarRental.enums.VehicleStatus;
import CarRental.enums.VehicleType;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class Inventory {
    private final ConcurrentHashMap<Integer,Vehicle> vehicleMap;
    private ReservationRepository reservationRepository;
    public Inventory() {
          this.vehicleMap=new ConcurrentHashMap<>();
    }
    public void setReservationRepository(ReservationRepository reservationRepository){
          this.reservationRepository=reservationRepository;
    }

    public ConcurrentHashMap<Integer, Vehicle> getVehicleMap() {
        return vehicleMap;
    }
    public void addVehicle(Vehicle vehicle){
         vehicleMap.putIfAbsent(vehicle.getVehicleId(),vehicle);
    }
    public void removeVehicle(int vehicleId){
        vehicleMap.remove(vehicleId);
    }
    public boolean isAvailable(Integer vehicleId, LocalDate fromDate,LocalDate toDate){
             Vehicle vehicle=vehicleMap.get(vehicleId);
             if(vehicle==null || vehicle.getVehicleStatus().equals(VehicleStatus.MAINTAINANCE)) return false;
             List<Reservation>reservations=reservationRepository.getVehicleReservations(vehicleId);
             if(reservations==null || reservations.isEmpty()) return true;
              for(Reservation reservation:reservations){
                        if((reservation.getReservationStatus()== ReservationStatus.CREATED || reservation.getReservationStatus()==ReservationStatus.IN_PROGRESS) &&   Utility.isOverLapping(reservation,fromDate,toDate)) return  false;
              }
              return true;
    }
    public List<Vehicle> getAvailableVehicles(VehicleType vehicleType,LocalDate bookFrom, LocalDate bookTo){
           return    vehicleMap.values().stream().filter(vehicle -> vehicle.getVehicleType().equals(vehicleType)).filter(vehicle -> isAvailable(vehicle.getVehicleId(),bookFrom,bookTo)).toList();
    }
}
