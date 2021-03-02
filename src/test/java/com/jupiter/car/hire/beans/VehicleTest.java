package com.jupiter.car.hire.beans;

import com.jupiter.car.hire.enums.VehicleType;
import com.jupiter.car.hire.inventories.VehicleInventoryImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VehicleTest {

    private static Vehicle vehicle;
    @BeforeClass
    public static void Setup() {
         vehicle = new Vehicle(2222, VehicleType.car,  "AB123C", 2.4, 20) ;
    }

    @Test
    public void testRetrieveVehicleByReg(){;
        assert(vehicle.getVehicleId()==2222);
        assert(vehicle.getVehicleType().equals(VehicleType.car));
        assert (vehicle.getEngineSize() ==2.4);

    }
}
