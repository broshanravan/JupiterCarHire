package com.jupiter.car.hire.business;

import com.jupiter.car.hire.beans.Customer;

public interface CustomerService {
    public long addCustomer(Customer customer);
    public Customer findCustomerByEmail(String email);
    public Customer findCustomer(long customerId);
    public void updateCustomerDetails(Customer customer);

}
