package com.jupiter.car.hire.inventories;

import com.jupiter.car.hire.beans.Booking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public interface BookingInventory {

    public Booking retrieveBookingByRefNumber(long bookingReference);
    public Booking retrieveBookingByCarReg(String carReg);
    public long createNewBooking(Booking booking);
    public void closeBooking (Booking booking);
    public void updateNewBooking(Booking booking);


}
