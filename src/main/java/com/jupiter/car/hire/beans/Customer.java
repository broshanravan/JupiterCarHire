package com.jupiter.car.hire.beans;

import com.jupiter.car.hire.enums.CustomerType;

public class Customer {

    private long customerId;
    private long addressId;
    private String firstName;
    private String surname;
    private String companyName;
    private CustomerType customerType;
    private String email;
    private String telephone;
    private Address address;

    public Customer(long addressId, String firstName, String surname, String companyName, CustomerType customerType, String email, String telephone, Address address) {
        this.addressId = addressId;
        this.firstName = firstName;
        this.surname = surname;
        this.companyName = companyName;
        this.customerType = customerType;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
    }

    public Customer( String firstName, String surname, String companyName, CustomerType customerType, String email, String telephone, Address address) {
        this.firstName = firstName;
        this.surname = surname;
        this.companyName = companyName;
        this.customerType = customerType;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
    }

    public Customer(){

    }

    /**
     * retrieves customer Id
     * @return
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
     * customerId to be set
     * @param customerId
     */
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    /**
     * retrieves addressId
     * @return
     */
    public long getAddressId() {
        return addressId;
    }

    /**
     * sets customerId
     * @param addressId
     */
    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    /**
     * retrieves customer
     * first name
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * customer firstname to be set
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * retrieves customer
     * suename
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     * customer surname
     * to be set
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * retrieves company
     * name if aplicable
     * @return
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * compay's name to
     * be set if
     * applicable
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * retrives customer type
     * (private or commercial)
     * @return
     */
    public CustomerType getCustomerType() {
        return customerType;
    }

    /**
     * customer type (private or commercial)
     * to be set
     * @param customerType
     */
    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    /**
     * retrieves customer
     * Address
     * @return
     */
    public Address getAddress() {
        return address;
    }

    /**
     * customer address to be set
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }


    /**
     * retrieves Telephone Number
     * @return
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Telephone Number to be set
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * retrieve customer
     * email
     * @return
     */

    public String getEmail() {
        return email;
    }

    /**
     * customer email to set
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
