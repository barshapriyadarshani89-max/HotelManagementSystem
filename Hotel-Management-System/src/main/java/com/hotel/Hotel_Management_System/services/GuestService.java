package com.hotel.Hotel_Management_System.services;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.hotel.Hotel_Management_System.model.Guest;
import com.hotel.Hotel_Management_System.repository.GuestRepository;

import java.util.List;

	@Service
	public class GuestService {

	    @Autowired
	    private GuestRepository guestRepository;

	    public List<Guest> getAllGuests() {
	        return guestRepository.findAll();
	    }

	    public Guest getGuestById(Long id) {
	        return guestRepository.findById(id).orElse(null);
	    }

	    public Guest saveGuest(Guest guest) {
	        return guestRepository.save(guest);
	    }

	    public void deleteGuest(Long id) {
	        guestRepository.deleteById(id);
	    }
	    public Guest updateGuest(Long id, Guest updatedGuest) {
	        Guest existing = guestRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Guest not found: " + id));
	        existing.setName(updatedGuest.getName());
	        existing.setEmail(updatedGuest.getEmail());
	        existing.setPhone(updatedGuest.getPhone());
	        existing.setAddress(updatedGuest.getAddress());
	        existing.setIdProof(updatedGuest.getIdProof());
	        return guestRepository.save(existing);
	    }

	}

