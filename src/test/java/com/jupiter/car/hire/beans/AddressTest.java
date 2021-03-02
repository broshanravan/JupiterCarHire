package com.jupiter.car.hire.beans;

import com.jupiter.car.hire.enums.VehicleType;
import com.jupiter.car.hire.inventories.VehicleInventoryImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressTest {

    private static Address address;

    @BeforeClass
    public static void Setup() {
        address = new Address("Ghosts house", "22","Shadow Street", "The cemetery", "Transylvania","TR2 ll3" );
    }

    @Test
    public void testConstructor(){
        assert("Ghosts house".equalsIgnoreCase(address.getHouseName()));
        assert("22".equals(address.getHouseNumber()));
        assert("Shadow Street".equalsIgnoreCase(address.getAddress1()));
        assert("THe Cemetery".equalsIgnoreCase(address.getAddress2()));
        assert("Transylvania".equalsIgnoreCase(address.getTown())) ;
        assert("TR2 ll3".equalsIgnoreCase(address.getPostcode()));

    }
}
