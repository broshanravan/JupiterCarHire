package com.jupiter.car.hire.services;

import com.jupiter.car.hire.beans.Vehicle;
import com.jupiter.car.hire.enums.VehicleType;
import com.jupiter.car.hire.inventories.VehicleInventory;
import com.jupiter.car.hire.inventories.VehicleInventoryImpl;
import static org.mockito.Mockito.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class VehicleServiceTest {

    private static VehicleInventory inventory ;

    /**
     * Preparing the neded atributes
     * for the Test
     */
    @BeforeClass
    public static void Setup() {
        inventory = mock(VehicleInventoryImpl.class);
        Vehicle vehicle = new Vehicle(2222, VehicleType.car,  "AB123C", 2.4, 20) ;
        when(inventory.retrieveVehicleByReg("AB123C")).thenReturn(vehicle);

    }

    @Test
    public void testRetrieveVehicleByReg(){
        Vehicle vehicle = inventory.retrieveVehicleByReg("AB123C");
        assert(vehicle.getVehicleId()==2222);
        assert(vehicle.getVehicleType().equals(VehicleType.car));
        assert (vehicle.getEngineSize() ==2.4);

    }



}
