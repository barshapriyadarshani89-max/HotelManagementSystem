package com.hotel.Hotel_Management_System.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    private String type;        // Single, Double, Suite
    private Double pricePerNight;
    private String status;      // AVAILABLE, OCCUPIED, MAINTENANCE

}