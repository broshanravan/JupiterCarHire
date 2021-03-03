package com.jupiter.car.hire.enterprise.controllers;

import com.jupiter.car.hire.beans.*;
import com.jupiter.car.hire.services.BookingService;
import com.jupiter.car.hire.services.CustomerService;
import com.jupiter.car.hire.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    CustomerService customerService;

    @Autowired
    BookingService bookingService;

    /**
     * retrieving vehicle details from DB
     * using its registration number
     * and passing it to the front controller
     * to be displayes
     * @param RegistrationNum
     * @param model
     * @return
     */
    @RequestMapping(value="/findVehicleByReg", params="start.do",method=RequestMethod.POST)
    public String getVehicle(@RequestParam String RegistrationNum, ModelMap model){
        Vehicle Vehicle = vehicleService.retrieveVehicleByReg(RegistrationNum);
        model.put("registration",Vehicle.getRegistration());
        model.put("vehicleType",Vehicle.getVehicleType());
        model.put("engineSize",Vehicle.getEngineSize());
        model.put("dailyRentalPrice",Vehicle.getPricePerDay());

        if(Vehicle !=null && Vehicle.getVehicleId() != 0){
            return "vehicleMaintenance";
        }
        return "index";

    }


    /**
     * to retrieve customer detail using
     * their email
     * and pass it to the front controller
     * in order to be displays in
     * The JSP
     * @param email
     * @param model
     * @return
     */
    @RequestMapping(value="/findCustomerByEmail", params="start.do",method=RequestMethod.POST)
    public String retrieveCustomer(@RequestParam String email, ModelMap model){
        Customer customer = customerService.findCustomerByEmail(email);
        if(customer.getCustomerId() != 0){
            model.put("companyName",customer.getCompanyName());
            model.put("costumerType",customer.getCustomerType().toString());
            model.put("mail",customer.getEmail());
            model.put("dirstName",customer.getFirstName());
            model.put("surname",customer.getSurname());
            model.put("telephone",customer.getTelephone());
            model.put("customerId",customer.getCustomerId());
            return "vehicleMaintenance";
        }
        return "index";

    }

    /**
     * retrieves an exist booking using the booking
     * Reference number
     */
    @RequestMapping(value="/findBookingByNum", params="start.do",method=RequestMethod.POST)
    @ResponseBody
    public String retrieveExistingBooking(@RequestParam long bookingId, ModelMap  model){
        Booking booking = bookingService.getBookingDetails(bookingId);

        if(booking.getCustomerId() !=0) {
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
        return "index";
    }

    /**
     * retrieves an exist booking using the booking
     * Reference number
     */
    @RequestMapping(value="/findBookingByReg",params="start.do",method=RequestMethod.POST)
    @ResponseBody
    public String retrieveBookingByVehicleReg(@RequestParam String registration, ModelMap  model){
        Booking booking = bookingService.getBookingDetailsByVehicleReg(registration);

        if(booking.getBookingId() !=0) {
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
        return "index";
    }


}
