package com.jupiter.car.hire.business;

import com.jupiter.car.hire.beans.Vehicle;
import com.jupiter.car.hire.inventories.VehicleInventory;
import com.jupiter.car.hire.inventories.VehicleInventoryImpl;

public class VehicleServiceImpl implements VehicleService{


    VehicleInventory vehicleInventory = new VehicleInventoryImpl();

    public Vehicle retrieveVehicleByReg(String registrationNumber){
        Vehicle vehicle = new Vehicle();

        return vehicle;
    }

    public void addNewVehicle(Vehicle vehicle){
        vehicleInventory.addNewVehicle(vehicle);

    }

    public void updateVehicleDetails(Vehicle vehicle){
        vehicleInventory.updateVehicleDetail(vehicle);

    }
}
