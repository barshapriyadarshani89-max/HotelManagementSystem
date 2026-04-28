package com.hotel.Hotel_Management_System.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hotel.Hotel_Management_System.model.Bill;
import com.hotel.Hotel_Management_System.model.Booking;
import com.hotel.Hotel_Management_System.services.BillingService;
import com.hotel.Hotel_Management_System.services.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
@CrossOrigin(origins = "*")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Bill> getAllBills() {
        return billingService.getAllBills();
    }

    @PostMapping("/generate/{bookingId}")
    public Bill generateBill(@PathVariable Long bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        return billingService.generateBill(booking);
    }

    @PutMapping("/{id}/pay")
    public Bill payBill(@PathVariable Long id) {
        return billingService.payBill(id);
    }

}
