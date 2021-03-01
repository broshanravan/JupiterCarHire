package com.jupiter.car.hire.beans;

import java.util.Date;

public class Booking {

    private long bookingId;
    private long customerId;
    private long vehicleId;
    private Date startDate;
    private Date endDate;
    private double totalPrice;
    private double deposit;
    private boolean vehicleDamaged;
    private boolean closed;

    public Booking(long bookingId, long customerId,
                   long vehicleId, Date startDate,
                   Date endDate, double totalPrice,
                   double deposit, boolean vehicleDamaged, boolean  closed) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.deposit = deposit;
        this.vehicleDamaged = vehicleDamaged;
        this.closed = closed;
    }

    public Booking(long customerId,
                   long vehicleId, Date startDate,
                   Date endDate, double totalPrice,
                   double deposit, boolean vehicleDamaged) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.deposit = deposit;
        this.vehicleDamaged = vehicleDamaged;
    }

    public Booking(){

    }


    /**
     * gets booking Id
     * @return
     */
    public long getBookingId() {
        return bookingId;
    }

    /**
     *
     *  bookingId being set
     * @param bookingId
     */
    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * retrieves customer Id
     * @return
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
     * customer Id to be set
     * @param customerId
     */
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    /**
     * retrieves vehicle Id
     * @return
     */
    public long getVehicleId() {
        return vehicleId;
    }

    /**
     *vehicle id to be set
     * @param vehicleId
     */
    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * retrieves the date of booking
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * start date to be set
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * retrive nooking end date
     * @return
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * booking end date to be set
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * retrieves rental price
     * @return
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * rental price to be set
     * @param totalPrice
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * retrive deposit amount
     * @return
     */
    public double getDeposit() {
        return deposit;
    }

    /**
     * Deposit amount to be set
     * @param deposit
     */
    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    /**
     * finds if editionsl damage made to the vehicle
     * @return
     */
    public boolean isVehicleDamaged() {
        return vehicleDamaged;
    }

    /**
     * sets additional damage
     * made by the customer
     * @param vehicleDamaged
     */
    public void setVehicleDamaged(boolean vehicleDamaged) {
        this.vehicleDamaged = vehicleDamaged;
    }

    /**
     * if it is closed
     * @return
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     * close value to be set
     * @param closed
     */
    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
