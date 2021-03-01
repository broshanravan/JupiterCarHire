package com.jupiter.car.hire.inventories;

import com.jupiter.car.hire.beans.Vehicle;

public interface VehicleInventory {
    public Vehicle retrieveVehicleByReg(String registrationNum);
    public Vehicle retrieveVehicleById(long bookingId);
    public void addNewVehicle(Vehicle vehicle);
    public void updateVehicleDetail(Vehicle vehicle);

}
