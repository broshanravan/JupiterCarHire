package com.jupiter.car.hire.enterprise.controllers;

import com.jupiter.car.hire.beans.Address;
import com.jupiter.car.hire.beans.Booking;
import com.jupiter.car.hire.beans.Customer;
import com.jupiter.car.hire.services.BookingService;
import com.jupiter.car.hire.services.CustomerService;
import com.jupiter.car.hire.enums.CustomerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    CustomerService customerService;


    /**
     * uses to user input to create a new bookinf
     */
    @RequestMapping(value="/createBooking", params="booking.do",method= RequestMethod.POST)
    public String createNewBooking(@RequestParam long customerId,
                                 @RequestParam long vehicleId,
                                 @RequestParam Date startDate,
                                 @RequestParam Date endDate,
                                 @RequestParam long totalPrice,
                                 @RequestParam double deposit,
                                 @RequestParam boolean vehicleDamaged,
                                 @RequestParam boolean closed,
                                 @RequestParam String firstName,
                                 @RequestParam  String surname,
                                 @RequestParam  String companyName,
                                 @RequestParam  CustomerType customerType,
                                 @RequestParam  String email,
                                 @RequestParam  String telephone,
                                 @RequestParam int intendedDays, ModelMap model){


        if(customerId == 0) {
            Address address = new Address();


            Customer customer = new  Customer(firstName, surname, companyName,
                    customerType, email, telephone, address) ;
            customerId= customerService.addCustomer(customer);
        }

        long bookingId = bookingService.createNewBooking(deposit, customerId,vehicleId,startDate,endDate, deposit,vehicleDamaged, intendedDays);

        model.put("bookingId",bookingId);
        return "booking";
    }

    /**
     * retrieves an exist booking using the booking
     * Reference number
     */
    @RequestMapping(value="/retrieveBooking", params="booking.do",method= RequestMethod.POST)
    @ResponseBody
    public String retrieveExistingBooking(@RequestParam long bookingId, ModelMap  model){
        Booking booking = bookingService.getBookingDetails(bookingId);
        model.put("deposit", booking.getDeposit() );
        model.put("endDate", booking.getEndDate());
        model.put("intendedDays", booking.getIntendedDays());
        model.put("startDate", booking.getStartDate());
        model.put("totalPrice", booking.getTotalPrice());

        Long customerId= booking.getCustomerId();
        Customer customer = customerService.findCustomer(customerId);
        model.put("firstName", customer.getFirstName());
        model.put("Ssurname", customer.getSurname());
        model.put("customerType", customer.getCustomerType().toString());
        model.put("email", customer.getEmail());
        model.put("telephone", customer.getTelephone());
        model.put("companyName", customer.getCompanyName());

        Address address = customer.getAddress();
        model.put("houseNumber", address.getHouseNumber());
        model.put("houseName", address.getHouseName());
        model.put("address1", address.getAddress2());
        model.put("address2", address.getAddress2());
        model.put("town", address.getTown());
        model.put("postCode", address.getPostcode());
        model.put("addressID", address.getAddressId());

        return "booking";
    }

    /**
     * update existing bookings
     * when required
     */
    @RequestMapping(value="/updateBooking", params="booking.do",method= RequestMethod.POST)
    public String updateBooking(@RequestParam long bookingId,
                              @RequestParam long customerId,
                              @RequestParam long vehicleId,
                              @RequestParam Date startDate,
                              @RequestParam Date endDate,
                              @RequestParam double totalPrice,
                              @RequestParam double deposit,
                              @RequestParam boolean vehicleDamaged,
                              @RequestParam boolean closed,
                              @RequestParam int daysIntended, ModelMap model){



        Booking booking = new Booking(bookingId, customerId, vehicleId, startDate,endDate, totalPrice,deposit, vehicleDamaged, closed,daysIntended) ;
        bookingService.updateBooKing(booking);

        return "booking";

    }

    /**
     * closes a booking when completed or
     * cancelled
     */
    @RequestMapping(value="/closeBooking", params="booking.do",method= RequestMethod.POST)
    public String closeBooking(@RequestParam long bookingId,
                             @RequestParam long customerId,
                             @RequestParam long vehicleId,
                             @RequestParam Date startDate,
                             @RequestParam Date endDate,
                             @RequestParam double totalPrice,
                             @RequestParam double deposit,
                             @RequestParam boolean vehicleDamaged,
                             @RequestParam boolean closed,
                             @RequestParam int daysIntended, ModelMap model){


        Booking booking = new Booking(bookingId, customerId, vehicleId, startDate,endDate, totalPrice,deposit, vehicleDamaged, closed,daysIntended) ;
        bookingService.closeBooking(booking);

        return "booking";
    }

    @RequestMapping(value="/cancelBooking", params="booking.do",method= RequestMethod.POST)
    public String cancel(@RequestParam long bookingId, ModelMap model){
        bookingService.cancelBooking(bookingId);
        return "booking";
    }

}
