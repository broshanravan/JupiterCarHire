package com.jupiter.car.hire.services;

import com.jupiter.car.hire.beans.Vehicle;
import com.jupiter.car.hire.inventories.VehicleInventory;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleServiceImpl implements VehicleService{


    @Autowired
    VehicleInventory vehicleInventory;

    public Vehicle retrieveVehicleByReg(String registrationNumber){
        Vehicle vehicle = vehicleInventory.retrieveVehicleByReg(registrationNumber);

        return vehicle;
    }

    public void addNewVehicle(Vehicle vehicle){
        vehicleInventory.addNewVehicle(vehicle);

    }

    public void updateVehicleDetails(Vehicle vehicle){
        vehicleInventory.updateVehicleDetail(vehicle);

    }
}
