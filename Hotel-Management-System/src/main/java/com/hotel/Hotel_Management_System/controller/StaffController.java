package com.hotel.Hotel_Management_System.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hotel.Hotel_Management_System.model.Staff;
import com.hotel.Hotel_Management_System.services.StaffService;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin(origins = "*")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable Long id) {
        return staffService.getStaffById(id);
    }

    @PostMapping
    public Staff addStaff(@RequestBody Staff staff) {
        return staffService.saveStaff(staff);
    }

    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
        staff.setId(id);
        return staffService.saveStaff(staff);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
    }

}