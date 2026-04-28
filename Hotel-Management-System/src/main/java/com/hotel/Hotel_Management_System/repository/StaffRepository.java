package com.hotel.Hotel_Management_System.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.Hotel_Management_System.model.Staff;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findByStatus(String status);
}
