package com.jupiter.car.hire.enterprise.controllers;


import com.jupiter.car.hire.beans.Vehicle;
import com.jupiter.car.hire.business.VehicleService;
import com.jupiter.car.hire.enums.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value="/getVehicleDetails")
    public Vehicle getVehicle(@RequestParam String RegistrationNum, Model model){
        Vehicle Vehicle = vehicleService.retrieveVehicleByReg(RegistrationNum);

        return Vehicle;

    }

    @RequestMapping(value="/updateVehicleDetails")
    public void updateVehicleDetails(@RequestParam String RegistrationNum,
                                     @RequestParam long vehicleId,
                                     @RequestParam VehicleType vehicleType,
                                     @RequestParam String registration,
                                     @RequestParam long engineSize,
                                     @RequestParam double pricePerDay,
                                     Model model){
        Vehicle vehicle = new  Vehicle(vehicleId, vehicleType,  registration, engineSize, pricePerDay);
        vehicleService.updateVehicleDetails(vehicle);



    }

    @RequestMapping(value="/newVehicleDetails")
    public void createNewVehicle(@RequestParam String RegistrationNum,
                                     @RequestParam VehicleType vehicleType,
                                     @RequestParam String registration,
                                     @RequestParam long engineSize,
                                     @RequestParam double pricePerDay,
                                     Model model){
        Vehicle vehicle = new  Vehicle(vehicleType,  registration, engineSize, pricePerDay);
        vehicleService.updateVehicleDetails(vehicle);
    }
}

