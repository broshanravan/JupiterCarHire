package com.jupiter.car.hire.services;

import com.jupiter.car.hire.beans.Customer;
import com.jupiter.car.hire.inventories.CustomerInventory;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerInventory customerInventory;


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

    public Customer findCustomer(long customerId){
        Customer customer = customerInventory.getCustomerById(customerId);

        return customer;
    }

    /**
     *
     * @param customer
     */
    public void updateCustomerDetails(Customer customer){
        customerInventory.updateCustomerDetails(customer);

    }


}
