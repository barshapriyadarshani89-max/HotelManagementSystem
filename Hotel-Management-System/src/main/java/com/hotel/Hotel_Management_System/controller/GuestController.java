package com.hotel.Hotel_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hotel.Hotel_Management_System.model.Guest;
import com.hotel.Hotel_Management_System.services.GuestService;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
@CrossOrigin(origins = "*")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    @GetMapping("/{id}")
    public Guest getGuestById(@PathVariable Long id) {
        return guestService.getGuestById(id);
    }

    @PostMapping
    public Guest addGuest(@RequestBody Guest guest) {
        return guestService.saveGuest(guest);
    }

    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable Long id, @RequestBody Guest guest) {
        return guestService.updateGuest(id, guest); // ✅ use this
    }
    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
    }

}