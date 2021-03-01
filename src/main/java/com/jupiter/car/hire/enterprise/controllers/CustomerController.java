package com.jupiter.car.hire.enterprise.controllers;

import com.jupiter.car.hire.beans.Address;
import com.jupiter.car.hire.beans.Customer;
import com.jupiter.car.hire.business.CustomerService;
import com.jupiter.car.hire.enums.CustomerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value="/getCustomer")
    public Customer retrieveCustomer(@RequestParam String email, Model model){
        Customer customer = customerService.findCustomerByEmail(email);


        return customer;
    }


    @RequestMapping(value="/getCustomer")
    public void createNewCustomer(@RequestParam long addressId,
                                  @RequestParam  String firstName,
                                  @RequestParam String surname,
                                  @RequestParam String companyName,
                                  @RequestParam String customerType ,
                                  @RequestParam  String email,
                                  @RequestParam  String telephone,
                                  @RequestParam  String houseName,
                                  @RequestParam  String houseNumber,
                                  @RequestParam  String address1,
                                  @RequestParam  String address2,
                                  @RequestParam  String town,
                                  @RequestParam  String postcode,
                                  Model model){

        CustomerType customerTypeEnum = CustomerType.valueOf(customerType);

        Address address = new  Address(houseName, houseNumber, address1, address2, town, postcode);

        Customer customer = new Customer(addressId, firstName, surname, companyName,
                customerTypeEnum,  email,  telephone,  address);

        customerService.addCustomer(customer);

    }




}
