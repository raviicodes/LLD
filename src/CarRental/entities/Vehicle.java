package CarRental.entities;

import CarRental.enums.VehicleStatus;
import CarRental.enums.VehicleType;

public class Vehicle {
    private int vehicleId;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private VehicleStatus vehicleStatus;
    private double dailyRentalCost;

    public Vehicle(int vehicleId,String vehicleNumber, VehicleType vehicleType, VehicleStatus vehicleStatus, double dailyRentalCost) {
        this.vehicleId = vehicleId;
         this.vehicleNumber=vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleStatus = vehicleStatus;
        this.dailyRentalCost = dailyRentalCost;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public double getDailyRentalCost() {
        return dailyRentalCost;
    }
}
