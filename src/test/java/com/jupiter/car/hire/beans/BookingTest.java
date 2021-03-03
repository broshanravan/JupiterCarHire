package com.jupiter.car.hire.beans;

import com.jupiter.car.hire.enums.CustomerType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    private static Customer customer;


    @Test
    public void testConstructor(){
        Booking booking = new Booking(
        14, 20, new Date(), null, 343, 100, false ,10);
        assert(booking.getCustomerId() ==14);
        assert(booking.getVehicleId() == 20);
        assertEquals(booking.getStartDate(),new Date());
        assert(booking.getEndDate() == null);
        assert(booking.getDeposit() ==100);
        assert(!booking.isVehicleDamaged());
        assert(booking.getIntendedDays() ==10);

    }

}
