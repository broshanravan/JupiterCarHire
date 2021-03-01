package com.jupiter.car.hire.business;

import com.jupiter.car.hire.beans.Booking;
import com.jupiter.car.hire.beans.Payment;
import com.jupiter.car.hire.beans.Vehicle;
import com.jupiter.car.hire.enums.VehicleType;
import com.jupiter.car.hire.inventories.*;

import java.util.Date;

public class BookingServiceImpl implements BookingService{

    Payment payment = null;
    PaymentInventory paymentInventory = new PaymentInventoryImpl();
    CustomerInventory customerInventory = new CustomerInventoryImpl();
    VehicleInventory vehicleInventory = new VehicleInventoryImpl();
    BookingInventory bookingInventory = new BookingInventoryImpl();

    /**
     * retrieves the customer
     * payment amount
     * using their booking Id
     * @param bookingRef
     * @return
     */
    public Payment getPaymentDetails(long bookingRef){
        if(payment ==null) {
            payment = paymentInventory.retrievePayment(bookingRef);
        }
        return payment;
    }

    /**
     * creates new booking uding
     * customer,vehicle and
     * deposite details
     * @param depositAmount
     * @param customerId
     * @param vehicleId
     * @param startDate
     * @param endDate
     * @param rentalPrice
     * @param deposit
     * @param vehicleDamaged
     * @return
     */
    public long createNewBooking(double depositAmount,
                               long customerId,
                               long vehicleId,
                               Date startDate,
                               Date endDate,
                               double rentalPrice,
                               double deposit,
                               boolean vehicleDamaged){


          Booking booking = new Booking(customerId,
                                        vehicleId,
                                        startDate,
                                        endDate,
                                        rentalPrice,
                                        deposit,
                                        vehicleDamaged);



        long bookingReference =  bookingInventory.createNewBooking(booking);



      return bookingReference;

    }


    /**
     * closes booking after
     * balance due is payed
     * @param bookingReference
     * @param paymentAmount
     */
    public boolean isBookingClosed(long bookingReference, double paymentAmount, double damageDue){
        boolean bookingClosed =false;
        Booking booking = bookingInventory.retrieveBookingByRefNumber(bookingReference);
        Vehicle vehicle = vehicleInventory.retrieveVehicleById(booking.getVehicleId());

        double amountDue = this.calculateAmountDue(booking.getStartDate(), new Date(),
                booking.getDeposit(),
                vehicle.getVehicleType(),
                damageDue);
        if(amountDue ==paymentAmount) {
            bookingInventory.closeBooking(booking);
            bookingClosed = true;
        }
        return bookingClosed;

    }

    /**
     * calculating final amount
     * due from customer
     * @param startDate
     * @param endDate
     * @param deposit
     * @param vehicleType
     * @param damageDue
     * @return
     */
    private double calculateAmountDue(Date startDate, Date endDate, double deposit, VehicleType vehicleType, double damageDue){
        double paymentDue = 0;
        long numberOfDays = startDate.getTime() - endDate.getTime();
        double pricePerDay = 50;
        double totalPrice = pricePerDay * numberOfDays + damageDue;
        paymentDue = totalPrice - deposit;

        return paymentDue;
     }

}
