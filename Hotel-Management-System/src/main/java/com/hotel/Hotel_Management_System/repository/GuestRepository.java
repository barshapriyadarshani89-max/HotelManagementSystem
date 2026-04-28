package com.hotel.Hotel_Management_System.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.Hotel_Management_System.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    Guest findByEmail(String email);
}
