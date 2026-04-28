package com.hotel.Hotel_Management_System.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.Hotel_Management_System.model.Bill;
public interface BillingRepository extends JpaRepository<Bill, Long> {
    Bill findByBookingId(Long bookingId);
}
