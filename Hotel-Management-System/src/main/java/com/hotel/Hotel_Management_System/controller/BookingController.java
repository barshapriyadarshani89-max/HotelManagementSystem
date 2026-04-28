package com.hotel.Hotel_Management_System.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hotel.Hotel_Management_System.model.Booking;
import com.hotel.Hotel_Management_System.services.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    @PutMapping("/{id}/checkin")
    public Booking checkIn(@PathVariable Long id) {
        return bookingService.checkIn(id);
    }

    @PutMapping("/{id}/checkout")
    public Booking checkOut(@PathVariable Long id) {
        return bookingService.checkOut(id);
    }

    @PutMapping("/{id}/cancel")
    public void cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
    }

    @DeleteMapping("/{id}")        // ✅ ADD THIS
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
}