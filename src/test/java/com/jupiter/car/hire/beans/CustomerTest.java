package com.jupiter.car.hire.beans;

import com.jupiter.car.hire.enums.CustomerType;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerTest {

    private static Customer customer;

    @BeforeClass
    public static void Setup(){
        Address address = new Address("", "342","Evergreen Terrace", "Downtown",
                "SpringField","SP2 3RR" );

        customer = new Customer(12, "Homer", "Simpson", "Mr Burn Nuclear Plant", CustomerType.privateCustomer
                ,"homer@nexttoFlanders.us", "0342 564 67",  address);
        customer.setCustomerId(14);

    }

    @Test
    public void testConstructor(){
        Address address = customer.getAddress();
        assert("".equalsIgnoreCase(address.getHouseName()));
        assert("342".equals(address.getHouseNumber()));
        assert("Evergreen Terrace".equalsIgnoreCase(address.getAddress1()));
        assert("Downtown".equalsIgnoreCase(address.getAddress2()));
        assert("SpringField".equalsIgnoreCase(address.getTown())) ;
        assert("SP2 3RR".equalsIgnoreCase(address.getPostcode()));
        assert (customer.getCustomerId()== 14);
        assert (customer.getAddressId()== 12);
        assert("Homer".equalsIgnoreCase(customer.getFirstName()));
        assert("Simpson".equalsIgnoreCase(customer.getSurname()));
        assert("Mr Burn Nuclear Plant".equalsIgnoreCase(customer.getCompanyName()));
        assert(CustomerType.privateCustomer.equals(customer.getCustomerType()));
        assert("homer@nexttoFlanders.us".equalsIgnoreCase(customer.getEmail()));
        assert("0342 564 67".equalsIgnoreCase(customer.getTelephone()));

    }
}
