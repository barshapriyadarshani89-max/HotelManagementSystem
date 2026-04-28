package com.hotel.Hotel_Management_System.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.Hotel_Management_System.model.Booking;
import com.hotel.Hotel_Management_System.model.Room;
import com.hotel.Hotel_Management_System.repository.BookingRepository;
import com.hotel.Hotel_Management_System.repository.RoomRepository;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking saveBooking(Booking booking) {
        Room room = roomRepository.findById(booking.getRoom().getId())
                .orElseThrow(() -> new RuntimeException("Room not found"));
        room.setStatus("OCCUPIED");
        roomRepository.save(room);
        booking.setRoom(room);
        booking.setStatus("BOOKED");
        return bookingRepository.save(booking);
    }

    // ✅ ADD THIS METHOD
    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking existing = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found: " + id));

        existing.setCheckInDate(updatedBooking.getCheckInDate());
        existing.setCheckOutDate(updatedBooking.getCheckOutDate());
        existing.setStatus(updatedBooking.getStatus());
        existing.setGuest(updatedBooking.getGuest());
        existing.setRoom(updatedBooking.getRoom());

        return bookingRepository.save(existing);
    }

    public Booking checkIn(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            booking.setStatus("CHECKED_IN");
            bookingRepository.save(booking);
        }
        return booking;
    }

    public Booking checkOut(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            booking.setStatus("CHECKED_OUT");
            Room room = booking.getRoom();
            room.setStatus("AVAILABLE");
            roomRepository.save(room);
            bookingRepository.save(booking);
        }
        return booking;
    }

    public void cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            booking.setStatus("CANCELLED");
            Room room = booking.getRoom();
            room.setStatus("AVAILABLE");
            roomRepository.save(room);
            bookingRepository.save(booking);
        }
    }
    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found: " + id));

        // Free up the room
        Room room = booking.getRoom();
        room.setStatus("AVAILABLE");
        roomRepository.save(room);

        bookingRepository.deleteById(id);
    }
}