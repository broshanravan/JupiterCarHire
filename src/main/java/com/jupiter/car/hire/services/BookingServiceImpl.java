package com.jupiter.car.hire.services;

import com.jupiter.car.hire.beans.Booking;
import com.jupiter.car.hire.beans.Payment;
import com.jupiter.car.hire.beans.Vehicle;
import com.jupiter.car.hire.enums.VehicleType;
import com.jupiter.car.hire.inventories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingInventory bookingInventory;

    @Autowired
    VehicleInventory vehicleInventory;

    Payment payment = null;
    PaymentInventory paymentInventory = new PaymentInventoryImpl();
    CustomerInventory customerInventory = new CustomerInventoryImpl();

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
     *Updates booking details
     * @param booking
     */
    public void updateBooKing(Booking booking){
        bookingInventory.updateNewBooking(booking);
    }

    /**
     * Closes a booking when the
     * vehicle  is returned and payment is completed
     * @param booking
     */
    public void closeBooking(Booking booking){
        bookingInventory.closeBooking(booking);
    }

    /**
     * retrieves booking details using thee booking reference
     * @param bookingReference
     * @return
     */
    public Booking getBookingDetails(long bookingReference){
        Booking booking = bookingInventory.retrieveBookingByRefNumber(bookingReference);
        return booking;

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
     * @param deposit
     * @param vehicleDamaged
     * @return
     */
    public long createNewBooking(double depositAmount,
                               long customerId,
                               long vehicleId,
                               Date startDate,
                               Date endDate,
                               double deposit,
                               boolean vehicleDamaged,
                               int intendedDays){

          double rentalPrice = calculateRentalPrice( vehicleId,  intendedDays);
          Booking booking = new Booking(customerId,
                                        vehicleId,
                                        startDate,
                                        endDate,
                                        rentalPrice,
                                        deposit,
                                        vehicleDamaged,intendedDays);


        long bookingReference =  bookingInventory.createNewBooking(booking);

      return bookingReference;

    }

    public double calculateRentalPrice(Long vehicleId, int daysNum){
        double rentalPrice = 0;
        double dailyPrice = 0;
        Vehicle vehicle = vehicleInventory.retrieveVehicleById(vehicleId);
        VehicleType vehicleType = vehicle.getVehicleType();
        if(vehicleType.toString().equalsIgnoreCase("car")){
            dailyPrice = 25;
        }else if(vehicleType.toString().equalsIgnoreCase("estate")){
            dailyPrice = 35;
        }else{
            dailyPrice = 50;
        }

        rentalPrice = dailyPrice * daysNum;

        return rentalPrice;
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
     * Uses car registration to retrieve the booking
     * contract for it
     * @param carReg
     * @return
     */
    public Booking getBookingDetailsByVehicleReg(String carReg){
        Booking booking = bookingInventory.retrieveBookingByCarReg( carReg);
        return booking;
    }

    /**
     * cancel existing booking at customer
     * Request
     * @param bookingId
     */
    public void cancelBooking(long bookingId){
        bookingInventory.cancelBooking(bookingId);

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
