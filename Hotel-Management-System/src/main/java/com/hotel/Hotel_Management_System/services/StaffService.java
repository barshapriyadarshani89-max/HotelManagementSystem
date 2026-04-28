package com.hotel.Hotel_Management_System.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.Hotel_Management_System.model.Staff;
import com.hotel.Hotel_Management_System.repository.StaffRepository;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff getStaffById(Long id) {
        return staffRepository.findById(id).orElse(null);
    }

    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }

}
