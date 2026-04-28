package com.hotel.Hotel_Management_System.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.Hotel_Management_System.model.Room;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByStatus(String status);
    List<Room> findByType(String type);
}
