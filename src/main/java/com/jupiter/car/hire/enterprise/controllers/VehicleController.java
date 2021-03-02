package com.jupiter.car.hire.enterprise.controllers;


import com.jupiter.car.hire.beans.Vehicle;
import com.jupiter.car.hire.business.VehicleService;
import com.jupiter.car.hire.enums.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    /**
     * retrieving vehicle details from DB
     * using its registration number
     * and passing it to the front controller
     * to be displayes
     * @param RegistrationNum
     * @param model
     * @return
     */
    @RequestMapping(value="/getVehicleDetails")
    public String getVehicle(@RequestParam String RegistrationNum, ModelMap model){
        Vehicle Vehicle = vehicleService.retrieveVehicleByReg(RegistrationNum);
        model.put("registration",Vehicle.getRegistration());
        model.put("vehicleType",Vehicle.getVehicleType());
        model.put("engineSize",Vehicle.getEngineSize());
        model.put("dailyRentalPrice",Vehicle.getPricePerDay());
        return "vehicleMaintenance";

    }

    /**
     * to update capture vehicle details from
     * the front controller
     *  and passing it to the service classes
     *  to be saved to the Database
     * @param RegistrationNum
     * @param vehicleId
     * @param vehicleType
     * @param registration
     * @param engineSize
     * @param pricePerDay
     * @param model
     */
    @RequestMapping(value="/updateVehicleDetails")
    public String updateVehicleDetails(@RequestParam String RegistrationNum,
                                     @RequestParam long vehicleId,
                                     @RequestParam VehicleType vehicleType,
                                     @RequestParam String registration,
                                     @RequestParam long engineSize,
                                     @RequestParam double pricePerDay,
                                     ModelMap model){
        Vehicle vehicle = new  Vehicle(vehicleId, vehicleType,  registration, engineSize, pricePerDay);
        vehicleService.updateVehicleDetails(vehicle);
        return "vehicleMaintenance";

    }

    /**
     * to capture the details of
     * new vehicles being added to the
     * freet and passing them to
     * the service classes to
     * be processes for
     * being saved to the database
     * @param RegistrationNum
     * @param vehicleType
     * @param registration
     * @param engineSize
     * @param pricePerDay
     * @param model
     */
    @RequestMapping(value="/newVehicleDetails")
    public String createNewVehicle(@RequestParam String RegistrationNum,
                                     @RequestParam VehicleType vehicleType,
                                     @RequestParam String registration,
                                     @RequestParam long engineSize,
                                     @RequestParam double pricePerDay,
                                 ModelMap model){
        Vehicle vehicle = new  Vehicle(vehicleType,  registration, engineSize, pricePerDay);
        vehicleService.updateVehicleDetails(vehicle);

        return "vehicleMaintenance";
    }
}

