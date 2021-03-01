package com.jupiter.car.hire.business;

import com.jupiter.car.hire.beans.Customer;
import com.jupiter.car.hire.inventories.CustomerInventory;
import com.jupiter.car.hire.inventories.CustomerInventoryImpl;

public class CustomerServiceImpl implements CustomerService {

    CustomerInventory customerInventory = new CustomerInventoryImpl();


    public Customer findCustomerByEmail(String email){
        Customer customer = customerInventory.retrieveCustomerByEmail(email);

        return customer;
    }

    /**
     * to add a new customer
     * @param customer
     */
    public long addCustomer(Customer customer){
        long customerReference = customerInventory.createNewCustomer(customer);

        return customerReference;

    }

    /**
     *
     * @param customer
     */
    public void updateCustomerDetails(Customer customer){
        customerInventory.updateCustomerDetails(customer);

    }
}
