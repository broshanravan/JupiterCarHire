package com.jupiter.car.hire.inventories;

import com.jupiter.car.hire.beans.Customer;

public interface CustomerInventory {

    public Customer retrieveCustomerByEmail(String customerEmail);
    public Customer getCustomerById(long customerId);
    public long createNewCustomer(Customer customer);
    public void updateCustomerDetails(Customer customer);;
}
