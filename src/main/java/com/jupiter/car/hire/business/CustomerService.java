package com.jupiter.car.hire.business;

import com.jupiter.car.hire.beans.Customer;

public interface CustomerService {
    public String addCustomer(Customer customer);
    public Customer findCustomer(String houseNameNumber, String postCode, String firstName, String surname, String companyName);
    public void updateCustomerDetails(Customer customer);

}
