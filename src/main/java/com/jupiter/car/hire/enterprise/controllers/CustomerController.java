package com.jupiter.car.hire.enterprise.controllers;

import com.jupiter.car.hire.beans.Address;
import com.jupiter.car.hire.beans.Customer;
import com.jupiter.car.hire.business.CustomerService;
import com.jupiter.car.hire.enums.CustomerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /**
     * to retrieve customer detail
     * and pass it to the front controller
     * in order to be desplayes in
     * The JSP
     * @param email
     * @param model
     * @return
     */
    @RequestMapping(value="/getCustomer")
    public String retrieveCustomer(@RequestParam String email, ModelMap model){
        Customer customer = customerService.findCustomerByEmail(email);
        model.put("companyName",customer.getCompanyName());
        model.put("costumerType",customer.getCustomerType().toString());
        model.put("mail",customer.getEmail());
        model.put("dirstName",customer.getFirstName());
        model.put("surname",customer.getSurname());
        model.put("telephone",customer.getTelephone());
        model.put("customerId",customer.getCustomerId());

        return "booking";
    }


    /**
     * To save the new customer
     * using Details passed by front
     * controller from
     * The JSP page
     * @param addressId
     * @param firstName
     * @param surname
     * @param companyName
     * @param customerType
     * @param email
     * @param telephone
     * @param houseName
     * @param houseNumber
     * @param address1
     * @param address2
     * @param town
     * @param postcode
     * @param model
     */
    @RequestMapping(value="/createCustomer")
    public String createNewCustomer(@RequestParam long addressId,
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
        return "booking";

    }




}
