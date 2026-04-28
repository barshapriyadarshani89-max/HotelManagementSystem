package com.hotel.Hotel_Management_System.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.Hotel_Management_System.model.Booking;
import java.util.List;
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByStatus(String status);
    List<Booking> findByGuestId(Long guestId);
}


