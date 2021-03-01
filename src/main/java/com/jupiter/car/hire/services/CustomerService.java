package com.jupiter.car.hire.services;

import com.jupiter.car.hire.beans.Customer;

public interface CustomerService {
    public Customer retrieveCustomer(String surname, String houseNumber, String Postcode);
    public String addNewCustomer(Customer customer);
    public void updateCustomer(Customer customer);
}
