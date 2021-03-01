package com.jupiter.car.hire.inventories;

import com.jupiter.car.hire.beans.Payment;

public interface PaymentInventory {
    public String makePayment(Payment payment);
    public Payment retrievePayment(long bookingtRef);
    public void completePayment(Payment payment);
    public void updatePayment(Payment payment);

}
