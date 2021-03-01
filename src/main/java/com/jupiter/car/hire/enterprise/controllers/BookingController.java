package com.jupiter.car.hire.enterprise.controllers;

import com.jupiter.car.hire.beans.Booking;
import com.jupiter.car.hire.business.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;

    /**
     * uses to user input to create a new bookinf
     */
    @RequestMapping(value="/createBooking")
    public void createNewBooking(@RequestParam long customerId,
                                 @RequestParam long vehicleId,
                                 @RequestParam Date startDate,
                                 @RequestParam Date endDate,
                                 @RequestParam long totalPrice,
                                 @RequestParam double deposit,
                                 @RequestParam boolean vehicleDamaged,
                                 @RequestParam boolean closed,
                                 @RequestParam int intendedDays,Model model){

        long bookingId = bookingService.createNewBooking(deposit, customerId,vehicleId,startDate,endDate, deposit,vehicleDamaged, intendedDays);
        //model.

    }

    /**
     * retrieves an exist booking using the booking
     * Reference number
     */
    @RequestMapping(value="/retrieveBooking")
    @ResponseBody
    public void retrieveExistingBooking(@RequestParam long bookingId, Model model){
        Booking booking = bookingService.getBookingDetails(bookingId);
        //model.

    }

    /**
     * update existing bookings
     * when required
     */
    @RequestMapping(value="/updateBooking")
    public void updateBooking(@RequestParam long bookingId,
                              @RequestParam long customerId,
                              @RequestParam long vehicleId,
                              @RequestParam Date startDate,
                              @RequestParam Date endDate,
                              @RequestParam double totalPrice,
                              @RequestParam double deposit,
                              @RequestParam boolean vehicleDamaged,
                              @RequestParam boolean closed,
                              @RequestParam int daysIntended, Model model){



        Booking booking = new Booking(bookingId, customerId, vehicleId, startDate,endDate, totalPrice,deposit, vehicleDamaged, closed,daysIntended) ;
        bookingService.updateBooKing(booking);


    }

    /**
     * closes a booking when completed or
     * cancelled
     */
    @RequestMapping(value="/closeBooking")
    public void closeBooking(@RequestParam long bookingId,
                             @RequestParam long customerId,
                             @RequestParam long vehicleId,
                             @RequestParam Date startDate,
                             @RequestParam Date endDate,
                             @RequestParam double totalPrice,
                             @RequestParam double deposit,
                             @RequestParam boolean vehicleDamaged,
                             @RequestParam boolean closed,
                             @RequestParam int daysIntended,Model model){



        Booking booking = new Booking(bookingId, customerId, vehicleId, startDate,endDate, totalPrice,deposit, vehicleDamaged, closed,daysIntended) ;
        bookingService.closeBooking(booking);

    }

}
