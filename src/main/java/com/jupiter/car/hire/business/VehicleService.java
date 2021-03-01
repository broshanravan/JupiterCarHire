package com.jupiter.car.hire.business;

import com.jupiter.car.hire.beans.Vehicle;

public interface VehicleService {

    public Vehicle retrieveVehicleByReg(String registrationNumbe);

    public void addNewVehicle(Vehicle vehicle);

    public void updateVehicleDetails(Vehicle vehicle);
}
