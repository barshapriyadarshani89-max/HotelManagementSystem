package com.hotel.Hotel_Management_System.services;	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.Hotel_Management_System.model.Room;
import com.hotel.Hotel_Management_System.repository.RoomRepository;

import java.util.List;

	@Service
	public class RoomService {

	    @Autowired
	    private RoomRepository roomRepository;

	    public List<Room> getAllRooms() {
	        return roomRepository.findAll();
	    }

	    public Room getRoomById(Long id) {
	        return roomRepository.findById(id).orElse(null);
	    }

	    public Room saveRoom(Room room) {
	        return roomRepository.save(room);
	    }

	    public void deleteRoom(Long id) {
	        roomRepository.deleteById(id);
	    }

	    public List<Room> getAvailableRooms() {
	        return roomRepository.findByStatus("AVAILABLE");
	    }

	}

