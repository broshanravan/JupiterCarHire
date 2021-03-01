package com.jupiter.car.hire.business;

import com.jupiter.car.hire.beans.Booking;
import com.jupiter.car.hire.beans.Payment;
import com.jupiter.car.hire.enums.VehicleType;

import java.util.Date;

public interface BookingService {

    public Payment getPaymentDetails(long bookingRef);

    public boolean isBookingClosed(long bookingReference, double paymentAmount, double damageDue);

    public long createNewBooking(double depositAmount,
                                 long customerId,
                                 long vehicleId,
                                 Date startDate,
                                 Date endDate,
                                 double rentalPrice,
                                 double deposit,
                                 boolean vehicleDamaged);




}

