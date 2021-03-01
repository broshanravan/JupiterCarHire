package com.jupiter.car.hire.beans;

import java.util.Date;

public class Payment {
    private long paymentID;
    private double totalAmountDue;
    private double deposit;
    private Date paymentDate;

    /**
     * retrieves payment Number
     * @return
     */
    public long getPaymentID() {
        return paymentID;
    }

    /**
     * payment id to be set
     * @param paymentID
     */
    public void setPaymentID(long paymentID) {
        this.paymentID = paymentID;
    }

    /**
     * retrieves total
     * amount due
     * @return
     */
    public double getTotalAmountDue() {
        return totalAmountDue;
    }

    /**
     * payment amount due
     * to be set
     * @param totalAmountDue
     */
    public void setTotalAmountDue(double totalAmountDue) {
        this.totalAmountDue = totalAmountDue;
    }

    /**
     * retrieves deposit
     * amount
     * @return
     */
    public double getDeposit() {
        return deposit;
    }

    /**
     * deposit amount
     * to be set
     * @param deposit
     */
    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    /**
     * retrieves payment
     * date
     * @return
     */
    public Date getPaymentDate() {
        return paymentDate;
    }

    /**
     * Payment deta to be set
     * @param paymentDate
     */
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
