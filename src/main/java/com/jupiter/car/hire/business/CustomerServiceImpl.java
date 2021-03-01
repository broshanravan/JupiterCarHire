package com.jupiter.car.hire.business;

import com.jupiter.car.hire.beans.Customer;
import com.jupiter.car.hire.inventories.CustomerInventory;
import com.jupiter.car.hire.inventories.CustomerInventoryImpl;

public class CustomerServiceImpl implements CustomerService {
    CustomerInventory customerInventory = new CustomerInventoryImpl();

    /**
     * searching for an existing customer
     * using their name and
     * address details
     * @param houseNameNumber
     * @param postCode
     * @param firstName
     * @param surname
     * @param companyName
     * @return
     */
    public Customer findCustomer(String houseNameNumber, String postCode, String firstName, String surname, String companyName){
        Customer customer = customerInventory.retriveCustomerDetails(houseNameNumber, postCode, firstName, surname, companyName);


        return customer;
    }

    /**
     * to add a new customer
     * @param customer
     */
    public String addCustomer(Customer customer){
        String customerReference = customerInventory.createNewCustomer(customer);

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
